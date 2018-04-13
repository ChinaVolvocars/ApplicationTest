package com.renj.applicationtest.model.bean;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2018-03-27   14:26
 * <p>
 * 描述：用于RxBus传递数据，通过 what 和 msg 标记信息进行判断
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class RxBusBean {
    /*** 数字标记 ***/
    public int what;
    /*** 字符串标记 ***/
    public String msg;
    /*** 简单的数字数据 ***/
    public int intData;
    /*** 简单的字符串数据 ***/
    public String stringData;
    /*** 复杂数据 ***/
    public Object objectData;

    public RxBusBean(int what, String msg) {
        this.what = what;
        this.msg = msg;
    }

    public RxBusBean(int what, String msg, int intData) {
        this.what = what;
        this.msg = msg;
        this.intData = intData;
    }

    public RxBusBean(int what, String msg, int intData, String stringData) {
        this.what = what;
        this.msg = msg;
        this.intData = intData;
        this.stringData = stringData;
    }

    public RxBusBean(int what, String msg, int intData, String stringData, Object objectData) {
        this.what = what;
        this.msg = msg;
        this.intData = intData;
        this.stringData = stringData;
        this.objectData = objectData;
    }
}
