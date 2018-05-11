name := "exercise"

version := "1.0"

scalaVersion := "2.11.11"

val sparkVersion = "2.1.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test"
)
