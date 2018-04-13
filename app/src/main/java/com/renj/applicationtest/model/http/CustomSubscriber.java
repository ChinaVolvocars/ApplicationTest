package com.renj.applicationtest.model.http;

import android.support.annotation.NonNull;

import com.renj.applicationtest.base.view.IBaseView;
import com.renj.applicationtest.utils.Logger;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2018-03-20   14:10
 * <p>
 * 描述：自定义的 {@link ResourceSubscriber} ，减少重写方法的个数
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public abstract class CustomSubscriber<T> extends ResourceSubscriber<T> {
    private IBaseView mView;

    public CustomSubscriber(@NonNull IBaseView view) {
        this.mView = view;
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof NoNetworkException) {
            mView.showNetWorkErrorPage();
            Logger.e("Error info => " + e);
        } else {
            mView.showErrorPage(e);
            Logger.e("Get Data Error => " + e);
        }
    }

    @Override
    public void onComplete() {

    }
}
