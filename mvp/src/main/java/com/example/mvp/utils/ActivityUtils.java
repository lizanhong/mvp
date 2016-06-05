package com.example.mvp.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/* *
* 作者：李赞红 on 2016/06/04 17:35
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/
public class ActivityUtils {
    public static void addFragmentToActivity(FragmentManager fragmentManager,
                                      Fragment fragment, int resId){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(resId, fragment);
        transaction.commit();
    }
}
