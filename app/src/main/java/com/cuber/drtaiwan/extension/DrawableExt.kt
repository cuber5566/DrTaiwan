package com.cuber.drtaiwan.extension

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat

fun Drawable.setColor(context: Context, @ColorRes color: Int) {
    mutate().setColorFilter(ContextCompat.getColor(context, color), PorterDuff.Mode.SRC_IN)
}