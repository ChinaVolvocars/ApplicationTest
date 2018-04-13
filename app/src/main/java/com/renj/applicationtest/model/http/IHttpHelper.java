package com.renj.applicationtest.model.http;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2018-03-20   10:55
 * <p>
 * 描述：APP 操作网络的帮助类接口，将所有的网络相关操作方法定义在此接口中
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public interface IHttpHelper {
    Flowable<String> getWeather(String text, Map<String, String> queryMap);
}
