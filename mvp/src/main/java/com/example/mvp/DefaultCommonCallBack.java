package com.example.mvp;

import org.xutils.common.util.LogUtil;

/* *
* 作者：李赞红 on 2016/06/04 16:26
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/
public class DefaultCommonCallBack<ResultType> extends CommonCallBackAdapter<ResultType> {
    @Override
    public void onSuccess(ResultType resultType) {
        LogUtil.d(resultType + "");
    }
}
