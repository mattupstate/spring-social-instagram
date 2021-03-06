# Spring Social Instagram

To check out the project and build from source, do the following:

    git clone --recursive git://github.com/mattupstate/spring-social-instagram.git
    cd spring-social-instagram
    ./gradlew build

Note: the --recursive switch above is important, as spring-social uses git submodules, which must themselves be cloned and initialized. If --recursive is omitted, doing so becomes a multi-step process of: 

    git clone git://github.com/mattupstate/spring-social-instagram.git
    git submodule init
    git submodule update

## Example Project

An example project is available at https://github.com/mattupstate/spring-social-instagram-example

## Using Eclipse

To generate Eclipse metadata (.classpath and .project files), do the following:

    ./gradlew eclipse

Once complete, you may then import the projects into Eclipse as usual:

    File -> Import -> Existing projects into workspace

## Using IntelliJ

To generate IDEA metadata (.iml and .ipr files), do the following:

    ./gradlew idea

## Documentation

To build the JavaDoc, do the following from within the root directory:

    ./gradlew :docs:api

The result will be available in 'docs/build/api'.
