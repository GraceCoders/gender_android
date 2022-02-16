package com.gender.gendercomfortable.employee_section.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gender.gendercomfortable.R
import kotlinx.android.synthetic.main.activity_change__password_.*

class Employee_Change_Password : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change__password_)
        initView()
    }
    private fun initView() {
        img_back.setOnClickListener(this)
        ll_change.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.img_back -> {

                onBackPressed()

            }
            R.id.ll_change -> {

                onBackPressed()

            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
