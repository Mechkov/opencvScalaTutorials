import sbt._
import Keys._

object JavaOpenCVSampleBuild extends Build {
  def scalaSettings = Seq(
    scalaVersion := "2.10.3",
    scalacOptions ++= Seq(
      "-optimize",
      "-unchecked",
      "-deprecation"
    )
  )

  def appSettings = Seq(
    mainClass in (Compile, run) := Some("HelloOpenCV")
  )

  def buildSettings = Project.defaultSettings.++(scalaSettings).++(appSettings)

  lazy val root = {
    val settings = buildSettings ++ Seq(name := "JavaOpenCVSample")
    Project(id = "JavaOpenCVSample", base = file("."), settings = settings)
  }
}
