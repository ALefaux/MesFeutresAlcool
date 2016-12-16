package fr.itomorrow.mesfeutresalcool.interfaces;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Axou on 10/12/2016.
 */

public interface FragmentManagerInterface {
    void showFragment(Fragment sFragment);
    void showFragment(Fragment sFragment, Bundle sBundle);
}
