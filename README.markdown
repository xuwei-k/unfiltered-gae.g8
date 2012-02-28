A [giter8][g8] template for [Google App Engine][gae] [Unfiltered][unfiltered] applications.


## install

Build with [sbt 0.11.x][sbt]

    # download and copy google app engines sdk to /path/to/your/gae-home
    export APPENGINE_SDK_HOME=/path/to/your/gae-home
    g8 unfiltered/unfiltered-gae --name your-app
    cd your-app

To run through the appengine SDK

    sbt appengine-dev-server

Point your browser at http://localhost:8080/

## TODO

* yaml configs - http://code.google.com/appengine/docs/java/configyaml/appconfig_yaml.html

[sbt]: https://github.com/harrah/xsbt/wiki
[eed3si9n]: https://github.com/eed3si9n/
[gaesbt]: https://github.com/sbt/sbt-appengine
[g8]: http://github.com/n8han/giter8#readme
[unfiltered]: http://github.com/unfiltered/unfiltered#readme
[gae]: http://code.google.com/appengine/
[webplugin]: https://github.com/siasia/xsbt-web-plugin#readme
