package com.emmaguy.quicktilepocket.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.emmaguy.quicktilepocket.base.AbstractPresenter

abstract class AbstractActivity<V : AbstractPresenter.View> : AppCompatActivity() {
    protected abstract fun getLayoutId(): Int

    protected abstract fun getPresenter(): AbstractPresenter<V>
    protected abstract fun getPresenterView(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())
        getPresenter().onAttachView(getPresenterView())
    }

    override fun onDestroy() {
        getPresenter().onDetachView()

        super.onDestroy()
    }
}
