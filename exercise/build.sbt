name := "exercise"

version := "1.0"

scalaVersion := "2.11.11"

val sparkVersion = "2.1.0"

libraryDependencies ++= Seq(
  "com.github.pureconfig"      %% "pureconfig"                  % "0.7.2",
  "com.typesafe.scala-logging" %% "scala-logging"               % "3.7.2",
  "joda-time"                  % "joda-time"                    % "2.9.9",
  "org.apache.logging.log4j"   % "log4j-1.2-api"                % "2.8.2",
  "org.apache.logging.log4j"   % "log4j-api"                    % "2.8.2",
  "org.apache.logging.log4j"   % "log4j-core"                   % "2.8.2",
  "org.apache.logging.log4j"   % "log4j-slf4j-impl"             % "2.8.2",
  "org.joda"                   % "joda-convert"                 % "1.8.2",
  "org.scalacheck"             %% "scalacheck"                  % "1.13.5" % Test,
  "org.scalamock"              %% "scalamock-scalatest-support" % "3.6.0" % Test,
  "org.scalatest"              %% "scalatest"                   % "3.0.3" % Test,
  "org.slf4j"                  % "slf4j-api"                    % "1.7.25",
  "org.apache.spark"           %% "spark-core"                  % sparkVersion,
  "org.apache.spark"           %% "spark-hive"                  % sparkVersion,
  "net.fosdal"                 %% "oslo"                        % "0.2.1"
)