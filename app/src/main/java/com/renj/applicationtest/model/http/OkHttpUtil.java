package com.renj.applicationtest.model.http;

import android.content.Context;
import android.util.Log;

import com.renj.applicationtest.app.AppConstants;
import com.renj.applicationtest.utils.Logger;
import com.renj.applicationtest.utils.NetWorkUtils;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ======================================================================
 * 作者：Renj
 * <p>
 * 创建时间：2017-05-11   18:11
 * <p>
 * 描述：对OKHttp进行初始化的类(自定义配置OKHttp)
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class OkHttpUtil {
    private static OkHttpClient mOkHttpClient;

    private OkHttpUtil() {
    }

    /**
     * 初始化OkHttpClient，可以自定义配置
     *
     * @param context
     */
    public static OkHttpClient initOkHttp(final Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS);

        // 增加网络状态监听拦截器
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                if (NetWorkUtils.isConnected(context)) {
                    return chain.proceed(chain.request());
                } else {
                    throw new NoNetworkException("网络连接异常!!!");
                }
            }
        });

        // Debug 模式下打印访问网络的地址和提交的参数
        if (AppConstants.IS_DEBUG) {
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();

                    long startTime = System.currentTimeMillis();
                    Response response = chain.proceed(chain.request());
                    long endTime = System.currentTimeMillis();
                    long duration = endTime - startTime;

                    String content = response.body().string();
                    Logger.d("=============== Start ===============");
                    Logger.d("| " + request.toString());
                    String method = request.method();
                    if ("POST".equals(method)) {
                        StringBuilder sb = new StringBuilder();
                        if (request.body() instanceof FormBody) {
                            FormBody body = (FormBody) request.body();
                            for (int i = 0; i < body.size(); i++) {
                                sb.append(body.encodedName(i) + " = " + body.encodedValue(i) + " ,");
                            }
                            if (sb.length() > 0)
                                sb.delete(sb.length() - 1, sb.length());
                            Logger.d("| RequestParams:{ " + sb.toString() + " }");
                        }
                    }
                    Logger.d("| Response:" + content);
                    Logger.d("=============== End:" + duration + "毫秒 ===============");

                    return chain.proceed(request);
                }
            });
        }

        mOkHttpClient = builder.build();
        return mOkHttpClient;
    }

    /**
     * 获取OkHttpClient
     *
     * @return
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public static OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }
}
