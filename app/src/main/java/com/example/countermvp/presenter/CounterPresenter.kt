package com.example.countermvp.presenter

import android.widget.Toast
import com.example.countermvp.model.CounterModel
import com.example.countermvp.view.CounterView

class CounterPresenter {
    private val model = CounterModel()
    lateinit var view : CounterView

    fun increment(){
        model.increment()
        view.changeCount(model.count)
    }
    fun decrement(){
        model.decrement()
        view.changeCount(model.count)
    }

    fun attachView(view: CounterView){
        this.view = view
    }

    fun numberView(){
        if (model.count == 10){
            view.toast()
        }
        if (model.count == 15){
            view.changeColor()
        }
    }
}