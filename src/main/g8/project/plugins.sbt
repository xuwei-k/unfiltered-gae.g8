resolvers += "Web plugin repo" at "http://siasia.github.com/maven2"

libraryDependencies <+= sbtVersion(v => "com.github.siasia" %% "xsbt-web-plugin" % (v+"-0.2.10"))

addSbtPlugin("com.eed3si9n" % "sbt-appengine" % "0.4.0")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.cc",
  Resolver.url("sbt-plugin-releases",
    url("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)
)
