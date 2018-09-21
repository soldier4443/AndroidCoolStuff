package com.turastory.coolstuff

import android.app.Activity
import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.support.v4.app.Fragment
import android.view.Window
import android.view.WindowManager

/**
 * Created by nyh0111 on 2018-03-26.
 *
 * Dimming 기능
 */
private fun dim(window: Window?, amount: Float = 0.8f) {
    if (window == null)
        return

    window.requestFeature(Window.FEATURE_NO_TITLE)
    val params = window.attributes
    params.dimAmount = amount
    params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND
    window.attributes = params
    window.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
}

fun Activity.dim(amount: Float = 0.8f) = com.turastory.coolstuff.dim(window, amount)
fun Dialog.dim(amount: Float = 0.8f) = com.turastory.coolstuff.dim(window, amount)
fun Fragment.dim(amount: Float = 0.8f) = com.turastory.coolstuff.dim(activity?.window, amount)
fun android.app.Fragment.dim(amount: Float = 0.8f) = com.turastory.coolstuff.dim(activity?.window, amount)
