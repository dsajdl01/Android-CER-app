package org.example.currenciesrateexchange;
/**
* Source interface class set methods that must be used for 
* implemented class.
* 
* @author dsajdl01 (David Sajdl)
* @version (01/14/2015)
*/
public interface Source {
	public void  open();
	public void close();
	public void addValueIntoTable(String name, Double value);
	public void updateTable(String name, Double value);
	public double getCurrencyValue(String name);
}
