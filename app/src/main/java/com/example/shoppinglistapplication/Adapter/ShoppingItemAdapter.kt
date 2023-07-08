package com.example.shoppinglistapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapplication.R
import com.example.shoppinglistapplication.data.ShoppingItem
import com.example.shoppinglistapplication.viewmodel.ShoppingViewModel

class ShoppingItemAdapter(private val viewModel: ShoppingViewModel) :
    RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    var item:List<ShoppingItem> = ArrayList()

    class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.title)
        val amount: TextView = itemView.findViewById(R.id.tv_amount)
        val add: ImageView = itemView.findViewById(R.id.img_add)
        val sub: ImageView = itemView.findViewById(R.id.img_sub)
        val delete: ImageView = itemView.findViewById(R.id.img_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentItem = item[position]
        holder.name.text = currentItem.name
        holder.amount.text = currentItem.amount.toString()
        holder.delete.setOnClickListener {
            viewModel.delete(currentItem)
        }
        holder.add.setOnClickListener {
            currentItem.amount++
            viewModel.update(currentItem)
        }
        holder.sub.setOnClickListener {
            if (currentItem.amount > 0) {
                currentItem.amount--
                viewModel.update(currentItem)
            }
        }
    }
}