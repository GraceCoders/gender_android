package com.gender.gendercomfortable.company_section.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.company_section.view.adapter.Buisness_Category_Adapter
import com.gender.gendercomfortable.company_section.view.adapter.Courses_Details_Adapter
import kotlinx.android.synthetic.main.activity_business__category_.*
import kotlinx.android.synthetic.main.activity_signup_.*

class Business_Category_Activity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business__category_)
        initView()
    }

    private fun initView() {
        img_back.setOnClickListener(this)
        ll_continue.setOnClickListener(this)
        rv_categories?.layoutManager= GridLayoutManager(this,3) as RecyclerView.LayoutManager?
        rv_categories?.adapter= Buisness_Category_Adapter(this)

    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.ll_continue ->
            {
                val i = Intent(this,MainActivity::class.java)
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
}
