package org.example.currenciesrateexchange;
 /**
 * SwitchCurrencyName class enable switching currency Name that is inside spinner
 * to currency name that is inside database tables
 *
 * @author dsajdl01 (David Sajdl)
 * @version (01/14/2015)
 *
 */
public class SwitchCurrencyName {
     
    /**
    * switchBarclaysCurrencyName() method converts currency name that is inside spinner 
    * to currency name that is inside database table called TABLE_BARCLAYS_NAME.
    *
    * @param string currencyName that represent currency name inside spinners.
    * @return string that represent currency name inside database table TABLE_BARCLAYS_NAME.
    */
     public String switchBarclaysCurrencyName(String currencyName){
          
           if(currencyName.equals("GBP - British Pound"))  return "British Pound";
           else if(currencyName.equals("EUR - EURO")) return "Euro"; 
           else if(currencyName.equals("USD - US Dollar"))  return "US Dollar";
           else if(currencyName.equals("AUD - Australian Dollar")) return "Australian Dollar";
           else if(currencyName.equals("BHD - Bahrain Dinar")) return "Bahraini Dinar";
           else if(currencyName.equals("BBD - Barbados Dollar")) return "Barbados Dollar";
           else if(currencyName.equals("BRL - Brazilian Real")) return "Brazilian Real";
           else if(currencyName.equals("BND - Brunei Ringgit"))  return "";
           else if(currencyName.equals("BGN - Bulgarian Lev"))  return "Bulgarian Lev";
           else if(currencyName.equals("CAD - Canadian Dollar")) return "Canadian Dollar";
           else if(currencyName.equals("KYD - Cayman Island Dollar"))  return "";
           else if(currencyName.equals("CLP - Chilean Peso"))return "Chilean Peso";
           else if(currencyName.equals("CNY - Chinese Yuan")) return "Chinese Renminbi";
           else if(currencyName.equals("CRC - Costa Rican Colon")) return "";
           else if(currencyName.equals("HRK - Croatian Kuna")) return "Croatian Kuna";  
           else if(currencyName.equals("CZK - Czech Koruna")) return "Czech Koruna";
           else if(currencyName.equals("DKK - Danish Kroner")) return "Danish Krona";
           else if(currencyName.equals("DOP - Dominican Rep. Peso"))  return "";
           else if(currencyName.equals("XCD - East Caribbean Dollar"))  return "East Carribbean Dollar";
           else if(currencyName.equals("EGP - Egyptian Pound")) return "Egyptian Pound";
           else if(currencyName.equals("FJD - Fiji Dollar")) return "";
           else if(currencyName.equals("HKD - Hong Kong Dollar")) return "Hong Kong Dollar";
           else if(currencyName.equals("HUF - Hungarian Forint")) return "Hungarian Forint";
           else if(currencyName.equals("ISK - Icelandic Krona"))  return "Iceland Krona";
           else if(currencyName.equals("IDR - Indonesian Rupiah"))  return "Indian Rupee";
           else if(currencyName.equals("ILS - Israeli New Sheqel")) return "Israeli Shekel";
           else if(currencyName.equals("JMD - Jamaican Dollar")) return "Jamaican Dollar";
           else if(currencyName.equals("JPY - Japanese Yen"))   return "Japanese Yen";
           else if(currencyName.equals("JOD - Jordanian Dinar")) return "Jordanian Dinar";
           else if(currencyName.equals("KES - Kenyan Shilling")) return "Kenyan Shilling";
           else if(currencyName.equals("KWD - Kuwaiti Dinar")) return "Kuwaiti Dinar";
           else if(currencyName.equals("LBP - Lebanon Pound")) return "";
           else if(currencyName.equals("MYR - Malaysian Ringgit")) return "Malaysian Ringgit";
           else if(currencyName.equals("MUR - Mauritian Rupee")) return "Mauritius Rupee";
           else if(currencyName.equals("MXN - Mexican Pesos")) return "Mexican Peso";
           else if(currencyName.equals("TWD - New Taiwan Dollar"))  return "Taiwanese Dollar";
           else if(currencyName.equals("TRY - Turkish Lira"))return "New Turkish Lira";
           else if(currencyName.equals("NDZ - New Zealand Dollar")) return "New Zealand Dollar"; 
           else if(currencyName.equals("NOK - Norwegian Kroner")) return "Norwegian Krone";
           else if(currencyName.equals("OMR - Omani Rial"))return "";
           else if(currencyName.equals("PGK - Papua New Guinea Kina")) return "";
           else if(currencyName.equals("PEN - Peru New Sol"))  return "Peruvian Nuevo Sol";
           else if(currencyName.equals("PHP - Philippines Piso"))  return "Phillipine Peso";
           else if(currencyName.equals("PLN - Polish Zloty"))  return "Polish Zloty";
           else if(currencyName.equals("QAR - Qatar Riyal")) return "Qatari Rial";
           else if(currencyName.equals("RUB - Russian Ruble"))  return "Russian Ruble";
           else if(currencyName.equals("SAR - Saudi Arabian Riyal"))  return "Saudi Riyal";  
           else if(currencyName.equals("SGD - Singapore Dollar")) return "Singapore Dollar";  
           else if(currencyName.equals("ZAR - South African Rand")) return "South African Rand";
           else if(currencyName.equals("KRW - South Korean Won"))return "Korean Wong";
           else if(currencyName.equals("SEK - Swedish Krona"))  return "Swedish Krona";
           else if(currencyName.equals("CHF - Swiss Franc")) return "Swiss Franc";
           else if(currencyName.equals("THB - Thai Bath")) return "Thai Baht";
           else if(currencyName.equals("TTD - Trinidad & Tobago Dollar")) return "Trinidad and Tobago Dollar"; 
           else if(currencyName.equals("AED - Uae Dirham")) return "UAE Dirham"; 
           else return null;           
         }
 
      
    /**
    * switchXRateCurrencyName() method converts currency name that is inside spinner 
    * to currency name that is inside database table called TABLE_XRATE_NAME
    *
    * @param string currencyName that represent currency name inside spinners.
    * @return string that represent currency name inside database table TABLE_XRATE_NAME.
    */
    public String switchXRateCurrencyName(String name){
           
         if(name.equals("GBP - British Pound"))return "GBP - BRITISH POUND";
         else if("EUR - EURO".equals(name)) return "Euro"; 
         else if("USD - US Dollar".equals(name)) return "US Dollar";
         else if("AUD - Australian Dollar".equals(name)) return "Australian Dollar";
         else if("BHD - Bahrain Dinar".equals(name)) return "Bahraini Dinar";
         else if("BBD - Barbados Dollar".equals(name)) return "";
         else if("BRL - Brazilian Real".equals(name)) return "Brazilian Real";
         else if("BND - Brunei Ringgit".equals(name)) return "Bruneian Dollar";
         else if("BGN - Bulgarian Lev".equals(name))  return "Bulgarian Lev";
         else if("CAD - Canadian Dollar".equals(name)) return "Canadian Dollar";
         else if("KYD - Cayman Island Dollar".equals(name)) return "";
         else if("CLP - Chilean Peso".equals(name)) return "Chilean Peso";
         else if("CNY - Chinese Yuan".equals(name)) return "Chinese Yuan Renminbi";
         else if("CRC - Costa Rican Colon".equals(name)) return "";
         else if("HRK - Croatian Kuna".equals(name))return "Croatian Kuna";  
         else if("CZK - Czech Koruna".equals(name))return "Czech Koruna";
         else if("DKK - Danish Kroner".equals(name))return "Danish Krone";
         else if("DOP - Dominican Rep. Peso".equals(name))return "";
         else if("XCD - East Caribbean Dollar".equals(name))return "";
         else if("EGP - Egyptian Pound".equals(name))return "";
         else if("FJD - Fiji Dollar".equals(name))return "";
         else if("HKD - Hong Kong Dollar".equals(name))return "Hong Kong Dollar";
         else if("HUF - Hungarian Forint".equals(name))return "Hungarian Forint";
         else if("ISK - Icelandic Krona".equals(name)) return "Icelandic Krona";
         else if("IDR - Indonesian Rupiah".equals(name))return "Indonesian Rupiah";
         else if("ILS - Israeli New Sheqel".equals(name))return "Israeli Shekel";
         else if("JMD - Jamaican Dollar".equals(name))return "";
         else if("JPY - Japanese Yen".equals(name))return "Japanese Yen";
         else if("JOD - Jordanian Dinar".equals(name))return "";
         else if("KES - Kenyan Shilling".equals(name))return "";
         else if("KWD - Kuwaiti Dinar".equals(name))return "Kuwaiti Dinar";
         else if("LBP - Lebanon Pound".equals(name))return "";
         else if("MYR - Malaysian Ringgit".equals(name))return "Malaysian Ringgit";
         else if("MUR - Mauritian Rupee".equals(name))return "Mauritian Rupee";
         else if("MXN - Mexican Pesos".equals(name))return "Mexican Peso";
         else if("TWD - New Taiwan Dollar".equals(name))return "Taiwan New Dollar";
         else if("TRY - Turkish Lira".equals(name))return "Turkish Lira";
         else if("NDZ - New Zealand Dollar".equals(name))return "New Zealand Dollar"; 
         else if("NOK - Norwegian Kroner".equals(name))return "Norwegian Krone";
         else if("OMR - Omani Rial".equals(name))return "Omani Rial";
         else if("PGK - Papua New Guinea Kina".equals(name))return "";
         else if("PEN - Peru New Sol".equals(name))return "";
         else if("PHP - Philippines Piso".equals(name))return "Philippine Peso";
         else if("PLN - Polish Zloty".equals(name))return "Polish Zloty";
         else if("QAR - Qatar Riyal".equals(name))return "Qatari Riyal";
         else if("RUB - Russian Ruble".equals(name))return "Russian Ruble";
         else if("SAR - Saudi Arabian Riyal".equals(name))return "Saudi Arabian Riyal";  
         else if("SGD - Singapore Dollar".equals(name))return "Singapore Dollar";  
         else if("ZAR - South African Rand".equals(name))return "South African Rand";
         else if("KRW - South Korean Won".equals(name))return "South Korean Won";
         else if("SEK - Swedish Krona".equals(name))return "Swedish Krona";
         else if("CHF - Swiss Franc".equals(name))return "Swiss Franc";
         else if("THB - Thai Bath".equals(name))return "Thai Baht";
         else if("TTD - Trinidad & Tobago Dollar".equals(name))return "Trinidadian Dollar"; 
         else if("AED - Uae Dirham".equals(name))return "Emirati Dirham"; 
         else return null;
     }
    /**
    * switchRBSCurrencyName() method converts currency name that is inside spinner 
    * to currency name that is inside database table called TABLE_RBS_NAME.
    *
    * @param string currencyName that represent currency name inside spinners.
    * @return string that represent currency name inside database table TABLE_RBS_NAME.
    */
     public String switchRBSCurrencyName(String currencyName){
           
            if(currencyName.equals("GBP - British Pound"))
                return "GBP - BRITISH POUND";
            else if(currencyName.equals("EUR - EURO"))
           return "EURO"; 
       else if(currencyName.equals("USD - US Dollar"))
           return "US DOLLARS";
       else if(currencyName.equals("AUD - Australian Dollar"))
           return "AUSTRALIAN DOLLARS";
       else if(currencyName.equals("BHD - Bahrain Dinar"))
           return "BAHRAINIAN DINARS";
       else if(currencyName.equals("BBD - Barbados Dollar"))
           return "BARBADOS DOLLARS";
       else if(currencyName.equals("BRL - Brazilian Real"))
           return "BRAZILIAN REAL";
       else if(currencyName.equals("BND - Brunei Ringgit"))
           return "BRUNEI RINGGITS";
       else if(currencyName.equals("BGN - Bulgarian Lev"))
           return "BULGARIAN LEV";
       else if(currencyName.equals("CAD - Canadian Dollar"))
           return "CANADIAN DOLLARS";
       else if(currencyName.equals("KYD - Cayman Island Dollar"))
           return "CAYMAN ISLANDS DOLLARS";
       else if(currencyName.equals("CLP - Chilean Peso"))
           return "CHILEAN PESOS";
       else if(currencyName.equals("CNY - Chinese Yuan"))
           return "CHINESE YUAN";
       else if(currencyName.equals("CRC - Costa Rican Colon"))
           return "COSTA RICAN COLON";
       else if(currencyName.equals("HRK - Croatian Kuna"))
           return "CROATIAN KUNA";  
       else if(currencyName.equals("CZK - Czech Koruna"))
           return "CZECH KORUNA";
       else if(currencyName.equals("DKK - Danish Kroner"))
           return "DANISH KRONER";
       else if(currencyName.equals("DOP - Dominican Rep. Peso")) 
           return "DOMINICAN REPUBLIC PESOS";
       else if(currencyName.equals("XCD - East Caribbean Dollar")) 
           return "EAST CARIBBEAN DOLLAR";
       else if(currencyName.equals("EGP - Egyptian Pound"))
           return "EGYPTIAN POUNDS";
       else if(currencyName.equals("FJD - Fiji Dollar"))
           return "FIJI DOLLARS";
       else if(currencyName.equals("HKD - Hong Kong Dollar"))
            return "HONG KONG DOLLARS";
       else if(currencyName.equals("HUF - Hungarian Forint"))
           return "HUGARIAN FORINTS";
       else if(currencyName.equals("ISK - Icelandic Krona"))
           return "ICELANDIC KRONA";
       else if(currencyName.equals("IDR - Indonesian Rupiah"))
           return "INDONESIAN RUPIAH";
       else if(currencyName.equals("ILS - Israeli New Sheqel"))
           return "ISRAELI NEW SHEQELS";
       else if(currencyName.equals("JMD - Jamaican Dollar"))
           return "JAMAICAN DOLLARS";
       else if(currencyName.equals("JPY - Japanese Yen"))
               return "JAPANESE YEN";
       else if(currencyName.equals("JOD - Jordanian Dinar"))
           return "JORDANIAN DINARS";
       else if(currencyName.equals("KES - Kenyan Shilling"))
           return "KENYAN SHILLINGS";
       else if(currencyName.equals("KWD - Kuwaiti Dinar"))
           return "KUWAITI DINARS";
       else if(currencyName.equals("LBP - Lebanon Pound"))
           return "LEBANON POUND";
       else if(currencyName.equals("MYR - Malaysian Ringgit"))
           return "MALAYSIAN RINGGITS";
       else if(currencyName.equals("MUR - Mauritian Rupee"))
           return "MAURITIAN RUPEES";
       else if(currencyName.equals("MXN - Mexican Pesos"))
           return "MEXICAN PESOS";
       else if(currencyName.equals("TWD - New Taiwan Dollar"))
           return "NEW TAIWAN DOLLARS";
       else if(currencyName.equals("TRY - Turkish Lira"))
           return "NEW TURKISH LIRA";
       else if(currencyName.equals("NDZ - New Zealand Dollar"))  
           return "NEW ZEALAND DOLLARS"; 
       else if(currencyName.equals("NOK - Norwegian Kroner"))
           return "NORWEGIAN KRONER";
       else if(currencyName.equals("OMR - Omani Rial"))
           return "OMANI RIALS";
       else if(currencyName.equals("PGK - Papua New Guinea Kina"))
           return "PAPUA NEW GUINEA KINA";
       else if(currencyName.equals("PEN - Peru New Sol"))
           return "PERU NEW SOL";
       else if(currencyName.equals("PHP - Philippines Piso"))
           return "PHILIPPINES PISO";
       else if(currencyName.equals("PLN - Polish Zloty"))
           return "POLISH ZLOTY";
       else if(currencyName.equals("QAR - Qatar Riyal"))
           return "QATAR RIYALS";
       else if(currencyName.equals("RUB - Russian Ruble"))
           return "RUSSIAN RUBLE";
       else if(currencyName.equals("SAR - Saudi Arabian Riyal"))
           return "SAUDI ARABIAN RIYALS";  
       else if(currencyName.equals("SGD - Singapore Dollar"))
           return "SINGAPORE DOLLARS";  
       else if(currencyName.equals("ZAR - South African Rand"))
           return "SOUTH AFRICAN RAND";
       else if(currencyName.equals("KRW - South Korean Won"))
           return "SOUTH KOREAN WON";
       else if(currencyName.equals("SEK - Swedish Krona"))
           return "SWEDISH KRONA";
       else if(currencyName.equals("CHF - Swiss Franc"))
           return "SWISS FRANCS";
       else if(currencyName.equals("THB - Thai Bath"))
           return "THAI BAHTS";
       else if(currencyName.equals("TTD - Trinidad & Tobago Dollar"))
           return "TRINIDAD &amp; TOBAGO DOLLAR"; 
       else if(currencyName.equals("AED - Uae Dirham"))
           return "UAE DIRHAMS"; 
       else
           return null;           
     }
}
