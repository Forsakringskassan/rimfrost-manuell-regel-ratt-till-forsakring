# Template Quarkus App

An example Quarkus application implementing [template-api](https://github.com/Forsakringskassan/template-api).

Build it with `./mvnw -s settings.xml clean verify`.

A GitHub workflow will also create a Docker image, it is published to [repository](https://github.com/Forsakringskassan/repository). It can be started with:

```sh
docker run -d \
  -p 8080:8080 \
  ghcr.io/forsakringskassan/template-quarkus-app:snapshot
```

See also: [fk-maven](https://github.com/Forsakringskassan/fk-maven).
