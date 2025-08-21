enablePlugins(GatlingPlugin)

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.6"

lazy val root = (project in file("."))
  .settings(
    name := "LoadTest"
  )

val gatlingVersion = "3.13.5"
libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion % "test,it"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % gatlingVersion % "test,it"
