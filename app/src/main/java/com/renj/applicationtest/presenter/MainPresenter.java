package com.renj.applicationtest.presenter;

import com.renj.applicationtest.app.AppConstants;
import com.renj.applicationtest.base.presenter.RxPresenter;
import com.renj.applicationtest.controler.IMainControler;
import com.renj.applicationtest.model.http.CustomSubscriber;
import com.renj.applicationtest.utils.Logger;
import com.renj.applicationtest.utils.StringUtils;
import com.renj.applicationtest.utils.UIUtils;
import com.renj.applicationtest.utils.rxjava.RxUtils;
import com.renj.cachelibrary.CacheThreadResult;

import java.io.File;
import java.util.Map;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-04-02   11:03
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class MainPresenter extends RxPresenter<IMainControler.IMainView> implements IMainControler.IMainPresenter {
    @Override
    public void getWeather(final String url, Map<String, String> queryMap) {

        // 先判断缓存
        String cacheData = mModelManager.getCacheData(url);
        if (!StringUtils.isEmpty(cacheData)) {
            mView.setData(cacheData);
            mView.showContentPage();
            UIUtils.showToastSafe("Use Cache Data");
            return;
        }

        addDisposable(mModelManager.getWeather(url, queryMap)
                .compose(RxUtils.newInstance().<String>threadTransformer())
                .subscribeWith(new CustomSubscriber<String>(mView) {
                    @Override
                    public void onNext(String s) {
                        if (!StringUtils.isEmpty(s)) {
                            mView.setData(s);
                            mView.showContentPage();

                            // 将数据缓存2分钟
                            mModelManager.cacheDataOnNewThread(url, s, 2 * 60)
                                    .onResult(new CacheThreadResult.CacheResultCallBack<File>() {
                                        @Override
                                        public void onResult(File result) {
                                            // 缓存文件位置
                                            if (AppConstants.IS_DEBUG)
                                                Logger.i("Cache File Path => " + result);
                                        }
                                    });

                        } else {
                            mView.showEmptyDataPage();
                        }
                    }
                }));
    }
}
