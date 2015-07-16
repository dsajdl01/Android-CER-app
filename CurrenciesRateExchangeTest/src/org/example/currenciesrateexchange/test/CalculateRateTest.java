package org.example.currenciesrateexchange.test;

import org.example.currenciesrateexchange.CalculateRate;
import android.test.AndroidTestCase;
/**
 * CalculateRateTest class enable to test all methods in 
 * CalculateRate class in CurrenciesRateExchange file
 * 
 * @author dsajdl01 (David Sajdl)
 * @version (01/03/2015)
 *
 */
public class CalculateRateTest extends AndroidTestCase {
	
		private CalculateRate cr1;
		private CalculateRate cr2;
		private double have1, have2, want1, want2;
		
		public CalculateRateTest(){
			
		}
		/**
	     * setUp() method is called before every single test inside 
	     * CalculateRateTest class is tested and it sets instance variables
	     */
		public void setUp(){
			have1 = 3.0921;
			want1 = 6.932734;
			cr1 = new CalculateRate(have1, want1);
			have2 = 8;
			want2 = 0.896554;
			cr2 = new CalculateRate(have2, want2);
		}
		/**
         * tearDown() is called after every single test inside CalculateRateTest class is tested 
         * and it sets instance variables cr1 and cr2 to null
         */
		public void tearDown(){
			cr1 = null;
			cr2 = null;
		}
		/**
         * testing getHave() method.
         */
		public void testGetHave(){
			assertEquals(have1, cr1.getHave());
			assertEquals(have2, cr2.getHave());
			assertNotSame(have1, cr2.getHave());
		}
		/**
	     * testing getWant() method.
	     */
		public void testGetWant(){
			assertEquals(want1, cr1.getWant());
			assertEquals(want2, cr2.getWant());
			assertNotSame(want1, cr2.getWant());
		}
		/**
	     * testing getRate() method.
	     */
		public void testGetRate(){
			Double result1 = want1/have1;
			assertEquals(result1, cr1.getRate());
			Double result2 = want2/have2;
			assertEquals(result2, cr2.getRate());
			Double result3 = want1/have2;
			assertNotSame(result3, cr1.getRate());
			assertNotSame(result3, cr2.getRate());
		}
		/**
	     * testing calculateUserInput() method.
	     */
		public void testCalculateUserInput(){
			Double input = 1500.00;
			Double result1 = (want1/have1) * input;
			assertEquals(result1, cr1.calculateUserInput(input));
			Double result2 = (want2/have2) * input;
			assertEquals(result2, cr2.calculateUserInput(input));
			assertNotSame(result1, cr2.calculateUserInput(input));
			assertNotSame(result2, cr1.calculateUserInput(input));
		}

}
