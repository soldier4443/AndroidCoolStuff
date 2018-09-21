package com.turastory.coolstuff

import android.util.Log

/**
 * Created by tura on 2018-09-19.
 *
 * Logging methods.
 */

fun Any.ld(message: String, tag: String = javaClass.simpleName) {
    if (BuildConfig.DEBUG) {
        Log.d(tag, message)
    }
}

fun Any.le(message: String, tag: String = javaClass.simpleName) {
    if (BuildConfig.DEBUG) {
        Log.e(tag, message)
    }
}
