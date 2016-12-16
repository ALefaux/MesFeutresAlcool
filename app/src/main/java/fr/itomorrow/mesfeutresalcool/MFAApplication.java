package fr.itomorrow.mesfeutresalcool;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by Axou on 11/12/2016.
 */

public class MFAApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();

        //This instantiates DBFlow
        FlowManager.init(new FlowConfig.Builder(this).build());
    }
}
