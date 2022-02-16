package com.gender.gendercomfortable.company_section.view.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.controller.utills.SnackbarUtil
import com.gender.gendercomfortable.employee_section.view.App_Main_Activity
import com.gender.gendercomfortable.employee_section.view.Employe_Login
import kotlinx.android.synthetic.main.activity_welcome_.*

class Welcome_Activity : AppCompatActivity(), View.OnClickListener{
    var mAccount:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_welcome_)
        initView()
    }

    private fun initView() {
        ll_login.setOnClickListener(this)
        ll_started.setOnClickListener(this)
        val mAccountType = resources.getStringArray(R.array.accountType)


        //>>>>>>......................................age range.....................................//

        if (sp_account_type != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,mAccountType
            )
            sp_account_type.adapter = adapter
            sp_account_type.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {

                    (view as TextView).setTextColor(Color.BLACK)
                    if (position == 0) {
                    } else {
                        mAccount=sp_account_type?.selectedItem.toString()
                    }

                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }
        }

    }

    //..........................................click listner..............................................


    override fun onClick(v: View?) {
       when(v?.id)
       {
           R.id.ll_login ->
           {
               if(mAccount!=null)
               {
                   if(mAccount.equals("Company"))
                   {
                       val i = Intent(this, Login_Activity::class.java)
                       startActivity(i)
                   }
                   else{
                       val i = Intent(this, Employe_Login::class.java)
                       startActivity(i)
                   }

               }
               else
               {
                   showSnackBar("Please Select one account type ")
               }

           }
           R.id.ll_started ->
               if(mAccount!=null)
               {
                   if(mAccount.equals("Company"))
                   {
                       val i = Intent(this, Login_Activity::class.java)
                       startActivity(i)
                   }
                   else{
                       val i = Intent(this, Employe_Login::class.java)
                       startActivity(i)
                   }

               }
               else
               {
                   showSnackBar("Please Select one account type ")
               }
       }
    }

    private fun showSnackBar(message: String?) {
        SnackbarUtil.showWarningShortSnackbar(this,message)
    }

    //................................hide keyboard on touch.................................................
    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager =
            activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE
            ) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            activity.currentFocus!!.windowToken, 0
        )
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val view = currentFocus
        val ret = super.dispatchTouchEvent(ev)
        if (view is EditText) {
            val w = currentFocus
            val scrcoords = IntArray(2)
            w!!.getLocationOnScreen(scrcoords)
            val x = ev.rawX + w.left - scrcoords[0]
            val y = ev.rawY + w.top - scrcoords[1]
            if (ev.action == MotionEvent.ACTION_UP
                && (x < w.left || x >= w.right || y < w.top || y > w.bottom)
            ) {
                hideSoftKeyboard(this)
            }
        }
        return ret
    }



}
