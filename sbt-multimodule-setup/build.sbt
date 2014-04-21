name := "XBMC Desktop Client"

version := "1.0.0"

scalaVersion := "2.10.4"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

fork in run := true

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

lazy val backend = project

lazy val frontend = project.dependsOn(backend)
