package com.gender.gendercomfortable.employee_section.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.company_section.view.activity.Checkout_Activity
import com.gender.gendercomfortable.company_section.view.activity.Setting_Activity
import com.gender.gendercomfortable.employee_section.view.Employee_Test_Activity
import kotlinx.android.synthetic.main.bottom_sheet_take_test.view.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class Bottom_sheet_take_test : BottomSheetDialogFragment(),View.OnClickListener {
    internal var rootView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.bottom_sheet_take_test, container, false)
        initView()
        return rootView;
}

    private fun initView() {
        rootView?.ll_take_test?.setOnClickListener(this)
        rootView?.go_home?.setOnClickListener(this)


    }

    override fun onClick(v: View?)
    {
        when(v?.id)
        {
            R.id.ll_take_test ->
            {
                val i = Intent(activity, Employee_Test_Activity::class.java)
                startActivity(i)

            }
            R.id.go_home ->
            {
                val i = Intent(activity, Setting_Activity::class.java)
                startActivity(i)
            }

        }
    }



}