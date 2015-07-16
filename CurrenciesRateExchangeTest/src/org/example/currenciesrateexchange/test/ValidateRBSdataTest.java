package org.example.currenciesrateexchange.test;

import org.example.currenciesrateexchange.ValidateRBSdata;
import android.test.AndroidTestCase;
/**
 * ValidateRBSdataTest class enable to test all methods in 
 * ValidateRBSData class in CurrenciesRateExchange file
 * 
 * @author dsajdl01 (David Sajdl)
 * @version (01/03/2015)
 *
 */
public class ValidateRBSdataTest extends AndroidTestCase {
	
	private ValidateRBSdata rbsDataV;
	private ValidateRBSdata rbsDataNotV;
	
	public ValidateRBSdataTest(){
		
	}
	/**
     * setUp() method is called before every single test inside 
     * ValidateRBSdataTest class is tested and it creates two instances of the 
     * ValidateRBSData class plus it sets instance variables with HTML RBS source value
     * 
     */
	protected void setUp() {
		  String url = "<!DOCTYPE html>" 
                  + "<div id=\"mid\">" 
                  + "<h1 id=\"flashcontent_ID0EYUAG\" class=\"printHidden jqsifr lola\">Exchange rates</h1>"
                  +   "<script type=\"text/javascript\">"
                  + " $(\"#flashcontent_ID0EYUAG\").sifr({ swf : \"/templates/swf/lola.swf\", text : \"Exchange rates\", width : 390, height : 25, offsetTop : 0, textColour : \"#002A66\", link : \"\" });"
                  + " </script> "
                  +   "<br class=\"cb\" /> "
                  +   "<h2 class=\"hdn\">Travel money</h2> <div> <p>The table below displays the currencies and exchange rates as at 06/12/2014. You can also use our"
                  +  " <a id=\"autid200753104948\" href=\"/personal/travel/g1/money/currency-converter.ashx\">currency converter</a> to get the latest conversion rates to or from Sterling.</p></div> <ul class=\"linklist\"> <li><a id=\"autid200753105249\" href=\"#exchangeRatesNotes\">Banknote exchange rates</a></li> <li><a href=\"#exchangeRatesCheques\">Travellers Cheque exchange rates</a></li></ul> <div id=\"autid2007104165210\" edit=\"w\"> <p>The currency converter and exchange rate board contain indication rates only. These rates exclude any other associated charges which may apply. Please ask your branch for details of exchange rates before you make the transaction.</p></div> <div><a name=\"exchangeRatesNotes\"> </a> <h3>Notes</h3></div><div class=\"table_top\" xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\\\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\"><hr /></div><table xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\"><colgroup><col width=\"33%\" /><col width=\"33%\" /><col width=\"33%\" /></colgroup><thead><tr><th>Currency</th><th>Bank buys</th><th>Bank sells</th></tr></thead><tr><td>EURO</td><td>1.38</td><td>1.21</td></tr><tr><td>US DOLLARS</td><td>1.71</td><td>1.50</td></tr><tr><td>AUSTRALIAN DOLLARS</td><td>2.04</td><td>1.78</td></tr><tr><td>BAHRAINIAN DINARS</td><td>0.65</td><td>0.57</td></tr><tr><td>BARBADOS DOLLARS</td><td>3.42</td><td>2.86</td></tr><tr><td>BRAZILIAN REAL</td><td>4.54</td><td>3.61</td></tr><tr><td>BRUNEI RINGGITS</td><td>2.26</td><td>1.97</td></tr><tr><td>BULGARIAN LEV</td><td>2.77</td><td>2.25</td></tr><tr><td>CANADIAN DOLLARS</td><td>1.94</td><td>1.69</td></tr><tr><td>CAYMAN ISLANDS DOLLARS</td><td>1.41</td><td>1.19</td></tr><tr><td>CHILEAN PESOS</td><td>1056.08</td><td>871.04</td></tr><tr><td>CHINESE YUAN</td><td>10.79</td><td>8.75</td></tr><tr><td>COSTA RICAN COLON</td><td>952.45</td><td>726.64</td></tr><tr><td>CROATIAN KUNA</td><td>10.68</td><td>8.83</td></tr><tr><td>CZECH KORUNA</td><td>39.14</td><td>31.54</td></tr><tr>"
                  +   "<td>SAUDI ARABIAN RIYALS</td><td>6.37</td><td>5.63</td></tr><tr><td>SINGAPORE DOLLARS</td><td>2.25</td><td>1.94</td></tr><tr><td>SOUTH AFRICAN RAND</td><td>19.52</td><td>16.53</td></tr><tr><td>SOUTH KOREAN WON</td><td>1919.92</td><td>1583.52</td></tr><tr><td>SWEDISH KRONA</td><td>12.55</td><td>11.16</td></tr><tr><td>SWISS FRANCS</td><td>1.67</td><td>1.44</td></tr><tr><td>THAI BAHTS</td><td>56.74</td><td>47.13</td></tr><tr><td>TRINIDAD &amp; TOBAGO DOLLAR</td><td>10.71</td><td>8.97</td></tr><tr class=\"last_row\"><td>UAE DIRHAMS</td><td>6.36</td><td>5.29</td></tr></table><div class=\"table_bot white\" xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\"><hr /></div><br class=\"cb\" xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\" /> <div id=\"heading2\"><a class=\"b2top\" href=\"#canvas\">back to top</a></div> <div><a name=\"exchangeRatesCheques\"> </a> <h3>Travellers Cheques</h3></div><div class=\"table_top\" xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\"><hr /></div><table xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\"><colgroup><col width=\"33%\" /><col width=\"33%\" /><col width=\"33%\" /></colgroup><thead><tr><th>Currency</th><th>Bank buys</th><th>Bank sells</th></tr></thead><tr><td>EURO</td><td>1.38</td><td>1.20</td></tr><tr><td>US DOLLARS</td><td>1.73</td><td>1.46</td></tr><tr><td>AUSTRALIAN DOLLARS</td><td>2.06</td><td>1.75</td></tr><tr><td>CANADIAN DOLLARS</td><td>1.95</td><td>1.68</td></tr><tr><td>JAPANESE YEN</td><td>207.20</td><td>177.36</td></tr><tr><td>NEW ZEALAND DOLLARS</td><td>2.14</td><td>0.00</td></tr><tr><td>POUNDS STERLING</td><td>0.00</td><td>1.00</td></tr><tr><td>SOUTH AFRICAN RAND</td><td>18.84</td><td>0.00</td></tr><tr class=\"last_row\"><td>SWISS FRANCS</td><td>1.67</td><td>0.00</td></tr></table><div class=\"table_bot white\" xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\"><hr /></div><br class=\"cb\" xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\" /> <div id=\"heading2\"><a class=\"b2top\" href=\"#canvas\">back to top</a></div><br class=\"cb\" /></div> "
                  +  "<div class=\"right\">"
                  + " <div class=\"sidebar extRHS\">"
                  +       "<div class=\"sidebar_content\">"
                  +           "<h2 id=\"flashcontent_ID0EFXAG\" class=\"printHidden jqsifr rhs_sifr_heading\">Ready to order?</h2>"
                  +           "<script type=\"text/javascript\"> ";   
		  
		  String url2 = "<!DOCTYPE html>" 
                  + "<div id=\"mid\">" 
                  + "<h1 id=\"flashcontent_ID0EYUAG\" class=\"printHidden jqsifr lola\">Exchange rates</h1>"
                  +   "<script type=\"text/javascript\">"
                  + " $(\"#flashcontent_ID0EYUAG\").sifr({ swf : \"/templates/swf/lola.swf\", text : \"Exchange rates\", width : 390, height : 25, offsetTop : 0, textColour : \"#002A66\", link : \"\" });"
                  + " </script> "
                  +   "<br class=\"cb\" /> "
                  +   "<h2 class=\"hdn\">Travel money</h2> <div> <p>The table below displays the currencies and exchange rates as at 06/12/2014. You can also use our"
                  +  " <a id=\"autid200753104948\" href=\"/personal/travel/g1/money/currency-converter.ashx\">currency converter</a> to get the latest conversion rates to or from Sterling.</p></div> <ul class=\"linklist\"> <li><a id=\"autid200753105249\" href=\"#exchangeRatesNotes\">Banknote exchange rates</a></li> <li><a href=\"#exchangeRatesCheques\">Travellers Cheque exchange rates</a></li></ul> <div id=\"autid2007104165210\" edit=\"w\"> <p>The currency converter and exchange rate board contain indication rates only. These rates exclude any other associated charges which may apply. Please ask your branch for details of exchange rates before you make the transaction.</p></div> <div><a name=\"exchangeRatesNotes\"> </a> <h3>Notes</h3></div><div class=\"table_top\" xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\\\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\"><hr /></div><table xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\"><colgroup><col width=\"33%\" /><col width=\"33%\" /><col width=\"33%\" /></colgroup><thead><tr><th>Currency</th><th>Bank buys</th><th>Bank sells</th></tr></thead>"
                  // in front of EURO is added € sign so the data will not be validated
                  + "<tr><td>€EURO</td><td>1.38</td><td>1.21</td></tr><tr><td>US DOLLARS</td><td>1.71</td><td>1.50</td></tr><tr><td>AUSTRALIAN DOLLARS</td><td>2.04</td><td>1.78</td></tr><tr><td>BAHRAINIAN DINARS</td><td>0.65</td><td>0.57</td></tr><tr><td>BARBADOS DOLLARS</td><td>3.42</td><td>2.86</td></tr><tr><td>BRAZILIAN REAL</td><td>4.54</td><td>3.61</td></tr><tr><td>BRUNEI RINGGITS</td><td>2.26</td><td>1.97</td></tr><tr><td>BULGARIAN LEV</td><td>2.77</td><td>2.25</td></tr><tr><td>CANADIAN DOLLARS</td><td>1.94</td><td>1.69</td></tr><tr><td>CAYMAN ISLANDS DOLLARS</td><td>1.41</td><td>1.19</td></tr><tr><td>CHILEAN PESOS</td><td>1056.08</td><td>871.04</td></tr><tr><td>CHINESE YUAN</td><td>10.79</td><td>8.75</td></tr><tr><td>COSTA RICAN COLON</td><td>952.45</td><td>726.64</td></tr><tr><td>CROATIAN KUNA</td><td>10.68</td><td>8.83</td></tr><tr><td>CZECH KORUNA</td><td>39.14</td><td>31.54</td></tr><tr>"
                  +   "<td>SAUDI ARABIAN RIYALS</td><td>6.37</td><td>5.63</td></tr><tr><td>SINGAPORE DOLLARS</td><td>2.25</td><td>1.94</td></tr><tr><td>SOUTH AFRICAN RAND</td><td>19.52</td><td>16.53</td></tr><tr><td>SOUTH KOREAN WON</td><td>1919.92</td><td>1583.52</td></tr><tr><td>SWEDISH KRONA</td><td>12.55</td><td>11.16</td></tr><tr><td>SWISS FRANCS</td><td>1.67</td><td>1.44</td></tr><tr><td>THAI BAHTS</td><td>56.74</td><td>47.13</td></tr><tr><td>TRINIDAD &amp; TOBAGO DOLLAR</td><td>10.71</td><td>8.97</td></tr><tr class=\"last_row\"><td>UAE DIRHAMS</td><td>6.36</td><td>5.29</td></tr></table><div class=\"table_bot white\" xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\"><hr /></div><br class=\"cb\" xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\" /> <div id=\"heading2\"><a class=\"b2top\" href=\"#canvas\">back to top</a></div> <div><a name=\"exchangeRatesCheques\"> </a> <h3>Travellers Cheques</h3></div><div class=\"table_top\" xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\"><hr /></div><table xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\"><colgroup><col width=\"33%\" /><col width=\"33%\" /><col width=\"33%\" /></colgroup><thead><tr><th>Currency</th><th>Bank buys</th><th>Bank sells</th></tr></thead><tr><td>EURO</td><td>1.38</td><td>1.20</td></tr><tr><td>US DOLLARS</td><td>1.73</td><td>1.46</td></tr><tr><td>AUSTRALIAN DOLLARS</td><td>2.06</td><td>1.75</td></tr><tr><td>CANADIAN DOLLARS</td><td>1.95</td><td>1.68</td></tr><tr><td>JAPANESE YEN</td><td>207.20</td><td>177.36</td></tr><tr><td>NEW ZEALAND DOLLARS</td><td>2.14</td><td>0.00</td></tr><tr><td>POUNDS STERLING</td><td>0.00</td><td>1.00</td></tr><tr><td>SOUTH AFRICAN RAND</td><td>18.84</td><td>0.00</td></tr><tr class=\"last_row\"><td>SWISS FRANCS</td><td>1.67</td><td>0.00</td></tr></table><div class=\"table_bot white\" xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\"><hr /></div><br class=\"cb\" xmlns:nav=\"http://www.rbs.com/schemas/navigation\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:c=\"http://www.rbs.com/schemas/content\" xmlns:http=\"http://www.rbs.com/schemas/httpContext\" xmlns:req=\"http://www.rbs.com/schemas/pageRequest\" /> <div id=\"heading2\"><a class=\"b2top\" href=\"#canvas\">back to top</a></div><br class=\"cb\" /></div> "
                  +  "<div class=\"right\">"
                  + " <div class=\"sidebar extRHS\">"
                  +       "<div class=\"sidebar_content\">"
                  +           "<h2 id=\"flashcontent_ID0EFXAG\" class=\"printHidden jqsifr rhs_sifr_heading\">Ready to order?</h2>"
                  +           "<script type=\"text/javascript\"> "; 
	rbsDataV = new ValidateRBSdata(url);
	rbsDataNotV = new ValidateRBSdata(url2);
	
	}
	/**
     * tearDown() is called after every single test inside ValidateRBSdataTest class is tested 
     * and it sets instance variables rbsDataV rbsDataNotV to null
     */
	protected void tearDown() {

		rbsDataV = null;
		rbsDataNotV = null;
	}
	/**
     * testing getData() method.
     */
	public void testGetData(){
		String[] rbsDataArray = rbsDataV.getData();
		assertNotNull(rbsDataArray);
		assertEquals("EURO",rbsDataArray[0].trim());
		assertEquals("1.38",rbsDataArray[1].trim());
		assertEquals("1.21",rbsDataArray[2].trim());
		int lastIndex = rbsDataArray.length -1;
		assertEquals("5.29",rbsDataArray[lastIndex - 1].trim());
		assertEquals("6.36",rbsDataArray[lastIndex - 2].trim());
		assertEquals("UAE DIRHAMS",rbsDataArray[lastIndex - 3].trim());
		
		assertNull(rbsDataNotV.getData());
		
	}
	/**
     * testing getValid() method.
     */
	public void testgetValid(){
		assertTrue(rbsDataV.getValid());
		assertFalse(rbsDataNotV.getValid());
	}
	/**
     * testing getErrorMessage() method.
     */
	public void testGetErrorMessage(){
		assertNull(rbsDataV.getErrorMessage());
		assertEquals("RBS data is not valiadated!",rbsDataNotV.getErrorMessage());
	}
	/**
     * testing validateData() method.
     */
	public void testValidateData(){
		assertTrue(rbsDataV.validateData("Fred Shith", "2.89", "19.99"));
		assertTrue(rbsDataV.validateData("USA &iuy; EURO", "123456.8901", "654321"));
		assertTrue(rbsDataV.validateData("woow &tdr; mow", "1", "0.9941"));
		
		assertFalse(rbsDataV.validateData("Fred Shith", "2.89969", "19.99"));
		assertFalse(rbsDataV.validateData("USA &iuy;", "123456.8901", "654321"));
		assertFalse(rbsDataV.validateData("woow & mow", "1", "0.9941"));
		assertFalse(rbsDataV.validateData("Fred Shith", "2.89", "1,999"));
		assertFalse(rbsDataV.validateData("USA", "12.8.9", "654"));
		assertFalse(rbsDataV.validateData("woow", "1", "0.99412"));
		assertFalse(rbsDataV.validateData("woow &tdr mow", "1", "0.99"));
	}
}
