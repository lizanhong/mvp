package com.example.mvp.data;

import android.support.annotation.NonNull;

import com.example.mvp.CommonCallBackAdapter;
import com.example.mvp.DefaultCommonCallBack;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;
import org.xutils.x;

import java.util.List;

/* *
* 作者：李赞红 on 2016/06/03 17:31
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/
public class AdviceRepository implements AdviceDataSource{
    private static AdviceRepository sAdviceRepository;

    private AdviceRepository() {
    }

    public static AdviceRepository getInstance(){
        if(sAdviceRepository == null){
            sAdviceRepository = new AdviceRepository();
        }
        return sAdviceRepository;
    }

    @Override
    public void addAdvice(@NonNull String content, @NonNull int uid, @NonNull final AddedAdviceCallBack callBack) {
        String url = "http://tr.api.gson.cn/system/feedback/" + uid;
        RequestParams params = new RequestParams(url);
        params.addBodyParameter("content", content);
        x.http().post(params, new CommonCallBackAdapter<String>() {
            @Override
            public void onSuccess(String s) {
                callBack.onAdviceAdded();
            }
        });
    }

    @Override
    public void getMyAdvices(@NonNull int uid, @NonNull final LoadAdviceCallBack callBack) {
        String url = "http://tr.api.gson.cn/system/feedback/" + uid;
        RequestParams params = new RequestParams(url);
        x.http().get(params, new CommonCallBackAdapter<List<Advice>>() {
            @Override
            public void onSuccess(List<Advice> advices) {
                callBack.onAdviceLoaded(advices);
            }
        });
    }

    @Override
    public void deleteAdvice(@NonNull int id, @NonNull  int uid, @NonNull final DeletedAdviceCallBack callBack) {
        String url = "http://tr.api.gson.cn/system/feedback/delete/" + uid + "/" + id;
        LogUtil.d(url);
        RequestParams params = new RequestParams(url);
        x.http().get(params, new CommonCallBackAdapter<String>() {
            @Override
            public void onSuccess(String s) {
                callBack.onAdviceDeleted();
            }
        });
    }
}
