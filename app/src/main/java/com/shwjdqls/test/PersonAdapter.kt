package com.shwjdqls.test

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.shwjdqls.test.databinding.ItemPersonBinding

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    private val items = arrayListOf<Person>()
    private val totalItems = arrayListOf<Person>()
    private var isShrunk = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PersonViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_person, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(items: List<Person>) {
        totalItems.addAll(items)
        var showedItems = items
        if (isShrunk && items.size > 6) {
            showedItems = items.subList(0, 6)
        }
        Log.d("asdf", showedItems.toString())
        this.items.addAll(showedItems)
        notifyDataSetChanged()
    }

    fun resize(): Boolean {
        return if (isShrunk) {
            items.clear()
            items.addAll(totalItems)
            notifyDataSetChanged()
            isShrunk = false
            false
        } else {
            items.clear()
            items.addAll(totalItems.subList(0, 6))
            notifyDataSetChanged()
            isShrunk = true
            true
        }
    }

    inner class PersonViewHolder(private val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Person) {
            binding.apply {
                this.item = item
                this.itemImage.setImageResource(item.face)
                if (adapterPosition == RecyclerView.NO_POSITION) {
                    return@apply
                }
            }
        }
    }
}