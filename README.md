# Autoping plugin

A small Play2 plugin that ping an url every 10 minutes.


## Setup

In your `conf/play.plugins` file, add:

```
10000:com.github.ndeverge.autoping.Autoping
```

In the `Build.scala` file, configure a new resolver:

```
resolvers += Resolver.url("Autoping repository", url("http://ndeverge.github.com/autoping-play2-plugin/snapshots/"))(Resolver.ivyStylePatterns)
```

Add the library dependency:

For Play up to 2.1.x :

```
val appDependencies = Seq(
   ...
   "com.github.ndeverge" %% "autoping-play2-plugin" % "0.1.0-SNAPSHOT"
)
```

For Play 2.2.1

```
val appDependencies = Seq(
   ...
   "com.github.ndeverge" %% "autoping-play2-plugin" % "0.1.1"
)
```

And configure the Url to ping the `conf/application.conf` file:

```
autoping.url="http://mysite.com"
```


For Play 2.3.5


In the `build.sbt` file, configure a new resolver:

```
	Resolver.url("My GitHub Play Repository",  url("http://juliender.github.io/autoping-play2-plugin/snapshots/"))(Resolver.ivyStylePatterns)
```

```
val appDependencies = Seq(
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
