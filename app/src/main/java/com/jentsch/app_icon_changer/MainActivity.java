package com.jentsch.app_icon_changer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMoonClick(View view) {
        String moon = (String)view.getTag();

        findViewById(R.id.moon1).setBackgroundColor(Color.TRANSPARENT);
        findViewById(R.id.moon2).setBackgroundColor(Color.TRANSPARENT);
        findViewById(R.id.moon3).setBackgroundColor(Color.TRANSPARENT);
        findViewById(R.id.moon4).setBackgroundColor(Color.TRANSPARENT);
        findViewById(R.id.moon5).setBackgroundColor(Color.TRANSPARENT);
        for (int i = 1; i < 6; i++) {
            this.getPackageManager().setComponentEnabledSetting(
                    new ComponentName(BuildConfig.APPLICATION_ID, "com.jentsch.app_icon_changer.Moon" + i),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        }

        view.setBackgroundColor(Color.GREEN);
        this.getPackageManager().setComponentEnabledSetting(
                new ComponentName(BuildConfig.APPLICATION_ID, "com.jentsch.app_icon_changer." + moon),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }
}