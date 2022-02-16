package com.gender.gendercomfortable.company_section.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gender.gendercomfortable.R
import com.gender.gendercomfortable.company_section.view.fragment.Bottom_sheet_addCard
import kotlinx.android.synthetic.main.activity_add_card__list.*

class AddCard_List : AppCompatActivity(),View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card__list)
        initView()
    }

    private fun initView() {
        fab.setOnClickListener(this)
        img_back.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when(v?.id )
       {
           R.id.fab ->
           {
               val bottomSheet =
                   Bottom_sheet_addCard()
               bottomSheet.show(
                   supportFragmentManager,
                   "ModalBottomSheet"
               )

           }

           R.id.img_back ->
           {
               onBackPressed()
           }


       }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
