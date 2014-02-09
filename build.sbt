import SonatypeKeys._

// Import default Sonatype publish settings.
sonatypeSettings

sbtPlugin := true

name := "sbt-imagej"

organization := "net.sf.ij-plugins"

version := "1.2.0-SNAPSHOT"

description := "SBT plugin that helps create runtime directory structure for ImageJ plugin development."

homepage := Some(url("http://github.com/jpsacha/sbt-imagej"))

organizationHomepage := Some(url("http://ij-plugins.sf.net"))

startYear := Some(2013)

licenses := Seq("GPLv3" -> url("http://www.gnu.org/licenses/gpl.html"))

scalacOptions := Seq("-deprecation", "-unchecked")

publishArtifact in(Test, packageBin) := false

publishArtifact in(Test, packageDoc) := false

publishArtifact in(Test, packageSrc) := false

publishTo <<= version {
  version: String =>
    if (version.contains("-SNAPSHOT"))
      Some("Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
    else
      Some("Sonatype Nexus Releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
}

pomExtra :=
  <scm>
    <url>git@github.com:jpsacha/sbt-imagej.git</url>
    <connection>scm:git@github.com:jpsacha/sbt-imagej.git</connection>
  </scm>
  <developers>
    <developer>
      <id>jpsacha</id>
      <name>Jarek Sacha</name>
      <url>https://github.com/jpsacha</url>
    </developer>
  </developers>
