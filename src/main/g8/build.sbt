name                  := "$name$"
organization          := "$organization$"
version               := "$version$"
scalaVersion          := "$scala_version$"

scalacOptions ++= Seq (
  "-deprecation", 
  "-feature", 
  "-encoding", 
  "utf8"
)

javacOptions ++= Seq (
  "-Xlint:unchecked", 
  "-Xlint:deprecation"
)

val akka = "$akka_version$"

/* Dependencies */
libraryDependencies ++= Seq (
  // -- Testing --
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
  ,"junit" % "junit" % "4.12" % "test"
  // -- Logging --
  ,"org.slf4j" % "slf4j-api" % "1.7.18"
  ,"ch.qos.logback" % "logback-classic" % "1.1.6"
  ,"com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
  // -- Akka --
  ,"com.typesafe.akka" %% "akka-testkit" % akka % "test"
  ,"com.typesafe.akka" %% "akka-actor" % akka
  ,"com.typesafe.akka" %% "akka-slf4j" % akka
  // -- Sql --
  ,"org.jooq" % "jooq" % "3.7.3"
)

resolvers ++= Seq (
  Resolver.sonatypeRepo("snapshots"),
  Resolver.typesafeRepo("releases")
)

fork := true

testOptions in Test += Tests.Argument("-oDS")

packageArchetype.java_server

scalaSource in Compile := baseDirectory.value / "src/main/scala"

javaSource in Compile := baseDirectory.value / "src/main/java"

scalaSource in Test := baseDirectory.value / "src/test/scala"

javaSource in Test := baseDirectory.value / "src/test/scala"

resourceDirectory in Compile := baseDirectory.value / "src/main/resources"

resourceDirectory in Test := baseDirectory.value / "src/test/resources"

excludeFilter in (Compile, unmanagedSources) := HiddenFileFilter || "*_test.scala" || "*.java"

excludeFilter in (Test, unmanagedSources) := HiddenFileFilter