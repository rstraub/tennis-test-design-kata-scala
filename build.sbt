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
    Defaults.itSettings,
    libraryDependencies += scalaTest % "it,test",
    libraryDependencies += mockito % Test,
    IntegrationTest / testOptions := Seq(Tests.Filter(itFilter)),
    // Cucumber CLI & Scala DSL dependency
    libraryDependencies += cucumber % Test,
    // Cucumber Runner dependencies
    libraryDependencies += junit % Test,
    libraryDependencies += junitSuite % Test,
    libraryDependencies += cucumberJunit % Test
  )
val projectScalaVersion = "2.13.10"
