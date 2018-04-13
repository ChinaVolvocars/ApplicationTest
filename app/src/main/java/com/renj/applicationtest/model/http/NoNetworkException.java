package com.renj.applicationtest.model.http;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-04-02   11:27
 * <p>
 * 描述：用于在 网络连接异常时抛出
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class NoNetworkException extends IllegalStateException {
    public NoNetworkException() {
    }

    public NoNetworkException(String message) {
        super(message);
    }

    public NoNetworkException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoNetworkException(Throwable cause) {
        super(cause);
    }
}
