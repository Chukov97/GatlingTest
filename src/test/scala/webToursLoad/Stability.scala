package webToursLoad

import io.gatling.core.Predef._
import scala.concurrent.duration._

class Stability extends Simulation {
  setUp(Scenarios()
    .inject(
      constantUsersPerSec(10)
        .during(1.hour))
    .protocols(WebTours.httpProtocol)
  )
}
