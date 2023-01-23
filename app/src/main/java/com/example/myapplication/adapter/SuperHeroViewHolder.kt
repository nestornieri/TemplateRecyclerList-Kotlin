package com.example.myapplication.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.myapplication.SuperHero
import com.example.myapplication.databinding.ItemSuperheroBinding

class SuperHeroViewHolder (view:View):ViewHolder(view){
    val binding = ItemSuperheroBinding.bind(view)
    /*
    val ivSuperHero = view.findViewById<ImageView>(R.id.ivSuperHero)
    val tvSuperHeroName = view.findViewById<TextView>(R.id.tvSuperHeroName)
    val tvRealName = view.findViewById<TextView>(R.id.tvRealName)
    val tvPublisher = view.findViewById<TextView>(R.id.tvPublisher)
     */
    fun render(superHeroModel: SuperHero, onClick: (SuperHero) -> Unit, onDelete: (Int) -> Unit){
        with(binding){
            tvSuperHeroName.text = superHeroModel.superhero
            tvRealName.text = superHeroModel.realName
            tvPublisher.text = superHeroModel.publisher

            Glide.with(ivSuperHero.context).load(superHeroModel.photo).into(ivSuperHero)

            /*ivSuperHero.setOnClickListener{Toast.makeText(ivSuperHero.context, "Hola",LENGTH_LONG)
                .show()}*/
            itemView.setOnClickListener { onClick(superHeroModel)}
            btnBorrar.setOnClickListener { onDelete(adapterPosition) }
        }

    }
}