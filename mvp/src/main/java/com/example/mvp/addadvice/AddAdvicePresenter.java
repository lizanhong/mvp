package com.example.mvp.addadvice;

import com.example.mvp.advices.AdvicesContract;
import com.example.mvp.data.AdviceDataSource;
import com.example.mvp.data.AdviceRepository;

/* *
* 作者：李赞红 on 2016/06/04 20:41
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/
public class AddAdvicePresenter implements AddAdviceContract.Presenter {
    private AddAdviceContract.View mView;
    private AdviceRepository mAdviceRepository;

    public AddAdvicePresenter(AddAdviceContract.View view, AdviceRepository adviceRepository) {
        mView = view;
        mAdviceRepository = adviceRepository;

        mView.setPresenter(this);
    }

    @Override
    public void addAdvice(String content) {
        mAdviceRepository.addAdvice(content, 5, new AdviceDataSource.AddedAdviceCallBack() {
            @Override
            public void onAdviceAdded() {
                mView.showAdvicesList();
            }
        });
    }

    @Override
    public void start() {
        //啥也不干
    }
}
