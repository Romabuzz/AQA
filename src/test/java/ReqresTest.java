import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojo.Color;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReqresTest {

    private static final String BASE_URI = "https://reqres.in";
    private static final String API_KEY = "reqres-free-v1";

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void testAllColorsHaveYearFrom2000() {
        Response response = RestAssured
                .given()
                .header("x-api-key", API_KEY)
                .get("/api/unknown");

        assertTrue(response.statusCode() == 200);

        List<Color> colors = response.jsonPath().getList("data", Color.class);

        for (Color color : colors) {
            assertTrue(color.getYear() >= 2000);
        }
    }
}
