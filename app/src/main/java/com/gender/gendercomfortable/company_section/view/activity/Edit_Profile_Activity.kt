package com.gender.gendercomfortable.company_section.view.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.company_section.view.fragment.Bottom_sheet_addCard
import kotlinx.android.synthetic.main.activity_add_card__list.*
import kotlinx.android.synthetic.main.activity_add_card__list.img_back
import kotlinx.android.synthetic.main.activity_edit__profile_.*

class Edit_Profile_Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit__profile_)
        initView()
    }

    private fun initView() {
        img_back.setOnClickListener(this)
        ll_save.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v?.id )
        {

            R.id.img_back ->
            {
                onBackPressed()
            }
            R.id.ll_save ->
            {
                onBackPressed()
            }


        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


    //................................hide keyboard on touch.................................................
    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager =
            activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE
            ) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            activity.currentFocus!!.windowToken, 0
        )
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val view = currentFocus
        val ret = super.dispatchTouchEvent(ev)
        if (view is EditText) {
            val w = currentFocus
            val scrcoords = IntArray(2)
            w!!.getLocationOnScreen(scrcoords)
            val x = ev.rawX + w.left - scrcoords[0]
            val y = ev.rawY + w.top - scrcoords[1]
            if (ev.action == MotionEvent.ACTION_UP
                && (x < w.left || x >= w.right || y < w.top || y > w.bottom)
            ) {
                hideSoftKeyboard(this)
            }
        }
        return ret
    }

}
