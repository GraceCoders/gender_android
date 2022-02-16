package com.gender.gendercomfortable.employee_section.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.employee_section.fragment.Bottom_sheet_take_test

import com.gender.gendercomfortable.employee_section.fragment.Employee_Lessions_List
import com.gender.gendercomfortable.employee_section.fragment.Employee_More_Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_employee__courses__details.*

class Employee_Courses_Details : AppCompatActivity(),View.OnClickListener {
    internal var rootView: View? = null
    private var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee__courses__details)
        initView()

    }
    private fun initView() {
        ll_take_test.setOnClickListener(this)
        img_back.setOnClickListener(this)
        viewPager = findViewById(R.id.viewPager) as ViewPager
        setupViewPager(viewPager!!)

        tabLayout = findViewById(R.id.tabLayout) as TabLayout
        tabLayout!!.setupWithViewPager(viewPager)
    }
    //..................................setup view pager.............................................//

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Employee_Lessions_List(), "Lessons")
        adapter.addFragment(Employee_More_Fragment(), "More")
        viewPager.adapter = adapter
    }
    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.ll_take_test -> {
                OpenBottomTakeTest()

            }
            R.id.img_back -> {
                onBackPressed()

            }
        }
    }

    private fun OpenBottomTakeTest() {
        val bottomSheet =
            Bottom_sheet_take_test()
        bottomSheet.show(
            supportFragmentManager,
            "ModalBottomSheet"
        )

    }


    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
