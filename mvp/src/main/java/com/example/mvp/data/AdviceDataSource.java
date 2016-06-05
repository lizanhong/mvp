package com.example.mvp.data;

import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* *
* 作者：李赞红 on 2016/06/04 15:24
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/
public interface AdviceDataSource {
    public class AdviceJSONResponseParser implements ResponseParser{

        @Override
        public void checkResponse(UriRequest uriRequest) throws Throwable {

        }

        @Override
        public Object parse(Type type, Class<?> aClass, String s) throws Throwable {
            JSONObject json = JSON.parseObject(s);

            if(aClass == List.class) {
                if (json.getBoolean("success")) {
                    JSONArray data = json.getJSONArray("data");
                    List<Advice> list = new ArrayList<>();
                    for (int i = 0; i < data.size(); i++) {
                        JSONObject current = data.getJSONObject(i);
                        Advice advice = new Advice(current.getIntValue("id"),
                                current.getIntValue("uid"),
                                current.getString("content"),
                                current.getString("reply"),
                                current.getDate("create_time"),
                                current.getDate("reply_date"),
                                current.getIntValue("reply_uid"));
                        list.add(advice);
                    }
                    return list;
                }
            }else{
                return s;
            }
            return null;
        }
    }

    public void addAdvice(@NonNull String content, @NonNull int uid, @NonNull AddedAdviceCallBack callBack);
    public void getMyAdvices(@NonNull int uid, @NonNull LoadAdviceCallBack callBack);
    public void deleteAdvice(@NonNull int id, @NonNull  int uid, @NonNull DeletedAdviceCallBack callBack);

    public interface LoadAdviceCallBack{
        void onAdviceLoaded(List<Advice> advices);
    }

    public interface DeletedAdviceCallBack{
        void onAdviceDeleted();
    }

    public interface AddedAdviceCallBack{
        void onAdviceAdded();
    }
}
