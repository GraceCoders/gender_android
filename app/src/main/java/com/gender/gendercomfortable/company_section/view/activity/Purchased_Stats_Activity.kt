package com.gender.gendercomfortable.company_section.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.company_section.view.fragment.Bottom_sheet_buy
import com.gender.gendercomfortable.company_section.view.fragment.Courses_Details_Fragments
import com.gender.gendercomfortable.company_section.view.fragment.Courses_Stats_Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_purchased__stats_.*

class Purchased_Stats_Activity : AppCompatActivity(),View.OnClickListener {
    internal var rootView: View? = null
    private var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchased__stats_)
        initView()
    }

    private fun initView() {
        ll_buy.setOnClickListener(this)
        img_back.setOnClickListener(this)
        viewPager = findViewById(R.id.viewPager) as ViewPager
        setupViewPager(viewPager!!)

        tabLayout = findViewById(R.id.tabLayout) as TabLayout
        tabLayout!!.setupWithViewPager(viewPager)
    }
    //..................................setup view pager.............................................//

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Courses_Details_Fragments(), "Courses Details")
        adapter.addFragment(Courses_Stats_Fragment(), "Courses Stats")
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
            R.id.ll_buy -> {
                OpenBottomSheetPayment()

            }
            R.id.img_back -> {
                onBackPressed()

            }
        }
    }

    private fun OpenBottomSheetPayment() {
        val bottomSheet =
            Bottom_sheet_buy()
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
