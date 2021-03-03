package com.indiabana.Utility;


import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.indiabana.Activities.MainActivity;

public class Util {

    public static void replaceFragment(Fragment fragment, MainActivity activity, int containerId) {
        String backStateName = fragment.getClass().getName();
        String fragmentTag = backStateName;

        FragmentManager manager = activity.getSupportFragmentManager();

        if (manager.findFragmentByTag(fragmentTag) == null) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(containerId, fragment, fragmentTag);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        } else {
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(containerId, fragment, fragment.getClass().getName());
            ft.commit();
        }
    }
}
