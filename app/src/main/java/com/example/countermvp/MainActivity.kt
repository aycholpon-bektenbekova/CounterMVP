package com.example.countermvp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.countermvp.databinding.ActivityMainBinding
import com.example.countermvp.presenter.CounterPresenter
import com.example.countermvp.view.CounterView

class MainActivity : AppCompatActivity(), CounterView{

    private lateinit var binding: ActivityMainBinding
    var presenter = CounterPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClicker()
    }

    private fun initClicker() {
        with(binding){
            incrementBtn.setOnClickListener {
                presenter.increment()
                presenter.numberView()
            }
            decrementBtn.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun changeCount(count:Int) {
        binding.counterTv.text = count.toString()
    }

    override fun toast() {
        Toast.makeText(this,"Congratulations", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("ResourceAsColor")
    override fun changeColor() {
       binding.counterTv.setTextColor(R.color.green)
    }
}