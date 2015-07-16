package org.example.currenciesrateexchange;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

 /**
 * DateSource class is a middle class or communication class between database tables 
 * called TABLE_DATE_NAME and CurrenciesRateExchangeMainActivity class
 * Class enable to open and close database 
 * insert data into table, update table and retrieve data from the table. 
 * 
 * @author dsajdl01 (David Sajdl)
 * @version (01/14/2015)
 *
 */
public class DateSource  {
     
    //declaring instance variables
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] timeColumn = {MySQLiteHelper.COLUMN_DATE_ID, MySQLiteHelper.COLUMN_DATE,};
      
    /**
    * Constructor that has one argument called Context object
    *
    * @param Context that in object of the calls CurrenciesRateExchangeMainActivity
    */
    public DateSource(Context context){
        dbHelper = new MySQLiteHelper(context);
    }
     /**
    * open method opens database if method does not manage to open database it throws SQLException
    *  
    * @throws SQLException if does not manage to open database or find database
    */
    public void open() throws SQLException{
        database = dbHelper.getReadableDatabase();
    }
    /**
    * close method closes database
    */
    public void close(){
        dbHelper.close();
    }
    /**
    * addDate() method allows to add current data into database table called TABLE_DATE_NAME
    *
    * @param string date that represents current day
    */
    public void addDate(String date){
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_DATE, date);
        database.insert(MySQLiteHelper.TABLE_DATE_NAME, null, values);
    }  
    /**
    * updateDateValue() method manages to update database table called TABLE_DATE_NAME
    * In the table 'TABLE_DATE_NAME' is just one raw therefore only  the first raw is update 
    * by using WHERE cause where COLUMN_DATE_ID is equal to 1 
    *
    * @param string date that represents current day     
    *
    */
    public void updateDateValue(String date){
        ContentValues val = new ContentValues();
        val.put(MySQLiteHelper.COLUMN_DATE, date);
        database.update(MySQLiteHelper.TABLE_DATE_NAME, val, MySQLiteHelper.COLUMN_DATE_ID + "=" + "'1'", null);
    }
    /**
    * getStoredDate() method manages to get data from database table called TABLE_DATE_NAME and return them as a string
    * In the table 'TABLE_DATE_NAME' is just one raw therefore only  the first is retrieved 
    *
    *@return String that represents day, which day was whole database updated 
     */
    public String getStoredDate(){
        Cursor crs = database.query(MySQLiteHelper.TABLE_DATE_NAME, timeColumn, null, null, null, null, null);
        crs.moveToFirst();
        return (crs.getString(1));
    }
      /**
      * isOpen() method check if database table called TABLE_DATE_NAME is open
      *
      * @return boolean either true if database table is open or false if database table is close
      */
      public boolean isOpen(){
        return database.isOpen();
      }       
}
