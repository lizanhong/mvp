package com.example.mvp;

import org.xutils.common.Callback;

/* *
* 作者：李赞红 on 2016/06/04 16:02
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/
public abstract class CommonCallBackAdapter<ReturnType>
        implements Callback.CommonCallback<ReturnType> {

    @Override
    public void onError(Throwable throwable, boolean b) {

    }

    @Override
    public void onCancelled(CancelledException e) {

    }

    @Override
    public void onFinished() {

    }
}
