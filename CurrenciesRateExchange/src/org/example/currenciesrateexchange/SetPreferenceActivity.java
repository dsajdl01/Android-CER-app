package org.example.currenciesrateexchange;
  
import android.app.Activity;
import android.os.Bundle;
 /**
 * SetPreferenceAcivity class manages sending message SetPreference class
 *
 * @author dsajdl01 (David Sajdl)
 * @version (01/14/2015)
 *
 */
public class SetPreferenceActivity extends Activity{
    /**
    * onCreate() method is the first method that is called when SetPreference is called
    * Firstly it calls inherit method follow by calling SetPreference class
    *
    */
    @Override
     protected void onCreate(Bundle savedInstanceState) {
      // TODO Auto-generated method stub
      super.onCreate(savedInstanceState);
      getFragmentManager().beginTransaction().replace(android.R.id.content,new SetPreference()).commit();
     }
}
