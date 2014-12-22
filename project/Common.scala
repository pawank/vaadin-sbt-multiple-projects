import sbt._
import Keys._

object Common {
  val globalVersion = "1.0"
  val organizationName = "AcelrTechLabs"
  val vaadinVersion = "7.3.5"
  //val jettyVersion = "7.3.0.v20110203"
  val jettyVersion = "9.1.0.v20131115"
  val scalaTestVersion = "2.2.0"
  val mockitoVersion = "1.9.5"

  def scalaReflect(scalaVersion: String) = "org.scala-lang" % "scala-reflect" % scalaVersion
  val vaadin = "com.vaadin" % "vaadin-server" % vaadinVersion
  val vaadinClientCompiled = "com.vaadin" % "vaadin-client-compiled" % vaadinVersion
  val vaadinThemes = "com.vaadin" % "vaadin-themes" % vaadinVersion
  val servletApi = "javax.servlet" % "servlet-api" % "2.4"
  val portletApi = "javax.portlet" % "portlet-api" % "2.0"
  val jetty = "org.eclipse.jetty" % "jetty-webapp" % jettyVersion
  val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion
  val junitInterface = "com.novocode" % "junit-interface" % "0.7"
  val mockito = "org.mockito" % "mockito-all" % mockitoVersion
  val jettyWebappContainer = jetty % "container"
  val jettyPlus = "org.eclipse.jetty" % "jetty-plus" % jettyVersion
  val jettyPlusContainer = jettyPlus % "container"
  val jettyAnnotations = "org.eclipse.jetty" % "jetty-annotations" % jettyVersion
  val jettyAnnotationsContainer = jettyAnnotations % "container"
  val jettyAll = "org.eclipse.jetty.aggregate" % "jetty-all" % jettyVersion
  val jettyAllContainer = jettyAll % "container"
}
