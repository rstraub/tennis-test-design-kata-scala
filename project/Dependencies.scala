import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.15"
  lazy val mockito = "org.scalatestplus" %% "mockito-3-4" % "3.2.10.0"
  lazy val cucumber = "io.cucumber" %% "cucumber-scala" % "8.14.1"
  lazy val cucumberJunit = "io.cucumber" % "cucumber-junit-platform-engine" % "7.11.1"
  lazy val junit = "org.junit.jupiter" % "junit-jupiter" % "5.9.2"
  lazy val junitSuite = "org.junit.platform" % "junit-platform-suite" % "1.9.2"
}
