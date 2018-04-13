package com.renj.applicationtest.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.renj.applicationtest.model.db.DBHelper;
import com.renj.applicationtest.model.db.IDBHelper;
import com.renj.applicationtest.model.file.FileHelper;
import com.renj.applicationtest.model.file.IFileHelper;
import com.renj.applicationtest.model.http.HttpHelper;
import com.renj.applicationtest.model.http.IHttpHelper;
import com.renj.cachelibrary.CacheThreadResult;

import java.io.File;
import java.util.Map;

import io.reactivex.Flowable;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2018-03-20   10:42
 * <p>
 * 描述：Model 层管理类，所有对 Model 层的操作都通过 {@link ModelManager} 类实现
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class ModelManager implements IHttpHelper, IDBHelper, IFileHelper {
    private static volatile ModelManager instance;

    private IHttpHelper mIHttpHelper;
    private IDBHelper mIdbHelper;
    private IFileHelper mIFileHelper;

    private ModelManager(IHttpHelper iHttpHelper, IDBHelper idbHelper, IFileHelper iFileHelper) {
        this.mIHttpHelper = iHttpHelper;
        this.mIdbHelper = idbHelper;
        this.mIFileHelper = iFileHelper;
    }

    public static ModelManager newInstance() {
        if (instance == null) {
            synchronized (ModelManager.class) {
                if (instance == null)
                    instance = new ModelManager(new HttpHelper(), new DBHelper(), new FileHelper());
            }
        }
        return instance;
    }

    // ----------------------------- IHttpHelper ----------------------------- //

    @Override
    public Flowable<String> getWeather(String text, Map<String, String> queryMap) {
        return mIHttpHelper.getWeather(text, queryMap);
    }


    // ----------------------------- IFileHelper ----------------------------- //

    @Override
    public void cacheData(@NonNull String key, @NonNull String value) {
        mIFileHelper.cacheData(key, value);
    }

    @Override
    public void cacheData(@NonNull String key, @NonNull String value, int time) {
        mIFileHelper.cacheData(key, value, time);
    }

    @NonNull
    @Override
    public CacheThreadResult<File> cacheDataOnNewThread(@NonNull String key, @NonNull String value) {
        return mIFileHelper.cacheDataOnNewThread(key, value);
    }

    @NonNull
    @Override
    public CacheThreadResult<File> cacheDataOnNewThread(@NonNull String key, @NonNull String value, int time) {
        return mIFileHelper.cacheDataOnNewThread(key, value, time);
    }

    @Nullable
    @Override
    public String getCacheData(@NonNull String key) {
        return mIFileHelper.getCacheData(key);
    }

    @NonNull
    @Override
    public CacheThreadResult<String> getCacheDataOnNewThread(@NonNull String key) {
        return mIFileHelper.getCacheDataOnNewThread(key);
    }

    // ----------------------------- IDBHelper ----------------------------- //
}
