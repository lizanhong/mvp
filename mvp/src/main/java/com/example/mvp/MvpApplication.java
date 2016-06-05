package com.example.mvp;

import android.app.Application;

import org.xutils.x;

/* *
* 作者：李赞红 on 2016/06/04 15:49
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/
public class MvpApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
