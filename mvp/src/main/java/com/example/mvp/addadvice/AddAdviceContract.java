package com.example.mvp.addadvice;

import com.example.mvp.BasePresenter;
import com.example.mvp.BaseView;

/* *
* 作者：李赞红 on 2016/06/04 19:37
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/
public interface AddAdviceContract {
    public interface Presenter extends BasePresenter{
        public void addAdvice(String content);
    }

    public interface View extends BaseView<Presenter>{
        public void showAdvicesList();
    }
}
