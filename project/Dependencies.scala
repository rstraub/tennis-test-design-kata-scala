import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.15"
  lazy val scalaCheck = "org.scalatestplus" %% "scalacheck-1-17" % "3.2.15.0"
  lazy val mockito = "org.scalatestplus" %% "mockito-3-4" % "3.2.10.0"
  lazy val cucumber = "io.cucumber" %% "cucumber-scala" % "8.14.1"
  lazy val cucumberJunit = "io.cucumber" % "cucumber-junit" % "7.11.1"
  lazy val sbtJunit = "com.github.sbt" % "junit-interface" % "0.13.3"
}
