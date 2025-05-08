import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;

public class GoogleTest {

    @ParameterizedTest
    @ValueSource(strings = {"qa", "aqa", "cars"})
    void suggestionsShouldBeMoreThanFive(String query) {
        open("https://www.google.com/");

        $("textarea[name='q']").setValue(query);

        ElementsCollection suggestions = $$("ul[role='listbox'] li span");


        suggestions.first().shouldBe(visible);
        suggestions.shouldHave(sizeGreaterThan(5));
    }
}