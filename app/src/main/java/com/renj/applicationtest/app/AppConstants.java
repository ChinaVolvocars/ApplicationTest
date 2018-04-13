package com.renj.applicationtest.app;

import com.renj.applicationtest.utils.PackageUtils;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2017-12-12   17:13
 * <p>
 * 描述：APP全局参数、配置类
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public interface AppConstants {
    /**
     * 是否 debug 版本，true 是调试版本；false 是正式版本
     */
    boolean IS_DEBUG = true;
    /**
     * APP 版本名
     */
    String versionName = PackageUtils.getVersionName();
    /**
     * APP 版本号
     */
    int versionCode = PackageUtils.getVersionCode();
    /**
     * APP的包名
     */
    String packageName = PackageUtils.getPackageName();
    /**
     * 定义APP缓存SD卡上的根目录
     */
    String APP_CACHE_ROOT_FILE = "/AnLoveKNursing";
}
