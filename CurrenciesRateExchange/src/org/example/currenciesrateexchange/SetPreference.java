package org.example.currenciesrateexchange;
  
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
 /**
 * SetPreference class manages to open preferences xml layout that
 * is displayed on the top of the main layout (activity_main xml) 
 *
 * @author dsajdl01 (David Sajdl)
 * @version (01/14/2015)
 *
 */
public class SetPreference extends PreferenceFragment{
    /**
    * onCreate() method is the first method that is called when SetPreference is called
    * Firstly it calls inherit method follow by loading xml file called activity_main
    * onCreate method also has on button listener and when the button back is pressed 
    * setOnPreferenceClickListener class gets executed that 
    * returns back to CurrenciesRateExchangeMainActivity class or to main layout
    *
    */
    public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
  
            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.preferencies);
            //on button listener
            Preference button = (Preference)getPreferenceManager().findPreference("button");      
            if (button != null) {
                button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(){
                    @Override
                    public boolean onPreferenceClick(Preference arg0){
                        Intent intent = new Intent(getActivity(), CurrenciesRateExchangeMainActivity.class);
                        startActivity(intent);
                        return false;
                    }
                });     
           }
    }
}
 