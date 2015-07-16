package org.example.currenciesrateexchange;
  
import android.os.Bundle;
import android.app.Activity;
 /**
 * NotificationView class manages to open notification xml layout 
 * that could be display on the top of the main layout
 * 
 * @author dsajdl01 (David Sajdl)
 * @version (01/14/2015)
 *
 */
public class NotificationView extends Activity{
  
    /**
    * onCreate method is the first method that is called when the class is called
    * Firstly it calls inherit method follow by loading xml file called notification
    */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
    }
}
