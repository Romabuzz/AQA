import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojo.User;
import org.example.config.ReqresConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    public void testAvatarsContainDomain() {
        Response response = RestAssured
                .given()
                .header("x-api-key", ReqresConfig.API_KEY)
                .get(ReqresConfig.BASE_URL + "/api/users?page=1");

        assertTrue(response.statusCode() == 200);

        List<User> users = response.jsonPath().getList("data", User.class);

        for (User user : users) {
            assertTrue(user.getAvatar().contains("https://reqres.in"));
        }
    }
}
