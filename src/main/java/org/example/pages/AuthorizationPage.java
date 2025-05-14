package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.visible;

public class AuthorizationPage {

    private SelenideElement loginField = $("#login_field");
    private SelenideElement passwordField = $("#password");
    private SelenideElement signInButton = $("input[type='submit']");
    private SelenideElement avatarIcon = $("img.avatar-user");
    private SelenideElement errorMessage = $("#js-flash-container .flash-error");

    public AuthorizationPage openLoginPage() {
        open("https://github.com/login");
        return this;
    }

    public AuthorizationPage enterUsername(String username) {
        loginField.setValue(username);
        return this;
    }

    public AuthorizationPage enterPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public AuthorizationPage  submitLogin() {
        signInButton.click();
        return this;
    }

    public AuthorizationPage shouldSeeAvatarIcon() {
        avatarIcon.shouldBe(visible);
        return this;
    }

    public AuthorizationPage shouldSeeLoginError() {
        errorMessage.shouldBe(visible);
        return this;
    }
}
