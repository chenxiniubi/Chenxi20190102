package com.example.l.chenxi20190102.di.Contract;

public interface IShowContract {

    //View层
    public interface IShowView{
        //展示数据
        public void showData(String message);
    }
    //Presenter层
    public interface IShowPresenter<T>{
        //绑定
         public void attachView(T t);
         //解绑
        public void dettachView(T t);
        //请求数据关联M层
        public void requestData();
    }
    //Model层
    public interface IShowModel{
         //登陆
        public void cotainData(CallBack callBack);

        //接口回调
        public interface CallBack{
            public void responseData(String message);
        }
    }

}
