package com.gender.gendercomfortable.employee_section.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.company_section.view.activity.Checkout_Activity
import kotlinx.android.synthetic.main.bottom_sheet_buy.view.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class Bottom_sheet_add_license : BottomSheetDialogFragment(),View.OnClickListener {
    internal var rootView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.bottom_sheet_add_license, container, false)
        initView()
        return rootView;
}

    private fun initView() {
        rootView?.ll_continue?.setOnClickListener(this)


    }

    override fun onClick(v: View?)
    {
        when(v?.id)
        {
            R.id.ll_continue ->
            {
                val i = Intent(activity, Checkout_Activity::class.java)
                startActivity(i)

            }

        }
    }



}