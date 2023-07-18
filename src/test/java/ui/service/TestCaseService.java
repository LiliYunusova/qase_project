package ui.service;

import ui.pages.TestCasePage;

public class TestCaseService {

   public OneSingleProjectPageService fillTestCase(String name){
       TestCasePage testCasePage = new TestCasePage();
       testCasePage.fillInTestCaseTitle(name).clickSaveButton();
       return new OneSingleProjectPageService();
   }

}
