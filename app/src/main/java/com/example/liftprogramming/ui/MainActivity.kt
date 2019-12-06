package com.example.liftprogramming.ui

import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.liftprogramming.R
import com.example.liftprogramming.adapter.LiftAdapter
import com.example.liftprogramming.model.LiftModel
import com.example.liftprogramming.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BasicActivity() {

    var viewModel: MainActivityViewModel? = null
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]


        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        viewModel?.getLiftList()?.observe(this, Observer<List<LiftModel>>{ lift ->

            val adapter = LiftAdapter(this,lift)

            recyclerView.adapter = adapter



        })
        viewModel?.loadList()




    }
}
