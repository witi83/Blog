import AssemblyKeys._

assemblySettings

assemblyOption in assembly ~= { _.copy(includeScala = false) }

name := "NIO Bug"

version := "1.0"

jarName in assembly := s"${name.value.replace(" ", "-").toLowerCase}-${version.value}.jar"

scalaVersion := "2.11.2"

mainClass := Some("Main")

incOptions := incOptions.value.withNameHashing(true)

fork in run := true

javacOptions ++= Seq("-Xlint:unchecked")
