package com.example.mvp.advices;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.addadvice.AddAdviceActivity;
import com.example.mvp.data.Advice;

import org.xutils.common.util.LogUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* *
* 作者：李赞红 on 2016/06/04 17:12
* 邮箱：lifenote@21cn.com
* 版权所有：韬睿科技 新程IT教育
*/
public class AdvicesFragment extends Fragment implements AdvicesContract.View {
    private AdvicesContract.Presenter mPresenter;
    private AdviceAdapter mAdviceAdapter;

    public static AdvicesFragment getInstance() {
        return new AdvicesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdviceAdapter = new AdviceAdapter(new ArrayList<Advice>(0));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_advices, container, false);
        setHasOptionsMenu(true);//显示选项菜单
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.lv_advices);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view,
                                           int i, final long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                AlertDialog alertDialog = builder.setTitle("确定删除")
                        .setMessage("确定要删除该建议吗？")
                        .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                LogUtil.d("==建议id：" + l);
                                mPresenter.deleteAdvice((int) l);
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).create();
                alertDialog.show();
                return true;
            }
        });
        listView.setAdapter(mAdviceAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showAdvices(List<Advice> advices) {
        mAdviceAdapter.refreshAdvices(advices);
    }

    @Override
    public void showAddAdvice() {
        Intent intent = new Intent(AddAdviceActivity.ACTION);
        startActivityForResult(intent, 0x002);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0x002 && resultCode == Activity.RESULT_OK) {
            mPresenter.loadMyAdvices();
        }
    }

    @Override
    public void deleteAdvice(@NonNull int id) {
        mAdviceAdapter.deleteAdvice(id);
    }

    @Override
    public void setPresenter(AdvicesContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_advices, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_add_advice){
            mPresenter.addNewAdvice();
        }else if(item.getItemId() == R.id.menu_refresh_advice){
            mPresenter.loadMyAdvices();
        }
        return true;
    }

    /**
     * 适配器
     */
    class AdviceAdapter extends BaseAdapter {
        private List<Advice> mAdvices;

        public AdviceAdapter(List<Advice> advices) {
            mAdvices = advices;
        }

        public void setAdvices(List<Advice> advices) {
            mAdvices = advices;
        }

        @Override
        public int getCount() {
            return mAdvices.size();
        }

        @Override
        public Object getItem(int i) {
            return mAdvices.get(i);
        }

        @Override
        public long getItemId(int i) {
            return mAdvices.get(i).getId();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View root = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_advices, viewGroup, false);
            TextView tvDate = (TextView) root.findViewById(R.id.tv_date);
            TextView tvContent = (TextView) root.findViewById(R.id.tv_content);
            TextView tvReply = (TextView) root.findViewById(R.id.tv_reply);

            Advice advice = mAdvices.get(i);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(advice.getCreateTime());
            tvDate.setText(calendar.get(Calendar.MONTH) + 1
                    + "/" + calendar.get(Calendar.DAY_OF_MONTH));
            tvContent.setText(advice.getContent());
            tvReply.setText(advice.getReply());

            return root;
        }

        public void refreshAdvices(List<Advice> advices) {
            setAdvices(advices);
            notifyDataSetChanged();
        }

        public void deleteAdvice(int id) {
            mPresenter.loadMyAdvices();
        }
    }
}
