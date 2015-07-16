package org.example.currenciesrateexchange;
 /**
 * CalculateRate class calculate currency rate exchange.
 * 
 * @author dsajdl01 (David Sajdl)
 * @version (01/14/2015)
 *
 */
public class CalculateRate {
  
    //declaring instance variables
    private Double have;
    private Double want;
    /**
    * Constructor that takes two double as argument
    * that represent currency that user has e.g: US Dollar and
    * currency that user wants e.g: EURO
    *
    * @param double have that represent currency that user has e.g: US Dollar
    * @param double want that represent  currency that user wants e.g: EURO
    */
    public CalculateRate(Double have, Double want){
        this.have = have;
        this.want = want;
    }
      
    /**
    * getHave() method returns currency that user has
    *
    * @return double currency that user has
    */
    public Double getHave(){
        return have;
    }
    /**
    * getWant() method returns currency that user wants
    * 
    * @return currency that user wants
    */
    public Double getWant(){
        return want;
    }
    /**
    * getRate method calculates rate that user would get for 1 currency
    * that has to currency user wants eg: how much EURO gets for 1 US Dollar.
    *
    * @return double rates to currency has to currency wants
    */
    public Double getRate(){
        return want/have;
    }
    /**
    * calculateUserInput() method calculate how much user gets for money that user has  
    *
    *@param double that represents amount of currency that user has.
    *@return double that represent amount of currency that user gets.
    */
    public Double calculateUserInput(double input){
        return (want/have) * input;
    }
  
}
