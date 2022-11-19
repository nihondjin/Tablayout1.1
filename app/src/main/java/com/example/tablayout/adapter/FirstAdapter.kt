package com.example.tablayout.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tablayout.databinding.ItemFirsBinding
import com.example.tablayout.model.CharacterModel
import com.example.tablayout.ontemclick.OnItemClickListener

class FirstAdapter(onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<FirstAdapter.ChacaterViewHolder>(), View.OnClickListener {

    private var list: MutableList<CharacterModel>? = null
    private val onItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChacaterViewHolder {
        return ChacaterViewHolder(
        ItemFirsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ChacaterViewHolder, position: Int) {
        holder.itemView.setOnClickListener(this)
        holder.onBind(list!![position])

    }
    // method for filtering our recyclerview items.
    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filterlist: ArrayList<CharacterModel>) {

        list = filterlist

        notifyDataSetChanged()
    }
    class ChacaterViewHolder(private val binding: ItemFirsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(characterModel: CharacterModel) {
            Glide.with(binding.imageView.context).load(characterModel.imageUrl).into(binding.imageView)
            binding.textView.text = characterModel.name
            binding.tvAge.text = characterModel.age.toString()
            itemView.tag = characterModel


        }

    }
    init {
        this.onItemClickListener = onItemClickListener
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onClick(view: View?) {
        onItemClickListener.onClick(view?.tag as CharacterModel)

    }

    fun setData(listKorowa: MutableList<CharacterModel>?) {
        this.list = listKorowa
        notifyDataSetChanged()
    }


//    ________________________
//        <HELLO WORLD>
//    ------------------------
//    ------------------------  ^___^                        Это Радин
//                              (o o)\___________\
//                             (____) \            )\/\/\
//                                W   | |______W  |
//                                    | |       | |
//                                    | |       | |

}