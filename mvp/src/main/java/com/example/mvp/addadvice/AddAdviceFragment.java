package com.example.mvp.addadvice;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvp.R;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/* *
* 作者：李赞红 on 2016/06/04 20:47
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/
public class AddAdviceFragment extends Fragment implements AddAdviceContract.View {
    private AddAdviceContract.Presenter mPresenter;

    @ViewInject(R.id.et_content)
    private EditText etContent;

    @ViewInject(R.id.btn_send)
    private Button btnSend;

    public static AddAdviceFragment getInstance(){
        return new AddAdviceFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_advice, container, false);
        x.view().inject(this, root);
        this.setHasOptionsMenu(true);
        return root;
    }

    @Event(R.id.btn_send)
    private void send(View v){
        mPresenter.addAdvice(etContent.getText().toString());
    }

    @Override
    public void showAdvicesList() {
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
    }

    @Override
    public void setPresenter(AddAdviceContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
