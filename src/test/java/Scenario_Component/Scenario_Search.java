package Scenario_Component;

import java.io.IOException;

import org.apache.commons.exec.ExecuteException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;

public class Scenario_Search extends Base_Class {
	
	 static Logger log= Logger.getLogger(Scenario_Search.class);
	SoftAssert sAssert =new SoftAssert();
	
	@Test(dataProvider="dp_InvalidSearch", dataProviderClass=DataProvider_Component.DataProvider_Search.class,groups={"smoke"})
	public void testInvalid_Search(String TC_ID, String Order, String Search_Item, String Exp_Result) throws ExecuteException, IOException, InterruptedException
	{
		log.info("Executing the TC ID  " +TC_ID+"  Order  is "+Order);
		Start_appiumserver();
		InitApp();
		
		PageObject_Search BS_pob= new PageObject_Search(driver);
		BS_pob.Click_btn();
		BS_pob.Enter_Search(Search_Item);
		Explicit_wait(BS_pob.Invalid_msg,25);
		String Actual_Result = BS_pob.getInvalid_msg();
		System.out.println(Actual_Result);
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Expected and Actual msg");
		}
		else
			
		{
			log.info("Failed as Expected " +Exp_Result+ "and Actual msg  "+Actual_Result);
			sAssert.fail("Failed as Expected " +Exp_Result+ "and Actual msg  "+Actual_Result);
		}
		
		Stop_appiumserver();
		sAssert.assertAll();
	}
	
	@Test(dataProvider="dp_ValidSearch", dataProviderClass=DataProvider_Component.DataProvider_Search.class)
	public void testValid_Search(String TC_ID, String Order, String Search_Item, String Exp_Result) throws ExecuteException, IOException, InterruptedException
	{
		log.info("Executing the TC ID  " +TC_ID+"  Order  is "+Order);
		Start_appiumserver();
		InitApp();
		
		PageObject_Search BS_pob= new PageObject_Search(driver);
		BS_pob.Click_btn();
		BS_pob.Enter_Search(Search_Item);
		Explicit_wait(BS_pob.Valid_msg,25);
		String Result = BS_pob.getValid_msg();
		String Actual_Result = Result.replace(" products", "");
		
		System.out.println(Actual_Result);
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Expected and Actual msg");
		}
		else
			
		{
			log.info("Failed as Expected " +Exp_Result+ "and Actual msg  "+Actual_Result);
			sAssert.fail("Failed as Expected " +Exp_Result+ "and Actual msg  "+Actual_Result);
		}
		
		Stop_appiumserver();
		sAssert.assertAll();
	}
}
