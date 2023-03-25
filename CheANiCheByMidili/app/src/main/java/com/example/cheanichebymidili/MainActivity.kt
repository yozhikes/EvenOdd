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
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameComputer,ComputerFragment.newInstance())
            .commit()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameUser,UserFragment.newInstance())
            .commit()
    }
    fun StartClick(view:View){
        if(dataModel.otvForUserFragment.value=="1"){
            schUser++
            bind.schUser.text=schUser.toString()
        }
        if(dataModel.otvForComputerFragment.value=="1"){
            schComp++
            bind.schComp.text=schComp.toString()
        }
    }
    fun ExitClick(view:View){
        finish()
    }
}