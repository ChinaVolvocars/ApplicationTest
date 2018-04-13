package com.renj.applicationtest.base.view;

import android.support.annotation.LayoutRes;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2017-09-29   16:39
 * <p>
 * 描述：MVP模式中View顶层接口
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public interface IBaseView {
    @LayoutRes
    int getLayoutId();

    void initData();

    void showContentPage();

    void showLoadingPage();

    void showEmptyDataPage();

    void showNetWorkErrorPage();

    void showErrorPage(Throwable e);
}
