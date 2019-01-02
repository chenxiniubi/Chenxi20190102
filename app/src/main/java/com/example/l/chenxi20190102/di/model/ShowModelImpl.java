package com.example.l.chenxi20190102.di.model;

import com.example.l.chenxi20190102.data.Constant;
import com.example.l.chenxi20190102.di.Contract.IShowContract;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ShowModelImpl implements IShowContract.IShowModel {
    @Override
    public void cotainData(final CallBack callBack) {
        //OkHttp
        OkHttpClient client = new OkHttpClient.Builder().build();
        //创建Request对象
        Request request = new Request.Builder().url(Constant.SHOP_URL).build();
        //通过client调用方法
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String message = e.getMessage();
                callBack.responseData(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                   String s = response.body().string();
                   callBack.responseData(s);
            }
        });
    }
}
