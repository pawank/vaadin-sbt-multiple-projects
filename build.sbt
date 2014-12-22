import org.vaadin.sbt.VaadinPlugin._
import sbt.Keys._
import sbt.ScalaVersion

name         := "VaadinMultipleModulesProject"

version      := Common.globalVersion

scalaVersion := "2.11.4"

crossScalaVersions  := Seq("2.11.4", "2.11.2", "2.11.1","2.10.4")


val commonlibraryDependencies = Seq(
    "org.scalaz" %% "scalaz-core" % "7.0.6" withSources
    )

val vaadinDependencies = commonlibraryDependencies ++ Seq(
    "com.vaadin" % "vaadin-server" % "7.1.12",
    "com.vaadin" % "vaadin-client-compiled" % "7.1.12",
    "com.vaadin" % "vaadin-themes" % "7.1.12",
    "javax.servlet" % "servlet-api" % "2.4" % "provided",
    "org.eclipse.jetty.aggregate" % "jetty-all" % "9.1.0.v20131115",
    "org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115" % "container",
    "org.eclipse.jetty" % "jetty-plus" % "9.1.0.v20131115" % "container",
    "org.eclipse.jetty" % "jetty-annotations" % "9.1.0.v20131115" % "container"
    )

organization := Common.organizationName

    resolvers ++= Seq(
    Resolver.url("scala-js-releases",
        url("http://dl.bintray.com/content/scala-js/scala-js-releases"))(
            Resolver.ivyStylePatterns),
        "Typesafe releases" at "http://repo.typesafe.com/typesafe/releases/",
        "webjars" at "http://webjars.github.com/m2",
        Resolver.url("play-plugin-releases", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns),
        Resolver.url("play-plugin-releases", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns),
        Resolver.url("play-plugin-snapshots", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots/"))(Resolver.ivyStylePatterns),
        Resolver.url("sbt-plugin-snapshots", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots/"))(Resolver.ivyStylePatterns),
        Resolver.url("Sonatype Snapshots",url("http://oss.sonatype.org/content/repositories/snapshots/"))(Resolver.ivyStylePatterns),
        Resolver.url("Objectify Play Repository", url("http://schaloner.github.com/releases/"))(Resolver.ivyStylePatterns),
        Resolver.url("Objectify Play Snapshot Repository", url("http://schaloner.github.com/snapshots/"))(Resolver.ivyStylePatterns),
        Resolver.url("Graylog2 Play Repository", url("http://graylog2.github.io/play2-graylog2/releases/"))(Resolver.ivyStylePatterns),
        Resolver.url("Graylog2 Play Snapshot Repository", url("http://graylog2.github.io/play2-graylog2/snapshots/"))(Resolver.ivyStylePatterns),
        "Mandubian repository snapshots" at "https://github.com/mandubian/mandubian-mvn/raw/master/snapshots/",
        "Mandubian repository releases" at "https://github.com/mandubian/mandubian-mvn/raw/master/releases/",
        "Local ivy2 Repository" at "file:////workspces/ivy2/local"
    )

    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-language:reflectiveCalls",
        "-language:implicitConversions", "-language:postfixOps", "-language:dynamics","-language:higherKinds",
        "-language:existentials", "-language:experimental.macros", "-Xmax-classfile-name", "140")

    logBuffered in Test := false

    Keys.fork in Test := false

    parallelExecution in Test := false
    
    aggregate in update := false
    
    autoAPIMappings := true

  initialCommands := """ // make app resources accessible
|Thread.currentThread.setContextClassLoader(getClass.getClassLoader)
  |new play.core.StaticApplication(new java.io.File("."))
  |""".stripMargin

lazy val constants = project in file("constants")

lazy val utils = (project in file("utils")).settings(libraryDependencies ++= commonlibraryDependencies).dependsOn(constants)

//lazy val app = (project in file("app")).settings(vaadinWebSettings: _*).settings(libraryDependencies ++= vaadinDependencies).dependsOn(constants,utils)

lazy val root = (project in file(".")).settings(vaadinWebSettings: _*).settings(libraryDependencies ++= vaadinDependencies).aggregate(constants, utils)

//port in container.Configuration := 3002
