package com.renj.applicationtest.base.presenter;

import android.support.annotation.NonNull;

import com.renj.applicationtest.base.view.IBaseView;
import com.renj.applicationtest.utils.rxjava.RxBus;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2018-03-20   9:37
 * <p>
 * 描述：MVP 模式中基于 RxJava 的 Presenter，与 {@link BasePresenter} 进行分离；同时对生命周期进行绑定
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class RxPresenter<T extends IBaseView> extends BasePresenter<T> {
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    /**
     * 将 {@link Disposable} 增加到 {@link CompositeDisposable} 中，对生命周期进行控制
     *
     * @param disposable 需要增加的 {@link Disposable}
     */
    public void addDisposable(@NonNull Disposable disposable) {
        if (compositeDisposable == null)
            compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(disposable);
    }

    /**
     * 增加指定观察者的事件
     *
     * @param tClass   事件类型
     * @param consumer 观察者
     */
    public void addDefaultFlowable(@NonNull Class<T> tClass, @NonNull Consumer<T> consumer) {
        if (compositeDisposable == null)
            compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RxBus.newInstance().toDefaultFlowable(tClass, consumer));
    }

    @Override
    public void detachView() {
        // 清除事件
        if (compositeDisposable != null)
            compositeDisposable.clear();

        super.detachView();
    }
}
