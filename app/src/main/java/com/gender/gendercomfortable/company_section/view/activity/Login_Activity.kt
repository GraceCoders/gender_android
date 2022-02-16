package com.gender.gendercomfortable.company_section.view.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.gender.gendercomfortable.R
import kotlinx.android.synthetic.main.activity_login_.*

class Login_Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_)
        initView()
    }


    private fun initView() {
        tv_fgt_pwd.setOnClickListener(this)
        ll_login.setOnClickListener(this)
        ll_signup.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.ll_login->
            {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }
            R.id.ll_signup ->
            {
                val i = Intent(this, Signup_Activity::class.java)
                startActivity(i)
            }
            R.id.tv_fgt_pwd ->
            {
                val i = Intent(this, Forget_Password_Activity::class.java)
                startActivity(i)
            }

        }
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
