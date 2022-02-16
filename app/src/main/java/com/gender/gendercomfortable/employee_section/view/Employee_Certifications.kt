package com.gender.gendercomfortable.employee_section.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.employee_section.adapter.Certification_Adapter
import kotlinx.android.synthetic.main.activity_employee__certifications.*
import kotlinx.android.synthetic.main.activity_purchased_.img_back

class Employee_Certifications : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee__certifications)
        initView()
    }


    private fun initView() {
        img_back.setOnClickListener(this)
        rv_certification.layoutManager= LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL ,false)
        rv_certification?.adapter= Certification_Adapter(this)
//        (rv_certification?.adapter as Purchased_Courses_Adapter).onItemClick ={ pos, view ->
//            val intent = Intent(this, Purchased_Stats_Activity::class.java)
//            startActivity(intent)
//
//        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.img_back -> {

                onBackPressed()

            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
