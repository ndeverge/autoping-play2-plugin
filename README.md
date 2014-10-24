# Autoping plugin for play 2.3

A small Play2 plugin that ping an url every 10 minutes.


## Setup

In your `conf/play.plugins` file, add:

```
10000:com.github.ndeverge.autoping.Autoping
```

In the `build.sbt` file, configure a new resolver:

```
resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  Resolver.url("My GitHub Play Repository",  url("http://juliender.github.io/autoping-play2-plugin/snapshots/"))(Resolver.ivyStylePatterns)
)
```

Add the library dependency:

```
libraryDependencies ++= Seq(
   ...
   "com.github.ndeverge" %% "autoping-play2-plugin" % "0.1.2"
)
```

And configure the Url to ping the `conf/application.conf` file:

```
autoping.url="http://mysite.com"
```

## Development

If you fork the project, for local testing, use `publish-local` from sbt and remove the `resolver`.
