package com.example.liftprogramming.repository

import androidx.lifecycle.LiveData
import com.example.liftprogramming.model.LiftModel

class MainActivityRepository {



    private constructor()
    companion object{

        private var _instance: MainActivityRepository? = null

        fun getInstance(): MainActivityRepository? {
            if (_instance == null) {
                _instance = MainActivityRepository()
            }
            return _instance
        }

    }


    fun loadListLift(): List<LiftModel> {


        val list= listOf<LiftModel>(LiftModel(6,"6","6"),LiftModel(5,"5","5")

        ,LiftModel(4,"4","4"),LiftModel(3,"3","3"),LiftModel(2,"2","2")


        ,LiftModel(1,"1","1"))


        return list

    }


}