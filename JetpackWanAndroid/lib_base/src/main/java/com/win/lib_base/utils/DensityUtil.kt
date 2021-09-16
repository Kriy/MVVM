package com.win.lib_base.utils

import android.content.res.Configuration
import android.content.res.Resources
import android.util.DisplayMetrics

object DensityUtil {

    @JvmStatic
    fun dip2px(dpValue: Float): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    @JvmStatic
    fun px2dip(pxValue: Float): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    @JvmStatic
    fun isLandscape(): Boolean {
        if (Resources.getSystem().configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return true
        } else if (Resources.getSystem().configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            return false
        }
        return false
    }

    @JvmStatic
    fun getScreenWidth(): Int{
        return Resources.getSystem().displayMetrics.widthPixels
    }

    @JvmStatic
    fun getScreenHeight():Int{
        return Resources.getSystem().displayMetrics.heightPixels
    }

    private fun getDisplayMetrics(): DisplayMetrics {
        return Resources.getSystem().displayMetrics
    }

}