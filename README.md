# Autoping plugin



## Setup

In your `conf/play.plugins` file, add:

```
10000:com.github.ndeverge.autoping.Autoping
```

In the `Build.scala` file, configure a new resolver:

```
resolvers += "Autoping plugin" at "http://ndeverge.github.com/autoping-play2-plugin/"
```

Add the library dependency:

```
val appDependencies = Seq(
   ...
   "com.github.ndeverge" %% "autoping-play2-plugin" % "0.1.0-SNAPSHOT"
)
```

## Development

If you fork the project, for local testing, use `publish-local` from sbt and remove the `resolver`.