package org.example.currenciesrateexchange;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/**
 * XRateSource class is a middle class or communication class between database table 
 * called TABLE_XRATE_NAME and CurrenciesRateExchangeMainActivity class
 * Class enable to open and close database 
 * insert data into table, update table and retrieve data from the table. 
 * 
 * @author dsajdl01 (David Sajdl)
 * @version (01/14/2015)
 *
 */
public class XRateSource implements Source {
  
    //declaring instance variables
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
  //  private String[] allColumns = {MySQLiteHelper.COLUMN_XRATE_ID,MySQLiteHelper.COLUMN_XRATE_CURRENCY_NAME,MySQLiteHelper.COLUMN_XRATE_VALUE};
    /**
    * constructor that has one argument called Context object
    *
    * @param Context that in object of the calls CurrenciesRateExchangeMainActivity
    */
    protected XRateSource(Context context){
        dbHelper = new MySQLiteHelper(context);
    }
     
   /**
    * open method opens database if method does not manage to open database it throws SQLException 
    * 
    * @throws SQLException if does not manage to open database
    */
    @Override
    public void open() throws SQLException{
        database = dbHelper.getReadableDatabase();
    }
    /**
    * close method closes database
    */
    @Override
    public void close(){
        dbHelper.close();
    }
     
    /**
    * addValueIntoTable method insert arguments values into table called TABLE_XRATE_NAME
    * 
    * @param currencyName string currency name (country)
    * @param value double that represent value of the currency name
    */
    @Override
    public void addValueIntoTable(String currencyName, Double value) {
        // TODO Auto-generated method stub
         ContentValues val= new ContentValues();
         currencyName = currencyName.trim();
         val.put(MySQLiteHelper.COLUMN_XRATE_CURRENCY_NAME, currencyName);
         val.put(MySQLiteHelper.COLUMN_XRATE_VALUE, value);
         database.insert(MySQLiteHelper.TABLE_XRATE_NAME, null, val);
    }
    /**
     * updateTable() method enables to update database table called TABLE_XRATE_NAME
     * Method update column COLUMN_XRATE_VALUE using WHERE clause where column name COLUMN_XRATE_CURRENCY_NAME name is equal to name
     *
     */
    @Override
    public void updateTable(String currencyName, Double value) {
        // TODO Auto-generated method stub
        currencyName =  "'" +currencyName.trim() +"'";
        ContentValues val = new ContentValues();
        val.put(MySQLiteHelper.COLUMN_XRATE_VALUE, value);
        database.update(MySQLiteHelper.TABLE_XRATE_NAME, val, MySQLiteHelper.COLUMN_XRATE_CURRENCY_NAME + "=" + currencyName, null);
    }
     
    /**
     *getCurrencyValue() method enables to retrieve currency' value where currency 
     * name equal to currency' name passed by parameter argument.
     *
     * @return double that represent currency rate value to British pound
     */
    @Override
    public double getCurrencyValue(String name) {
        // TODO Auto-generated method stub
        Cursor cr = database.rawQuery("select * from " + MySQLiteHelper.TABLE_XRATE_NAME + " where " + MySQLiteHelper.COLUMN_XRATE_CURRENCY_NAME + " = " + "'" + name + "'", null);
        cr.moveToFirst();
        return cr.getDouble(2);
    }
        /**
        * getProfilesCount() method enables to count raw in the database table called TABLE_XRATE_NAME
        *
        * @return integer that represent number of raw in the table called TABLE_XRATE_NAME
        */
        public int getProfilesCount() {
            String countQuery = "SELECT  * FROM " + MySQLiteHelper.TABLE_XRATE_NAME;
            Cursor cursor = database.rawQuery(countQuery, null);
            int cnt = cursor.getCount();
            cursor.close();
            return cnt;
        }
         
        //*********************************************************************************************************//
        //**                         METHODS BELOW DO NOT NEED IT FOR CRE APP                                    **//  
        //** however result of the method was print it out to check it if all data is inserted and then updated. **//
        //*********************************************************************************************************//
         
        /**
        * getAllTuples() method retrieves all data from the database table called TABLE_XRATE_NAME
        *
        * @return string that represents data in table called TABLE_XRATE_NAME. 
        *  Each raw contains currency's id, currency's name and currency's value
        */
        public String getAllTuples(){
            String allTuples = "Database Values\n\n";
          //  Cursor cr = database.query(MySQLiteHelper.TABLE_XRATE_NAME, allColumns, null, null, null, null, null);
            Cursor cr = database.rawQuery("select * from " + MySQLiteHelper.TABLE_XRATE_NAME + " ORDER BY LOWER (" + MySQLiteHelper.COLUMN_XRATE_CURRENCY_NAME + ")", null);
            cr.moveToFirst();
            while(!cr.isAfterLast()){
                allTuples = allTuples + getRowValues(cr);
                cr.moveToNext();
            }
            cr.close();
            return allTuples;
        }
        /**
        * getRowValues() private method convert Cursor object into string
        * Cursor is output of the database queries that is casting into string 
        *
        * @return string that contains currency's id, currency's name and currency's value
        */
        private String getRowValues(Cursor cr){
            long id = (cr.getLong(0));
            String name = (cr.getString(1));
            Double value = (cr.getDouble(2));
            return "  " + id + ". " + name + ", " + value +"\n";
        }
}
