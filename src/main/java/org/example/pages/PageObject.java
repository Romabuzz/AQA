package org.example.pages;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class PageObject {

    static {
        baseUrl = "https://github.com";
    }

    private static final String LOGIN_FIELD = "#login_field";
    private static final String PASSWORD_FIELD = "#password";
    private static final String SIGN_IN_BUTTON = "input[name='commit']";
    private static final String AVATAR_ICON = ".avatar.circle";
    private static final String ERROR_MESSAGE = ".flash-error";

    public PageObject openLoginPage() {
        open("/login");
        return this;
    }

    public PageObject enterUsername(String username) {
        $(LOGIN_FIELD).setValue(username);
        return this;
    }

    public PageObject enterPassword(String password) {
        $(PASSWORD_FIELD).setValue(password);
        return this;
    }

    public PageObject submitLogin() {
        $(SIGN_IN_BUTTON).click();
        return this;
    }

    public PageObject shouldSeeAvatarIcon() {
        $(AVATAR_ICON).shouldBe(visible);
        return this;
    }

    public PageObject shouldSeeLoginError() {
        $(ERROR_MESSAGE).shouldHave(text("Incorrect username or password."));
        return this;
    }
}
