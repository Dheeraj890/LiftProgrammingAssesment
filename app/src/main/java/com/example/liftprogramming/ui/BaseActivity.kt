package com.example.liftprogramming.ui

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.liftprogramming.R


open class BaseActivity(var resId:Int) : AppCompatActivity() {


constructor() : this(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(resId)




        }
    }


