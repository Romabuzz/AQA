import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojo.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    private static final String BASE_URI = "https://reqres.in";
    private static final String API_KEY = "reqres-free-v1";

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void testAvatarsContainDomain() {
        Response response = RestAssured
                .given()
                .header("x-api-key", API_KEY)
                .get("/api/users?page=1");

        assertTrue(response.statusCode() == 200);

        List<User> users = response.jsonPath().getList("data", User.class);

        for (User user : users) {
            assertTrue(user.getAvatar().contains("https://reqres.in"));
        }
    }
}
