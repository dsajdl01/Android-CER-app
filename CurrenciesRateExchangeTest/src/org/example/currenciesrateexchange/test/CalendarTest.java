package org.example.currenciesrateexchange.test;

import org.example.currenciesrateexchange.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import android.annotation.SuppressLint;
import android.test.AndroidTestCase;
/**
 * CalendarTest class enable to test method in 
 * Calendar class in CurrenciesRateExchange file
 * 
 * @author dsajdl01 (David Sajdl)
 * @version (01/03/2015)
 *
 */
@SuppressLint("SimpleDateFormat")
public class CalendarTest extends AndroidTestCase {
	
	private Calendar c;

	public CalendarTest(){
	}
	/**
     * setUp() method is called before every single test inside 
     * CalendarTest class is tested and it creates instance of the Calendar class
     */
	public void setUp(){
		c = new Calendar();
	}
	/**
     * tearDown() is called after every single test inside CalendarTest class is tested 
     * and it sets instance variables c to null
     */
	protected void tearDown() {
		c = null;
	}
	/**
     * testing getCurrentDate() method 
     * 
     */
	public void testGetCurrentDate(){
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		assertEquals(date, c.getCurrentDate());
	}
	
}
