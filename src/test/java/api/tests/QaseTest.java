package api.tests;

import adapters.CaseAdapter;
import adapters.ProjectAdapter;
import adapters.SuiteAdapter;
import io.restassured.response.Response;
import models.Cases;
import models.Project;
import models.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;
import static java.net.HttpURLConnection.HTTP_OK;

public class QaseTest {

    @Test
    public void getProjectTest() {
        int statusCode = new ProjectAdapter().getProjects().statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    public void createProjectTest() {
        Project project = Project.builder()
                .title("AQA24")
                .code("aqa24")
                .build();
        String codeOfProject = new ProjectAdapter().create(project).body().path("result.code");
        Assert.assertTrue(codeOfProject.equalsIgnoreCase(project.getCode()));
    }

    @Test
    public void createSuiteTest() {
        String projectCode = "AQA24";
        Suite suite = Suite.builder()
                .title("smoke2")
                .description("This is smoke2 test")
                .build();
        int resultId = new SuiteAdapter().create(projectCode, suite).body().path("result.id");
        Assert.assertTrue(resultId != 0);
    }

    @Test
    public void getCasesTest(){
        String projectCode = "AQA24";
        int statusCode = new CaseAdapter().getCases(projectCode).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    public void createCasesTest() {
        String projectCode = "AQA24";
        Cases cases = Cases.builder()
                .title("testCase2")
                .description("This is number 2 case")
                .build();
        int resultId = new CaseAdapter().create(projectCode, cases).body().path("result.id");
        Assert.assertTrue(resultId != 0);
    }

    @Test
    public void createCasesIntoSuiteTest() {
        String projectCode = "AQA24";
        Cases cases = Cases.builder()
                .title("testCaseIntoSuite")
                .suiteId(2)
                .description("This is number testCaseIntoSuite case")
                .build();
        int resultId = new CaseAdapter().create(projectCode, cases).body().path("result.id");
        Assert.assertTrue(resultId != 0);
    }

    @Test
    public void updateSuiteTest(){
        String projectCode = "AQA20";
        int id = 1;
        Suite suite = Suite.builder()
                .title("test4")
                .build();
        int statusCode = new SuiteAdapter().update(projectCode,id,suite).statusCode();
        Assert.assertEquals(statusCode,HTTP_OK);
    }

    @Test
    public void deleteSuiteTest(){
        String projectCode = "AQA20";
        Suite suite = Suite.builder()
                .build();
        int id = 1;
        int statusCode = new SuiteAdapter().delete(projectCode,id, suite).statusCode();
        Assert.assertEquals(statusCode,HTTP_OK);
    }
}
