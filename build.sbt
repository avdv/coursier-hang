
ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

resolvers += Resolver.url(
  "Artifactory (nginx)",
  new URL("http://localhost:8000/ivy-virtual/"))(Resolver.ivyStylePatterns)

credentials += Credentials(
  "Artifactory Realm",
  "localhost",
  "arti", "123456"
)

lazy val root = (project in file("."))
  .settings(
    name := "coursier-update",
    libraryDependencies += "com.sample" %% "common-lib" % "19.23.0-does-not-exist"
  )
