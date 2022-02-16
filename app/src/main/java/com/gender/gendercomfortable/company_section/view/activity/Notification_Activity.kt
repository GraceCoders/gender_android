package com.gender.gendercomfortable.company_section.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.company_section.view.adapter.Notifications_Adapter
import com.gender.gendercomfortable.company_section.view.adapter.Purchased_Courses_Adapter
import kotlinx.android.synthetic.main.activity_notification_.*
import kotlinx.android.synthetic.main.activity_purchased_.*
import kotlinx.android.synthetic.main.activity_purchased_.img_back
import kotlinx.android.synthetic.main.activity_purchased_.rv_courses_list

class Notification_Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_)
        initView()
    }
    private fun initView() {
        img_back.setOnClickListener(this)

        rv_notification.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        rv_notification?.adapter = Notifications_Adapter(this)
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
