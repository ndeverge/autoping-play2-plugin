name := "autoping-play2-plugin"

organization := "com.github.ndeverge"

crossScalaVersions := Seq("2.10.4", "2.11.4")

version := "0.1.2"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
	ws
)

