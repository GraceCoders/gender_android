package com.gender.gendercomfortable.company_section.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.company_section.view.adapter.Courses_Details_Adapter
import com.gender.gendercomfortable.company_section.view.adapter.Purchased_Users_Adapter
import kotlinx.android.synthetic.main.fragment_stats.view.*


class Courses_Stats_Fragment : Fragment() {
    internal var rootView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_stats, container, false)
        initView()
        return rootView;


    }



    private fun initView() {

        rootView?.rv_redeemed_list?.layoutManager= LinearLayoutManager(activity,
            LinearLayoutManager.VERTICAL ,false)
        rootView?.rv_redeemed_list?.adapter= Purchased_Users_Adapter(activity)


    }
}