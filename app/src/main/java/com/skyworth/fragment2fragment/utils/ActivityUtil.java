package com.skyworth.fragment2fragment.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by tonycheng on 2016/10/9.
 */

public class ActivityUtil {

    public static void addFragmentToActivity(FragmentManager fragmentManager,
                                             Fragment fragment,
                                             int containerViewId) {
        FragmentTransaction transition = fragmentManager.beginTransaction();
        transition.replace(containerViewId, fragment);
        transition.addToBackStack(null);
        transition.commit();
    }

    public static void removeFragmentFromActivity(FragmentManager fragmentManager,
                                                  Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }
}
