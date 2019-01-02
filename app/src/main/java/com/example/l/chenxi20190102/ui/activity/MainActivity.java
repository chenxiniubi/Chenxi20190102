package com.example.l.chenxi20190102.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.l.chenxi20190102.R;
import com.example.l.chenxi20190102.data.ShowBean;
import com.example.l.chenxi20190102.di.Contract.IShowContract;
import com.example.l.chenxi20190102.di.presenter.ShowPresenterImpl;
import com.example.l.chenxi20190102.ui.adapter.ShowAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IShowContract.IShowView {
    Context context;
    @BindView(R.id.re_view)
    RecyclerView reView;
    private IShowContract.IShowPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //创建P层对象
        presenter = new ShowPresenterImpl();
        presenter.attachView(this);
        presenter.requestData();
    }

    @Override
    public void showData(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                ShowBean showBean = gson.fromJson(message, ShowBean.class);
//                ArrayList<ShowBean.DataBean> beanList = (ArrayList<ShowBean.DataBean>) showBean.getData();
               ShowBean.DataBean beanData = showBean.getData();
                GridLayoutManager manager = new GridLayoutManager(context, GridLayoutManager.DEFAULT_SPAN_COUNT);
                reView.setLayoutManager(manager);
                ShowAdapter adapter = new ShowAdapter();
                adapter.setData(context, beanData);
                reView.setAdapter(adapter);
            }
        });
    }
    //防止内存泄漏

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettachView(this);
    }
}
