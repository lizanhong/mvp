package com.example.mvp.addadvice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.mvp.R;
import com.example.mvp.data.AdviceRepository;
import com.example.mvp.utils.ActivityUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/* *
* 作者：李赞红 on 2016/06/04 20:10
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/

@ContentView(R.layout.activity_add_advice)
public class AddAdviceActivity extends AppCompatActivity {
    public static final String ACTION = "com.example.mvp.addadvice.AddAdviceActivity";
    private AddAdvicePresenter mAddAdvicePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        init();
    }

    private void init(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        AddAdviceFragment fragment = (AddAdviceFragment) fragmentManager
                .findFragmentById(R.id.frame_content);
        if(fragment == null){
            fragment = AddAdviceFragment.getInstance();
            ActivityUtils.addFragmentToActivity(fragmentManager, fragment, R.id.frame_content);
        }

        mAddAdvicePresenter = new AddAdvicePresenter(fragment, AdviceRepository.getInstance());
    }
}
