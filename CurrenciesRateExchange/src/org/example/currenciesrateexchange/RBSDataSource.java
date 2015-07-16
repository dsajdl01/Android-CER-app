package org.example.currenciesrateexchange;
  
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
 /**
 * RBSDataSource class is a middle class or communication class between database tables
 * called TABLE_RBS_NAME and CurrenciesRateExchangeMainActivity class
 * Class enable to open and close database 
 * create new rows into table update table and retrieve data from the table
 * 
 * @author dsajdl01 (David Sajdl)
 * @version (01/14/2015)
 *
 */
public class RBSDataSource {
  
    //declaring instance variables
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.COLUMN_ID,MySQLiteHelper.COLUMN_CURRENCY_NAME,MySQLiteHelper.COLUMN_BUYS,MySQLiteHelper.COLUMN_SELLS};
      
    /**
     * constructor that takes Context object as argument 
     *
     * @param Context that in object of the calls CurrenciesRateExchangeMainActivity
     */
    public RBSDataSource(Context context){
        dbHelper = new MySQLiteHelper(context);
    }
     
    /**
    * open() method opens database if method does not manage to open database 
    * it throws SQLException or if the database cannot be found
    * 
    * @throws SQLException if does not manage to open database
    */
    public void open() throws SQLException{
        database = dbHelper.getReadableDatabase();
    }
    /**
     * close() method closes database
     */
    public void close(){
        dbHelper.close();
    }
    /**
     * addRBSValuesIntoTable() method increase arguments values into database table called TABLE_RBS_NAME
     * 
     * @param currencyName string currency name (country)
     * @param buys double the value of currency that is buy
     * @param sells double the value of the currency that is sell
     */
    public void addRBSValuesIntoTable(String currencyName, double buys, double sells){
        ContentValues value = new ContentValues();
        currencyName = currencyName.trim();
        value.put(MySQLiteHelper.COLUMN_CURRENCY_NAME,currencyName);
        value.put(MySQLiteHelper.COLUMN_BUYS, buys);
        value.put(MySQLiteHelper.COLUMN_SELLS, sells);
        database.insert(MySQLiteHelper.TABLE_RBS_NAME, null, value);
    }
    /**
    * updateRBSValues() methods manages to update database table called TABLE_RBS_NAME
    * updateRBSValues updates only currency value buy and sell by using cause WHERE COLUMN_CURRENCY_NAME = currency name 
    *
    * @param currencyName string currency name (country)
    * @param buys double the value of currency that is being buy
    * @param sells double the value of the currency that is being sell
    */
    public void updateRBSValues(String currencyName, double buys, double sells){
        currencyName =  "'" +currencyName.trim() +"'";
        ContentValues value = new ContentValues();
        value.put(MySQLiteHelper.COLUMN_BUYS, buys);
        value.put(MySQLiteHelper.COLUMN_SELLS, sells);
        database.update(MySQLiteHelper.TABLE_RBS_NAME, value, MySQLiteHelper.COLUMN_CURRENCY_NAME + "=" + currencyName, null);
    }
    /**
    * getCurrencyRBSValue() method manages to retrieve currency value that is equal to 
    * currency's name that is passed through parameter
    *
    *@return double that is average of currency buy and sell
    */
    public double getCurrencyRBSValue(String name){
        Cursor cr = database.rawQuery("select * from " + MySQLiteHelper.TABLE_RBS_NAME 
                + " where " + MySQLiteHelper.COLUMN_CURRENCY_NAME + " = " + "'" + name + "'", null);
        cr.moveToFirst();
        double buy = cr.getDouble(2);
        double sell = cr.getDouble(3);
        return (buy+sell)/2;
    }
     
    /**
    *getProfilesCount() method manage to count how many rows are in the table called TABLE_RBS_NAME
    *
    * @return integer the represents numbers of rows in the table called TABLE_RBS_NAME
    */
    public int getProfilesCount(){
        String countQuery = "SELECT  * FROM " + MySQLiteHelper.TABLE_RBS_NAME;
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
     * getAllTableTuples method loads all tuples value from the table called TABLE_RBS_NAME into string and return it 
     * 
     * @return string allTuples that hold all values from the table called TABLE_RBS_NAME
     */
    public String getAllTableTuples(){
        String allTuples = "Database Values\n\n";
        Cursor cr = database.query(MySQLiteHelper.TABLE_RBS_NAME, allColumns, null, null, null, null, null);
        cr.moveToFirst();
        while(!cr.isAfterLast()){
            allTuples = allTuples + getRowValues(cr);
            cr.moveToNext();
        }
        cr.close();
        return allTuples;
    }
    /**
     * getRowValues() private method manages to cast object 'Cursor' into string
     * Cursor object holds row value that are converted into string and then return it. 
     * 
     * @param cursor object that holds rows values from database table called TABLE_RBS_NAME.
     * @return string that hold currency's id, currency's name currency's buy and currency's sell 
     */
    private String getRowValues(Cursor cursor){
        long id = (cursor.getLong(0));
        String name = (cursor.getString(1));
        Double buy = (cursor.getDouble(2));
        Double sell = (cursor.getDouble(3));
        return id + ". " + name + ", " + buy + ", " + sell +"\n";
    }
}
