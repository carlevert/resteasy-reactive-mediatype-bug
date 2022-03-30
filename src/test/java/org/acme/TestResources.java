package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class TestResources {

    private void doTest(String path, String mediaType, String expectBody) {
        given()
                .header(new Header("Accept", mediaType))
                .when().get(path)
                .then()
                .statusCode(200)
                .contentType(mediaType)
                .body(is(expectBody));
    }

    @Test
    public void testRes1ApplicationJson() {
        doTest("res1", "application/json", "{\"data\":\"Datadata\"}");
    }

    @Test
    public void testRes1ApplicationVndMsExcel() {
        doTest("res1", "application/vnd.ms-excel", "Datadata");
    }

    @Test
    public void testRes1TextPlain() {
        doTest("res1", "text/plain", "text/plain");
    }

    @Test
    public void testRes2ApplicationJson() {
        doTest("res2", "application/json", "{\"data\":\"Datadata\"}");
    }

    @Test
    public void testRes2ApplicationVndMsExcel() {
        doTest("res2", "application/vnd.ms-excel", "Datadata");
    }

    @Test
    public void testRes2TextPlain() {
        doTest("res2", "text/plain", "text/plain");
    }

}
