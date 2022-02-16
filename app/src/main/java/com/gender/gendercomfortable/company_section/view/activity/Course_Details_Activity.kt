package com.gender.gendercomfortable.company_section.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.company_section.view.adapter.Courses_Adapter
import com.gender.gendercomfortable.company_section.view.adapter.Courses_Details_Adapter
import com.gender.gendercomfortable.company_section.view.fragment.Bottom_sheet_buy
import kotlinx.android.synthetic.main.activity_course__details_.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.rv_courses

class Course_Details_Activity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course__details_)
        initView()
    }

    private fun initView() {
        img_back.setOnClickListener(this)
        ll_buy.setOnClickListener(this)
        rv_lession_list.layoutManager= LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL ,false)
        rv_lession_list?.adapter= Courses_Details_Adapter(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.img_back ->
            {
                onBackPressed()
            }
            R.id.ll_buy ->
            {
                OpenBottomSheetPayment()
            }
        }
    }

    private fun OpenBottomSheetPayment() {
        val bottomSheet =
            Bottom_sheet_buy()
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
