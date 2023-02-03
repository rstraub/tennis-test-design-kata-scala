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
    Defaults.itSettings,
    libraryDependencies += scalaTest % "it,test",
    // Cucumber CLI dependency
    libraryDependencies += cucumber % Test,
    libraryDependencies += mockito % Test,
    IntegrationTest / testOptions := Seq(Tests.Filter(itFilter))
  )
val projectScalaVersion = "2.13.10"
