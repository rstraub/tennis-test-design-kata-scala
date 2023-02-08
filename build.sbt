import Dependencies._
import sbt.Keys.libraryDependencies

def itFilter(name: String): Boolean = name.endsWith("IT")

lazy val root = project
  .enablePlugins(ScalafmtPlugin)
  .configs(IntegrationTest)
  .in(file("."))
  .settings(
    name := "BDD in Scala",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := projectScalaVersion,
    libraryDependencies += scalaTest % "it,test",
    libraryDependencies += scalaCheck % Test,
    libraryDependencies += mockito % Test,
    // Cucumber CLI & Scala DSL dependency
    libraryDependencies += cucumber % Test,
    // Cucumber Runner dependencies
    libraryDependencies += cucumberJunit % Test,
    libraryDependencies += sbtJunit % Test,
    Defaults.itSettings,
    IntegrationTest / testOptions := Seq(Tests.Filter(itFilter))
  )

val projectScalaVersion = "2.13.10"
