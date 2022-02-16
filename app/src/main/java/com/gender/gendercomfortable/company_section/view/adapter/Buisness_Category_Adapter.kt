package com.gender.gendercomfortable.company_section.view.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.gender.gendercomfortable.R
import kotlinx.android.synthetic.main.activity_business__category_.view.*
import kotlinx.android.synthetic.main.item_categories.view.*


class Buisness_Category_Adapter(
    val activity: FragmentActivity?
): RecyclerView.Adapter<Buisness_Category_Adapter.MyViewHolderFav>() {
    var image:String?=null
    private var selectedItemPosition: Int = 0
    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderFav {
        return MyViewHolderFav(
            LayoutInflater.from(activity).inflate(
                R.layout.item_categories,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
      return 10

    }



    override fun onBindViewHolder(holder: MyViewHolderFav, position: Int) {
        holder.itemView.setOnClickListener(View.OnClickListener {
            holder.itemView.ll_layout.setBackgroundResource(R.drawable.boarder_orange)
        })






    }


    inner class MyViewHolderFav(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        override fun onClick(v: View) {
            onItemClick?.invoke(adapterPosition, v)
        }

        init {
            itemView.setOnClickListener(this)
        }
    }
}
