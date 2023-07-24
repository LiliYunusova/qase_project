package ui.tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.NewAccount;
import ui.service.LoginPageService;
import ui.service.SignUpAccountService;
import ui.service.SignUpPageService;
import ui.utils.Retry;
import ui.utils.TestDataGeneration;

public class CreateNewAccountTest extends BaseTest {

    private LoginPageService loginPageService;

    private SignUpPageService signUpPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        signUpPageService = new SignUpPageService();
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Create new account test")
    public void verifyCreateAccountTest() {
        String email = TestDataGeneration.getEmail();
        String password = TestDataGeneration.getPassword();
        String confirmPassword = password;
        NewAccount newAccount = new NewAccount(email, password, confirmPassword);
        SignUpPageService signUpPageService = loginPageService.pushLinkToCreateNewAccount();
        SignUpAccountService signUpAccountService = signUpPageService.signUpAccount(newAccount);
        String actualTextCreateNewAccount = signUpAccountService.actualTextOfCreateNewAccount();
        String expectedTextCreateNewAccount = "We have successfully created your account and sent a confirmation email to:";
        Assert.assertEquals(actualTextCreateNewAccount, expectedTextCreateNewAccount);
    }
}
