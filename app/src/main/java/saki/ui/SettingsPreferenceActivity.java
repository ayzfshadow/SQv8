package saki.ui;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.ayzf.sqv8.R;

public class SettingsPreferenceActivity extends PreferenceActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      setContentView(R.layout.activity_setting);
        addPreferencesFromResource(R.xml.settingspreference);
    }
}
