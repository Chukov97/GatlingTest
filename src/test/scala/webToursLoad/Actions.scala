package webToursLoad

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Actions {

  val getMainPage: HttpRequestBuilder = http("getMainPage")
    .get("/")
    .check(status is 200)

//  val login: HttpRequestBuilder = http("login")
//    .post("/login.pl")
//    .formParam("username", "${username}")
//    .formParam("password", "${password}")
//    .check(status is 200)

}

