package com.example.mvp.advices;

import android.support.annotation.NonNull;

import com.example.mvp.data.Advice;
import com.example.mvp.data.AdviceDataSource;
import com.example.mvp.data.AdviceRepository;

import java.util.List;

/* *
* 作者：李赞红 on 2016/06/04 16:55
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/
public class AdvicesPresenter implements AdvicesContract.Presenter {
    private AdvicesContract.View mView;
    private AdviceRepository mRepository;

    public AdvicesPresenter(AdvicesContract.View view, AdviceRepository repository) {
        mView = view;//建立Presenter与View的关系
        mRepository = repository;

        //建立View与Presenter的关系
        mView.setPresenter(this);
    }

    @Override
    public void loadMyAdvices() {
        //读取id为5的用户的建议
        mRepository.getMyAdvices(5, new AdviceDataSource.LoadAdviceCallBack() {
            @Override
            public void onAdviceLoaded(List<Advice> advices) {
                mView.showAdvices(advices);
            }
        });
    }

    @Override
    public void deleteAdvice(@NonNull final int id) {
        //删除5号用户对应的建议
        mRepository.deleteAdvice(id, 5, new AdviceDataSource.DeletedAdviceCallBack() {
            @Override
            public void onAdviceDeleted() {
                mView.deleteAdvice(id);
            }
        });
    }

    @Override
    public void addNewAdvice() {
        mView.showAddAdvice();
    }

    @Override
    public void start() {
        loadMyAdvices();
    }
}
