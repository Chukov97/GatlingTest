package webToursLoad

import io.gatling.core.Predef._
import io.gatling.core.structure._

object Scenarios {
  def apply(): ScenarioBuilder = new Scenarios().scn
}

class Scenarios {
  val scn = scenario("Scenarios")
    .exec(Actions.getMainPage)
//    .exec(Actions.login)
}