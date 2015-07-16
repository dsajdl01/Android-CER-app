package org.example.currenciesrateexchange;
/**
* Validator interface class set methods that must be used for 
* implemented class.
* 
* @author dsajdl01 (David Sajdl)
* @version (01/14/2015)
*/
public interface Validator {
	public String[] getData();
	public boolean getValid();
	public String getErrorMessage();
	public void findData(String url);
	public String getCurrency(String url);
	public boolean validateData(String name, String value);
}
