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

And add the library dependency:

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

## Development

If you fork the project, for local testing, use `publish-local` from sbt and remove the `resolver`.