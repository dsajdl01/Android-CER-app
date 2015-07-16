package org.example.currenciesrateexchange.test;

import org.example.currenciesrateexchange.SwitchCurrencyName;

import android.test.AndroidTestCase;
/**
 * SwitchCurrencyNameTest class enable to test all methods in 
 * SwitchCurrencyName class in CurrenciesRateExchange file
 * 
 * @author dsajdl01 (David Sajdl)
 * @version (01/03/2015)
 *
 */
public class SwitchCurrencyNameTest extends AndroidTestCase {
	
	private SwitchCurrencyName swn;
	private String euro, usa, czech, russia, thai;
	
	public SwitchCurrencyNameTest(){
		
	}
	/**
     * setUp() method is called before every single test inside 
     * CalculateRateTest class is tested and it creates instance of the 
     * SwitchCurrencyName class plus it sets instance variables with values
     */
	public void setUp(){
		swn = new SwitchCurrencyName();
		euro = "EUR - EURO";
		usa = "USD - US Dollar";
		czech = "CZK - Czech Koruna";
		russia = "RUB - Russian Ruble";
		thai = "THB - Thai Bath";
		
	}
	/**
     * tearDown() is called after every single test inside CalculateRateTest class is tested 
     * and it sets instance variable wsn to null
     */
	public void tearDown(){
		swn = null;
	}
	/**
     * testing switchXRateCurrencyName() method.
     */
	public void testSwitchXRateCurrencyName(){
		assertEquals("Euro", swn.switchXRateCurrencyName(euro));
		assertEquals("US Dollar", swn.switchXRateCurrencyName(usa));
		assertEquals("Czech Koruna", swn.switchXRateCurrencyName(czech));
		assertEquals("Russian Ruble", swn.switchXRateCurrencyName(russia));
		assertEquals("Thai Baht", swn.switchXRateCurrencyName(thai));
		assertNull(swn.switchXRateCurrencyName("England"));
	}
	/**
     * testing switchRBSCurrencyName() method.
     */
	public void testSwitchRBSCurrencyName(){
		assertEquals("EURO", swn.switchRBSCurrencyName(euro));
		assertEquals("US DOLLARS", swn.switchRBSCurrencyName(usa));
		assertEquals("CZECH KORUNA", swn.switchRBSCurrencyName(czech));
		assertEquals("RUSSIAN RUBLE", swn.switchRBSCurrencyName(russia));
		assertEquals("THAI BAHTS", swn.switchRBSCurrencyName(thai));
		assertNull(swn.switchRBSCurrencyName("England"));
	}
	/**
     * testing switchBarclaysCurrencyName() method.
     */
	public void testSwitchBarclaysCurrencyName(){
		assertEquals("Euro", swn.switchBarclaysCurrencyName(euro));
		assertEquals("US Dollar", swn.switchBarclaysCurrencyName(usa));
		assertEquals("Czech Koruna", swn.switchBarclaysCurrencyName(czech));
		assertEquals("Russian Ruble", swn.switchBarclaysCurrencyName(russia));
		assertEquals("Thai Baht", swn.switchBarclaysCurrencyName(thai));
		assertNull(swn.switchBarclaysCurrencyName("England"));
	}
}
