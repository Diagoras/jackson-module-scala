// Basic facts
name := "jackson-module-scala"

organization := "com.fasterxml.jackson.module"

scalaVersion := "2.10.4"

crossScalaVersions := Seq("2.9.1", "2.9.2", "2.9.3", "2.10.4")

scalacOptions ++= Seq("-deprecation", "-unchecked")

// Ensure jvm 1.6 for java
javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

// Try to future-proof scala jvm targets, in case some future
// scala version makes 1.7 a default
scalacOptions <+= (scalaBinaryVersion) map { binVer => binVer match {
  case "2.9.1" | "2.9.2" | "2.9.3" => "-target:jvm-1.5"
  case _ => "-target:jvm-1.6"
} }

libraryDependencies ++= Seq(
    "com.fasterxml.jackson.core" % "jackson-core" % "2.3.5",
    "com.fasterxml.jackson.core" % "jackson-annotations" % "2.3.5",
    "com.fasterxml.jackson.core" % "jackson-databind" % "2.3.5",
    "com.fasterxml.jackson.datatype" % "jackson-datatype-joda" % "2.3.5" % "test",
    "com.fasterxml.jackson.datatype" % "jackson-datatype-guava" % "2.3.5" % "test",
    "com.fasterxml.jackson.module" % "jackson-module-jsonSchema" % "2.3.5" % "test",
    "com.thoughtworks.paranamer" % "paranamer" % "2.6",
    "com.google.code.findbugs" % "jsr305" % "2.0.1",
    "com.google.guava" % "guava" % "13.0.1",
    // test dependencies
    "org.scalatest" %% "scalatest" % "2.0.M5b" % "test",
    "junit" % "junit" % "4.11" % "test",
    "com.novocode" % "junit-interface" % "0.10" % "test"
)

// resource filtering
seq(filterSettings: _*)

