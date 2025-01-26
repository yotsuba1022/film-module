# film-module

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## How to create the project
You can leverage the `START CODING` in the Quarkus official site ([here](https://code.quarkus.io/)):

<img src="https://github.com/user-attachments/assets/5a026c5c-6f3b-4681-a4d9-862454ab9fe3" width="700" alt="">

Make sure what kind of dependencies you need.

## Install Graal VM
Please visit Graal VM [official site](https://www.graalvm.org/) for installation instructions

#### For MAC OS
[Installation on macOS Platforms](https://www.graalvm.org/22.0/docs/getting-started/macos/)

Configure the GRAALVM_HOME environment variable in your system:
```
export GRAALVM_HOME=/Library/Java/JavaVirtualMachines/graalvm-community-openjdk-17.0.9+9.1/Contents/Home
export PATH=$PATH:$GRAALVM_HOME/bin
```
Then, verify the installation by running this command:
```commandline
native-image --version
```
You should be able to see information similar to:
```
GraalVM Runtime Environment GraalVM CE 17.0.9+9.1 (build 17.0.9+9-jvmci-23.0-b22)
Substrate VM GraalVM CE 17.0.9+9.1 (build 17.0.9+9, serial gc)
```
Now you can perform the native build.


## Running the application in dev mode

You can run your app in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

Under the dev mode, you hot-reload the whole app by pressing "s" in the command line console:

<img src="https://github.com/user-attachments/assets/525075b3-ec9a-4d5a-b829-ae48eea84439" width="800" alt="">

Also, you can access the dev ui in the browser by pressing "d"
in the command line console (hostname/q/dev-ui/extensions) which can provide you with more insights for the app:

<img src="https://github.com/user-attachments/assets/681de619-3d41-4a58-8352-45efa6a81bfd" width="800" alt="">

For debugging, use the following command:

```shell script
./mvnw compile quarkus:dev -Ddebug
```

If you're using IntelliJ, you can configure the debug setting like this:

<img src="https://github.com/user-attachments/assets/27cb05c2-1082-4d65-bda0-ad9f9d4cf742" width="500" alt="">

The default port is: ``5005``

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/film-module-1.0.0-SNAPSHOT-runner`

The starting time is significantly faster than the traditional Java app:
<img src="https://github.com/user-attachments/assets/5e3c5093-3e24-4ca6-9aee-f10d429ae4b4" width="800">

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- JPAStreamer ([guide](https://quarkiverse.github.io/quarkiverse-docs/quarkus-jpastreamer/dev/)): Express your Hibernate queries as standard Java Streams
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- JDBC Driver - MySQL ([guide](https://quarkus.io/guides/datasource)): Connect to the MySQL database via JDBC
