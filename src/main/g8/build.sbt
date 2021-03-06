organization := "$org_id$"

name := "$name$"

version := "$version$"

scalaVersion := "$scala_version$"

enablePlugins(AppenginePlugin)

val unusedWarnings = Seq("-Ywarn-unused")

scalacOptions ++= PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
  case Some((2, v)) if v >= 11 => unusedWarnings
}.toList.flatten

Seq(Compile, Test).flatMap(c =>
  scalacOptions in (c, console) --= unusedWarnings
)

scalacOptions ++= "-deprecation" :: "unchecked" :: "-feature" :: Nil

val unfilteredVersion = "$unfiltered_version$"

libraryDependencies ++= Seq(
  "ws.unfiltered" %% "unfiltered-filter" % unfilteredVersion,
  "ws.unfiltered" %% "unfiltered-specs2" % unfilteredVersion % "test"
) ++ Seq( // local testing
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
   "org.eclipse.jetty" % "jetty-webapp" % "$jetty_version$" % "container"
)
