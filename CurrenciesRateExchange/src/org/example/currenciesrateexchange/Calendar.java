package org.example.currenciesrateexchange;
// import java classes
import android.annotation.SuppressLint;
import java.util.Date;
import java.text.SimpleDateFormat;
 /**
 * Calendar class represent current day
 * Calendar class is used to get current day when that 
 * database is updated to keep record of last updated database. 
 *
 * @author dsajdl01 (David Sajdl)
 * @version (01/14/2015)
 *
 */
public class Calendar {
  
    /**
    * getCurrentDate() methods gets and returns current day and hour
    *
    * @return string current day in format year, month, day, hour,minutes and second. 
    */
    @SuppressLint("SimpleDateFormat")
    public String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         return sdf.format(new Date());
    }
}
