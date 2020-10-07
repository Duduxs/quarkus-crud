# CRUD URI

# State
```
[Get(Paginated)] http://localhost:8080/states?pageNum=0&pageSize=5

[Get(Count)] http://localhost:8080/states/count

[Post] http://localhost:8080/states | Suggested body:{ "name": "Acre", "region": "???" }

[Put] http://localhost:8080/states/{20} | Suggested body:{ "name": "Pernambuco", "region": "Northoest" }

[Delete] http://localhost:8080/states/{27} 
```

# City
```
[Get(Paginated)] http://localhost:8080/cities?pageNum=0&pageSize=3

[Get(Count)] http://localhost:8080/cities/count

[Get(ByStateId)] http://localhost:8080/cities/{3}

[Get(ByName)] http://localhost:8080/cities/find/{Olinda}?pageNum=0&pageSize=3

[Post] http://localhost:8080/cities | Suggested body:{ "name": "Olinda", "state": { "id": 12  } and { "name": "Recife", "state": { "id": 12  }  }

[Put] http://localhost:8080/cities/{1} | Suggested body:{ "name": "Surubim", "state": { "id": 4 } }

[Delete] http://localhost:8080/cities/{2}
```

# getting-started project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `getting-started-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/getting-started-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/getting-started-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.
