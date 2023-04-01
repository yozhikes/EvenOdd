package com.example.cheanichebymidili

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import com.example.cheanichebymidili.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var schUser=0
    var schComp=0
    private val dataModel: DataModel by viewModels()
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.startBtn.isEnabled=false
        dataModel.startCheck.value=false
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameComputer,ComputerFragment.newInstance())
            .commit()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameUser,UserFragment.newInstance())
            .commit()
        dataModel.otvForUserFragment.observe(this,{
            bind.startBtn.isEnabled=it
        })
    }
    fun StartClick(view:View){
        if(bind.startBtn.text == "Start") {
            dataModel.startCheck.value = true
            bind.startBtn.text = "Next"
        }
        else{
            dataModel.startCheck.value = false
            bind.startBtn.text = "Start"
        }
    }
    fun ExitClick(view:View){
        finish()
    }
}