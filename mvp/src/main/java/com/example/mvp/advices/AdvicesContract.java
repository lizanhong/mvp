package com.example.mvp.advices;

import android.support.annotation.NonNull;

import com.example.mvp.BasePresenter;
import com.example.mvp.BaseView;
import com.example.mvp.data.Advice;

import java.util.List;

/* *
* 作者：李赞红 on 2016/06/04 16:31
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/
public interface AdvicesContract {

    public interface Presenter extends BasePresenter{
        /**
         * 加载我的建议
         */
        void loadMyAdvices();

        /**
         * 删除建议
         * @param id
         */
        void deleteAdvice(@NonNull int id);

        /**
         * 添加新建议
         */
        void addNewAdvice();
    }

    public interface View extends BaseView<Presenter>{
        /**
         * 显示我的建议
         * @param advices
         */
        void showAdvices(List<Advice> advices);

        /**
         * 打开提建议的Activity
         */
        void showAddAdvice();

        /**
         * 删除我的一条建议
         * @param id
         */
        void deleteAdvice(@NonNull int id);
    }

}
