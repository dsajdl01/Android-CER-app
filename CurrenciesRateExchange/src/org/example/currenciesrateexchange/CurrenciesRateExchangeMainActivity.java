package org.example.currenciesrateexchange;
  
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
 
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
  
/**
 * CurrenciesRateExchangeMainActivity class is master or driver class that communicate with other classes
 * When the application gets active the first method that is executed  is onCreate().
 * Class enable to download data from the web serves and send them to validate them and then store them into database.
 * Class fill spinner with values (currency name) and display selected spinners value with rate.
 * Class is also able to deal with user input when the button is pressed class.
 * 
 * @author dsajdl01 (David Sajdl)
 * @version (01/03/2015)
 *
 */
  
public class CurrenciesRateExchangeMainActivity extends Activity {
     
        // initialize instance variables
        private Spinner spinner_from, spinner_to;
        private EditText amount;
        private TextView rateView, txtPreference, output;
        private Button btn_preference, btn_about, btn_used;
        private File dtb; 
        private String valueFrom, valueTo, preference, currentDate;
        private boolean finalUpdatedAllData, dataRBSIsUpdated,  dataXRateIsUpdated, dataBarclaysUpdated, isXrateDataExist, dateIsUpdated, isBarclaysDataExist;
        private Calendar c;
        private ValidateRBSdata rbsData;
        private DateSource dateSource;
        private RBSDataSource rbsSource;
        private XRateSource xrateSource;
        private BarclaysDataSource barclaysSource;
        private CalculateRate rbsCrl = null;
        private CalculateRate xrateCrl = null;
        private CalculateRate barclaysCrl = null;
        private NotificationManager mNotificationManager;
        private int notificationID = 1500;
        private int numMessages = 0;
        private InputMethodManager imm;
        /**
         * onCreate() method "main method"  is the first method that is called when the application gets active
         * Firstly it calls inherit method follow by loading xml file called activity_main xml layout.
         * Then give a value to instance variables and check if database exist. If database exist it opens database as writable
         * Finally method calls the other methods. One to load a data from web server by downloadRBSData(). 
         * Other one to add value into spinner by addValuesIntoSpinner() 
         * and the last method that is called is to get stare data from preferences by reloadPreferences();
         * 
         */
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
              
            dtb = getApplicationContext().getDatabasePath("bank_rate.db");
            rbsSource = new RBSDataSource(this);
            dateSource = new DateSource(this);
            xrateSource = new XRateSource(this);
            barclaysSource = new BarclaysDataSource(this);
            c = new Calendar();
            valueFrom = null;
            valueTo = null;
            currentDate = null;
            dataRBSIsUpdated = false;
            dataXRateIsUpdated = false;
            dataBarclaysUpdated = false;
            isXrateDataExist = false;
            isBarclaysDataExist = false;
            dateIsUpdated = false;
            finalUpdatedAllData = false;
            preference ="0";
             
            imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
  
            spinner_from = (Spinner) findViewById(R.id.spinner_From);
            spinner_to = (Spinner) findViewById(R.id.spinner_to);
            txtPreference = (TextView) findViewById(R.id.txt_preference);
            rateView = (TextView) findViewById(R.id.txtview_inputRate);
            output = (TextView) findViewById(R.id.txtview_output_user_result);
            btn_preference = (Button) findViewById(R.id.btn_press);
            btn_about = (Button) findViewById(R.id.btn_about);
            btn_used  = (Button) findViewById(R.id.btn_used);
            btn_about.setGravity(Gravity.CENTER);
            btn_used.setGravity(Gravity.CENTER);
             
            amount = (EditText) findViewById(R.id.txtEdit_amount);
            amount.setFocusable(false);
             
