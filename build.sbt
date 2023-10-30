ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "scalametrics",
    idePackagePrefix := Some("io.github.slava0135.scalametrics")
  )

libraryDependencies += "org.scalameta" %% "scalameta" % "4.8.12"
