package com.gender.gendercomfortable.employee_section.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.employee_section.adapter.Employee_Courses_Adapter
import com.gender.gendercomfortable.employee_section.fragment.Bottom_sheet_add_license
import kotlinx.android.synthetic.main.activity_employee__courses.*
import kotlinx.android.synthetic.main.activity_employee__main__acitivity.*

class Employee_Main_Acitivity : AppCompatActivity(), View.OnClickListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee__main__acitivity)
        initvIEW()
    }

    private fun initvIEW() {
        img_settings.setOnClickListener(this)
        tv_map_page.setOnClickListener(this)
        tv_add_licnese.setOnClickListener(this)
        rv_courses_list.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        rv_courses_list?.adapter = Employee_Courses_Adapter(this)
        (rv_courses_list?.adapter as Employee_Courses_Adapter).onItemClick = { pos, view ->
            val intent = Intent(this, Employee_Courses_Details::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.tv_map_page->
            {
                val i = Intent(this, App_Main_Activity::class.java)
                startActivity(i)
            }
            R.id.img_settings->
            {
                val i = Intent(this, Employee_settings::class.java)
                startActivity(i)
            }
            R.id.tv_add_licnese->
            {
                OpenBottomSheetPayment()
            }


        }

    }

    private fun OpenBottomSheetPayment() {
        val bottomSheet =
            Bottom_sheet_add_license()
        bottomSheet.show(
            supportFragmentManager,
            "ModalBottomSheet"
        )

    }


}
