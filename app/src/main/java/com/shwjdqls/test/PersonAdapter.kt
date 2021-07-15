package com.shwjdqls.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.shwjdqls.test.databinding.ItemPersonBinding

class PersonAdapter(private val items: ArrayList<Person>) : RecyclerView.Adapter<PersonAdapter.CouponViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CouponViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_person, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CouponViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(items: List<Person>) {
        this.items.run {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    inner class CouponViewHolder(private val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Person) {
            binding.apply {
                this.item = item
                if (adapterPosition == RecyclerView.NO_POSITION) {
                    return@apply
                }
            }
        }
    }
}