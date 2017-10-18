package com.unicorn.mediatorex.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseAct : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
    }

    abstract val layoutResId: Int

    protected open fun injectDependencies() {}

    protected open fun initView(savedInstanceState: Bundle?) {}

    protected open fun bindPresenter() {}

}