name := "Simple JavaFX example"

version := "1.0.0"

scalaVersion := "2.11.0"

// Java 7 workaround
// javaHome := Some(file(System.getenv("JAVA_HOME")))
// http://stackoverflow.com/questions/14123749/how-to-detect-javafx-runtime-jar-in-sbt
// unmanagedJars in Compile <+= javaHome map { jh => new File( jh.getOrElse(sys.error("Error, could not get java home")),"jre/lib/jfxrt.jar" ) }