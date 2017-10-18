package com.unicorn.mediatorex

import android.Manifest
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.tbruyelle.rxpermissions2.RxPermissions
import com.unicorn.mediatorex.app.BaseAct
import kotlinx.android.synthetic.main.act_splash.*


class SplashAct : BaseAct() {

    override val layoutResId = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Glide.with(this).load(R.mipmap.splash_bg).into(splashBg)
        requestPermission()
    }

    private fun requestPermission() {
        RxPermissions(this)
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.ACCESS_COARSE_LOCATION)
                .subscribe { granted ->
                        if (granted) {
                            // showRoleDialog()
                        } else {
//                            ToastUtils.showShort("未授予权限")
                            finish()
                        }
                    }

    }






}
