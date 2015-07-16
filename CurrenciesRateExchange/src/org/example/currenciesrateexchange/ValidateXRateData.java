package org.example.currenciesrateexchange;
 /**
 * ValidateXRateData class enable to clear and validate HTML data 
 * that is loaded from x-Rate web site.
 *
 * @author dsajdl01 (David Sajdl)
 * @version (01/14/2015)
 *
 */
public class ValidateXRateData implements Validator{
       
    private String[] xRateData;
    private boolean xRateValid;
    private String errorMessage;
    /**
    * constructor takes one argument as a parameter that is 
    * string data that represent HTML source of x-Rate web site.
    *
    */
    public ValidateXRateData(String data){
        this.xRateValid = false;
        this.errorMessage = null;
        this.findData(data);
    }
    /**
    * getData() method returns array string that 
    * contain currency name and currency value if data is validated
    * or null if data is not validated.
    *
    * @return array string that contain currecy's name and currecy's value or null.
    */
    @Override
    public String[] getData() {
        // TODO Auto-generated method stub
        return xRateData;
    }
    /**
     * getValid() method returns true if data is validated or false if not.
     *
     * @return boolean either true if data is validated or false is data is not validated.
     */
    @Override
    public boolean getValid() {
        // TODO Auto-generated method stub
        return xRateValid;
    }
     /**
     * getErrorMessage() method returns error message if data is not validated 
     * or null if data is validate.
     *
     * @return string that contain either error message if data is not valid or null if data is valid.
     */
    @Override
    public String getErrorMessage(){
        return errorMessage;
    }
    /**
    * findData() method send a message to split HTML data to get data that is needed 
    * and check if data contain what it should "validate data"
    * if data is validated then it assigns instance variable: xRateData with data that is needed, 
    * aRateValid assigns to true and errorMessage to null.
    * if data is NOT validate then it assigns instance variable: xRateData with null 
    * errorMessage with validation error message and dataIsValid to false.
    *
    */
    @Override
    public void findData(String data){
        // TODO Auto-generated method stub
        boolean error = true;
        String dataXRate = getCurrency(data);
        String[] xRateArray = dataXRate.split(",");
        for(int i =0; i < xRateArray.length-1; i = i + 2){
            if(!validateData(xRateArray[i],xRateArray[i+1])){
                error = false;
                break;
            }
        }
         
        if(error){
            xRateData = xRateArray;
            xRateValid = true;
            errorMessage = null;
        }
        else{
            xRateData = null;
            xRateValid = false;
            errorMessage = "x-Rate data was NOT validated!";
        }
    }
    /**
    * getCurrency() method split HTML data to data that are needed 
    * that represent currency name and currency value.
    *
    * @return string that contain currency name and currency value.
    */
    @Override
    public String getCurrency(String url) {
        String[] arrData = url.split("[<>]");
        int count =0;
         String message = "";
         for(int i = 0; i < arrData.length; i++){
             if("tbody".equals(arrData[i])){
                 count ++;
             }
             if(count > 1){
                 if("td".equals(arrData[i])&&(!("class='rtRates'".equals(arrData[i].trim())))){
                     if("Venezuelan Bolivar".equals(arrData[i+1].trim())){
                         message = message + arrData[i+1] +","+ arrData[i + 7];
                         break;
                     }
                     else{
                         message = message + arrData[i+1] +"," + arrData[i + 7]+",";
                     }
                 }
             }
         }
         return message;
    }
    /**
    * validateData() method checks if strings from parameter contain what it should.
    * First parameter name only alphabetical letters and second one value only digits with one dots. 
    *
    * @param string name that represent currency'name.
    * @param string value that represent currency's value.
    * @return boolean that contain either true if data is validated or false if data is not validated. 
    */
    @Override
    public boolean validateData(String name, String value){
        final String DigitsRegExp = "^\\d{0,6}\\.\\d{0,7}|^\\d{0,6}$";
        final String LettersRegExp = "^[a-zA-Z]+$";;
        return name.replaceAll("\\s+","").matches(LettersRegExp) && value.replaceAll("\\s+","").matches(DigitsRegExp);
    }
}
