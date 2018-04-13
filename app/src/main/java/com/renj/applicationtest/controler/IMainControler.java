package com.renj.applicationtest.controler;

import com.renj.applicationtest.base.presenter.IBasePresenter;
import com.renj.applicationtest.base.view.IBaseView;

import java.util.Map;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-04-02   11:01
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public interface IMainControler {
    interface IMainView extends IBaseView{
        void setData(String result);
    }

    interface IMainPresenter extends IBasePresenter<IMainView>{
        void getWeather(String text, Map<String, String> queryMap);
    }
}
