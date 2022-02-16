package com.gender.gendercomfortable.company_section.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gender.gendercomfortable.R
import kotlinx.android.synthetic.main.activity_checkout__successfull_.*

class Checkout_Successfull_Activity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout__successfull_)
        initView()
    }

    private fun initView() {
       go_home.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.go_home ->
            {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finishAffinity()
            }
        }
    }
}
