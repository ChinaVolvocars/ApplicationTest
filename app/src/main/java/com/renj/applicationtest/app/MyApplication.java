package com.renj.applicationtest.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.renj.applicationtest.model.http.retrofit.RetrofitUtil;
import com.renj.applicationtest.utils.SPUtils;
import com.renj.cachelibrary.CacheManageUtils;
import com.renj.imageloaderlibrary.GlideLoaderModule;
import com.renj.imageloaderlibrary.loader.ImageLoader;


/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2018-03-19   10:56
 * <p>
 * 描述：程序入口
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class MyApplication extends Application {
    private static Application mApplication;
    private static Handler mHandler = new Handler();

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;

        // 初始化库和相关配置
        initAppConfig();

    }

    /**
     * 初始化库和相关配置
     */
    private void initAppConfig() {
        // 初始化网络框架
        RetrofitUtil.newInstance().initRetrofit(this);
        // 初始化图片加载框架
        ImageLoader.initImageLoader(this, new GlideLoaderModule());
        // 初始化SharedPreferences工具类
        SPUtils.SPConfig spConfig = new SPUtils.SPConfig.Builder().spName("nursing_sp").spMode(Context.MODE_PRIVATE).build();
        SPUtils.initConfig(spConfig);
        // 初始化缓存框架
        CacheManageUtils.initCacheUtil(this);
    }

    @org.jetbrains.annotations.Contract(pure = true)
    public static Context getApplication() {
        return mApplication;
    }

    @org.jetbrains.annotations.Contract(pure = true)
    public static Handler getMainThreadHandler() {
        return mHandler;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        ImageLoader.getImageLoaderModule().clearAllMemoryCaches();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        ImageLoader.getImageLoaderModule().trimMemory(level);
    }
}
