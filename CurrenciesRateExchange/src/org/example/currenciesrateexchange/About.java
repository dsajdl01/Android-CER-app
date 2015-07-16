package org.example.currenciesrateexchange;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
 
/**
 * About class enable to open new xml layout activity called about.xml
 * where layout is set with exact width and height. 
 *
 * @author dsajdl01 (David Sajdl)
 * @version (01/03/2015)
 */
public class About extends Activity {
     
    /**
    * onCreate() method allows to open new xml layout called about.xml
    */
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.about);
          
         WindowManager.LayoutParams params = getWindow().getAttributes();  
         params.x = 0;  
         params.height = 380;  
         params.width = 270;  
         params.y = 25;  
 
         this.getWindow().setAttributes(params); 
          
     }
}
