organization := "$org_id$"

name := "$name$"

version := "$version$"

scalaVersion := "$scala_version$"

enablePlugins(AppenginePlugin)

val unusedWarnings = (
  "-Ywarn-unused" ::
  "-Ywarn-unused-import" ::
  Nil
)

scalacOptions ++= PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
  case Some((2, v)) if v >= 11 => unusedWarnings
}.toList.flatten

Seq(Compile, Test).flatMap(c =>
  scalacOptions in (c, console) --= unusedWarnings
)

scalacOptions ++= "-deprecation" :: "unchecked" :: "-feature" :: Nil

libraryDependencies ++= Seq(
  "ws.unfiltered" %% "unfiltered-filter" % "$unfiltered_version$",
  "ws.unfiltered" %% "unfiltered-specs2" % "$unfiltered_version$" % "test"
) ++ Seq( // local testing
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
   "org.eclipse.jetty" % "jetty-webapp" % "$jetty_version$" % "container"
)
