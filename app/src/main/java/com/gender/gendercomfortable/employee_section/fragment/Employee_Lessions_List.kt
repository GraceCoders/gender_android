package com.gender.gendercomfortable.employee_section.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.company_section.view.adapter.Courses_Details_Adapter
import com.gender.gendercomfortable.company_section.view.fragment.Bottom_sheet_buy
import kotlinx.android.synthetic.main.fragments_courses_details.view.*

class Employee_Lessions_List : Fragment()  {
    internal var rootView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_lession_list, container, false)
        initView()
        return rootView;
        initView()


    }

    private fun initView() {

        rootView?.rv_lession_list?.layoutManager= LinearLayoutManager(activity,
            LinearLayoutManager.VERTICAL ,false)
        rootView?.rv_lession_list?.adapter= Courses_Details_Adapter(activity)
        }




}
