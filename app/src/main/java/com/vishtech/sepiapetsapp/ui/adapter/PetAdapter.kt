package com.vishtech.sepiapetsapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.vishtech.sepiapetsapp.R
import com.vishtech.sepiapetsapp.model.Pet
import com.vishtech.sepiapetsapp.ui.activities.OnClickHandler

class PetAdapter(private val onClickHandler: OnClickHandler): RecyclerView.Adapter<PetAdapter.PetViewHolder>() {

    var petList: List<Pet> = emptyList()

    class PetViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ivPetIcon: ImageView = view.findViewById(R.id.ivPetIcon)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pet_item, parent, false)
        return PetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.tvTitle.text = petList[position].title
        holder.itemView.setOnClickListener {
            onClickHandler.onClick(petList[position].contentUrl)
        }
        Glide
            .with(holder.itemView.context)
            .load(petList[position].imageUrl)
            .placeholder(R.drawable.placeholder)
            .into(holder.ivPetIcon)

    }

    override fun getItemCount() = petList.size
}