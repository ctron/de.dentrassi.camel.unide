# Apache Camel™ PPMP Converter [![Build status](https://api.travis-ci.org/ctron/de.dentrassi.camel.unide.svg "Travis Build Status")](https://travis-ci.org/ctron/de.dentrassi.camel.unide) [![Maven Central](https://img.shields.io/maven-central/v/de.dentrassi.camel.unide/camel-unide.svg)](https://search.maven.org/#search|ga|1|g%3A%22de.dentrassi.camel.unide%22%20AND%20a%3A%22camel-unide%22)

This is an Apache Camel component for providing PPMP support based on [Eclipse Unide](https://eclipse.org/unide/ "Eclipse Unide™")™.

This repository is a work in progress with the final goal of adding this component to Apache Camel.

# Building the project

The project is a simple Maven project and can be built using:

    git clone https://github.com/ctron/de.dentrassi.camel.unide.git
    cd de.dentrassi.camel.unide
    mvn clean install

# Known bugs and issues

Currently the Eclipse Unide project didn't yet release a first version. This is why this
project still works with a `-SNAPSHOT` of Eclipse Unide. This will be switched to a stable
release version as soon as this is available.

Eclipse Unide currently doesn't support OSGi metadata. There is PR https://github.com/eclipse/unide/issues/14
pending, which should get merged soon in order to fix this. As a result the `camel-unide` component currently
requires an OSGi package dependency which cannot be resolved.
