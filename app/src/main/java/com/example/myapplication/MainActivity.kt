package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.SuperHeroAdapter
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var llmanager = LinearLayoutManager(this@MainActivity)
    private var heroMutableList: MutableList<SuperHero> =
        SuperHeroProvider.superList.toMutableList()
    private lateinit var adapter: SuperHeroAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        //importar view binding
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAddHero.setOnClickListener { createSuperHero() }
        /*
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        */

        initRecycler()

    }

    private fun createSuperHero() {
        var super2 = SuperHero(
            "devsconocido",
            "??????",
            "unknow",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Anonymous_emblem.svg/320px-Anonymous_emblem.svg.png"
        )
        heroMutableList.add(1,super2)
        adapter.notifyItemInserted(1)
        llmanager.scrollToPositionWithOffset(1,10)
    }

    /*fun initRecycler(){
        val recyclerView = findViewById<RecyclerView>(R.id.rvSuperHero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SuperHeroAdapter(SuperHeroProvider.superList)
    }*/
    fun initRecycler() {
        adapter = SuperHeroAdapter(superHeroList = heroMutableList,
            onClick = { superH -> itemSelected(superH) },
            onDelete = { position -> onDeletedItem(position) })
        //val manager = LinearLayoutManager(this)
        //val decoration = DividerItemDecoration(this,manager.orientation )
        with(binding) {
            rvSuperHero.layoutManager = llmanager
            rvSuperHero.adapter = adapter

            //rvSuperHero.addItemDecoration(decoration)
        }

    }

    fun onDeletedItem(position: Int) {
        heroMutableList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

    fun itemSelected(superHero: SuperHero) {
        Toast.makeText(this, superHero.realName, LENGTH_LONG).show()
    }
}