package com.gender.gendercomfortable.employee_section.view

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText

import android.widget.TextView
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.company_section.view.activity.Welcome_Activity
import kotlinx.android.synthetic.main.activity_app__main_.*

class  App_Main_Activity : AppCompatActivity(), View.OnClickListener {
    var mBusiness:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app__main_)
        initView()
    }
    private fun initView() {
        tv_login.setOnClickListener(this)
        //.........................................gender spinner..................................................//
        val businessCategory = resources.getStringArray(R.array.category)
        if (sp_category != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item, businessCategory
            )
            sp_category.adapter = adapter
            sp_category.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    (view as TextView).setTextColor(Color.BLACK)
                    if (position == 0) {
                    } else {


                        //             genderSp[position]
                    }

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {

            R.id.tv_login->
            {
                val i = Intent(this, Welcome_Activity::class.java)
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
