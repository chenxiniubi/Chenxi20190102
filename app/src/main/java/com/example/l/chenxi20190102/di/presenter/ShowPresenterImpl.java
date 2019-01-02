package com.example.l.chenxi20190102.di.presenter;

import com.example.l.chenxi20190102.di.Contract.IShowContract;
import com.example.l.chenxi20190102.di.model.ShowModelImpl;

import java.lang.ref.SoftReference;

public class ShowPresenterImpl implements IShowContract.IShowPresenter<IShowContract.IShowView> {
    IShowContract.IShowView iShowView;
    private SoftReference<IShowContract.IShowView> reference;
    private IShowContract.IShowModel model;

    @Override
    public void attachView(IShowContract.IShowView iShowView) {
        this.iShowView = iShowView;
        //软引用包裹
        reference = new SoftReference<>(iShowView);
       //创建model层对象
        model = new ShowModelImpl();
    }

    @Override
    public void dettachView(IShowContract.IShowView iShowView) {
        reference.clear();
    }

    @Override
    public void requestData() {
        model.cotainData(new IShowContract.IShowModel.CallBack() {
            @Override
            public void responseData(String message) {
                iShowView.showData(message);
            }
        });
    }
}
