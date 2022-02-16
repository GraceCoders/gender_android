package com.gender.gendercomfortable.company_section.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.company_section.view.adapter.Courses_Adapter
import com.gender.gendercomfortable.company_section.view.adapter.Courses_Details_Adapter
import com.gender.gendercomfortable.company_section.view.adapter.Purchased_Courses_Adapter
import kotlinx.android.synthetic.main.activity_course__details_.rv_lession_list
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_purchased_.*

class Purchased_Activity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchased_)
        initView()
    }

    private fun initView() {
        img_back.setOnClickListener(this)

        rv_courses_list.layoutManager= LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL ,false)
        rv_courses_list?.adapter= Purchased_Courses_Adapter(this)
        (rv_courses_list?.adapter as Purchased_Courses_Adapter).onItemClick ={ pos, view ->
            val intent = Intent(this, Purchased_Stats_Activity::class.java)
            startActivity(intent)

        }

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

