package com.renj.applicationtest.model.file;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.renj.cachelibrary.CacheManageUtils;
import com.renj.cachelibrary.CacheThreadResult;

import java.io.File;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2018-03-20   11:00
 * <p>
 * 描述：APP 操作文件的帮助类，实现 {@link IFileHelper} 接口
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class FileHelper implements IFileHelper {
    private CacheManageUtils cacheManageUtils;

    public FileHelper() {
        cacheManageUtils = CacheManageUtils.newInstance();
    }

    @Override
    public void cacheData(@NonNull String key, @NonNull String value) {
        cacheManageUtils.put(key, value);
    }

    @Override
    public void cacheData(@NonNull String key, @NonNull String value, int time) {
        cacheManageUtils.put(key, value, time);
    }

    @NonNull
    @Override
    public CacheThreadResult<File> cacheDataOnNewThread(@NonNull String key, @NonNull String value) {
        return cacheManageUtils.putOnNewThread(key, value);
    }

    @NonNull
    @Override
    public CacheThreadResult<File> cacheDataOnNewThread(@NonNull String key, @NonNull String value, int time) {
        return cacheManageUtils.putOnNewThread(key, value, time);
    }

    @Nullable
    @Override
    public String getCacheData(@NonNull String key) {
        return cacheManageUtils.getAsString(key);
    }

    @NonNull
    @Override
    public CacheThreadResult<String> getCacheDataOnNewThread(@NonNull String key) {
        return cacheManageUtils.getAsStringOnNewThread(key);
    }
}
