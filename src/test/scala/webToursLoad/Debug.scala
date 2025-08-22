package webToursLoad

import io.gatling.core.Predef.*
import io.gatling.http.Predef.*


class Debug extends Simulation {
  setUp(Scenarios().inject(atOnceUsers(1)))
    .protocols(WebTours.httpProtocol)
}
