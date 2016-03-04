name := "$name;format="norm"$"

organization := "$project_group_id$"

version := "0.1.0-SNAPSHOT"

name                  := "$name$",
organization          := "$organization$",
version               := "$version$",
scalaVersion          := "$scala_version$",

// These options will be used for *all* versions.
scalacOptions ++= Seq(
  "-deprecation", 
  "-feature", 
  "-encoding", 
  "utf8"
)

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

val akka = "2.4.2"

/* dependencies */
libraryDependencies ++= Seq (
  // -- Testing --
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
  // -- Logging --
  ,"ch.qos.logback" % "logback-classic" % "1.1.6"
  ,"com.typesafe.scala-logging" %% "scala-logging" % "2.1.2"
  // -- Akka --
  ,"com.typesafe.akka" %% "akka-testkit" % akka % "test"
  ,"com.typesafe.akka" %% "akka-actor" % akka
  ,"com.typesafe.akka" %% "akka-slf4j" % akka
  // -- Sql --
  "org.jooq" % "jooq" % "3.7.3"
)

resolvers ++= Seq(
  Resolver.sonatypeRepo("snapshots")
  Resolver.typesafeRepo("releases")
)

fork := true

testOptions in Test += Tests.Argument("-oDS")

packageArchetype.java_server

scalaSource in Compile := baseDirectory.value / "src"

scalaSource in Test := baseDirectory.value / "src"

excludeFilter in (Compile, unmanagedSources) := HiddenFileFilter || "*_test.scala"

excludeFilter in (Test, unmanagedSources) := HiddenFileFilter

resourceDirectory in Compile := baseDirectory.value / "resources"

resourceDirectory in Test := baseDirectory.value / "resources_test"