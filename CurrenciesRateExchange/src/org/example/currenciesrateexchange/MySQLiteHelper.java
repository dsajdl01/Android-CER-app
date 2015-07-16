package org.example.currenciesrateexchange;
  
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 /**
 * MySQLiteHelper class manages to create database called bank_rate and
 * tables called TABLE_DATE_NAME, TABLE_RBS_NAME, TABLE_XRATE_NAME and TABLE_BARCLAYS_NAME
 *
 * @author dsajdl01 (David Sajdl)
 * @version (01/14/2015)
 *
 */
public class MySQLiteHelper extends SQLiteOpenHelper{
      
    // Constant that represent database
    protected static final String DATABASE_NAME = "bank_rate.db";
    private static final int DATABASE_VERSION = 1;
      
    // Constants that represent table informations for RBS
    protected static final String TABLE_RBS_NAME = "rbs_data";
    protected static final String COLUMN_ID = "id";
    protected static final String COLUMN_CURRENCY_NAME = "currency_name";
    protected static final String COLUMN_BUYS = "buy";
    protected static final String COLUMN_SELLS = "sell";
      
    // table creation as sql statement for RBS table
    private static final String DATABASE_CREATE_RBS = "create table " + TABLE_RBS_NAME + "("
            + COLUMN_ID + " integer primary key autoincrement, " + COLUMN_CURRENCY_NAME 
            + " text not null, " + COLUMN_BUYS + " REAL, " + COLUMN_SELLS + " REAL)";
      
    // Constants that represent table informations for date
    protected static final String TABLE_DATE_NAME = "DATE";
    protected static final String COLUMN_DATE_ID = "date_id";
    protected static final String COLUMN_DATE = "date";
    // table creation as SQL statement for date table
    private static final String DATABASE_CREATE_DATE = "create table " + TABLE_DATE_NAME + "("
            + COLUMN_DATE_ID + " integer primary key autoincrement, " + COLUMN_DATE + " test)";
      
    // Constants that represent table informations for xRate
    protected static final String TABLE_XRATE_NAME = "xrate_data";
    protected static final String COLUMN_XRATE_ID = "xrate_id";
    protected static final String COLUMN_XRATE_CURRENCY_NAME = "xrate_name";
    protected static final String COLUMN_XRATE_VALUE = "xrate_value";
    // table creation as SQL statement for xRate table
    private static final String DATABASE_CREATE_XRATE = "create table " + TABLE_XRATE_NAME + "("
            + COLUMN_XRATE_ID + " integer primary key autoincrement, " + COLUMN_XRATE_CURRENCY_NAME 
            + " text not null, " + COLUMN_XRATE_VALUE + " REAL)";
      
    // Constants that represent table informations for Barclays
    protected static final String TABLE_BARCLAYS_NAME = "barclays_data";
    protected static final String COLUMN_BARCLAYS_ID = "barclays_id";
    protected static final String COLUMN_BARCLAYS_CURRENCY_NAME = "barclays_name";
    protected static final String COLUMN_BARCLAYS_VALUE = "barclays_value";
    // table creation as SQL statement for barclays table
    private static final String DATABASE_CREATE_BARCLAYS = "create table " + TABLE_BARCLAYS_NAME + "("
            + COLUMN_BARCLAYS_ID + " integer primary key autoincrement," + COLUMN_BARCLAYS_CURRENCY_NAME 
            + " text not null, " + COLUMN_BARCLAYS_VALUE + " REAL)";
     
    /**
    * Constructor that has one argument called Context object
    *
    * @param Context that in object of the calls CurrenciesRateExchangeMainActivity
    */
    public MySQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
      
    /**
     * onCreate() method create database and their tables. 
     * However if the database isn't created, it will create a new database
     * if database is already created then it check the current database version against
     * supplied version. if both version matches nothing happens. 
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(DATABASE_CREATE_RBS);
        db.execSQL(DATABASE_CREATE_DATE);
        db.execSQL(DATABASE_CREATE_XRATE);
        db.execSQL(DATABASE_CREATE_BARCLAYS);
    }
  
    /**
     * onUpgrade method handle the upgrade logic for database schema
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        Log.w(MySQLiteHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which destroy all data");
        db.execSQL("DROP TABLE IF EXICTS " + TABLE_RBS_NAME);
        Log.w(MySQLiteHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which destroy all data");
                db.execSQL("DROP TABLE IF EXICTS " + TABLE_DATE_NAME);
        Log.w(MySQLiteHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which destroy all data");
                db.execSQL("DROP TABLE IF EXICTS " + TABLE_XRATE_NAME);
        Log.w(MySQLiteHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which destroy all data");
                db.execSQL("DROP TABLE IF EXICTS " + TABLE_BARCLAYS_NAME);
        onCreate(db);     
    }  
}
