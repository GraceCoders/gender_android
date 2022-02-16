package com.gender.gendercomfortable.company_section.view.activity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.company_section.view.adapter.Courses_Adapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener  {
    var mBusiness:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {


        setting_page.setOnClickListener(this)
        courses_purchased.setOnClickListener(this)
        img_notification.setOnClickListener(this)
        img_cart.setOnClickListener(this)



        rv_courses.layoutManager= LinearLayoutManager(this,
        LinearLayoutManager.VERTICAL ,false)
        rv_courses?.adapter= Courses_Adapter(this)
        (rv_courses?.adapter as Courses_Adapter).onItemClick ={pos, view ->
            val intent = Intent(this, Course_Details_Activity::class.java)
            startActivity(intent)

        }
    }


    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.setting_page ->
            {
                val i = Intent(this, Setting_Activity::class.java)
                startActivity(i)
            }
            R.id.courses_purchased ->
            {
                val i = Intent(this, Purchased_Activity::class.java)
                startActivity(i)
            }
            R.id.img_notification ->
            {
                val i = Intent(this, Notification_Activity::class.java)
                startActivity(i)
            }
            R.id.img_cart ->
            {
                val i = Intent(this, Checkout_Activity::class.java)
                startActivity(i)
            }
        }
    }
}
