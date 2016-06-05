package com.example.mvp.advices;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.example.mvp.R;
import com.example.mvp.data.AdviceRepository;
import com.example.mvp.utils.ActivityUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/* *
* 作者：李赞红 on 2016/06/04 17:32
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/

@ContentView(R.layout.activity_advices)
public class AdviceActivity extends AppCompatActivity {
    private AdvicesPresenter mAdvicesPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        //判断Fragment是否存在
        AdvicesFragment fragment = (AdvicesFragment) fragmentManager
                .findFragmentById(R.id.frame_content);
        //不存在则创建
        if(fragment == null){
            fragment = AdvicesFragment.getInstance();
            ActivityUtils.addFragmentToActivity(fragmentManager,
                    fragment, R.id.frame_content);
        }

        //创建Presenter
        mAdvicesPresenter = new AdvicesPresenter(fragment, AdviceRepository.getInstance());
    }

}
