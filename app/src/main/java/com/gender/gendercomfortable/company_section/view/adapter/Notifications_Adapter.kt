package com.gender.gendercomfortable.company_section.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gender.gendercomfortable.R
import kotlinx.android.synthetic.main.item_courses.view.*


class Notifications_Adapter(
    val activity: FragmentActivity?
): RecyclerView.Adapter<Notifications_Adapter.MyViewHolderFav>() {
    var image:String?=null
    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderFav {
        return MyViewHolderFav(LayoutInflater.from(activity).inflate(R.layout.items_notification, parent, false))
    }

    override fun getItemCount(): Int {
      return 10

    }



    override fun onBindViewHolder(holder: MyViewHolderFav, position: Int) {



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
