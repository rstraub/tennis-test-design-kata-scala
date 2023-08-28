import Dependencies._
import sbt.Keys.libraryDependencies

lazy val root = project
  .enablePlugins(ScalafmtPlugin)
  .in(file("."))
  .settings(
    name := "Tennis Test Design Kata",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := projectScalaVersion,
    libraryDependencies += scalaCheck % Test,
    libraryDependencies += mockito % Test,
    // Cucumber CLI & Scala DSL dependency
    libraryDependencies += cucumber % Test,
    // Cucumber Runner dependencies
    libraryDependencies += cucumberJunit % Test,
    libraryDependencies += sbtJunit % Test,
    Defaults.itSettings,
  )

val projectScalaVersion = "2.13.11"
