import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReqresTest {

    @Test
    public void testAllColorsHaveYearFrom2000() {
        Response response = RestAssured
                .given()
                .header("x-api-key", "reqres-free-v1")
                .get("https://reqres.in/api/unknown");

        assertTrue(response.statusCode() == 200);

        List<Color> colors = response.jsonPath().getList("data", Color.class);

        for (Color color : colors) {
            assertTrue(color.getYear() >= 2000);
        }
    }
}
