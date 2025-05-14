package org.example;

import org.example.pages.AuthorizationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class GithubTests {

    private static final String BASE_URL = "https://github.com";
    private static final String USERNAME = "duff91@mail.ru";
    private static final String PASSWORD = "G7r!xZ2@pLm#qT9v";
    private static final String INVALID_USERNAME = "usertest@test.ru";
    private static final String INVALID_PASSWORD = "test11112345";

    @DisplayName("Успешная авторизация на Github")
    @Test
    public void successfulLoginTest() {
        AuthorizationPage page = new AuthorizationPage();

        open(BASE_URL);
        page.openLoginPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .submitLogin()
                .shouldSeeAvatarIcon();

        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();
    }

    @DisplayName("Ошибка авторизации на Github")
    @Test
    public void unsuccessfulLoginTest() {
        AuthorizationPage page = new AuthorizationPage();

        open(BASE_URL);
        page.openLoginPage()
                .enterUsername(INVALID_USERNAME)
                .enterPassword(INVALID_PASSWORD)
                .submitLogin()
                .shouldSeeLoginError();

        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();
    }
}
