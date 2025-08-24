package webToursLoad

import io.gatling.core.Predef._
import io.gatling.http.Predef._


class Debug extends Simulation {
  setUp(Scenarios().inject(atOnceUsers(1)))
    .protocols(WebTours.httpProtocol)
}
