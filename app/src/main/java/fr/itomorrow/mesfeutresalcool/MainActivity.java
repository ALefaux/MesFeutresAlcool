package fr.itomorrow.mesfeutresalcool;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import fr.itomorrow.mesfeutresalcool.fragments.MarquesFragment;
import fr.itomorrow.mesfeutresalcool.interfaces.FragmentManagerInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragmentManagerInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragment(new MarquesFragment());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void showFragment(Fragment sFragment) {
        showFragment(sFragment, null);
    }

    @Override
    public void showFragment(Fragment sFragment, Bundle sBundle) {
        if(sFragment != null){
            final android.support.v4.app.FragmentManager tFragmentManager = getSupportFragmentManager();
            if(sBundle != null){
                sFragment.setArguments(sBundle);
            }
            FragmentTransaction tFragmentTransaction;
            tFragmentTransaction = tFragmentManager.beginTransaction();
            tFragmentTransaction.addToBackStack(sFragment.getClass().getName());
            tFragmentTransaction.replace(R.id.main_activity_container, sFragment, sFragment.toString());
            tFragmentTransaction.commit();
        }
    }
}
