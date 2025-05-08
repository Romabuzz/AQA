package org.example;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Github {

    public static void main(String[] args) {
        task3();
        task4();
        task5();
        task6();
    }

    // Успешная авторизация на Github
    public static void task3() {
        String username = "duff91@mail.ru";
        String password = "G7r!xZ2@pLm#qT9v";

        open("https://github.com/login");
        $("#login_field").setValue(username);
        $("#password").setValue(password);
        $("input[name='commit']").click();
        $(".avatar.circle").shouldBe(visible);

        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();
    }

    // Ошибка авторизации на Github
    public static void task4() {
        open("https://github.com/login");
        $("#login_field").setValue("usertest@test.ru");
        $("#password").setValue("usertest111123");
        $("input[name='commit']").click();

        $(".flash-error").shouldHave(text("Incorrect username or password."));

        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();
    }

    // Навигация Solutions и проверка формы Contact Sales
    public static void task5() {
        open("https://github.com");

        $$(".js-header-menu-item").findBy(text("Solutions")).hover();
        $("a[href='/solutions/use-case/ci-cd']").click();
        $("a.Primer_Brand__Button-module__Button--secondary___akMC2")
                .scrollIntoView(true).click();

        String firstName = "Ivan";
        String lastName = "Ivanov";

        $("[name='first_name']").shouldBe(visible).setValue(firstName);
        $("[name='last_name']").shouldBe(visible).setValue(lastName);

        $("[name='first_name']").shouldHave(value(firstName));
        $("[name='last_name']").shouldHave(value(lastName));

        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();
    }

    // Проверка, что меню Resources содержит нужные пункты
    public static void task6() {
        open("https://github.com");

        $$(".js-header-menu-item").findBy(text("Resources")).hover();

        ElementsCollection menuItems = $$("div.HeaderMenu-dropdown ul li a");

        menuItems.shouldHave(CollectionCondition.itemWithText("AI"));
        menuItems.shouldHave(CollectionCondition.itemWithText("DevOps"));
        menuItems.shouldHave(CollectionCondition.itemWithText("Security"));
        menuItems.shouldHave(CollectionCondition.itemWithText("Software Development"));
        menuItems.shouldHave(CollectionCondition.itemWithText("View All"));
    }
}
