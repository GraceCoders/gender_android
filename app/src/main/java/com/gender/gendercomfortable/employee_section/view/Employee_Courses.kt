package com.gender.gendercomfortable.employee_section.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.company_section.view.fragment.Bottom_sheet_buy
import com.gender.gendercomfortable.employee_section.adapter.Employee_Courses_Adapter
import com.gender.gendercomfortable.employee_section.fragment.Bottom_sheet_add_license
import kotlinx.android.synthetic.main.activity_employee__certifications.*
import kotlinx.android.synthetic.main.activity_employee__courses.*
import kotlinx.android.synthetic.main.activity_purchased_.img_back

class Employee_Courses : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee__courses)
        initView()
    }

    private fun initView() {
        img_back.setOnClickListener(this)
        tv_add_courses.setOnClickListener(this)
        rv_employee_courses.layoutManager= LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL ,false)
        rv_employee_courses?.adapter= Employee_Courses_Adapter(this)
        (rv_employee_courses?.adapter as Employee_Courses_Adapter).onItemClick ={ pos, view ->
            val intent = Intent(this, Employee_Courses_Details::class.java)
            startActivity(intent)

        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.img_back -> {

                onBackPressed()

            }
            R.id.tv_add_courses -> {

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

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
