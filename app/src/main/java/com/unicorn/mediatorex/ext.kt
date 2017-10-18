package com.unicorn.mediatorex

import android.content.Intent
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat

import android.view.View
import com.unicorn.mediatorex.app.BaseAct


fun BaseAct.startAct(actClass: Class<*>) {
    startActivity(Intent(this, actClass))
}

fun BaseAct.startActAndFinish(actClass: Class<*>) {
    startActivity(Intent(this, actClass))
    finish()
}

