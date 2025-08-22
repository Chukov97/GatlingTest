package webToursLoad

import io.gatling.core.Predef._
import io.gatling.core.structure._
import webToursLoad.Feeders

object Scenarios {
  def apply(): ScenarioBuilder = new Scenarios().scn
}

class Scenarios {
  val scn = scenario("Scenarios")
    .feed(Feeders.users)
    .exec(Actions.getMainPage)
    .exec(Actions.login)
}