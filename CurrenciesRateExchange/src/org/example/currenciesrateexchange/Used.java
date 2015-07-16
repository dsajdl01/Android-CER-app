package org.example.currenciesrateexchange;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
/**
 * Used class enable to open new xml layout activity called how_to_use.xml
 * where layout is set with exact width and height.
 *
 * @author dsajdl01 (David Sajdl)
 * @version (01/03/2015)
 */
public class Used extends Activity{
 
    /**
    * onCreate() methed allows to open new xml layout called about.xml
    */
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.how_to_use);
          
         WindowManager.LayoutParams params = getWindow().getAttributes();  
         params.x = 0;  
         params.height = 380;  
         params.width = 270;  
         params.y = 25;  
         this.getWindow().setAttributes(params);
     }
}
