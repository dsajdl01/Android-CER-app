package org.example.currenciesrateexchange;
 /**
 * ValidateRBSdata class enable to clear and validate HTML data 
 * that is loaded from RBS web site
 *
 * @author dsajdl01 (David Sajdl)
 * @version (01/14/2015)
 *
 */
public class ValidateRBSdata implements Validator {
      
    String[] rbsData;
    String errorMessage;
    boolean dataIsValid;
    /*
    * constructor takes one argument, string data 
    * that represent HTML source of RBS web site
    */
    public ValidateRBSdata(String data){
        dataIsValid = false;
        errorMessage = null;
        findData(data);
    }
    /**
    * getData() method returns data of BRS currency name, 
    * BRS currency buy value and BRS currency sell value.
    *
    * @return string array that contain BRS data in format as BRS currency name, 
    * BRS currency buy value and BRS currency sell value
    */
    @Override
    public String[] getData() {
        // TODO Auto-generated method stub
        return rbsData;
    }
    /**
     * getValid() method checks if data has been successful valid
     *
     * @return boolean either true if data is valid or false if data is not valid
     */
    @Override
    public boolean getValid() {
        // TODO Auto-generated method stub
        return dataIsValid;
    }
    /**
    * getErrorMessage() method return error validation message 
    * if data is not validated or null if data if validated.
    *
    * @return string that contain either validation error message or null
    */
    @Override
    public String getErrorMessage() {
        // TODO Auto-generated method stub
        return errorMessage;
    }
     
     /**
     * findData() method send a message to split HTML data to get data that is needed 
     * and check if data contain what it should "validate data"
     * if data is validated then it assigns instance variable: rdsData with data that is needed, dataIsValid assigns to true and errorMessage to null
     * if data is NOT validate then it assigns instance variable: errorMessage with validation error message, dataIsValid to false and rbsData to null.
     */
    @Override
    public void findData(String url) {
        // TODO Auto-generated method stub
         String values = getCurrency(url);
            String[] dataArray = values.split(",");
            int lastIndex = dataArray.length -1;
             if(validateData(dataArray[0],dataArray[1],dataArray[2]) &&validateData(dataArray[lastIndex-3],dataArray[lastIndex-2], dataArray[lastIndex-1])){
                rbsData = dataArray;
                dataIsValid = true;
                errorMessage = null;
             }
             else{
                errorMessage = "RBS data is not valiadated!";
                dataIsValid = false;
                rbsData = null;
             }
         
    }
     /**
     * getCurrency() method takes download data as an argument
     * and clear data for a data that is needed (currency name and value). 
     * 
     * @param urlStr string as HTML data
     * @return data string that contain only data that is needed  
     */
    @Override
    public String getCurrency(String url) {
        // TODO Auto-generated method stub
         String[] urlArr = url.split("[<>]");
           String data = "";
                int count = 0;
                for(int i = 0; i < urlArr.length; i++){
                    if(urlArr[i].equals("Travellers Cheques"))
                     break;
                    if(urlArr[i].equals("td")){
                       data = data + urlArr[i + 1] + ", ";
                           count++;
                           if(count == 3){
                               count = 0;
                               data = data + "\n";
                           }
                       }
                }
           return data;
    }
 
    /**
     * validateData() methods is implemented from interface class but method
     * its not needed! instead is used validateData method with three parameter arguments. 
     */
    @Override
    public boolean validateData(String name, String value) {
        // TODO Auto-generated method stub
        return false;
    }     
    /**
     * validateData method take three arguments as string that are data from web server
     * Method validate date if data are contain what we are interested
     * 
     * @param d1 string that is currency name
     * @param d2 string that contain currency value of buying
     * @param d3 string that contain currency value of selling
     * @return boolean condition true if the values contain correct data otherwise false
     */
     public boolean validateData(String d1, String d2, String d3){
            final String DigitsRegExp = "^\\d{0,6}\\.\\d{0,4}|^\\d{0,6}$";
            final String LettersRegExp = "^[a-zA-Z]+|^[a-zA-Z]+\\&[a-zA-Z]+\\;[a-zA-Z]+$";
            return d1.replaceAll("\\s+","").matches(LettersRegExp) && d2.replaceAll("\\s+","").matches(DigitsRegExp) && d3.replaceAll("\\s+","").matches(DigitsRegExp);
     }
}
