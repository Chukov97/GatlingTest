package webToursLoad

import io.gatling.core.Predef._
import scala.concurrent.duration._

class FindMax extends Simulation {

  val maxUsers = 10
  val stepUser = 1
  val stagesNumber: Int = maxUsers / stepUser
  val stagesDuration: FiniteDuration = 2.minutes
  val rampDuration: FiniteDuration = 10

  setUp(Scenarios()
    .inject(
      incrementUsersPerSec(stepUser)
        .times(stagesNumber)
        .eachLevelLasting(stagesDuration)
        .separatedByRampsLasting(rampDuration)
        .startingFrom(0))
    .protocols(WebTours.httpProtocol)
  )
}
