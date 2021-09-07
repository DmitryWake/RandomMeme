package com.ewake.randommeme.presentation.ui.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ewake.randommeme.databinding.ItemMemeBinding
import com.ewake.randommeme.presentation.extensions.picasso.setImage
import com.ewake.randommeme.presentation.model.MemeItemModel
import com.squareup.picasso.Picasso

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class MainPageAdapter : RecyclerView.Adapter<MainPageAdapter.MemeViewHolder>() {

    var items: List<MemeItemModel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder {
        val binding =
            ItemMemeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class MemeViewHolder(private val binding: ItemMemeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MemeItemModel) {
            binding.apply {
                title.text = item.title
                author.text = item.author
                image.setImage(item.url)
            }
        }
    }
}