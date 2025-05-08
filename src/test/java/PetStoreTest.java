import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PetStoreTest {
    int petId = 1500000;

    @Test
    public void PetLifecycle() throws InterruptedException {
        int petId = 1500000;

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"id\": " + petId + ", \"name\": \"TestPet\", \"status\": \"available\" }")
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .body("id", equalTo(petId));
        Thread.sleep(3000);

        RestAssured.given()
                .when()
                .get("https://petstore.swagger.io/v2/pet/" + petId)
                .then()
                .statusCode(200)
                .body("id", equalTo(petId));
        Thread.sleep(3000);

        RestAssured.given()
                .when()
                .delete("https://petstore.swagger.io/v2/pet/" + petId)
                .then()
                .statusCode(200)
                .body("message", equalTo(String.valueOf(petId)));


    }

    @Test
    public void testInvalidLogin() {
        RestAssured.given()
                .queryParam("username", "wrong")
                .queryParam("password", "wrong")
                .when()
                .get("https://petstore.swagger.io/v2/user/login")
                .then()
                .statusCode(200);
    }
}
