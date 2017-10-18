package com.unicorn.mediatorex.splash

import android.Manifest
import android.os.Bundle
import com.afollestad.materialdialogs.MaterialDialog
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide
import com.tbruyelle.rxpermissions2.RxPermissions
import com.unicorn.mediatorex.R
import com.unicorn.mediatorex.app.BaseAct
import com.unicorn.mediatorex.app.UserInfo
import io.reactivex.Observable
import kotlinx.android.synthetic.main.act_splash.*
import java.util.concurrent.TimeUnit


class SplashAct : BaseAct() {

    override val layoutResId = R.layout.act_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        renderBg()
        requestPermission()
    }

    private fun renderBg() {
        Glide.with(this).load(R.mipmap.splash_bg).into(splashBg)
    }

    private fun requestPermission() {
        RxPermissions(this)
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                .subscribe { granted ->
                    if (granted) {
                        showChooseRoleDialog()
                    } else {
                        ToastUtils.showShort("未授予权限")
                        finish()
                    }
                }
    }

    private fun showChooseRoleDialog() {
        val roles = listOf("申请人", "受理人")
        MaterialDialog.Builder(this)
                .title("选择角色")
                .items(roles)
                .itemsCallback { _, _, _, role ->
                    UserInfo.role = role.toString()
                    startMainAct()
                }
                .show()
    }

    private fun startMainAct() {
        Observable.just("delay")
                .delay(1, TimeUnit.SECONDS)
                .subscribe {
                    //                                startActAndFinish(MainAct::class.java)
                }
    }


}
