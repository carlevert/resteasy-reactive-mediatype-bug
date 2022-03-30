# resteasy-reactive-mediatype-bug

Mediatype in MessageBodyWriters defaults to the first listed type in @Produces using resteasy-reactive, Quarkus
2.7.5.Final (and 2.8.0.CR1)

So for example Resource1's only method is
annotated `@Produces({"application/vnd.ms-excel", MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})`. This works as
expected with for example `application/json` _until_ the MessageBodyWriters where the mediaType-parameter always is the
first one listed in @Produces, `application/vnd.ms-excel` in this case.

Changing the `quarkus-resteasy-reactive-jackson` dependency to `quarkus-resteasy-jackson` makes this work as expected.

There are a few tests included to prove my point. They behave the same way as requests made with for example curl.

This project is generated with code.quarkus.io. Except the projects artifactId the setup is not touched.