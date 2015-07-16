package org.example.currenciesrateexchange.test;

import org.example.currenciesrateexchange.ValidateBarclaysData;
import android.test.AndroidTestCase;
/**
 * ValidateBarclaysDataTest class enable to test all methods in 
 * ValidateBarclaysData class in CurrenciesRateExchange file
 * 
 * @author dsajdl01 (David Sajdl)
 * @version (01/03/2015)
 *
 */
public class ValidateBarclaysDataTest extends AndroidTestCase {
	
	private ValidateBarclaysData barclaysDataV;
	private ValidateBarclaysData barclaysDataNotV;
	
	public ValidateBarclaysDataTest(){
		
	}
	/**
     * setUp() method is called before every single test inside 
     * ValidateBarclaysDataTest class is tested and it creates two instances of the 
     * ValidateBarclaysData class plus it sets instance variables with HTML source value
     * 
     */
	protected void setUp() {
	
		String brcURLData = "<table class=\"fxrates_graph\" width=\"100%\" border=\"0\"><tr><td><br /><b>British Pound - euro</b>"
					            + "<br /><div class=\"fxrates_plot\" id=\"81b813907c47437a9db4011e74d16a27\" ></div><div class=\"code prettyprint\"><pre class=\"code prettyprint brush: js\"></pre></div></td></tr>"
					            + "<tr><td><br /><b>British Pound - US Dollar</b><br /><div class=\"fxrates_plot\" id=\"0a128859ae79435ab886070f1af16cb7\" ></div>"
					            + "<div class=\"code prettyprint\"><pre class=\"code prettyprint brush: js\"></pre></div></td></tr></table><!--Time taken for fxrate (GBP): 166 ms. -->"
					            + "</div></div></div><div id=\"tab1\"><div class=\"parsys tab_par_1\"><div class=\"fxrate section\">"
					            + "<script language=\"javascript\" type=\"text/javascript\" src=\"/etc/designs/corppublic/corppublic/chart/excanvas.min.js\"></script>"
					            + "<script language=\"javascript\" type=\"text/javascript\" src=\"/etc/designs/corppublic/corppublic/chart/jquery.jqplot.min.js\"></script>"
					            + "<script language=\"javascript\" type=\"text/javascript\" src=\"/etc/designs/corppublic/corppublic/chart/jqplot.dateAxisRenderer.min.js\"></script>"
					            + "<script language=\"javascript\" type=\"text/javascript\" src=\"/etc/designs/corppublic/corppublic/js/fxchart_responsive.js\"></script>"
					            + "<link rel=\"stylesheet\" type=\"text/css\" href=\"/etc/designs/corppublic/corppublic/chart/jquery.jqplot.min.css\"/><script type=\"text/javascript\">"
					            + "chart2ba4633b61eb4d819b6030a9ddfa3453 = [[['2015-02-08 10:59:27',.6564],['2015-02-08 10:54:26',.6564],['2015-02-08 10:49:26',.6564],['2015-02-08 10:44:25',.6564],['2015-02-08 10:39:24',.6564],['2015-02-08 10:34:23',.6564],['2015-02-08 10:29:22',.6564],['2015-02-08 10:24:21',.6564],['2015-02-08 10:19:20',.6564],['2015-02-08 10:14:18',.6564],['2015-02-08 10:09:17',.6564],['2015-02-08 10:04:16',.6564],['2015-02-08 09:59:15',.6564],['2015-02-08 09:54:15',.6564],['2015-02-08 09:49:14',.6564],['2015-02-08 09:44:13',.6564],['2015-02-08 09:39:11',.6564],['2015-02-08 09:34:10',.6564],['2015-02-08 09:29:09',.6564],['2015-02-08 09:24:08',.6564],['2015-02-08 09:19:06',.6564],['2015-02-08 09:14:05',.6564],['2015-02-08 09:09:04',.6564],['2015-02-08 09:04:02',.6564],['2015-02-08 08:59:01',.6564],['2015-02-08 08:54:00',.6564],['2015-02-08 08:48:59',.6564],['2015-02-08 08:43:58',.6564],['2015-02-08 08:38:56',.6564],['2015-02-08 08:33:55',.6564],['2015-02-08 08:28:54',.6564],['2015-02-08 08:23:53',.6564],['2015-02-08 08:18:52',.6564],['2015-02-08 08:13:50',.6564],['2015-02-08 08:08:49',.6564],['2015-02-08 08:03:46',.6564],['2015-02-08 07:58:44',.6564],['2015-02-08 07:53:42',.6564],['2015-02-08 07:48:39',.6564],['2015-02-08 07:43:37',.6564],['2015-02-08 07:38:35',.6564],['2015-02-08 07:33:33',.6564],['2015-02-08 07:28:30',.6564],['2015-02-08 07:23:25',.6564],['2015-02-08 07:18:22',.6564],['2015-02-08 07:13:21',.6564],['2015-02-08 07:08:17',.6564],['2015-02-08 07:03:14',.6564],['2015-02-08 06:58:12',.6564],['2015-02-08 06:53:09',.6564],['2015-02-08 06:48:05',.6564],['2015-02-08 06:43:02',.6564],['2015-02-08 06:37:59',.6564],['2015-02-08 06:32:56',.6564],['2015-02-08 06:27:52',.6564],['2015-02-08 06:22:49',.6564],['2015-02-08 06:17:45',.6564],['2015-02-08 06:12:39',.6564],['2015-02-08 06:07:37',.6564],['2015-02-08 06:02:29',.6564],['2015-02-08 05:57:28',.6564],['2015-02-08 05:52:27',.6564],['2015-02-08 05:47:27',.6564],['2015-02-08 05:42:26',.6564],['2015-02-08 05:37:25',.6564],['2015-02-08 05:32:24',.6564],['2015-02-08 05:27:24',.6564],['2015-02-08 05:22:23',.6564],['2015-02-08 05:17:22',.6564],['2015-02-08 05:12:21',.6564],['2015-02-08 05:07:21',.6564],['2015-02-08 05:02:20',.6564],['2015-02-08 04:57:19',.6564],['2015-02-08 04:52:18',.6564],['2015-02-08 04:47:17',.6564],['2015-02-08 04:42:16',.6564],['2015-02-08 04:37:16',.6564],['2015-02-08 04:32:15',.6564],['2015-02-08 04:27:14',.6564],['2015-02-08 04:22:13',.6564],['2015-02-08 04:17:12',.6564],['2015-02-08 04:12:12',.6564],['2015-02-08 04:07:10',.6564],['2015-02-08 04:02:09',.6564],['2015-02-08 03:57:05',.6564]]];"
					            + "options2ba4633b61eb4d819b6030a9ddfa3453 ={  axes:{  xaxis:{min:'2015-02-08 03:57:05',max: '2015-02-08 10:59:27'}}};"
					            + "chart3ce94e22033847d09747ed4ead8281e5 = [[['2015-02-08 10:59:27',.8837],['2015-02-08 10:54:26',.8837],['2015-02-08 10:49:26',.8837],['2015-02-08 10:44:25',.8837],['2015-02-08 10:39:24',.8837],['2015-02-08 10:34:23',.8837],['2015-02-08 10:29:22',.8837],['2015-02-08 10:24:21',.8837],['2015-02-08 10:19:20',.8837],['2015-02-08 10:14:18',.8837],['2015-02-08 10:09:17',.8837],['2015-02-08 10:04:16',.8837],['2015-02-08 09:59:15',.8837],['2015-02-08 09:54:15',.8837],['2015-02-08 09:49:14',.8837],['2015-02-08 09:44:13',.8837],['2015-02-08 09:39:11',.8837],['2015-02-08 09:34:10',.8837],['2015-02-08 09:29:09',.8837],['2015-02-08 09:24:08',.8837],['2015-02-08 09:19:06',.8837],['2015-02-08 09:14:05',.8837],['2015-02-08 09:09:04',.8837],['2015-02-08 09:04:02',.8837],['2015-02-08 08:59:01',.8837],['2015-02-08 08:54:00',.8837],['2015-02-08 08:48:59',.8837],['2015-02-08 08:43:58',.8837],['2015-02-08 08:38:56',.8837],['2015-02-08 08:33:55',.8837],['2015-02-08 08:28:54',.8837],['2015-02-08 08:23:53',.8837],['2015-02-08 08:18:52',.8837],['2015-02-08 08:13:50',.8837],['2015-02-08 08:08:49',.8837],['2015-02-08 08:03:46',.8837],['2015-02-08 07:58:44',.8837],['2015-02-08 07:53:42',.8837],['2015-02-08 07:48:39',.8837],['2015-02-08 07:43:37',.8837],['2015-02-08 07:38:35',.8837],['2015-02-08 07:33:33',.8837],['2015-02-08 07:28:30',.8837],['2015-02-08 07:23:25',.8837],['2015-02-08 07:18:22',.8837],['2015-02-08 07:13:21',.8837],['2015-02-08 07:08:17',.8837],['2015-02-08 07:03:14',.8837],['2015-02-08 06:58:12',.8837],['2015-02-08 06:53:09',.8837],['2015-02-08 06:48:05',.8837],['2015-02-08 06:43:02',.8837],['2015-02-08 06:37:59',.8837],['2015-02-08 06:32:56',.8837],['2015-02-08 06:27:52',.8837],['2015-02-08 06:22:49',.8837],['2015-02-08 06:17:45',.8837],['2015-02-08 06:12:39',.8837],['2015-02-08 06:07:37',.8837],['2015-02-08 06:02:29',.8837],['2015-02-08 05:57:28',.8837],['2015-02-08 05:52:27',.8837],['2015-02-08 05:47:27',.8837],['2015-02-08 05:42:26',.8837],['2015-02-08 05:37:25',.8837],['2015-02-08 05:32:24',.8837],['2015-02-08 05:27:24',.8837],['2015-02-08 05:22:23',.8837],['2015-02-08 05:17:22',.8837],['2015-02-08 05:12:21',.8837],['2015-02-08 05:07:21',.8837],['2015-02-08 05:02:20',.8837],['2015-02-08 04:57:19',.8837],['2015-02-08 04:52:18',.8837],['2015-02-08 04:47:17',.8837],['2015-02-08 04:42:16',.8837],['2015-02-08 04:37:16',.8837],['2015-02-08 04:32:15',.8837],['2015-02-08 04:27:14',.8837],['2015-02-08 04:22:13',.8837],['2015-02-08 04:17:12',.8837],['2015-02-08 04:12:12',.8837],['2015-02-08 04:07:10',.8837],['2015-02-08 04:02:09',.8837],['2015-02-08 03:57:05',.8837]]];"
					            + "options3ce94e22033847d09747ed4ead8281e5 ={  axes:{  xaxis:{min:'2015-02-08 03:57:05',max: '2015-02-08 10:59:27'}}};"   
					            + "</script><table width=\"100%\" border=\"0\"><tr><th style=\"color: #666666\" colspan=\"4\">"
					            + "<p>All prices on this site were updated at 08/02/15 10:59:27. Prices are shown for indication only and are not intended for trading purposes.</p></th></tr>"
					            + "<tr class=\"title\"><td><b>Currency</b></td><td style=\"text-align: right;\"><b>Exchange Rate</b></td><td style=\"text-align: right;\"><b>Change</b></td><td style=\"text-align: right;\"><b>%</b></td></tr>"
					            + "<tr class=\"currency_break\"><td colspan=\"4\"><br /></td></tr><tr><td width=\"38%\">British Pound</td>"
					            + "<td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>British Pound</span>Exchange Rate</div>0.65640</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00060</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.09</td></tr>"
					            + "<tr><td width=\"38%\">euro</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>euro</span>Exchange Rate</div>0.88370</td>"
					            + "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00160</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.18</td></tr>"
					            + "<tr class=\"currency_break\"><td colspan=\"4\"><br /></td></tr></table><div class=\"read-more-text\"><table width=\"100%\" border=\"0\"> <tr><td width=\"38%\">Australian Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Australian Dollar</span>Exchange Rate</div>1.28250</td>"
					            + "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00150</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.12</td></tr>"
					            + "<tr><td width=\"38%\">Canadian Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Canadian Dollar</span>Exchange Rate</div>1.25310</td>"
					            + "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00060</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.05</td></tr>"
					            + "<tr><td width=\"38%\">Japanese Yen</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Japanese Yen</span>Exchange Rate</div>119.12000</td>"
					            + "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.01000</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.01</td></tr>"
					            + "<tr><td width=\"38%\">New Zealand Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>New Zealand Dollar</span>Exchange Rate</div>1.35820</td>"
					            + "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.00030</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.02</td></tr>"
					            + "<tr><td width=\"38%\">Norwegian Krone</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Norwegian Krone</span>Exchange Rate</div>7.62890</td>"
					            + "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.03640</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.48</td></tr>"
					            + "<tr><td width=\"38%\">Swedish Krona</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Swedish Krona</span>Exchange Rate</div>8.39980</td>"
					            + "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.01260</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.15</td></tr>"
					            + "<tr><td width=\"38%\">Swiss Franc</td> <td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Swiss Franc</span>Exchange Rate</div>0.92690</td>"
					            + "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00270</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.29</td></tr>"
					            + "<tr class=\"currency_break\"><td colspan=\"4\"><br /></td></tr><tr><td width=\"38%\">Argentine Peso</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Argentine Peso</span>Exchange Rate</div>8.66050</td>"
					            + "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00170</td> <td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.02</td></tr>"
					            + "<tr><td width=\"38%\">Bahraini Dinar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Bahraini Dinar</span>Exchange Rate</div>0.37703</td>"
					            +  "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            + "<tr><td width=\"38%\">Barbados Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Barbados Dollar</span>Exchange Rate</div>2.00000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Botswana Pula</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Botswana Pula</span>Exchange Rate</div>9.48320</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Brazilian Real</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Brazilian Real</span>Exchange Rate</div>2.78180</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.01330</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.48</td></tr>"
					            +   "<tr><td width=\"38%\">Bulgarian Lev</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Bulgarian Lev</span>Exchange Rate</div>1.72840</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00310</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.18</td></tr>"
					            +   "<tr><td width=\"38%\">Chilean Peso</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Chilean Peso</span>Exchange Rate</div>628.00000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+1.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.16</td></tr>"
					            +   "<tr><td width=\"38%\">Chinese Renminbi</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Chinese Renminbi</span>Exchange Rate</div>6.13050</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00050</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.01</td></tr>"
					            +   "<tr><td width=\"38%\">Colombian Peso</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Colombian Peso</span>Exchange Rate</div>2381.00000</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-6.00000</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.25</td></tr>"
					            +   "<tr><td width=\"38%\">Croatian Kuna</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Croatian Kuna</span>Exchange Rate</div>6.80320</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.01100</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.16</td></tr>"
					            +   "<tr><td width=\"38%\">Czech Koruna</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Czech Koruna</span>Exchange Rate</div>24.47300</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.03700</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.15</td></tr>"
					            +   "<tr><td width=\"38%\">Danish Krona</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Danish Krona</span>Exchange Rate</div>6.57720</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.01250</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.19</td></tr>"
					            +   "<tr><td width=\"38%\">East Carribbean Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>East Carribbean Dollar</span>Exchange Rate</div>2.70250</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Egyptian Pound</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Egyptian Pound</span>Exchange Rate</div>7.62590</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00030</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>" 
					            +   "<tr> <td width=\"38%\">Estonian Kroon</td> <td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Estonian Kroon</span>Exchange Rate</div>11.69190</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Hong Kong Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Hong Kong Dollar</span>Exchange Rate</div>7.75250</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>" 
					            +   "<tr><td width=\"38%\">Hungarian Forint</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Hungarian Forint</span>Exchange Rate</div>270.42000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.81000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.30</td></tr><tr>"
					            +   "<td width=\"38%\">Iceland Krona</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Iceland Krona</span>Exchange Rate</div>109.13000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Indian Rupee</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Indian Rupee</span>Exchange Rate</div>61.71000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Indonesian Rupiah</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Indonesian Rupiah</span>Exchange Rate</div>12658.00000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Israeli Shekel</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Israeli Shekel</span>Exchange Rate</div>3.89300</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00450</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.12</td></tr>" 
					            +   "<tr><td width=\"38%\">Jamaican Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Jamaican Dollar</span>Exchange Rate</div>112.49860</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"  
					            +   "<tr><td width=\"38%\">Jordanian Dinar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Jordanian Dinar</span>Exchange Rate</div>0.70935</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.00025</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.04</td></tr>"
					            +   "<tr><td width=\"38%\">Kazakhstan Tenge</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Kazakhstan Tenge</span>Exchange Rate</div>184.81000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.04000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.02</td></tr>"  
					            +   "<tr><td width=\"38%\">Kenyan Shilling</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Kenyan Shilling</span>Exchange Rate</div>91.35000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr><tr>"
					            +   "<td width=\"38%\">Korean Wong</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Korean Wong</span>Exchange Rate</div>1089.32000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Kuwaiti Dinar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Kuwaiti Dinar</span>Exchange Rate</div>0.29535</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.00003</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.01</td></tr>"   
					            +   "<tr><td width=\"38%\">Latvian Lats</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Latvian Lats</span>Exchange Rate</div>0.51370</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Lesotho Loti</td> <td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Lesotho Loti</span>Exchange Rate</div>11.37290</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td> <td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr> " 
					            +   "<tr><td width=\"38%\">Lithuanian Litas</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Lithuanian Litas</span>Exchange Rate</div>2.84040</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr> <tr>"
					            +   "<td width=\"38%\">Malaysian Ringgit</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Malaysian Ringgit</span>Exchange Rate</div>3.55750</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00300</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.08</td></tr> "
					            +   "<tr><td width=\"38%\">Mauritius Rupee</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Mauritius Rupee</span>Exchange Rate</div>32.89000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr> "
					            +   "<tr><td width=\"38%\">Mexican Peso</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Mexican Peso</span>Exchange Rate</div>14.85310</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.06560</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.44</td></tr>"
					            +   "<tr><td width=\"38%\">Moroccan Dirham</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Moroccan Dirham</span>Exchange Rate</div>9.55810</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.01900</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.20</td></tr>"
					            +   "<tr><td width=\"38%\">Namibia Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Namibia Dollar</span>Exchange Rate</div>11.37290</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>" 
					            +   "<tr><td width=\"38%\">New Ghana Cedi</td> <td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>New Ghana Cedi</span>Exchange Rate</div>3.41000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>" 
					            +   "<tr><td width=\"38%\">New Turkish Lira</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>New Turkish Lira</span>Exchange Rate</div>2.47480</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00240</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.10</td></tr> <tr>"
					            +   "<td width=\"38%\">Nigerian Niara</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Nigerian Niara</span>Exchange Rate</div>194.00000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr> <tr>"
					            +   "<td width=\"38%\">Pakistan Rupee</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Pakistan Rupee</span>Exchange Rate</div>101.20000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Peruvian Nuevo Sol</td> <td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Peruvian Nuevo Sol</span>Exchange Rate</div>3.07100</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00100</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.03</td></tr> "
					            +   "<tr><td width=\"38%\">Phillipine Peso</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Phillipine Peso</span>Exchange Rate</div>44.34000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.01000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.02</td></tr>" 
					            +   "<tr><td width=\"38%\">Polish Zloty</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Polish Zloty</span>Exchange Rate</div>3.67060</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00280</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.08</td></tr>"  
					            +   "<tr><td width=\"38%\">Qatari Rial</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Qatari Rial</span>Exchange Rate</div>3.64110</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.00080</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.02</td></tr>" 
					            +   "<tr><td width=\"38%\">Rial Omani</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Rial Omani</span>Exchange Rate</div>0.38500</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00001</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>" 
					            +   "<tr><td width=\"38%\">Romanian Leu</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Romanian Leu</span>Exchange Rate</div>3.90220</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00800</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.21</td></tr> <tr>"
					            +   "<td width=\"38%\">Russian Ruble</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Russian Ruble</span>Exchange Rate</div>67.09160</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>" 
					            +   "<tr><td width=\"38%\">Saudi Riyal</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Saudi Riyal</span>Exchange Rate</div>3.75220</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.00050</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.01</td></tr>" 
					            +   "<tr><td width=\"38%\">Singapore Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Singapore Dollar</span>Exchange Rate</div>1.35300</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00150</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.11</td></tr> <tr>"
					            +   "<td width=\"38%\">South African Rand</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>South African Rand</span>Exchange Rate</div>11.51760</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.01810</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.16</td> </tr>"
					            +   "<tr><td width=\"38%\">Sri Lankan Rupee</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Sri Lankan Rupee</span>Exchange Rate</div>133.00000</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.05000</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.04</td> </tr> "
					            +   "<tr><td width=\"38%\">Swaziland Lilangeni</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Swaziland Lilangeni</span>Exchange Rate</div>11.37290</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr> <tr>"
					            +   "<td width=\"38%\">Taiwanese Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Taiwanese Dollar</span>Exchange Rate</div>31.65000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.05700</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.18</td></tr>" 
					            +   "<tr><td width=\"38%\">Tanzanian Shilling</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Tanzanian Shilling</span>Exchange Rate</div>1825.00000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"  
					            +   "<tr><td width=\"38%\">Thai Baht</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Thai Baht</span>Exchange Rate</div>32.66000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.02000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.06</td></tr>"  
					            +   "<tr><td width=\"38%\">Trinidad and Tobago Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Trinidad and Tobago Dollar</span>Exchange Rate</div>6.29000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"   
					            +   "<tr><td width=\"38%\">Tunisian Dinar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Tunisian Dinar</span>Exchange Rate</div>1.93200</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00020</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.01</td></tr>" 
					            +   "<tr><td width=\"38%\">UAE Dirham</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>UAE Dirham</span>Exchange Rate</div>3.67270</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.00030</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.01</td></tr>" 
					            +   "<tr> <td width=\"38%\">Uganda Shilling</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Uganda Shilling</span>Exchange Rate</div>2857.00000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr> " 
					            +   "<tr><td width=\"38%\">Zambian Kwacha</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Zambian Kwacha</span>Exchange Rate</div>     5208.00000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr></table>"  
					            +   "</div> <div class=\"morestories section\"><div class=\"bc-morestories\"><div class=\"bc-read-more-button\">"
					            +   "<a href=\"#\" class=\"read-more-button\" title=\"Show all currencies\" data-hide-text='Show fewer currencies' data-hide-title-text='Show fewer currencies' data-target='.read-more-text'>Show all currencies</a></div>"
					            +   "</div></div><table class=\"fxrates_graph\" width=\"100%\" border=\"0\"><tr><td>"
					            +   "<br /> <b>US Dollar - British Pound</b><br /><div class=\"fxrates_plot\" id=\"2ba4633b61eb4d819b6030a9ddfa3453\" ></div><div class=\"code prettyprint\"><pre class=\"code prettyprint brush: js\"></pre></div>"
					            +   "</td><tr><tr><td><br /><b>US Dollar - euro</b><br /><div class=\"fxrates_plot\" id=\"3ce94e22033847d09747ed4ead8281e5\" ></div><div class=\"code prettyprint\"><pre class=\"code prettyprint brush: js\"></pre></div>"
					            +   "</td></tr></table><!--Time taken for fxrate (USD): 3625 ms. --></div></div></div></div>"
					            +   "<script type=\"text/javascript\">$(document).ready(function(){if($(\".cq-wcm-edit\").length > 0){setTimeout(function(){$(\".tabs-panel\").tabs();}, 10000);}else{$(\".tabs-panel\").tabs();}});</script></div>}";
		String brcURLData2 = "<table class=\"fxrates_graph\" width=\"100%\" border=\"0\"><tr><td><br /><b>British Pound - euro</b>"
					            + "<br /><div class=\"fxrates_plot\" id=\"81b813907c47437a9db4011e74d16a27\" ></div><div class=\"code prettyprint\"><pre class=\"code prettyprint brush: js\"></pre></div></td></tr>"
					            + "<tr><td><br /><b>British Pound - US Dollar</b><br /><div class=\"fxrates_plot\" id=\"0a128859ae79435ab886070f1af16cb7\" ></div>"
					            + "<div class=\"code prettyprint\"><pre class=\"code prettyprint brush: js\"></pre></div></td></tr></table><!--Time taken for fxrate (GBP): 166 ms. -->"
					            + "</div></div></div><div id=\"tab1\"><div class=\"parsys tab_par_1\"><div class=\"fxrate section\">"
					            + "<script language=\"javascript\" type=\"text/javascript\" src=\"/etc/designs/corppublic/corppublic/chart/excanvas.min.js\"></script>"
					            + "<script language=\"javascript\" type=\"text/javascript\" src=\"/etc/designs/corppublic/corppublic/chart/jquery.jqplot.min.js\"></script>"
					            + "<script language=\"javascript\" type=\"text/javascript\" src=\"/etc/designs/corppublic/corppublic/chart/jqplot.dateAxisRenderer.min.js\"></script>"
					            + "<script language=\"javascript\" type=\"text/javascript\" src=\"/etc/designs/corppublic/corppublic/js/fxchart_responsive.js\"></script>"
					            + "<link rel=\"stylesheet\" type=\"text/css\" href=\"/etc/designs/corppublic/corppublic/chart/jquery.jqplot.min.css\"/><script type=\"text/javascript\">"
					            + "chart2ba4633b61eb4d819b6030a9ddfa3453 = [[['2015-02-08 10:59:27',.6564],['2015-02-08 10:54:26',.6564],['2015-02-08 10:49:26',.6564],['2015-02-08 10:44:25',.6564],['2015-02-08 10:39:24',.6564],['2015-02-08 10:34:23',.6564],['2015-02-08 10:29:22',.6564],['2015-02-08 10:24:21',.6564],['2015-02-08 10:19:20',.6564],['2015-02-08 10:14:18',.6564],['2015-02-08 10:09:17',.6564],['2015-02-08 10:04:16',.6564],['2015-02-08 09:59:15',.6564],['2015-02-08 09:54:15',.6564],['2015-02-08 09:49:14',.6564],['2015-02-08 09:44:13',.6564],['2015-02-08 09:39:11',.6564],['2015-02-08 09:34:10',.6564],['2015-02-08 09:29:09',.6564],['2015-02-08 09:24:08',.6564],['2015-02-08 09:19:06',.6564],['2015-02-08 09:14:05',.6564],['2015-02-08 09:09:04',.6564],['2015-02-08 09:04:02',.6564],['2015-02-08 08:59:01',.6564],['2015-02-08 08:54:00',.6564],['2015-02-08 08:48:59',.6564],['2015-02-08 08:43:58',.6564],['2015-02-08 08:38:56',.6564],['2015-02-08 08:33:55',.6564],['2015-02-08 08:28:54',.6564],['2015-02-08 08:23:53',.6564],['2015-02-08 08:18:52',.6564],['2015-02-08 08:13:50',.6564],['2015-02-08 08:08:49',.6564],['2015-02-08 08:03:46',.6564],['2015-02-08 07:58:44',.6564],['2015-02-08 07:53:42',.6564],['2015-02-08 07:48:39',.6564],['2015-02-08 07:43:37',.6564],['2015-02-08 07:38:35',.6564],['2015-02-08 07:33:33',.6564],['2015-02-08 07:28:30',.6564],['2015-02-08 07:23:25',.6564],['2015-02-08 07:18:22',.6564],['2015-02-08 07:13:21',.6564],['2015-02-08 07:08:17',.6564],['2015-02-08 07:03:14',.6564],['2015-02-08 06:58:12',.6564],['2015-02-08 06:53:09',.6564],['2015-02-08 06:48:05',.6564],['2015-02-08 06:43:02',.6564],['2015-02-08 06:37:59',.6564],['2015-02-08 06:32:56',.6564],['2015-02-08 06:27:52',.6564],['2015-02-08 06:22:49',.6564],['2015-02-08 06:17:45',.6564],['2015-02-08 06:12:39',.6564],['2015-02-08 06:07:37',.6564],['2015-02-08 06:02:29',.6564],['2015-02-08 05:57:28',.6564],['2015-02-08 05:52:27',.6564],['2015-02-08 05:47:27',.6564],['2015-02-08 05:42:26',.6564],['2015-02-08 05:37:25',.6564],['2015-02-08 05:32:24',.6564],['2015-02-08 05:27:24',.6564],['2015-02-08 05:22:23',.6564],['2015-02-08 05:17:22',.6564],['2015-02-08 05:12:21',.6564],['2015-02-08 05:07:21',.6564],['2015-02-08 05:02:20',.6564],['2015-02-08 04:57:19',.6564],['2015-02-08 04:52:18',.6564],['2015-02-08 04:47:17',.6564],['2015-02-08 04:42:16',.6564],['2015-02-08 04:37:16',.6564],['2015-02-08 04:32:15',.6564],['2015-02-08 04:27:14',.6564],['2015-02-08 04:22:13',.6564],['2015-02-08 04:17:12',.6564],['2015-02-08 04:12:12',.6564],['2015-02-08 04:07:10',.6564],['2015-02-08 04:02:09',.6564],['2015-02-08 03:57:05',.6564]]];"
					            + "options2ba4633b61eb4d819b6030a9ddfa3453 ={  axes:{  xaxis:{min:'2015-02-08 03:57:05',max: '2015-02-08 10:59:27'}}};"
					            + "chart3ce94e22033847d09747ed4ead8281e5 = [[['2015-02-08 10:59:27',.8837],['2015-02-08 10:54:26',.8837],['2015-02-08 10:49:26',.8837],['2015-02-08 10:44:25',.8837],['2015-02-08 10:39:24',.8837],['2015-02-08 10:34:23',.8837],['2015-02-08 10:29:22',.8837],['2015-02-08 10:24:21',.8837],['2015-02-08 10:19:20',.8837],['2015-02-08 10:14:18',.8837],['2015-02-08 10:09:17',.8837],['2015-02-08 10:04:16',.8837],['2015-02-08 09:59:15',.8837],['2015-02-08 09:54:15',.8837],['2015-02-08 09:49:14',.8837],['2015-02-08 09:44:13',.8837],['2015-02-08 09:39:11',.8837],['2015-02-08 09:34:10',.8837],['2015-02-08 09:29:09',.8837],['2015-02-08 09:24:08',.8837],['2015-02-08 09:19:06',.8837],['2015-02-08 09:14:05',.8837],['2015-02-08 09:09:04',.8837],['2015-02-08 09:04:02',.8837],['2015-02-08 08:59:01',.8837],['2015-02-08 08:54:00',.8837],['2015-02-08 08:48:59',.8837],['2015-02-08 08:43:58',.8837],['2015-02-08 08:38:56',.8837],['2015-02-08 08:33:55',.8837],['2015-02-08 08:28:54',.8837],['2015-02-08 08:23:53',.8837],['2015-02-08 08:18:52',.8837],['2015-02-08 08:13:50',.8837],['2015-02-08 08:08:49',.8837],['2015-02-08 08:03:46',.8837],['2015-02-08 07:58:44',.8837],['2015-02-08 07:53:42',.8837],['2015-02-08 07:48:39',.8837],['2015-02-08 07:43:37',.8837],['2015-02-08 07:38:35',.8837],['2015-02-08 07:33:33',.8837],['2015-02-08 07:28:30',.8837],['2015-02-08 07:23:25',.8837],['2015-02-08 07:18:22',.8837],['2015-02-08 07:13:21',.8837],['2015-02-08 07:08:17',.8837],['2015-02-08 07:03:14',.8837],['2015-02-08 06:58:12',.8837],['2015-02-08 06:53:09',.8837],['2015-02-08 06:48:05',.8837],['2015-02-08 06:43:02',.8837],['2015-02-08 06:37:59',.8837],['2015-02-08 06:32:56',.8837],['2015-02-08 06:27:52',.8837],['2015-02-08 06:22:49',.8837],['2015-02-08 06:17:45',.8837],['2015-02-08 06:12:39',.8837],['2015-02-08 06:07:37',.8837],['2015-02-08 06:02:29',.8837],['2015-02-08 05:57:28',.8837],['2015-02-08 05:52:27',.8837],['2015-02-08 05:47:27',.8837],['2015-02-08 05:42:26',.8837],['2015-02-08 05:37:25',.8837],['2015-02-08 05:32:24',.8837],['2015-02-08 05:27:24',.8837],['2015-02-08 05:22:23',.8837],['2015-02-08 05:17:22',.8837],['2015-02-08 05:12:21',.8837],['2015-02-08 05:07:21',.8837],['2015-02-08 05:02:20',.8837],['2015-02-08 04:57:19',.8837],['2015-02-08 04:52:18',.8837],['2015-02-08 04:47:17',.8837],['2015-02-08 04:42:16',.8837],['2015-02-08 04:37:16',.8837],['2015-02-08 04:32:15',.8837],['2015-02-08 04:27:14',.8837],['2015-02-08 04:22:13',.8837],['2015-02-08 04:17:12',.8837],['2015-02-08 04:12:12',.8837],['2015-02-08 04:07:10',.8837],['2015-02-08 04:02:09',.8837],['2015-02-08 03:57:05',.8837]]];"
					            + "options3ce94e22033847d09747ed4ead8281e5 ={  axes:{  xaxis:{min:'2015-02-08 03:57:05',max: '2015-02-08 10:59:27'}}};"   
					            + "</script><table width=\"100%\" border=\"0\"><tr><th style=\"color: #666666\" colspan=\"4\">"
					            + "<p>All prices on this site were updated at 08/02/15 10:59:27. Prices are shown for indication only and are not intended for trading purposes.</p></th></tr>"
					            + "<tr class=\"title\"><td><b>Currency</b></td><td style=\"text-align: right;\"><b>Exchange Rate</b></td><td style=\"text-align: right;\"><b>Change</b></td><td style=\"text-align: right;\"><b>%</b></td></tr>"
					            + "<tr class=\"currency_break\"><td colspan=\"4\"><br /></td></tr><tr><td width=\"38%\">British Pound</td>"
					            + "<td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>British Pound</span>Exchange Rate</div>0.65640</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00060</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.09</td></tr>"
					            + "<tr><td width=\"38%\">euro</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>euro</span>Exchange Rate</div>0.88370</td>"
					            + "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00160</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.18</td></tr>"
					            + "<tr class=\"currency_break\"><td colspan=\"4\"><br /></td></tr></table><div class=\"read-more-text\"><table width=\"100%\" border=\"0\"> <tr><td width=\"38%\">Australian Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Australian Dollar</span>Exchange Rate</div>1.28250</td>"
					            + "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00150</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.12</td></tr>"
					            + "<tr><td width=\"38%\">Canadian Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Canadian Dollar</span>Exchange Rate</div>1.25310</td>"
					            + "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00060</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.05</td></tr>"
					            + "<tr><td width=\"38%\">Japanese Yen</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Japanese Yen</span>Exchange Rate</div>119.12000</td>"
					            + "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.01000</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.01</td></tr>"
					            + "<tr><td width=\"38%\">New Zealand Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>New Zealand Dollar</span>Exchange Rate</div>1.35820</td>"
					            + "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.00030</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.02</td></tr>"
					            + "<tr><td width=\"38%\">Norwegian Krone</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Norwegian Krone</span>Exchange Rate</div>7.62890</td>"
					            + "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.03640</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.48</td></tr>"
					            + "<tr><td width=\"38%\">Swedish Krona</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Swedish Krona</span>Exchange Rate</div>8.39980</td>"
					            + "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.01260</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.15</td></tr>"
					            + "<tr><td width=\"38%\">Swiss Franc</td> <td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Swiss Franc</span>Exchange Rate</div>0.92690</td>"
					            + "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00270</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.29</td></tr>"
					            + "<tr class=\"currency_break\"><td colspan=\"4\"><br /></td></tr><tr><td width=\"38%\">Argentine Peso</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Argentine Peso</span>Exchange Rate</div>8.66050</td>"
					            + "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00170</td> <td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.02</td></tr>"
					            + "<tr><td width=\"38%\">Bahraini Dinar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Bahraini Dinar</span>Exchange Rate</div>0.37703</td>"
					            +  "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            + "<tr><td width=\"38%\">Barbados Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Barbados Dollar</span>Exchange Rate</div>2.00000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Botswana Pula</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Botswana Pula</span>Exchange Rate</div>9.48320</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Brazilian Real</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Brazilian Real</span>Exchange Rate</div>2.78180</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.01330</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.48</td></tr>"
					            +   "<tr><td width=\"38%\">Bulgarian Lev</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Bulgarian Lev</span>Exchange Rate</div>1.72840</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00310</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.18</td></tr>"
					            +   "<tr><td width=\"38%\">Chilean Peso</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Chilean Peso</span>Exchange Rate</div>628.00000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+1.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.16</td></tr>"
					            +   "<tr><td width=\"38%\">Chinese Renminbi</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Chinese Renminbi</span>Exchange Rate</div>6.13050</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00050</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.01</td></tr>"
					            +   "<tr><td width=\"38%\">Colombian Peso</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Colombian Peso</span>Exchange Rate</div>2381.00000</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-6.00000</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.25</td></tr>"
					            +   "<tr><td width=\"38%\">Croatian Kuna</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Croatian Kuna</span>Exchange Rate</div>6.80320</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.01100</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.16</td></tr>"
					            +   "<tr><td width=\"38%\">Czech Koruna</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Czech Koruna</span>Exchange Rate</div>24.47300</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.03700</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.15</td></tr>"
					            +   "<tr><td width=\"38%\">Danish Krona</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Danish Krona</span>Exchange Rate</div>6.57720</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.01250</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.19</td></tr>"
					            +   "<tr><td width=\"38%\">East Carribbean Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>East Carribbean Dollar</span>Exchange Rate</div>2.70250</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Egyptian Pound</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Egyptian Pound</span>Exchange Rate</div>7.62590</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00030</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>" 
					            +   "<tr> <td width=\"38%\">Estonian Kroon</td> <td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Estonian Kroon</span>Exchange Rate</div>11.69190</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Hong Kong Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Hong Kong Dollar</span>Exchange Rate</div>7.75250</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>" 
					            +   "<tr><td width=\"38%\">Hungarian Forint</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Hungarian Forint</span>Exchange Rate</div>270.42000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.81000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.30</td></tr><tr>"
					            +   "<td width=\"38%\">Iceland Krona</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Iceland Krona</span>Exchange Rate</div>109.13000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Indian Rupee</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Indian Rupee</span>Exchange Rate</div>61.71000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Indonesian Rupiah</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Indonesian Rupiah</span>Exchange Rate</div>12658.00000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Israeli Shekel</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Israeli Shekel</span>Exchange Rate</div>3.89300</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00450</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.12</td></tr>" 
					            +   "<tr><td width=\"38%\">Jamaican Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Jamaican Dollar</span>Exchange Rate</div>112.49860</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"  
					            +   "<tr><td width=\"38%\">Jordanian Dinar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Jordanian Dinar</span>Exchange Rate</div>0.70935</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.00025</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.04</td></tr>"
					            +   "<tr><td width=\"38%\">Kazakhstan Tenge</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Kazakhstan Tenge</span>Exchange Rate</div>184.81000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.04000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.02</td></tr>"  
					            +   "<tr><td width=\"38%\">Kenyan Shilling</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Kenyan Shilling</span>Exchange Rate</div>91.35000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr><tr>"
					            +   "<td width=\"38%\">Korean Wong</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Korean Wong</span>Exchange Rate</div>1089.32000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Kuwaiti Dinar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Kuwaiti Dinar</span>Exchange Rate</div>0.29535</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.00003</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.01</td></tr>"   
					            +   "<tr><td width=\"38%\">Latvian Lats</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Latvian Lats</span>Exchange Rate</div>0.51370</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Lesotho Loti</td> <td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Lesotho Loti</span>Exchange Rate</div>11.37290</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td> <td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr> " 
					            +   "<tr><td width=\"38%\">Lithuanian Litas</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Lithuanian Litas</span>Exchange Rate</div>2.84040</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr> <tr>"
					            +   "<td width=\"38%\">Malaysian Ringgit</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Malaysian Ringgit</span>Exchange Rate</div>3.55750</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00300</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.08</td></tr> "
					            +   "<tr><td width=\"38%\">Mauritius Rupee</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Mauritius Rupee</span>Exchange Rate</div>32.89000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr> "
					            +   "<tr><td width=\"38%\">Mexican Peso</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Mexican Peso</span>Exchange Rate</div>14.85310</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.06560</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.44</td></tr>"
					            +   "<tr><td width=\"38%\">Moroccan Dirham</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Moroccan Dirham</span>Exchange Rate</div>9.55810</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.01900</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.20</td></tr>"
					            +   "<tr><td width=\"38%\">Namibia Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Namibia Dollar</span>Exchange Rate</div>11.37290</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>" 
					            +   "<tr><td width=\"38%\">New Ghana Cedi</td> <td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>New Ghana Cedi</span>Exchange Rate</div>3.41000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>" 
					            +   "<tr><td width=\"38%\">New Turkish Lira</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>New Turkish Lira</span>Exchange Rate</div>2.47480</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00240</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.10</td></tr> <tr>"
					            +   "<td width=\"38%\">Nigerian Niara</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Nigerian Niara</span>Exchange Rate</div>194.00000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr> <tr>"
					            +   "<td width=\"38%\">Pakistan Rupee</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Pakistan Rupee</span>Exchange Rate</div>101.20000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"
					            +   "<tr><td width=\"38%\">Peruvian Nuevo Sol</td> <td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Peruvian Nuevo Sol</span>Exchange Rate</div>3.07100</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00100</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.03</td></tr> "
					            +   "<tr><td width=\"38%\">Phillipine Peso</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Phillipine Peso</span>Exchange Rate</div>44.34000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.01000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.02</td></tr>" 
					            +   "<tr><td width=\"38%\">Polish Zloty</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Polish Zloty</span>Exchange Rate</div>3.67060</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00280</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.08</td></tr>"  
					            +   "<tr><td width=\"38%\">Qatari Rial</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Qatari Rial</span>Exchange Rate</div>3.64110</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.00080</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.02</td></tr>" 
					            +   "<tr><td width=\"38%\">Rial Omani</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Rial Omani</span>Exchange Rate</div>0.38500</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00001</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>" 
					            +   "<tr><td width=\"38%\">Romanian Leu</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Romanian Leu</span>Exchange Rate</div>3.90220</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00800</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.21</td></tr> <tr>"
					            +   "<td width=\"38%\">Russian Ruble</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Russian Ruble</span>Exchange Rate</div>67.09160</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>" 
					            +   "<tr><td width=\"38%\">Saudi Riyal</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Saudi Riyal</span>Exchange Rate</div>3.75220</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.00050</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.01</td></tr>" 
					            +   "<tr><td width=\"38%\">Singapore Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Singapore Dollar</span>Exchange Rate</div>1.35300</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00150</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.11</td></tr> <tr>"
					            +   "<td width=\"38%\">South African Rand</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>South African Rand</span>Exchange Rate</div>11.51760</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.01810</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.16</td> </tr>"
					            +   "<tr><td width=\"38%\">Sri Lankan Rupee</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Sri Lankan Rupee</span>Exchange Rate</div>133.00000</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.05000</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.04</td> </tr> "
					            +   "<tr><td width=\"38%\">Swaziland Lilangeni</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Swaziland Lilangeni</span>Exchange Rate</div>11.37290</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr> <tr>"
					            +   "<td width=\"38%\">Taiwanese Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Taiwanese Dollar</span>Exchange Rate</div>31.65000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.05700</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.18</td></tr>" 
					            +   "<tr><td width=\"38%\">Tanzanian Shilling</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Tanzanian Shilling</span>Exchange Rate</div>1825.00000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"  
					            +   "<tr><td width=\"38%\">Thai Baht</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Thai Baht</span>Exchange Rate</div>32.66000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.02000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.06</td></tr>"  
					            +   "<tr><td width=\"38%\">Trinidad and Tobago Dollar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Trinidad and Tobago Dollar</span>Exchange Rate</div>6.29000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr>"   
					            +   "<tr><td width=\"38%\">Tunisian Dinar</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Tunisian Dinar</span>Exchange Rate</div>1.93200</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>+0.00020</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.01</td></tr>" 
					            //  // in front of UAE Dirham is added number 36 so the data will not be validated
					            +   "<tr><td width=\"38%\">UAE Dirham</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>UAE 36 Dirham</span>Exchange Rate</div>3.67270</td>"
					            +   "<td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">Change</div>-0.00030</td><td width=\"20%\" style=\"color:red;text-align: right;\"><div class=\"mobile_title\">%</div>-0.01</td></tr>" 
					            +   "<tr> <td width=\"38%\">Uganda Shilling</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Uganda Shilling</span>Exchange Rate</div>2857.00000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr> " 
					            +   "<tr><td width=\"38%\">Zambian Kwacha</td><td width=\"22%\" style=\"text-align: right;\"><div class=\"mobile_title\"><span>Zambian Kwacha</span>Exchange Rate</div>     5208.00000</td>"
					            +   "<td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">Change</div>0.00000</td><td width=\"20%\" style=\"color:green;text-align: right;\"><div class=\"mobile_title\">%</div>0.00</td></tr></table>"  
					            +   "</div> <div class=\"morestories section\"><div class=\"bc-morestories\"><div class=\"bc-read-more-button\">"
					            +   "<a href=\"#\" class=\"read-more-button\" title=\"Show all currencies\" data-hide-text='Show fewer currencies' data-hide-title-text='Show fewer currencies' data-target='.read-more-text'>Show all currencies</a></div>"
					            +   "</div></div><table class=\"fxrates_graph\" width=\"100%\" border=\"0\"><tr><td>"
					            +   "<br /> <b>US Dollar - British Pound</b><br /><div class=\"fxrates_plot\" id=\"2ba4633b61eb4d819b6030a9ddfa3453\" ></div><div class=\"code prettyprint\"><pre class=\"code prettyprint brush: js\"></pre></div>"
					            +   "</td><tr><tr><td><br /><b>US Dollar - euro</b><br /><div class=\"fxrates_plot\" id=\"3ce94e22033847d09747ed4ead8281e5\" ></div><div class=\"code prettyprint\"><pre class=\"code prettyprint brush: js\"></pre></div>"
					            +   "</td></tr></table><!--Time taken for fxrate (USD): 3625 ms. --></div></div></div></div>"
					            +   "<script type=\"text/javascript\">$(document).ready(function(){if($(\".cq-wcm-edit\").length > 0){setTimeout(function(){$(\".tabs-panel\").tabs();}, 10000);}else{$(\".tabs-panel\").tabs();}});</script></div>}";
					     
		barclaysDataV = new ValidateBarclaysData(brcURLData);
		barclaysDataNotV = new ValidateBarclaysData(brcURLData2);

	}
	/**
     * tearDown() is called after every single test inside ValidateBarclaysDataTest class is tested 
     * and it sets instance variables barclaysDataV barclaysDataNotV to null
     */
	protected void tearDown() {
		barclaysDataV = null;
		barclaysDataNotV = null;
	}
	/**
     * testing getData() method.
     */
	public void testGetData(){
		assertNotNull(barclaysDataV.getData());
		assertNull(barclaysDataNotV.getData());
		String[] currencyData = barclaysDataV.getData();
		assertEquals("British Pound", currencyData[0]);
		assertEquals("0.65640", currencyData[1]);
		int last = currencyData.length - 1;
		assertEquals("5208.00000", currencyData[last]);
		assertEquals("Zambian Kwacha", currencyData[last - 1]);
	}
	/**
     * testing getValid() method.
     */
	public void testgetValid(){
		assertTrue(barclaysDataV.getValid());
		assertFalse(barclaysDataNotV.getValid());
	}
	/**
     * testing getErrorMessage() method.
     */
	public void testGetErrorMessage(){
		assertNotNull(barclaysDataNotV.getErrorMessage());
		assertNull(barclaysDataV.getErrorMessage());
		assertEquals("Barclays data was not validated!",barclaysDataNotV.getErrorMessage());
	}
	/**
     * testing ValidateDeta() method.
     */
	public void testValidateData(){
		     
	        assertEquals(true,barclaysDataV.validateData("Czech Republic","35.34895"));
	        assertEquals(false,barclaysDataV.validateData("Czech Republic","35,34895"));
	        assertEquals(true,barclaysDataV.validateData("Great Britan","1"));
	        assertEquals(false,barclaysDataV.validateData("Great & Britan","1"));
	        assertEquals(false,barclaysDataV.validateData("Great Britan","1.0000000000"));
	        
	        assertEquals(true,barclaysDataV.validateData("Czech Rep","12345.123456"));
	        assertEquals(true,barclaysDataV.validateData("MY Country","12345"));
	        assertEquals(true,barclaysDataV.validateData("towalec potapec","140.0990"));
	        assertEquals(false,barclaysDataV.validateData("Great & Britan","1"));
	        assertEquals(false,barclaysDataV.validateData("Great Britan","123456"));
	        assertFalse(barclaysDataV.validateData("Great Britan","123,1234567"));
	    }

}
