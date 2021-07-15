package com.shwjdqls.test

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.shwjdqls.test.databinding.ItemPersonBinding

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    private val items = arrayListOf<Person>()
    private val totalItems = arrayListOf<Person>()
    private var isShrunk = true
    private var isDeleteMode = false

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

    fun setDeleteMode() {
        isDeleteMode = true
    }

    inner class PersonViewHolder(private val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Person) {
            binding.apply {
                this.item = item
                this.itemImage.setBackgroundResource(item.face)
                if (adapterPosition == RecyclerView.NO_POSITION) {
                    return@apply
                }
                if (isDeleteMode) {
                    itemView.setOnClickListener {
                        it.findViewById<ImageView>(R.id.whole_view).setBackgroundColor(ContextCompat.getColor(it.context, R.color.design_default_color_error))
                    }
                }
            }
        }
    }
}