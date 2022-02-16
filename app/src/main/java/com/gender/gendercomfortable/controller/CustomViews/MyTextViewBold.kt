package com.gender.gendercomfortable.controller.CustomViews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import com.gender.gendercomfortable.R


class MyTextViewBold : AppCompatTextView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setCustomFont(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        setCustomFont(context, attrs)
    }

    private fun setCustomFont(ctx: Context, attrs: AttributeSet) {
        val a = ctx.obtainStyledAttributes(attrs, R.styleable.CustomTextView)
        val customFont = a.getString(R.styleable.CustomTextView_customFont)
        setCustomFont(ctx, customFont)
        a.recycle()
    }

    fun setCustomFont(ctx: Context, asset: String?): Boolean {
        var typeface: Typeface? = null
        try {
           typeface = Typeface.createFromAsset(ctx.assets, "Poppins-Bold.otf")
            // typeface = Typeface.createFromAsset(ctx.getAssets(),"asse/Poppins-Bold.otf");
        } catch (e: Exception) {
            Log.e(TAG, "Unable to load typeface: " + e.message)
            return false
        }

        setTypeface(typeface)
        return true
    }

    companion object {
        private val TAG = "CustomTextView"
    }
}
