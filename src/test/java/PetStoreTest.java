import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreTest {

    private static final int PET_ID = 1500000;
    private static RequestSpecification spec;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void petLifecycle() throws InterruptedException {
        given()
                .spec(spec)
                .body("{ \"id\": " + PET_ID + ", \"name\": \"TestPet\", \"status\": \"available\" }")
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .body("id", equalTo(PET_ID));

        Thread.sleep(3000);

        given()
                .spec(spec)
                .when()
                .get("/pet/" + PET_ID)
                .then()
                .statusCode(200)
                .body("id", equalTo(PET_ID));

        Thread.sleep(3000);

        given()
                .spec(spec)
                .when()
                .delete("/pet/" + PET_ID)
                .then()
                .statusCode(200)
                .body("message", equalTo(String.valueOf(PET_ID)));
    }

    @Test
    public void invalidLogin() {
        given()
                .spec(spec)
                .queryParam("username", "wrong")
                .queryParam("password", "wrong")
                .when()
                .get("/user/login")
                .then()
                .statusCode(200);
    }
}
