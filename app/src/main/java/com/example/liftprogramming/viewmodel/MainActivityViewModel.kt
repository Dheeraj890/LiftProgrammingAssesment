package com.example.liftprogramming.viewmodel

import androidx.lifecycle.ViewModel
import com.example.liftprogramming.repository.MainActivityRepository
import androidx.lifecycle.MutableLiveData
import com.example.liftprogramming.model.LiftModel
import androidx.lifecycle.LiveData




class MainActivityViewModel : ViewModel() {

var repository:MainActivityRepository?=null

    private var lift: MutableLiveData<List<LiftModel>>? = null
    
    init {

        repository=MainActivityRepository.getInstance()
    }


    fun getLiftList(): LiveData<List<LiftModel>> {
        if (lift == null) {
            lift = MutableLiveData<List<LiftModel>>()

        }
        return lift as MutableLiveData<List<LiftModel>>


    }


    fun loadList(){


       lift?.value= repository?.loadListLift()


    }

}