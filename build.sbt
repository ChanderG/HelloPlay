name := "ProComp"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)     

play.Project.playScalaSettings

libraryDependencies += "org.mongodb" %% "casbah" % "2.7.1"

libraryDependencies += "com.novus" %% "salat" % "1.9.8"
