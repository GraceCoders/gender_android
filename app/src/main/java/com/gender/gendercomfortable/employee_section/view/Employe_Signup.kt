package com.gender.gendercomfortable.employee_section.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.gender.gendercomfortable.R
import kotlinx.android.synthetic.main.activity_employe__signup.*

class Employe_Signup : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employe__signup)
        initView()
    }
    private fun initView() {

        img_back.setOnClickListener(this)
        ll_login.setOnClickListener(this)
        ll_signup.setOnClickListener(this)
        add_another_code.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.ll_login->
            {
                val i = Intent(this, Employe_Login::class.java)
                startActivity(i)
            }
            R.id.ll_signup ->
            {
                val i = Intent(this, Employee_Main_Acitivity::class.java)
                startActivity(i)
            }
            R.id.add_another_code ->
            {
                val i = Intent(this, Employee_Main_Acitivity::class.java)
                startActivity(i)
            }
            R.id.img_back ->
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
