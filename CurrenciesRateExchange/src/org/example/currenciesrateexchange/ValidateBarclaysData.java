package org.example.currenciesrateexchange;
 /**
 * ValidateBarclaysData class enable to clear and valiadate html data 
 * that is loaded from Barclays web site
 *
 * @author dsajdl01 (David Sajdl)
 * @version (01/14/2015)
 *
 */
public class ValidateBarclaysData implements Validator {
     
    private String[] barclaysData;
    private boolean BarclaysValid;
    private String  errorMessage;
     
    /**
    * constructor takes one argument as a parameter that is a 
    * string data that represent HTML source from Barclays web site
    *
    */
    public ValidateBarclaysData(String url)    {
        BarclaysValid = false;
        errorMessage = null;
        findData(url);
    }
     
    /**
    * getData() method returns array string that 
    * contain currency name and currency value
    *
    * @return array string that contain currecy's name and currecy's value
    */
     @Override
    public String[] getData() {
        // TODO Auto-generated method stub
         return barclaysData;
    }
 
    /**
    *isValid() method returns true if data is validated or false if not
    *
    * @return boolean either true if data is validated or false is data is not validated
    */
    @Override
    public boolean getValid() {
        // TODO Auto-generated method stub
        return BarclaysValid;
    }
    /**
     * getErrorMessage() method returns error message if data is not validated
     * if data is validated method return null.
     *
     * @return string that contain either error message or null
     */
    @Override
    public String getErrorMessage() {
        // TODO Auto-generated method stub
        return errorMessage;
    }
    /**
    * findData() method send a message to split HTML data to data that is needed 
    * and check if data contain what it should "validate data"
    * if data is validated then it assigns instance variable: barclaysData with data that is needed, BarclaysValid assigns to true and errorMessage to null.
    * if data is NOT validate then it assigns instance variable: errorMessage with validation error message, dataIsValid to false and barclaysData vith null.
    *
    */
    @Override
    public void findData(String data){
        // TODO Auto-generated method stub
         boolean error = true;
         String barData = getCurrency(data);
         String[] barArrdata = barData.split(",");
         for(int i = 0; i <  barArrdata.length-1; i = i + 2){
             if(!validateData(barArrdata[i],barArrdata[i+1])){
                 error = false;
                 break;
             }
         }
         if(error){
             barclaysData = barArrdata;
             BarclaysValid = true;
             errorMessage = null;
         }
         else{
             barclaysData = null;
             BarclaysValid = false;
             errorMessage = "Barclays data was not validated!";
         }
   }
    /**
    * getCurrency() method split HTML data to data that are needed 
    * that represent currency name and currency value
    *
    * @return string that contain currency name and currency value
    */
    @Override
    public String getCurrency(String url) {
        // TODO Auto-generated method stub
        String[] dataArr = url.split("[<>]");
        int count = 0;
        String barData = "";
        boolean toAdd = false;
        boolean toBreak = false;
        for(int i = 0; i < dataArr.length; i++){
            if(dataArr[i].equals("British Pound")){
                toAdd = true;
            }
            if(toAdd){
                if(dataArr[i].equals("span")||dataArr[i].equals("/div")){
                    count++;          
                    if(count <= 2){
                        if(toBreak){barData += dataArr[i+1].trim();
                        } 
                        else{ barData += dataArr[i+1].trim() + ",";
                        }
                          
                        if(dataArr[i+1].equals("Zambian Kwacha")) toBreak = true;
                    }
                    if(count == 4){
                        count = 0;
                        if(toBreak) break;
                    }
                }
            }
        }
        return barData;
    }
    /**
    * validateData() method checks if strings from parameter contain what it should
    * First parameter name only character and second one value only digits with one dots. 
    *
    * @param string name that represent currency'name
    * @param string value that represent currency's value
    * @return boolean that contain either true that data is validated or false if data is not validated 
    */
    @Override
    public boolean validateData(String name, String value) {
        // TODO Auto-generated method stub
        final String DigitsRegExp = "^\\d{0,5}\\.\\d{0,6}|^\\d{0,5}$";
        final String LettersRegExp = "^[a-zA-Z]+$";;
        return name.replaceAll("\\s+","").matches(LettersRegExp) && value.replaceAll("\\s+","").matches(DigitsRegExp);
    } 
}
