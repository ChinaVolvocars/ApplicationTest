package com.renj.applicationtest.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * ======================================================================
 * 作者：Renj
 * <p>
 * 创建时间：2017-05-11   18:39
 * <p>
 * 描述：Fragment的基类<br/>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 * 如果一个新的Fragment不需要访问网络，那么就直接继承{@link BaseFragment}<br/>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 * 如果一个新的Fragment需要访问网络，那么可以继承{@link BasePresenterFragment}
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public abstract class BaseFragment extends SupportFragment implements IBaseView, View.OnClickListener {

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(getLayoutId(), null);
        bind = ButterKnife.bind(this, view);
        initPresenter();
        initData();
        return view;
    }

    /**
     * 初始化Presenter，在{@link BasePresenterFragment}中重写
     */
    void initPresenter() {

    }

    @Override
    public void onClick(View v) {
        handlerClick(v, v.getId());
    }

    /**
     * 处理点击事件时，只需要重写该方法即可，不需要再实现{@link View.OnClickListener}接口
     *
     * @param v   点击的控件
     * @param vId 点击的控件id
     */
    protected void handlerClick(View v, int vId) {

    }

    @Override
    public void showContentPage() {

    }

    @Override
    public void showLoadingPage() {

    }

    @Override
    public void showEmptyDataPage() {

    }

    @Override
    public void showNetWorkErrorPage() {

    }

    @Override
    public void showErrorPage(Throwable e) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