            /**
            * setOnClickListener()  inner class  or Interface definition for a callback 
            * to be invoked when a edit text is clicked.
            */
            amount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // set focus true
                  amount.requestFocus();
                  amount.setFocusableInTouchMode(true);
                    // display keyboard
                  imm.showSoftInput(amount, InputMethodManager.SHOW_IMPLICIT);
                  getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
                  
                }
 
            });
            amount.setRawInputType(Configuration.KEYBOARD_12KEY);
            // check if database exist if yes open database
            if(dtb.exists()){
                barclaysSource.open();
                rbsSource.open();
                dateSource.open();
                xrateSource.open();
                barclaysSource.open();
                // check if x-Rate data was inserted
                if(xrateSource.getProfilesCount() > 1){
                    isXrateDataExist = true;
                }
                // check if Barclays data was inserted 
                if(barclaysSource.getProfilesCount() > 1){
                    isBarclaysDataExist = true;
                }
                  
            }
            downloadRBSData();
            addValuesIntoSpinner();
            reloadPreferences();
        }
        /**
        * onResume() methods is called when the activity start interacting with the user
        * Method sets data updated as false and send message to download data and reload preference
        */
        @Override
        public void onResume(){
            super.onResume();
            dataRBSIsUpdated = false;
            dataXRateIsUpdated = false;
            dataBarclaysUpdated = false;
            dateIsUpdated = false;
            finalUpdatedAllData = false;
            downloadRBSData();
            reloadPreferences();
        }
          
        /**
        * addValuesIntoSpinner() method allows to read a data from array call countries_name in string xml file
        * and add arrays value into spinners. Method also has inner class setOnItemSelectedListener, 
        * when the spinner change selected value setOnItemSelectedListener get execute and send 
        * message to the method call updateRateViewFromSpinner() to update for current value  
        */    
        private void addValuesIntoSpinner(){
                    // loading data from string array into spinner that currency have 
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            this, R.array.countries_name, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_from.setAdapter(adapter);
                    // loading data from string array into spinner that currency want 
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(this, R.array.countries_name_two, android.R.layout.simple_spinner_item);
                    adapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_to.setAdapter(adapterTwo);
                     
                    //listener when spinner is move to update value
                     spinner_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                            Object item = parent.getItemAtPosition(pos);
                            setValueFrom(String.valueOf(item));
                            updateRateViewFromSpinner();
                              
                              
                        }
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                 //listener when spinner is move to update value
                 spinner_to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                            Object item = parent.getItemAtPosition(pos);
                            setValueTo(String.valueOf(item));
                            updateRateViewFromSpinner();
                              
                        }
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                      
        }
        /**
        * setValueFrom() private method sets currency name into instance variable called valueFrom
        * that represent currency name that user has.
        */
        private void setValueFrom(String name){
            this.valueFrom = name;
        }
        /**
        * setValueTo private method sets currency name into instance variable called valueTo
        * that represent currency name that user wants.
        */
        private void  setValueTo(String name){
            this.valueTo = name;
               
        }
        /**
        * updateRateViewFromSpinner() private method update text view. The value of the view is the value 
        * of the spinners with currency rates. 
        * Method check is database exist if yes it update view by comparing spinner value and preference value,
        * if the database does not exist it displays message that "Device needs to be connected to the Internet!"
        */
        private void updateRateViewFromSpinner(){
            try{
                // check if database exist
                if(dtb.exists()){
                    // get currencies name that are stored in database
                    if(valueFrom == null || valueTo == null) addValuesIntoSpinner();
                    SwitchCurrencyName scn = new SwitchCurrencyName(); 
                    String rbsCurrencyName1 = scn.switchRBSCurrencyName(valueFrom);
                    String rbsCurrencyName2 = scn.switchRBSCurrencyName(valueTo);
                    String xrateCurName = scn.switchXRateCurrencyName(valueFrom);
                    String xrateCurName2 = scn.switchXRateCurrencyName(valueTo);
                    String barclaysName1 = scn.switchBarclaysCurrencyName(valueFrom);
                    String barclaysName2 = scn.switchBarclaysCurrencyName(valueTo); 
                    // display message if database using current data
                    if(finalUpdatedAllData){
                        // update database with current date
                        if(!dateIsUpdated){
                            currentDate = c.getCurrentDate();
                            dateSource.updateDateValue(currentDate);
                            dateIsUpdated = true;
                        }
                        displayTopToast("Database using current update");
                    }else{
                        // display message which date data was last time updated
                      String lastUpdate = dateSource.getStoredDate();
                      displayTopToast("Database using data from: " + lastUpdate);
                    }
                    // if the best result is selected
                     
                    if(preference.equals("0")){
                            // get currency value
                        rateView.setText(preference.toString() + " preference");
                            Double rbsHave = getRBSCurrencyValueFromSQLite(rbsCurrencyName1);
                            Double rbsWant = getRBSCurrencyValueFromSQLite(rbsCurrencyName2);
                            Double xrateHave = getXRateCurrencyValueFromSQLite(xrateCurName);
                            Double xrateWant = getXRateCurrencyValueFromSQLite(xrateCurName2);
                            Double barclaysHave = getBarclaysCurrencyValueFromSQLite(barclaysName1);
                            Double barclaysWant = getBarclaysCurrencyValueFromSQLite(barclaysName2);
                            rateView.setText(preference.toString() + " preference 1..");
                            barclaysCrl = new CalculateRate(barclaysHave,barclaysWant);
                            rbsCrl = new CalculateRate(rbsHave,rbsWant);
                            xrateCrl = new CalculateRate(xrateHave,xrateWant);
                            // display the best result
                            rateView.setText(preference.toString() + " preference comming here");
                            printBestResult(rbsCrl.getRate(),xrateCrl.getRate(),barclaysCrl.getRate()); 
                    }
                    // if RBS is selected
                    else if (preference.equals("1")){
                            // get RBS value
                            Double rbsHave = getRBSCurrencyValueFromSQLite(rbsCurrencyName1);
                            Double rbsWant = getRBSCurrencyValueFromSQLite(rbsCurrencyName2);
                            rbsCrl = new CalculateRate(rbsHave,rbsWant);
                            // display RBS value
                            rateView.setText( Html.fromHtml("<b><i>&nbsp; RBS offers:</i></b>&nbsp; &nbsp; 1 " + valueFrom.substring(0,3) + " = " + String.format( "%.4f", rbsCrl.getRate()) + " " + valueTo.substring(0,3)));
                    }
                    // if xRate is selected
                    else if(preference.equals("2")){
                            // get xRate value
                            Double xrateHave = getXRateCurrencyValueFromSQLite(xrateCurName);
                            Double xrateWant = getXRateCurrencyValueFromSQLite(xrateCurName2);
                            xrateCrl = new CalculateRate(xrateHave,xrateWant);
                            // display xRate value
                            rateView.setText(Html.fromHtml("<b><i>&nbsp; x-Rate offers:</b></i>&nbsp; &nbsp; 1 "  + valueFrom.substring(0,3) + " = " + String.format( "%.4f", xrateCrl.getRate()) + " " + valueTo.substring(0,3)));
                    }
                    else if(preference.equals("3")){
                        Double barclaysHave = getBarclaysCurrencyValueFromSQLite(barclaysName1);
                        Double barclaysWant = getBarclaysCurrencyValueFromSQLite(barclaysName2);
                        barclaysCrl = new CalculateRate(barclaysHave,barclaysWant);
                        rateView.setText(Html.fromHtml("<b><i>&nbsp; Barclays offers:</i></b>&nbsp; &nbsp; 1 "  + valueFrom.substring(0,3) + " = " + String.format( "%.4f", barclaysCrl.getRate()) + " " + valueTo.substring(0,3)));
                    }                   
                     
                    // check if database is updates if not download data
                    if(!dataRBSIsUpdated) downloadRBSData();
                    if(dataRBSIsUpdated && !dataXRateIsUpdated) downloadXRateData();
                    if(dataRBSIsUpdated && dataXRateIsUpdated && !dataBarclaysUpdated) downloadBarclysData();
                }
                else{
                    // if database does not exist display message
                    displayBottomToast("Device needs to be conected to the Internet to load a data! \nPlease make sure that Android divise has a connection to the Internet.");
                }
            } catch(Exception e){
                Log.d("DatabaseDemo ", e.toString());
            }
        }
        /**
        * printBestResult() private method compare currency rate value from the bank RBS, Barclays and x-Rate
        * and display values in ascending order. The rate value with higher rates it appears on the first line. 
        * Then second higher rate value is displayed on the second line and on the third line is displayed the lower rate value.
        *
        * @param rbs double that represent currency rate from the selected currency name inside the spinners.
        * @param xrate double that represent currency rate from the selected currency name inside the spinners.
        * @param barclays double that represent currency rate from the selected currency name inside the spinners.
        */
        private void printBestResult(double rbs, double xRate, double barclays){
            if(rbs < xRate){
                    if(rbs < barclays){
                        if(xRate < barclays){
                          //  System.out.println("c = " + barclays + ", b = " + xRate + ", a = " + rbs);
                            rateView.setText( Html.fromHtml("<p><b><i>&nbsp; 1)&nbsp Barclays offers: </i></b>&nbsp; 1 "  + valueFrom.substring(0,3) + " = " + String.format( "%.4f", barclays) + " " + valueTo.substring(0,3)
                                    +"</p><p><b><i>&nbsp; 2)&nbsp x-Rate offers: </i></b>&nbsp; 1 "  + valueFrom.substring(0,3) + " = " + String.format( "%.4f", xRate) + " " + valueTo.substring(0,3)
                                    + "</p><b><i>&nbsp; 3)&nbsp RBS offers: </i></b>&nbsp; 1 " + valueFrom.substring(0,3) + " = " + String.format( "%.4f", rbs) + " " + valueTo.substring(0,3))); 
                        
                        } else{
                            //System.out.println("b = " + xRate + ", c = " + barclays + ", a = "+ rbs );
                            rateView.setText(Html.fromHtml( "<p><b><i>&nbsp; 1)&nbsp x-Rate offers: </i></b>&nbsp; 1 "  + valueFrom.substring(0,3) + " = " + String.format( "%.4f", xRate) + " " + valueTo.substring(0,3)
                                    + "</p><p><b><i>&nbsp; 2)&nbsp; Barclays offers: </i></b>&nbsp; 1 " + valueFrom.substring(0,3) + " = " + String.format( "%.4f", barclays) + " " + valueTo.substring(0,3)
                                    + "</p><b><i>&nbsp; 3) &nbsp; RBS offers: </i></b>&nbsp; 1 "  + valueFrom.substring(0,3) + " = " + String.format( "%.4f", rbs) + " " + valueTo.substring(0,3)));
                        }
                    } else if(barclays < xRate){
                       // System.out.println("b = " + xRate + ", a = " + rbs + ", c = " + barclays);
                        rateView.setText(Html.fromHtml("<p><b><i>&nbsp; 1)&nbsp x-Rate offers: </i></b>&nbsp; 1 "  + valueFrom.substring(0,3) + " = " + String.format( "%.4f", xRate) + " " + valueTo.substring(0,3)
                                + "</p><p><b><i>&nbsp; 2)&nbsp; RBS offers: </i></b>&nbsp; 1 " + valueFrom.substring(0,3) + " = " + String.format( "%.4f", rbs) + " " + valueTo.substring(0,3)
                                + "</p><b><i>&nbsp; 3) &nbsp; Barclays offers: </i></b>&nbsp; 1 "  + valueFrom.substring(0,3) + " = " + String.format( "%.4f", barclays) + " " + valueTo.substring(0,3)));
                    }
                }
                else if (barclays < xRate){
                   System.out.println("a = " + rbs + ", b = " + xRate + ", c = " + barclays);
                    rateView.setText(Html.fromHtml("<p><b><i>&nbsp; 1)&nbsp RBS offers: </i></b>&nbsp; 1 "  + valueFrom.substring(0,3) + " = " + String.format( "%.4f", rbs) + " " + valueTo.substring(0,3)
                            + "</p><p><b><i>&nbsp; 2)&nbsp; x-Rate offers: </i></b>&nbsp; 1 " + valueFrom.substring(0,3) + " = " + String.format( "%.4f", xRate) + " " + valueTo.substring(0,3)
                            + "</p><b><i>&nbsp; 3) &nbsp; Barclays offers: </i></b>&nbsp; 1 "  + valueFrom.substring(0,3) + " = " + String.format( "%.4f", barclays) + " " + valueTo.substring(0,3)));
                }else if(rbs < barclays){
                    System.out.println("c = " + barclays + ", a = " + rbs +", b = " + xRate);
                    rateView.setText(Html.fromHtml("<p><b><i>&nbsp; 1)&nbsp Barclays offers: </i></b>&nbsp; 1 "  + valueFrom.substring(0,3) + " = " + String.format( "%.4f", barclays) + " " + valueTo.substring(0,3)
                            + "</p><p><b><i>&nbsp; 2)&nbsp; RBS offers: </i></b>&nbsp; 1 " + valueFrom.substring(0,3) + " = " + String.format( "%.4f", rbs) + " " + valueTo.substring(0,3)
                            + "</p><b><i>&nbsp; 3) &nbsp; x-Rate offers: </i></b>&nbsp; 1 "  + valueFrom.substring(0,3) + " = " + String.format( "%.4f", xRate) + " " + valueTo.substring(0,3)));
                }
                else{
                    System.out.println("a = " + rbs + ", c = " + barclays + ", b = " + xRate);
                    rateView.setText(Html.fromHtml("<p><b><i>&nbsp; 1)&nbsp RBS offers: </i></b>&nbsp; 1 "  + valueFrom.substring(0,3) + " = " + String.format( "%.4f", rbs) + " " + valueTo.substring(0,3)
                            + "</p><p><b><i>&nbsp; 2)&nbsp; Barclays offers: </i></b>&nbsp; 1 " + valueFrom.substring(0,3) + " = " + String.format( "%.4f", barclays) + " " + valueTo.substring(0,3)
                            + "</p><b><i>&nbsp; 3) &nbsp; x-Rate offers: </i></b>&nbsp; 1 "  + valueFrom.substring(0,3) + " = " + String.format( "%.4f", xRate) + " " + valueTo.substring(0,3)));
                }
            }
        /**
        * getBarclaysCurrencyValueFromSQLite() private method retrieve Barclays currency value from the database.
        *
        * @param String that represent currency name that value would be retrieved.
        * @param double that represent currency value.
        */
        private double getBarclaysCurrencyValueFromSQLite(String curName){
            if(curName.equals("Euro")) return 1.0;
            return barclaysSource.getCurrencyValue(curName);
        }
        /**
        * getRBSCurrencyValufromSqlite() method retrieve RBS currency's value from the database.
        *
        * @param String that represent currency name that value would be retrieved.
        * @param double that represent currency value.
        */
        private double getRBSCurrencyValueFromSQLite(String curName){
            if(curName.equals("GBP - BRITISH POUND")) return 1.0;
            return  rbsSource.getCurrencyRBSValue(curName);
        }
        /**
        * getxRateCurrencyValufromSqlite() method retrieves xRate currency's value from the database.
        *
        * @param String that represent currency name that value would be retrieved.
        * @param double that represent currency value.
        */
        private double getXRateCurrencyValueFromSQLite(String curName){
            if(curName.equals("GBP - BRITISH POUND")) return 1.0;
            return xrateSource.getCurrencyValue(curName);
        }
        /**
        * updateBarclaysDatabase() method validates Barclays data and 
        * it either creates a new database and store data or it updates database. 
        *
        * @param String that represent html downloaded data from Barclays server 
        */
        public void updateBarclaysDatabase(String data){
            try{
                    // checking if database is already update if not
                    if(!dataBarclaysUpdated){
                        ValidateBarclaysData barclays = new ValidateBarclaysData(data);
                        // checking if data are validate if yes
                        if(barclays.getValid()){
                            String[] barArray = barclays.getData();
                            // check if Barclays database table has value if not insert values
                            if(!isBarclaysDataExist){
                                barclaysSource.open();
                                for(int i = 0; i < barArray.length - 1; i = i + 2){
                                    double value = Double.parseDouble(barArray[i+1]);
                                    barclaysSource.addValueIntoTable(barArray[i], value);
                                }
                                dataBarclaysUpdated = true;
                                isBarclaysDataExist = true;
                                finalUpdatedAllData = true;
                                updateNotification("Database has been just created & all data is inserted.", "Database using current update from " + c.getCurrentDate());
                            // if Barclays table has values then update values 
                            } else {
                                for(int i = 0; i < barArray.length - 1; i = i + 2){
                                    double value = Double.parseDouble(barArray[i+1]);
                                    barclaysSource.updateTable(barArray[i], value);
                                }
                                 dataBarclaysUpdated = true;
                                 finalUpdatedAllData = true;
                                 // display that database is updated
                                 updateNotification("All database tables are updated.", "Database using current update from " + c.getCurrentDate());
                              
                            }
                        // if data is not validated display message 
                        } else {
                        	displayBottomToast(barclays.getErrorMessage());
                        } 
             
                    }
                 
            } catch (Exception e){
                Log.d("DatabaseDemo ", e.toString());
            }
        }
         
        /**
        * updateXRateDatabase() method validates xRate data and either create new database and store data 
        * or update database if database exist  
        *
        * @param String that represent HTML downloaded data from xRate server 
        */
        public void updateXRateDatabase(String data){
            try{
                    // check if database is updated if not then
                    if(!dataXRateIsUpdated){
                            // get validate data
                            ValidateXRateData xRate = new ValidateXRateData(data); 
                            // if data is validated update or store data
                            if(xRate.getValid()){
                                String[] xrateArr = xRate.getData();
                                    // check if database exist if not open & create database and add data to database
                                    if(!isXrateDataExist){
                                        xrateSource.open();
                                        for(int i = 0; i < xrateArr.length-1; i = i + 2){
                                            double value = Double.parseDouble(xrateArr[i + 1]);
                                            xrateSource.addValueIntoTable(xrateArr[i], value);
                                        }
                                        dataXRateIsUpdated = true;
                                        isXrateDataExist = true; }
                                    else{
                                        // if database exist update database
                                        for(int j = 0; j < xrateArr.length-1; j = j + 2){
                                            double value = Double.parseDouble(xrateArr[j + 1]);
                                            xrateSource.updateTable(xrateArr[j], value);
                                        }
                                        dataXRateIsUpdated = true;
                                    }   
                            }
                            else{
                                //if data is not validated display message
                                displayBottomToast(xRate.getErrorMessage());
                            }
                    }
            } catch(Exception e){
                Log.d("DatabaseDemo ", e.toString());
            }
        }
        /**
        * updateRBSDatabase() method validates RBS data and either create a new database and store data 
        * or update database if database exist 
        *
        * @param String that represent html downloaded data from RBS server 
        */
        public void updateRBSDatabase(String data){
            try{
                // checking if database is updated if not then update database 
                if(!dataRBSIsUpdated){
                        // get validate data
                        rbsData = new ValidateRBSdata(data);
                        // if data is validated then
                        if(rbsData.getValid()){
                                String[] rbsArrData = rbsData.getData();
                                // checking if database exist? if does not: 
                                if(!dtb.exists()){
                                    //it creates and opens database then add volue into database
                                    rbsSource.open();
                                    dateSource.open();
                                    for(int i = 0; i < rbsArrData.length - 1; i = i + 3){
                                        double buy = Double.parseDouble(rbsArrData[i + 1]);
                                        double sell = Double.parseDouble(rbsArrData[i + 2]);
                                        rbsSource.addRBSValuesIntoTable(rbsArrData[i], buy, sell);
                                    }
                                     
                                    currentDate = c.getCurrentDate();
                                    dateSource.addDate(currentDate);
                                    dataRBSIsUpdated = true;
          
                                }
                                else{
                                    // if database exist then update data 
                                    for(int i = 0; i < rbsArrData.length - 1; i = i + 3){
                                        double buy = Double.parseDouble(rbsArrData[i + 1]);
                                        double sell = Double.parseDouble(rbsArrData[i + 2]);
                                        rbsSource.updateRBSValues(rbsArrData[i], buy, sell);
                                    }
                                    dataRBSIsUpdated = true;
                            } 
                                  
                        } 
                        else{
                            // if data is not validated
                            displayBottomToast(rbsData.getErrorMessage());
                        } 
                }
            } 
            catch (Exception e){
                Log.d("DatabaseDemo ", e.toString());
            }
        }
        /**
        * btnToUse() method is executed when the How To Use button is pressed
        * and method starts new activity (Used Class).
        *
        */
        public void btnToUse(View v){
            Intent i = new Intent(this, Used.class);
            startActivity(i);
        }
        /**
        * btnAbout() method is executed when the About button is pressed
        * and method starts new activity (About Class).
        *
        */
        public void btnAbout(View v){
            Intent i = new Intent(this, About.class);
            startActivity(i);
        }
        /**
        * getData() method is execute when = 'equal' button is pressed and
        * method checks if database exist if yes; then method checks if value was insert into edit text.
        * if value is insert then method process value and display result if value 
        * was not insert does not do anything. If database does not exist 
        * it display message that database does not exist.
        *   
        */
        public void getData(View v){
            try{
     /*  // instruction codes to delete database...................................................
           // delete database
          this.deleteDatabase("bank_rate.db");
          //display pop up message of deleting database success 
            displayBottomToast("database was deleted " + dtb.exists());
            // set all database tables are updated to true to ensure that the database is not created again
            dataRBSIsUpdated = true;
            dataXRateIsUpdated = true;
            dataBarclaysUpdated = true; 
       */          
           
            // checking if database exist if yes;
            if(dtb.exists()){
                    // getting input data from edit text
                    String strInput = amount.getText().toString().trim();
                    // if value is not entered
                    if(strInput.matches("")){
                        displayBottomToast(" Value is not entered ");
     /* --- code below provide test to check if all data from web-site is stored in database and next day to check if data gets update ---*/
                    //    output.setText("" + xrateSource.getAllTuples());             
                    }
                    else{
                    	 // hide keyboard
                        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                        // if value is entered cast value string to double 
                        double input = Double.parseDouble(strInput);
                        // checking preference 
                        // if the best result is selected then
                        amount.requestFocus();
                        amount.setFocusable(false);
                        amount.setFocusableInTouchMode(false);
                        // force that 
                        while(rbsCrl == null && xrateCrl == null && barclaysCrl == null){
                            updateRateViewFromSpinner();
                        }
                        if(preference.equals("0")){
                            // compare which banks have better value and display the best value.
                            printBestInputResult(rbsCrl.getRate(),xrateCrl.getRate(), barclaysCrl.getRate(), input);
                        }
                        // if RBS is selected display rbs value
                        else if(preference.equals("1")){
                            output.setText(Html.fromHtml("<p><b><i>&nbsp; In RBS for: </i></b>&nbsp;" + input + " " + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", rbsCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)));
                        }
                        // if xRate is selected display rbs value
                        else if(preference.equals("2")){
                            output.setText(Html.fromHtml("<p><b><i>&nbsp; In x-Rate for: </i></b>&nbsp;" + input + " "  + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", xrateCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)));
                        }
                        else if(preference.equals("3")){
                            output.setText(Html.fromHtml("<p><b><i>&nbsp; In Barclays for: </i></b>&nbsp;" + input + " " + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", barclaysCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)));
                        }
                     // setting edit text 
                        amount.requestFocus();
                        amount.setFocusableInTouchMode(false);
                        amount.setFocusable(false);
                        amount.setText("");
                    }
            }
            // if database does not exit display message
            else{
                displayBottomToast("Device needs to be conected to the Internet to load a data! \nPlease make sure that Android divise has a connection to the Internet.");
            }
            // download data if necessary 
            if(!dataRBSIsUpdated) downloadRBSData(); // not appropriated
            if(dataRBSIsUpdated && !dataXRateIsUpdated) downloadXRateData();
            if(dataRBSIsUpdated && dataXRateIsUpdated && !dataBarclaysUpdated ) downloadBarclysData();
            } catch(Exception e){
            	 Log.d("DatabaseInputDemo ", e.toString());
            }
        }
        /**
        * printBestInputResult() private method compare currency rate value from the bank RBS, Barclays and x-Rate
        * and display values in ascending order. The rate value with higher rates it stand on the first line. 
        * Then second higher rate value display on second line and on the third line is display the lower rate value.
        *
        * @param rbs double that represent currency rate from the selected currency name inside the spinners.
        * @param xrate double that represent currency rate from the selected currency name inside the spinners.
        * @param barclays double that represent currency rate from the selected currency name inside the spinners.
        */
        private void printBestInputResult(double rbs, double xRate, double barclays, double input){
            if(rbs < xRate){
                    if(rbs < barclays){
                        if(xRate < barclays){
                        	System.out.println( "c = " + barclays + ", b = " + xRate +  ", a = "+ rbs);
                            output.setText( Html.fromHtml("<p><b><i>&nbsp; 1)&nbsp In Barclays for: </i></b>&nbsp;" + input + " " + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", barclaysCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)
                                    +"</p><p><b><i>&nbsp; 2)&nbsp In x-Rate for: </i></b>&nbsp;" + input + " "  + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", xrateCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)
                                    +"</p><b><i>&nbsp; 3)&nbsp In RBS for: </i></b>&nbsp;" + input + " " + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", rbsCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)));
                        } else{
                        	System.out.println("b = " + xRate + ", c = " + barclays + ", a = "+ rbs);
                            output.setText(Html.fromHtml("<p><b><i>&nbsp; 1)&nbsp In x-Rate for: </i></b>&nbsp;" + input + " "  + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", xrateCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)
                                    + "</p><p><b><i>&nbsp; 2)&nbsp In Barclays for: </i></b>&nbsp;" + input + " " + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", barclaysCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)
                                    + "</p><b><i>&nbsp; 3)&nbsp In RBS for: </i></b>&nbsp;" + input + " " + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", rbsCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)));
                        }
                    } else if(barclays < xRate){
                        System.out.println("b = " + xRate + ", a = " + rbs + ", c = " + barclays);
                        output.setText(Html.fromHtml("<p><b><i>&nbsp; 1)&nbsp In x-Rate for: </i></b>&nbsp;" + input + " "  + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", xrateCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)
                                + "</p><p><b><i>&nbsp; 2)&nbsp In RBS for: </i></b>&nbsp;" + input + " " + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", rbsCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)
                                + "</p><b><i>&nbsp; 3)&nbsp In Barclays for: </i></b>&nbsp;" + input + " " + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", barclaysCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)));
                    }
                }
                else if (barclays < xRate){
                    System.out.println("a = " + rbs + ", b = " + xRate +  ", c = " + barclays );
                    output.setText(Html.fromHtml("<p><b><i>&nbsp; 1)&nbsp In RBS for: </i></b>&nbsp;" + input + " " + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", rbsCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)
                            + "</p><p><b><i>&nbsp; 2)&nbsp In x-Rate for: </i></b>&nbsp;" + input + " "  + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", xrateCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)
                            + "</p><b><i>&nbsp; 3)&nbsp In Barclays for: </i></b>&nbsp;" + input + " " + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", barclaysCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)));
                }else if(rbs < barclays){
                    System.out.println("c = " + barclays + ", a = " + rbs + ", b = " + xRate);
                    output.setText(Html.fromHtml("<p><b><i>&nbsp; 1)&nbsp In Barclays for: </i></b>&nbsp;" + input + " " + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", barclaysCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)
                            + "</p><p><b><i>&nbsp; 2)&nbsp In RBS for: </i></b>&nbsp;" + input + " " + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", rbsCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)
                            + "</p><b><i>&nbsp; 3)&nbsp In x-Rate for: </i></b>&nbsp;" + input + " "  + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", xrateCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)));
                }
                else{
                    System.out.println("a = " + rbs + ", c = " + barclays + ", b = " + xRate );
                    output.setText(Html.fromHtml("<p><b><i>&nbsp; 1)&nbsp In RBS for: </i></b>&nbsp;" + input + " " + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", rbsCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)
                            + "</p><p><b><i>&nbsp; 2)&nbsp In Barclays for: </i></b>&nbsp;" + input + " " + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", barclaysCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)
                           + "</p><b><i>&nbsp; 3)&nbsp In x-Rate for: </i></b>&nbsp;" + input + " "  + valueFrom.substring(0,3) + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i> get:&nbsp;</i></b> " + String.format( "%.4f", xrateCrl.calculateUserInput(input)) + " " + valueTo.substring(0,3)));             
                }
            }
          
        /**
        * reloadPreferences() method retrieves data from preference resource
        * and the method is executed when the application is called
        */
        private void reloadPreferences(){
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this); 
             preference = sp.getString("dispalyRate","");
             btn_preference.setText("Setting Exchange Preference");
             btn_preference.setGravity(Gravity.CENTER);
             // checking which preference is selected
             // if the best preference is selected display the best result
             if(preference.equals("0")){
                 txtPreference.setGravity(Gravity.CENTER);
                 txtPreference.setText("  Display \nBest Result");
                 output.setText( Html.fromHtml("<b><i>&nbsp; RBS has for:</b></i><br>&nbsp; <br><b><i>&nbsp; x-Rate has for:</b></i><br>&nbsp; <br><b><i>&nbsp; Barclays has for:</b></i><br>&nbsp;"));
             }
             // if RBS preference is selected display RBS
             else if(preference.equals("1")){
                 txtPreference.setGravity(Gravity.CENTER);
                 txtPreference.setText("Display\n  RBS ");
                 output.setText( Html.fromHtml("<b><i>&nbsp; RBS has for:</b></i><br>&nbsp;" ));
             }
             // if xRate preference is selected display xRate
             else if(preference.equals("2")){
                 txtPreference.setGravity(Gravity.CENTER);
                 txtPreference.setText("Display\nx-Rate");
                 output.setText( Html.fromHtml("<b><i>&nbsp; x-Rate has for:</b></i><br>&nbsp;"));
             }
             // if Barclays preference is selected display Barclays 
             else if(preference.equals("3")){
                 txtPreference.setGravity(Gravity.CENTER);
                 txtPreference.setText("Display\nBarclays");
                 output.setText( Html.fromHtml("<b><i>&nbsp; Barclays has for:</b></i><br>&nbsp;"));
             }
             else{
                 displayBottomToast("Preference was not selected.");
             }
        }
        /**
        * setPreferencies method is executed when the button Setting Exchange Preference is pressed
        * It called class SetPreferenceActivity that show preference activity form
        */
        public void setPreferencies(View v){
            Intent i = new Intent();
            i.setClass(this, SetPreferenceActivity.class);
            startActivityForResult(i,0);
        }
        /**
        * onActivityResult() method is override from Activity class and 
        * method is called when new activity is closed and going back to main activity
        * Method is call when preference activity in closed and go back 
        * to main activity and it sends message to reload preference  
        */
        @Override
         protected void onActivityResult(int requestCode, int resultCode, Intent data) {
             reloadPreferences();
         }
         /**
         * onPause() method is called when the current "main" activity is being paused 
         * this happen when some other activity start overpaying the current "main" activity 
         */
         @Override
         protected void onPause() {
             super.onPause();
             setResult(RESULT_OK, new Intent(this, CurrenciesRateExchangeMainActivity.class));
         }
         /**
         * displayTopToast() method displays pop up message on the top of the screen which 
         * will be display approximately for 20 second.
         *
         * @param string message that represent a message that will be displayed
         */
         public void displayTopToast(String message){
             LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.toast_layout_root));
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText(message);
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 49);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
         }
         /**
         * displayBottomToast() method displays pop up message on the bottom of the screen which 
         * will be display approximately for 20 second.
         *
         * @param string message that represent a message that will be displayed
         */
         public void displayBottomToast(String message){
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.toast_layout_root));
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText(message);
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }
          
        /**
        * downloadBarclysData() method checks if the connection with network is available 
        * if yes it starts loading data by calling DownloadBarclysWebPageTask inner class that have Barclays url as the argument 
        * if no, it displays message that network in not available 
        */
         public void downloadBarclysData(){
             if(isNetworkAvailable()){
                 DownloadBarclysWebPageTask task = new DownloadBarclysWebPageTask();
                 task.execute(new String[] { "https://www.barclayscorporate.com/foreign-exchange-rates.html" });
             }
             else{
                 displayBottomToast("NETWORK IS NOT AVAILABLE");
             }
         }
          
        /**
        * downloadXRateData() method checks if the connection with network is available 
        * if yes it starts loading data by calling DownloadWebPageTask inner class that have xRate url as the argument 
        * if no, it displays message that network in not available 
        */
         public void downloadXRateData() {
                    if(isNetworkAvailable()){
                        DownloadWebPageTask task = new DownloadWebPageTask();
                        task.execute(new String[] { "http://www.x-rates.com/table/?from=GBP" });
                    }
                    else{
                        displayBottomToast("NETWORK IS NOT AVAILABLE");
                    }
  
            }
           
          
        /**
         * downloadRBSData() method checks if the connection with network is available
         * if yes it starts loading data by calling ReadStreamTask inner class that have RBS url argument
         * if no, it displays message that network in not available 
         */
        public void downloadRBSData(){
            if(isNetworkAvailable()){
                new ReadStreamTask().execute("http://www.rbs.co.uk/personal/travel/g1/money/exchange-rates.ashx");
            }
            else{   
                displayBottomToast("NETWORK IS NOT AVAILABLE");
            }
        }
      
        /**
         * isNetworkAvailable() check if android device is connected to the Internet
         *
         * @return boolean condition that is either true if there is a connection available or false there is not connection
         */
        private boolean isNetworkAvailable(){
            boolean available = false;
            ConnectivityManager mng = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = mng.getActiveNetworkInfo();
            if(netInfo != null && netInfo.isAvailable()){
                available = true;
            }
            return available;
        }
      
              
            /**
             * readStream method takes an URL as argument and return HTML text context
             *
             * @param urlStr string url from where data will be loaded
             * @return string HTML text content 
             * @throws IOException if instance of HttpURLconnection class is not delivered by method 
             * openConnection it throws exception
             */
              
            private String readStream(String urlStr) throws IOException{
                String str = "";
                InputStream inputstr = null;
                BufferedReader reader = null;
                  
                try{
                    URL url = new URL(urlStr);
                    HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
                    inputstr = urlConn.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(inputstr));
                    String line = "";
                    while((line = reader.readLine()) != null){
                        str +=line;
                    }
                }catch(Exception ex){
                    Log.d("Networking demo", ex.toString());
                } finally{
                    inputstr.close();
                    reader.close();
                }
                return str;
            }
             
            /**
            * displayNotification() method enable to create notification 
            * and display small notes on the top of the screen
            * 
            * @param string message that represent small note on the top of the screen
            * @param string message2 that represent text in the notification
            */
            protected void displayNotification(String message, String message2) {
                  Log.i("Start", "notification");
                   
                  /* Invoking the default notification service */
                  Notification.Builder  mBuilder = new Notification.Builder(this);  
                  mBuilder.setSmallIcon(R.drawable.logo_notification).setTicker(message); //.setWhen(0);
                  mBuilder.setAutoCancel(false).setContentTitle("Loading Data Info:");
                  mBuilder.setStyle(new Notification.BigTextStyle().bigText(message2));
                 
                  /* Increase notification number every time a new notification arrives */
                  mBuilder.setNumber(++numMessages);
                    
                  /* Creates an explicit intent for an Activity in your app */
                  Intent resultIntent = new Intent(this, NotificationView.class);
  
                  TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
                  stackBuilder.addParentStack(NotificationView.class);
  
                  /* Adds the Intent that starts the Activity to the top of the stack */
                  stackBuilder.addNextIntent(resultIntent);
                  PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
   
                  mBuilder.setContentIntent(resultPendingIntent);
                   
                  mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
  
                  /* notificationID allows you to update the notification later on. */
                  mNotificationManager.notify(notificationID, mBuilder.build());
               }
            /**
            * updateNotification() method enable to update notification text 
            * and pop up small note on the top of the screen
            * 
            * @param string message that represent small note on the top of the screen.
            * @param string message2 that represent text in the notification
            */
            protected void updateNotification(String message, String message2) {
                  Log.i("Update", "notification");
  
                  /* Invoking the default notification service */
                  Notification.Builder  mBuilder = new Notification.Builder(this);  
                   
                  mBuilder.setSmallIcon(R.drawable.logo_notification).setTicker(message); //.setWhen(0);
                  mBuilder.setContentTitle("Loading Data Info:");
                  mBuilder.setStyle(new Notification.BigTextStyle().bigText(message2));
  
                 /* Increase notification number every time a new notification arrives */
                  mBuilder.setNumber(++numMessages);
                    
                  /* Creates an explicit intent for an Activity in your app */
                  Intent resultIntent = new Intent(this, NotificationView.class);
  
                  TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
                  stackBuilder.addParentStack(NotificationView.class);
  
                  /* Adds the Intent that starts the Activity to the top of the stack */
                  stackBuilder.addNextIntent(resultIntent);
                  PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
  
                  mBuilder.setContentIntent(resultPendingIntent);
  
                  mNotificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
  
                  /* Update the existing notification using same notification ID */
                  mNotificationManager.notify(notificationID, mBuilder.build());
               }
                /**
                * cancelNotification() method destroyed or cancel notification 
                */
                protected void cancelNotification() {
                      Log.i("Cancel", "notification");
                      mNotificationManager.cancel(notificationID);
                 }  
              
                      
                    /**
                     * ReadStremTask class or inner class is a subclass of AsyncTask class 
                     * to not allowed to perform network operations  in a UI thread.
                     * Class allows to download data from the web server.
                     */
                    private class ReadStreamTask extends AsyncTask<String, Void, String>{
                        String str = "";
                         /**
                         * onPreExecute() method is execute before data is loaded.
                         */
                        @Override
                           protected void onPreExecute() {
                              super.onPreExecute();
                              // while RBS data is downloading do not send to download data again
                              dataRBSIsUpdated = true;
                              displayNotification("Downloading RBS data...", "RBS data just being loaded.");
                           }
                            /**
                             * doInBackground method download data from the server 
                             */
                            @Override
                            protected String doInBackground(String... params) {
                                // TODO Auto-generated method stub
                                try{
                                        str = readStream(params[0]);
                                    }catch(Exception ex){
                                        // if downloading fail then try to download data again
                                        dataRBSIsUpdated = false;
                                        Log.d("NetworkingDemo ", ex.toString());                                    
                                }
                                return str;
                            }
                  
                        /**
                         * onPostExecute method receives web server data and sent data to update database.
                         */
                        @Override
                        protected void onPostExecute(String result) {
                            cancelNotification();
                            // before RBS data is validated set dataRBSIsUpdated to fail
                            dataRBSIsUpdated = false;
                            updateRBSDatabase(result.toString());
                            downloadXRateData();
                    }
            }
             
                /**
                * DownloadBarclysWebPageTask class or inner class is a subclass of AsyncTask class 
                * Class allows to download Barclays data from the web server.
                */    
                private class DownloadBarclysWebPageTask extends AsyncTask<String, Void, String> {
                        /**
                         * onPreExecute() method is execute before data is loaded.
                         */
                        @Override
                           protected void onPreExecute() {
                              super.onPreExecute();
                              // while Barclays data is downloading set dataBarclaysUpdated to true to not sending download data again 
                              dataBarclaysUpdated = true;
                              displayNotification("Downloading Barclays data...", "RBS and x-Rate Data is downloaded and database has been updated \nBarclys data just being downloaded. \nTo download all data may take a couple second. Please wait...");
                           }
                        /**
                        * doInBackground method download data from the server 
                        */
                        @Override
                        protected String doInBackground(String... urls) {
                            String response = "";
                            for (String url : urls) {
                                DefaultHttpClient client = new DefaultHttpClient();
                                HttpGet httpGet = new HttpGet(url);
                                try {
                                    HttpResponse execute = client.execute(httpGet);
                                    InputStream content = execute.getEntity().getContent();
 
                                    BufferedReader buffer = new BufferedReader(
                                            new InputStreamReader(content));
                                    String s = "";
                                    while ((s = buffer.readLine()) != null) {
                                        response += s;
                                    }
 
                                } catch (Exception e) {
                                    // if downloading data fail set dataBarclaysUpdated to false to download data again.
                                    dataBarclaysUpdated = false;
                                    e.printStackTrace();
                                }
                            }
                            return response;
                        }
                        /**
                         * onPostExecute method receives web server data and sent data to update database.
                         */
                        @Override
                        protected void onPostExecute(String result) {
                            cancelNotification() ;
                            // before the data is validated set dataBarclaysUpdated to fail
                            dataBarclaysUpdated = false;
                            updateBarclaysDatabase(result.toString());
                        }
                         
                    }
                     
                    /**
                    * DownloadBarclysWebPageTask class or inner class is a subclass of AsyncTask class 
                    * Class allows to download barclays data from the web server.
                    */
                    private class DownloadWebPageTask extends AsyncTask<String, Void, String> {
                         /**
                         * onPreExecute() method is execute before data is loaded.
                         */
                        @Override
                           protected void onPreExecute() {
                              super.onPreExecute();
                              //while data is downloading do not send message to download data again.
                              dataXRateIsUpdated = true;
                              displayNotification("Downloading x-Rate data...", "RBS Data is downloaded \nx-Rate data just being loaded. \nTo download all data may take a couple second.");
                           }
                        /**
                        * doInBackground method download data from the server 
                        */
                        @Override
                        protected String doInBackground(String... urls) {
                            String response = "";
                            for (String url : urls) {
                                DefaultHttpClient client = new DefaultHttpClient();
                                HttpGet httpGet = new HttpGet(url);
                                try {
                                    HttpResponse execute = client.execute(httpGet);
                                    InputStream content = execute.getEntity().getContent();
  
                                    BufferedReader buffer = new BufferedReader(
                                            new InputStreamReader(content));
                                    String s = "";
                                    while ((s = buffer.readLine()) != null) {
                                        response += s;
                                    }
  
                                } catch (Exception e) {
                                    //if downloading fail set dataXRateIsUpdated to fail to try load data again
                                    dataXRateIsUpdated = false;
                                    e.printStackTrace();
                                }
                            }
                            return response;
                        }
                        /**
                         * onPostExecute method receives web server data and sent data to update database.
                         */
                        @Override
                        protected void onPostExecute(String result) {
                            cancelNotification() ;
                            // before the data is validated set dataXrateUpdate to fail
                            dataXRateIsUpdated = false;
                            updateXRateDatabase(result.toString());
                            downloadBarclysData();
                             
                        }
                   }
}
