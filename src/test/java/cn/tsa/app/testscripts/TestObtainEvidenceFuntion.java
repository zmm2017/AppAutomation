package cn.tsa.app.testscripts;

import org.testng.annotations.Test;

import cn.tsa.app.modules.InitPage;
import cn.tsa.app.modules.LoginSystem;
import cn.tsa.app.modules.NavigateBetweenPages;
import cn.tsa.app.pageobjects.LoginPage;
import cn.tsa.app.pageobjects.ObtainEvidence;
import cn.tsa.app.pageobjects.TakePicturePage;
import io.appium.java_client.TouchAction;

import org.testng.annotations.BeforeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestObtainEvidenceFuntion {
	public static ObtainEvidence obtainEvidence=null;
	public static LoginPage loginPage=null;
	public static TakePicturePage takePicturePage=null;
	
  @Test
  public void openAndCloseObtainPictureEvidencePage() throws Exception {
	  System.out.println("************开始执行第1条用例，打开和关闭照片取证页面******************");
	  String obtainPictureEviName="com.tsa.app.ObtainEvidence.camera";
	  String takePictureBtnName="com.tsa.app.TakePicturePage.takePictureBtn";
	  String backBtnName="com.tsa.app.TakePicturePage.backBtn";
	  takePicturePage=NavigateBetweenPages.goToTakePicturePage(obtainEvidence, obtainPictureEviName);
	  WebElement takePictureBtn=takePicturePage.getTakePictureBtn(takePictureBtnName);
	  System.out.println(takePictureBtn.isDisplayed()==true?"成功打开照片取证页面，测试通过":"打开照片取证页面失败，没有通过测试");
	  Assert.assertTrue(takePictureBtn.isDisplayed());
	  obtainEvidence=NavigateBetweenPages.backObtainEvidencePageFromPicture(takePicturePage,backBtnName );
	  WebElement obtainPictureEvi=obtainEvidence.cameraObtainEvidence(obtainPictureEviName);
	  System.out.println(obtainPictureEvi.isDisplayed()==true?"成功返回取证页面，通过测试":"返回取证页面失败，没有通过测试+\n");
	  Assert.assertTrue(obtainPictureEvi.isDisplayed());
  }
  
  @Test
  public void takePicture() throws Exception {
	  System.out.println("************开始执行第2条用例，拍照取证******************");
	  takePicturePage=NavigateBetweenPages.goToTakePicturePage(obtainEvidence, "com.tsa.app.ObtainEvidence.camera");
	  takePicturePage.getTakePictureBtn("com.tsa.app.TakePicturePage.takePictureBtn").click();
	  WebElement windowTitle=takePicturePage.driver.findElement(By.id("com.unitrust.tsa:id/activity_camera_tvdilaog"));
	  WebElement giveUp=takePicturePage.driver.findElement(By.id("com.unitrust.tsa:id/activity_camera_cancel"));
	  WebElement solidEvi=takePicturePage.driver.findElement(By.id("com.unitrust.tsa:id/activity_camera_commit"));
	  System.out.println("弹窗的文字是："+windowTitle.getText());
	  System.out.println("固化证据按钮的文字是："+giveUp.getText());
	  
	  /*WebDriverWait wait=new WebDriverWait(takePicturePage.driver,10);
	  wait.until(ExpectedConditions.invisibilityOf(giveUp));*/
	  System.out.println("等待7秒钟...");
	  Thread.sleep(7000);
	  System.out.println("点击固化证据按钮");
	  TouchAction action=new TouchAction(takePicturePage.driver);
	  action.tap(giveUp).perform();
	  System.out.println("点击完毕。");
	  
	  
  }
  
  @BeforeClass
  public void beforeClass() throws Exception {
	  loginPage=InitPage.execute();
	  obtainEvidence=LoginSystem.executeLogin("xiaxun", "123456", loginPage);
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("\n");
	  System.out.println("**************所有的取证页面的测试用例执行完毕*****************");
  }

}
