package webToursLoad

import io.gatling.core.Predef._
import io.gatling.core.structure._

object Scenarios {
  def apply(): ScenarioBuilder = new Scenarios().scn
}

class Scenarios {
  val scn = scenario("Scenarios")
    .feed(Feeders.users)
    .exec(Actions.getMainPage)
    .exec(Actions.getLoginPage)
    .exec(Actions.login)
    .exec(Actions.findFlights)
    .exec(Actions.selectCity)
    .exec(Actions.selectFlight)
    .exec(Actions.bookFlight)
    .exec(Actions.getHomePage)
}
