import Dependencies._
import sbt.Keys.libraryDependencies

lazy val root = project
  .enablePlugins(ScalafmtPlugin)
  .in(file("."))
  .settings(
    name := "tennis-test-design-kata",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := projectScalaVersion,
    libraryDependencies += scalaCheck % Test,
    libraryDependencies += mockito % Test,
    libraryDependencies += scalaTest % Test,
  )

val projectScalaVersion = "2.13.11"
