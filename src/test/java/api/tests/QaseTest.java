package api.tests;

import adapters.CaseAdapter;
import adapters.ProjectAdapter;
import adapters.SuiteAdapter;
import models.Cases;
import models.Project;
import models.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.utils.TestDataGeneration;

import java.util.Locale;

import static java.net.HttpURLConnection.HTTP_OK;

public class QaseTest {
    private String generateName = TestDataGeneration.getName();
    private String projectCode = generateName;

    @Test
    public void verifyNumberOfProjectTest() {
        int statusCode = new ProjectAdapter().getProjects().statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test(priority = 1)
    public void verifyThatProjectCreateTest() {
        Project project = Project.builder()
                .title(generateName)
                .code(generateName)
                .build();
        String codeOfProject = new ProjectAdapter().create(project).body().path("result.code");
        Assert.assertTrue(codeOfProject.equalsIgnoreCase(project.getCode()), "Project does not create");
    }

    @Test(priority = 2)
    public void verifyThatSuiteCreateTest() {
        Suite suite = Suite.builder()
                .title(generateName)
                .description("This is" + generateName + "test")
                .build();
        int resultId = new SuiteAdapter().create(projectCode.toUpperCase(Locale.ROOT), suite).body().path("result.id");
        Assert.assertTrue(resultId != 0, "Suite does not create");
    }

    @Test(dependsOnMethods = "verifyThatProjectCreateTest")
    public void verifyNumberOfCasesTest() {
        int statusCode = new CaseAdapter().getCases(projectCode.toUpperCase(Locale.ROOT)).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test(priority = 3)
    public void verifyThatCasesCreateTest() {
        Cases cases = Cases.builder()
                .title("testCase2")
                .description("This is number 2 case")
                .build();
        int resultId = new CaseAdapter().create(projectCode.toUpperCase(Locale.ROOT), cases).body().path("result.id");
        Assert.assertTrue(resultId != 0, "Case does not create");
    }

    @Test(priority = 4)
    public void verifyThatCasesIntoSuiteCreateTest() {
        Cases cases = Cases.builder()
                .title("testCaseIntoSuite")
                .suiteId(1)
                .description("This is number testCaseIntoSuite case")
                .build();
        int resultId = new CaseAdapter().create(projectCode.toUpperCase(Locale.ROOT), cases).body().path("result.id");
        Assert.assertTrue(resultId != 0, "Cases into suite does not create");
    }

    @Test(priority = 5)
    public void verifyThatSuiteUpdateTest() {
        int id = 1;
        Suite suite = Suite.builder()
                .title("test")
                .build();
        int statusCode = new SuiteAdapter().update(projectCode.toUpperCase(Locale.ROOT), id, suite).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test(priority = 6)
    public void verifyThatSuiteDeleteTest() {
        Suite suite = Suite.builder()
                .build();
        int id = 1;
        int statusCode = new SuiteAdapter().delete(projectCode.toUpperCase(Locale.ROOT), id, suite).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }
}
