package com.renj.applicationtest.model.http;

import com.renj.applicationtest.model.http.apis.ApiServer;
import com.renj.applicationtest.model.http.retrofit.RetrofitUtil;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2018-03-20   10:51
 * <p>
 * 描述：APP 操作网络的帮助类，实现 {@link IHttpHelper} 接口
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class HttpHelper implements IHttpHelper {
    private ApiServer mApiServer;

    public HttpHelper() {
        mApiServer = RetrofitUtil.newInstance().getApiServer();
    }

    @Override
    public Flowable<String> getWeather(String text, Map<String, String> queryMap) {
        return mApiServer.getWeather(text,queryMap);
    }
}
