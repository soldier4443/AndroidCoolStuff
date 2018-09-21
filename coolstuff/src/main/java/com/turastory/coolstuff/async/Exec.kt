@file:JvmName("Exec")

package com.turastory.coolstuff.async

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

private const val THREAD_COUNT = 3

@JvmField
val main: MainThreadExecutor = MainThreadExecutor()

@JvmField
val background: Executor = Executors.newFixedThreadPool(THREAD_COUNT)

fun <T : Executor> T.waitFor(ms: Long, command: (() -> Unit)? = null): T {
    this.execute {
        Thread.sleep(ms)
        command?.invoke()
    }
    return this
}

class MainThreadExecutor internal constructor() : Executor {
    private val mainHandler = Handler(Looper.getMainLooper())
    
    override fun execute(command: Runnable) {
        mainHandler.post(command)
    }
}
