package com.gender.gendercomfortable.company_section.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gender.gendercomfortable.R
import kotlinx.android.synthetic.main.activity_checkout_.*

class Checkout_Activity : AppCompatActivity(), View.OnClickListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_)
        initView()
    }

    private fun initView() {
        ll_checkout.setOnClickListener(this)
        img_back.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.ll_checkout ->
            {
                val i = Intent(this, Checkout_Successfull_Activity::class.java)
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
