package com.renj.applicationtest.model.file;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.renj.cachelibrary.CacheThreadResult;

import java.io.File;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2018-03-20   10:59
 * <p>
 * 描述：APP 操作文件的帮助类接口，将所有的文件相关操作方法定义在此接口中
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public interface IFileHelper {
    void cacheData(@NonNull String key, @NonNull String value);

    void cacheData(@NonNull String key, @NonNull String value, int time);

    @NonNull
    CacheThreadResult<File> cacheDataOnNewThread(@NonNull String key, @NonNull String value);

    @NonNull
    CacheThreadResult<File> cacheDataOnNewThread(@NonNull String key, @NonNull String value, int time);

    @Nullable
    String getCacheData(@NonNull String key);

    @NonNull
    CacheThreadResult<String> getCacheDataOnNewThread(@NonNull String key);
}
