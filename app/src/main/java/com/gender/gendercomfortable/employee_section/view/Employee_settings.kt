package com.gender.gendercomfortable.employee_section.view

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gender.gendercomfortable.R
import kotlinx.android.synthetic.main.activity_employee_settings.*
import kotlinx.android.synthetic.main.activity_employee_settings.img_back
import kotlinx.android.synthetic.main.activity_employee_settings.ll_change_pwd
import kotlinx.android.synthetic.main.activity_employee_settings.ll_courses
import kotlinx.android.synthetic.main.activity_employee_settings.ll_edit_profile
import kotlinx.android.synthetic.main.activity_employee_settings.ll_logout
import kotlinx.android.synthetic.main.activity_employee_settings.ll_privacy
import kotlinx.android.synthetic.main.activity_employee_settings.ll_terms

class Employee_settings : AppCompatActivity(),View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_settings)
        initView()
    }

    private fun initView() {
        img_back.setOnClickListener(this)
        ll_edit_profile.setOnClickListener(this)
        ll_certification.setOnClickListener(this)
        ll_change_pwd.setOnClickListener(this)
        ll_courses.setOnClickListener(this)
        ll_terms.setOnClickListener(this)
        ll_privacy.setOnClickListener(this)
        ll_logout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.img_back -> {
                onBackPressed()

            }
            R.id.ll_edit_profile -> {
                val i = Intent(this, Employee_Edit_Profile::class.java)
                startActivity(i)

            }
            R.id.ll_certification -> {
                val i = Intent(this, Employee_Certifications::class.java)
                startActivity(i)

            }
            R.id.ll_change_pwd -> {
                val i = Intent(this, Employee_Change_Password::class.java)
                startActivity(i)
            }
            R.id.ll_courses -> {
                val i = Intent(this, Employee_Courses::class.java)
                startActivity(i)
            }
            R.id.ll_terms -> {
                Toast.makeText(applicationContext,"Under Development", Toast.LENGTH_SHORT).show()
            }
            R.id.ll_privacy -> {
                Toast.makeText(applicationContext,"Under Development", Toast.LENGTH_SHORT).show()
            }
            R.id.ll_logout -> {
                openLogout()
            }
        }

    }
    private fun openLogout() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Logout")
        builder.setMessage("Are you sure you want to logout?")
        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            val i = Intent(this, Employe_Login::class.java)
            startActivity(i)
            finishAffinity()
        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->

        }
        builder.show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}

