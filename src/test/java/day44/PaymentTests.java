package day44;

import org.testng.annotations.Test;

public class PaymentTests {

	@Test(priority=1,groups= {"sanity","regression","functional"})
	void paymentinRupees()
	{
		System.out.println("payment in rupees....");
	}
	
	
	@Test(priority=2,groups= {"sanity","regression","functional"})
	void paymentinDollars()
	{
		System.out.println("payment in dollars....");
	}
}
//When testcase has multiple group then give group name as here sanity and regression give give group name functional
//This one helps when we run more then one group together in xml file by giving single group name in include