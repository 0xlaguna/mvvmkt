package com.lagunita.recycler1.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lagunita.recycler1.R
import com.lagunita.recycler1.model.Person

class PersonAdapter(private val ctx: Context, private var list: ArrayList<Person>): RecyclerView.Adapter<PersonAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(country: Person) {
            val nameTextView: TextView = itemView.findViewById(R.id.tv_name) as TextView
            val ageTextView: TextView = itemView.findViewById(R.id.tv_age) as TextView
            val aboutTextView: TextView = itemView.findViewById(R.id.tv_aboutMe) as TextView

            nameTextView.text = country.name
            ageTextView.text = country.age.toString()
            aboutTextView.text = country.aboutMe
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val cardViewContainer = LayoutInflater.from(ctx).inflate(R.layout.cardview_layout, parent, false)

        return MyViewHolder(cardViewContainer)
    }

    fun setData(list: ArrayList<Person>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(list[position])
    }
}