package com.renj.applicationtest.base.presenter;

import com.renj.applicationtest.base.view.IBaseView;
import com.renj.applicationtest.model.ModelManager;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2017-09-29   16:53
 * <p>
 * 描述：MVP 模式中 Presenter 层的基类
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {
    protected ModelManager mModelManager = ModelManager.newInstance();
    protected T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}
