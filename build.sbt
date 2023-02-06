import Dependencies._
import sbt.Keys.libraryDependencies

def itFilter(name: String): Boolean = name.endsWith("IT")

// TODO: make sbt execute the cucumber specs
lazy val root = project
  .enablePlugins(ScalafmtPlugin)
  .configs(IntegrationTest)
  .in(file("."))
  .settings(
    name := "BDD in Scala",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := projectScalaVersion,
    libraryDependencies += scalaTest % "it,test",
    libraryDependencies += mockito % Test,
    // Cucumber CLI & Scala DSL dependency
    libraryDependencies += cucumber % Test,
    // Cucumber Runner dependencies
    libraryDependencies += "net.aichler" % "jupiter-interface" % "0.11.1" % Test,
    libraryDependencies += junit % Test,
    libraryDependencies += junitSuite % Test,
    libraryDependencies += cucumberJunit % Test,
    Defaults.itSettings,
    IntegrationTest / testOptions := Seq(Tests.Filter(itFilter))
  )

//testOptions += Tests.Argument(TestFrameworks.JUnit)
val projectScalaVersion = "2.13.10"
