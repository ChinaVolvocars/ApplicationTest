package com.renj.applicationtest.view.activity;

import android.widget.TextView;

import com.renj.applicationtest.R;
import com.renj.applicationtest.base.view.BasePresenterActivity;
import com.renj.applicationtest.controler.IMainControler;
import com.renj.applicationtest.presenter.MainPresenter;
import com.renj.applicationtest.utils.Logger;
import com.renj.applicationtest.weight.CircleImageView;
import com.renj.applicationtest.weight.MultiStateView;
import com.renj.imageloaderlibrary.loader.ImageLoader;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class MainActivity extends BasePresenterActivity<MainPresenter> implements IMainControler.IMainView {

    @BindView(R.id.multiStateView)
    MultiStateView multiStateView;
    @BindView(R.id.iv_image)
    CircleImageView ivImage;
    @BindView(R.id.tv_data)
    TextView tvData;

    @Override
    public int getLayoutId() {
        return R.layout.main_activity;
    }

    @Override
    public void initData() {
        // http://wthrcdn.etouch.cn/weather_mini?citykey=101010100
        Map<String, String> map = new HashMap<>();
        map.put("citykey", "101010100");
        mPresenter.getWeather("weather_mini", map);
    }

    // 点击非EditText控件时隐藏软键盘
    @Override
    protected boolean isShouldHideSoftKeyBoard() {
        return true;
    }

    // 不要标题栏
    @Override
    protected boolean isShowTitleBar() {
        return false;
    }

    @Override
    public void setData(String result) {
        Logger.i(result);

        tvData.setText(result);
        String url = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4258600537,2998618099&fm=27&gp=0.jpg";
        ImageLoader.getImageLoaderModule().loadImage(this, url, ivImage);
    }

    @Override
    public void showContentPage() {
        multiStateView.setViewState(MultiStateView.ViewState.CONTENT);
    }

    @Override
    public void showLoadingPage() {
        multiStateView.setViewState(MultiStateView.ViewState.LOADING);
    }

    @Override
    public void showEmptyDataPage() {
        multiStateView.setViewState(MultiStateView.ViewState.EMPTY);
    }

    @Override
    public void showNetWorkErrorPage() {
        multiStateView.setViewState(MultiStateView.ViewState.NETWORK_VIEW);
    }

    @Override
    public void showErrorPage(Throwable e) {
        multiStateView.setViewState(MultiStateView.ViewState.ERROR);
    }
}
