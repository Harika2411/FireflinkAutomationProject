package firelink.ninzaCRM.GenericUtitlity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *  This class consists of generic  methods related to java operations 
 * @author Vemula Harika
 */
public class JavaUtility {
	
	/**
	 * Generate random number and return it to caller
	 * @param num
	 * @return
	 */
	public int GenerateRandomNumber(int num) {
		Random r=new Random();
		 int RandomNum=r.nextInt(num);
		return RandomNum; 
		
	}
	
	
	/**
	 * Generating date and return it to caller
	 * @param format
	 * @return
	 */
	public String GenerateDate() {
		//format-->"dd-MM-yyyy_hh-mm-ss"
		Date d=new Date();
		SimpleDateFormat dd=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date=dd.format(d);
		return date;
	}
	

	

}
