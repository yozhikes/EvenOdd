package com.example.cheanichebymidili

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.cheanichebymidili.databinding.FragmentComputerBinding
import com.example.cheanichebymidili.databinding.FragmentUserBinding
import kotlin.random.Random

class UserFragment : Fragment() {
    lateinit var bind:FragmentUserBinding
    private val dataModel: DataModel by activityViewModels()
    var pickedValue=0
    var count=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind= FragmentUserBinding.inflate(inflater)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bind.chetUser.setOnClickListener{
            dataModel.otvForUserFragment.value = true
            pickedValue = 1
        }
        bind.nechetUser.setOnClickListener{
            dataModel.otvForUserFragment.value = true
            pickedValue = 2
        }
        dataModel.startCheck.observe(activity as LifecycleOwner){
            if(it==true){
                bind.firstTxt.text= Random.nextInt(1,7).toString()
                bind.secondTxt.text= Random.nextInt(1,7).toString()
                bind.thirdTxt.text= Random.nextInt(1,7).toString()
                bind.SumTxt.text=(bind.firstTxt.text.toString().toInt()+
                        bind.secondTxt.text.toString().toInt()+
                        bind.thirdTxt.text.toString().toInt()).toString()
                    if (bind.SumTxt.text.toString().toInt()%2==0 && pickedValue==1){
                        count=1
                        bind.pickUser.setImageResource(R.drawable.galka)
                    }
                    else if (bind.SumTxt.text.toString().toInt()%2!=0 && pickedValue==2){
                        count=1
                        bind.pickUser.setImageResource(R.drawable.galka)
                    }
                    else{
                        count=0
                        bind.pickUser.setImageResource(R.drawable.krest)
                    }
                    bind.schUser.text=(bind.schUser.text.toString().toInt()+count).toString()
                }
                else{
                    bind.firstTxt.text = "0"
                    bind.secondTxt.text = "0"
                    bind.thirdTxt.text = "0"
                    bind.SumTxt.text = "0"
                    bind.pickUser.setImageResource(0)
                }
            }
        }

    companion object {
        @JvmStatic
        fun newInstance() = UserFragment()
    }
}