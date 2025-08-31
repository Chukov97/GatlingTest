package webToursLoad

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder


object Actions {

  val getMainPage: HttpRequestBuilder = http("getMainPage")
    .get("/webtours")
    .check(status.not(500))

  val getLoginPage: HttpRequestBuilder = http("getLoginPage")
    .get("/cgi-bin/nav.pl")
    .queryParam("in", "home")
    .check(css("input[name='userSession']", "value").saveAs("userSession"))
    .check(status is 200)

  val login: HttpRequestBuilder = http("login")
    .post("/cgi-bin/login.pl")
    .formParam("username", "#{username}")
    .formParam("password", "#{password}")
    .formParam("userSession", "#{userSession}")
    .formParam("login.x", "55")
    .formParam("login.y", "7")
    .check(status is 200)

  val findFlights: HttpRequestBuilder = http("find_flights")
    .get("/cgi-bin/reservations.pl")
    .queryParam("page", "welcome")
    .check(regex("""<option value="([^"]+)">""").findRandom.saveAs("citiesDepart"))
    .check(regex("""<option value="([^"]+)">""").findRandom.saveAs("citiesArrive"))
    .check(status is 200)

  val selectCity: HttpRequestBuilder = http("select_city")
    .post("/cgi-bin/reservations.pl")
    .formParam("depart", "#{citiesDepart}")
    .formParam("departDate", "09/01/2025")
    .formParam("arrive", "#{citiesArrive}")
    .formParam("returnDate", "09/02/2025")
    .formParam("numPassengers", "1")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("advanceDiscount", "0")
    .formParam("findFlights.x", "55")
    .formParam("findFlights.y", "7")
    .check(css("input[name=\"outboundFlight\"]", "value").findRandom.saveAs("outboundFlight"))
    .check(status is 200)

  val selectFlight: HttpRequestBuilder = http("select_flight")
    .post("/cgi-bin/reservations.pl")
    .formParam("outboundFlight", "#{outboundFlight}")
    .formParam("numPassengers", "1")
    .formParam("advanceDiscount", "0")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("reserveFlights.x", "39")
    .formParam("reserveFlights.y", "7")
    .check(status is 200)

  val bookFlight: HttpRequestBuilder = http("book_flight")
    .post("/cgi-bin/reservations.pl")
    .formParam("firstName", "Gatling")
    .formParam("lastName", "User")
    .formParam("address1", "Gatling street")
    .formParam("address2", "Gatling street")
    .formParam("pass1", "Ilya Chukov")
    .formParam("creditCard", "4634723474")
    .formParam("expDate", "11/30")
    .formParam("oldCCOwner", "112")
    .formParam("outboundFlight", "#{outboundFlight}")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("numPassengers", "1")
    .formParam("advanceDiscount", "0")
    .formParam("buyFlights.x", "49")
    .formParam("buyFlights.y", "7")

  val getHomePage: HttpRequestBuilder = http("getHomePage")
    .get("/cgi-bin/login.pl")
    .queryParam("intro", "true")
    .check(status is 200)

}
