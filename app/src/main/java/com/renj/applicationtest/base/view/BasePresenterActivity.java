package com.renj.applicationtest.base.view;

import com.renj.applicationtest.base.presenter.BasePresenter;
import com.renj.applicationtest.utils.Logger;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * ======================================================================
 * 作者：Renj
 * <p>
 * 创建时间：2017-05-12   10:22
 * <p>
 * 描述：需要访问网络的Activity的基类，同时也是{@link BaseActivity}的子类<br/>
 * 如果定义了泛型参数，那么就会将该泛型的Presenter初始化出来，子类直接使用即可。参数名：<code>mPresenter</code>
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public abstract class BasePresenterActivity<T extends BasePresenter> extends BaseActivity {
    private Class<T> mClazz;
    protected T mPresenter;

    @Override
    protected void initPresenter() {
        // 通过反射获取泛型的Class
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            try {
                mClazz = (Class<T>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                mPresenter = mClazz.newInstance();
                if (null != mPresenter)
                    mPresenter.attachView(this);
            } catch (Exception e) {
                e.printStackTrace();
                Logger.e("BasePresenterActivity 创建 T extends BasePresenter 失败 => " + e);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter)
            mPresenter.detachView();
    }
}
