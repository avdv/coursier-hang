# coursier-hang

Running `sbt update` results in:

```
[info] Loading settings for project global-plugins from plugins.sbt,idea.sbt,metals.sbt ...
[info] Loading global plugins from /home/claudio/.sbt/1.0/plugins
[info] Loading settings for project coursier-update-build from plugins.sbt ...
[info] Loading project definition from /home/claudio/sandbox/coursier-update/project
[info] Loading settings for project root from build.sbt ...
[info] Set current project to coursier-update (in build file:/home/claudio/sandbox/coursier-update/)
[info] Updating root
https://artifactory.xyz.com/ivy-virtual/org.mortbay.jetty/jetty/6.1.12.rc+/ivys/ivy.xml.sha1
    0.0% [          ] 0 B (0 B / s)
https://artifactory.xyz.com/ivy-virtual/org.mortbay.jetty/jetty/6.1.12.rc+/ivys/ivy.xml
    0.0% [          ] 0 B (0 B / s)
```

Requesting those URLs should result in a 404, actually.
