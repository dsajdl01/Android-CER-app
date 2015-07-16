package org.example.currenciesrateexchange.test;

import org.example.currenciesrateexchange.ValidateXRateData;
import android.test.AndroidTestCase;
/**
 * ValidateXRateDataTest class enable to test all methods in 
 * ValidateXRateData class in CurrenciesRateExchange file
 * 
 * @author dsajdl01 (David Sajdl)
 * @version (01/03/2015)
 *
 */
public class VatidateXRateDateTest extends AndroidTestCase {
	private ValidateXRateData vd;
    private ValidateXRateData notVd;
    
    public VatidateXRateDateTest(){
    	
    }
    /**
     * setUp() method is called before every single test inside 
     * ValidateXRateDataTest class is tested and it creates two instances of the 
     * ValidateXRateData class plus it sets instance variables with HTML source value
     * 
     */
   	protected void setUp() {
   			String data = " <div class=\'moduleContent\'> <h1 class=\"basicH1 ratestableH1\"> <span class=\"OutputHeader\">Rates Table</span><a href='#converter' class='backToConverterButton'>Converter</a> "
   	                + "<tbody> <tr> <td>Euro</td> <td class='rtRates'><a href='/graph/?from=GBP&amp;to=EUR'>1.277233</a></td> <td class='rtRates'><a href='/graph/?from=EUR&amp;to=GBP'>0.782943</a></td> </tr> <tr> <td>US Dollar</td> <td class='rtRates'><a href='/graph/?from=GBP&amp;to=USD'>1.532750</a></td> <td class='rtRates'><a href='/graph/?from=USD&amp;to=GBP'>0.652422</a></td> " 
   	                + " <td class='rtRates'><a href='/graph/?from=GBP&amp;to=NZD'>1.989809</a></td> <td class='rtRates'><a href='/graph/?from=NZD&amp;to=GBP'>0.502561</a></td> </tr> </tbody> </table> <span class='ratesTableAlpha'>Alphabetical order</span> <span class=\"ratesTimestamp\">Jan 03, 2015 13:23 UTC</span> <table class=\"tablesorter ratesTable\" cellpadding=0 cellspacing=0> <thead>   <tr>"
   	                + "<th class='rtHeader rtHeaderCurr'>British Pound</th> <th class='rtHeader rtHeaderValues'>1.00 GBP</th> <th class='rtHeader rtHeaderValues'>inv. 1.00 GBP</th> </tr> </thead> <tbody> <tr> <td>Argentine Peso</td> <td class='rtRates'><a href='/graph/?from=GBP&amp;to=ARS'>13.105013</a></td> <td class='rtRates'><a href='/graph/?from=ARS&amp;to=GBP'>0.076307</a></td>"             
   	                + " </tr> <tr> <td>Australian Dollar</td> <td class='rtRates'><a href='/graph/?from=GBP&amp;to=AUD'>1.893804</a></td> <td class='rtRates'><a href='/graph/?from=AUD&amp;to=GBP'>0.528038</a></td> </tr> <tr> <td>Bahraini Dinar</td>"
   	                + "<td class='rtRates'><a href='/graph/?from=GBP&amp;to=TTD'>9.754115</a></td><td class='rtRates'><a href='/graph/?from=TTD&amp;to=GBP'>0.102521</a></td></tr><tr><td>Turkish Lira</td><td class='rtRates'><a href='/graph/?from=GBP&amp;to=TRY'>3.601656</a></td><td class='rtRates'><a href='/graph/?from=TRY&amp;to=GBP'>0.277650</a></td></tr><tr><td>Emirati Dirham</td>"
   	                +"  <td class='rtRates'><a href='/graph/?from=GBP&amp;to=AED'>5.629637</a></td><td class='rtRates'><a href='/graph/?from=AED&amp;to=GBP'>0.177631</a></td></tr><tr><td>US Dollar</td><td class='rtRates'><a href='/graph/?from=GBP&amp;to=USD'>1.532750</a></td><td class='rtRates'><a href='/graph/?from=USD&amp;to=GBP'>0.652422</a></td></tr><tr><td>Venezuelan Bolivar</td>"
   	                +"  <td class='rtRates'><a href='/graph/?from=GBP&amp;to=VEF'>9.656708</a></td><td class='rtRates'><a href='/graph/?from=VEF&amp;to=GBP'>0.103555</a></td></tr></tbody></table><script type=\"text/javascript\">";
   			
   			// in data 'Venezuelan Bolivar' was added extra dots so the data should not be validated! 9.65.6708
   	   String data2 = " <div class=\'moduleContent\'> <h1 class=\"basicH1 ratestableH1\"> <span class=\"OutputHeader\">Rates Table</span><a href='#converter' class='backToConverterButton'>Converter</a> "
   	                + "<tbody> <tr> <td>Euro</td> <td class='rtRates'><a href='/graph/?from=GBP&amp;to=EUR'>1.277233</a></td> <td class='rtRates'><a href='/graph/?from=EUR&amp;to=GBP'>0.782943</a></td> </tr> <tr> <td>US Dollar</td> <td class='rtRates'><a href='/graph/?from=GBP&amp;to=USD'>1.532750</a></td> <td class='rtRates'><a href='/graph/?from=USD&amp;to=GBP'>0.652422</a></td> " 
   	                + " <td class='rtRates'><a href='/graph/?from=GBP&amp;to=NZD'>1.989809</a></td> <td class='rtRates'><a href='/graph/?from=NZD&amp;to=GBP'>0.502561</a></td> </tr> </tbody> </table> <span class='ratesTableAlpha'>Alphabetical order</span> <span class=\"ratesTimestamp\">Jan 03, 2015 13:23 UTC</span> <table class=\"tablesorter ratesTable\" cellpadding=0 cellspacing=0> <thead>   <tr>"
   	                + "<th class='rtHeader rtHeaderCurr'>British Pound</th> <th class='rtHeader rtHeaderValues'>1.00 GBP</th> <th class='rtHeader rtHeaderValues'>inv. 1.00 GBP</th> </tr> </thead> <tbody> <tr> <td>Argentine Peso</td> <td class='rtRates'><a href='/graph/?from=GBP&amp;to=ARS'>13.105013</a></td> <td class='rtRates'><a href='/graph/?from=ARS&amp;to=GBP'>0.076307</a></td>"             
   	                + " </tr> <tr> <td>Australian Dollar</td> <td class='rtRates'><a href='/graph/?from=GBP&amp;to=AUD'>1.893804</a></td> <td class='rtRates'><a href='/graph/?from=AUD&amp;to=GBP'>0.528038</a></td> </tr> <tr> <td>Bahraini Dinar</td>"
   	                + "<td class='rtRates'><a href='/graph/?from=GBP&amp;to=TTD'>9.754115</a></td><td class='rtRates'><a href='/graph/?from=TTD&amp;to=GBP'>0.102521</a></td></tr><tr><td>Turkish Lira</td><td class='rtRates'><a href='/graph/?from=GBP&amp;to=TRY'>3.601656</a></td><td class='rtRates'><a href='/graph/?from=TRY&amp;to=GBP'>0.277650</a></td></tr><tr><td>Emirati Dirham</td>"
   	                +"  <td class='rtRates'><a href='/graph/?from=GBP&amp;to=AED'>5.629637</a></td><td class='rtRates'><a href='/graph/?from=AED&amp;to=GBP'>0.177631</a></td></tr><tr><td>US Dollar</td><td class='rtRates'><a href='/graph/?from=GBP&amp;to=USD'>1.532750</a></td><td class='rtRates'><a href='/graph/?from=USD&amp;to=GBP'>0.652422</a></td></tr><tr><td>Venezuelan Bolivar</td>"
   	                +"  <td class='rtRates'><a href='/graph/?from=GBP&amp;to=VEF'>9.65.6708</a></td><td class='rtRates'><a href='/graph/?from=VEF&amp;to=GBP'>0.103555</a></td></tr></tbody></table><script type=\"text/javascript\">";
   	    vd = new ValidateXRateData(data);
   	    notVd = new ValidateXRateData(data2);

   	}
   	/**
     * tearDown() is called after every single test inside  
     * ValidateXRateDataTest class is tested and 
     * it sets instance variables vd and notVd to null
     */
   	protected void tearDown() {
   			vd = null;
   	        notVd = null;
   		}
   	/**
     * testing getValid() method.
     */
   	public void testGetValid(){
        assertEquals(true,vd.getValid());
        assertEquals(false,notVd.getValid());
    }
   	/**
     * testing getErrorMessage() method.
     */
    public void testGetErrorMessage(){
        assertNull(vd.getErrorMessage());
        assertNotNull(notVd.getErrorMessage());
        assertEquals("x-Rate data was NOT validated!",notVd.getErrorMessage());
    }
    /**
     * testing getData() method.
     */
    public void testGetData(){
        String[] dataArray = vd.getData();
        assertEquals("Argentine Peso",dataArray[0]);
        assertEquals("13.105013",dataArray[1]);
        assertEquals("9.656708",dataArray[dataArray.length - 1]);
        assertEquals("Venezuelan Bolivar",dataArray[dataArray.length - 2]);
         
        String[] notValDataArray = notVd.getData();
        assertNull(notValDataArray);
    }
    /**
     * testing ValidateDate() method.
     */
    public void testValidateData(){
        assertEquals(true,vd.validateData("Czech Republic","35.34895"));
        assertEquals(false,vd.validateData("Czech Republic","35,34895"));
        assertEquals(true,vd.validateData("Great Britan","1"));
        assertEquals(false,vd.validateData("Great & Britan","1"));
        assertEquals(false,vd.validateData("Great Britan","1.0000000000"));
    }
}
