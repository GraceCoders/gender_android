package com.gender.gendercomfortable.controller.CustomViews


import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import com.gender.gendercomfortable.R


class MyTextViewMedium : AppCompatTextView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setCustomFont(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
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
            typeface = Typeface.createFromAsset(ctx.assets, "Montserrat-Medium.ttf")
            // typeface = Typeface.createFromAsset(ctx.getAssets(),"font/HVD Fonts - BrandonText-Light.otf");
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
