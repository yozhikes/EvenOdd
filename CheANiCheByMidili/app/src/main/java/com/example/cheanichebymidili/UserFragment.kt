package com.example.cheanichebymidili

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.cheanichebymidili.databinding.FragmentComputerBinding
import com.example.cheanichebymidili.databinding.FragmentUserBinding
import kotlin.random.Random

class UserFragment : Fragment() {
    lateinit var bind:FragmentUserBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind= FragmentUserBinding.inflate(inflater)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bind.firstTxt.text= Random.nextInt(1,7).toString()
        bind.secondTxt.text= Random.nextInt(1,7).toString()
        bind.thirdTxt.text= Random.nextInt(1,7).toString()
        bind.SumTxt.text=(bind.firstTxt.text.toString().toInt()+
                bind.secondTxt.text.toString().toInt()+
                bind.thirdTxt.text.toString().toInt()).toString()
        val selectedId=bind.UserPick.checkedRadioButtonId
        if (selectedId!=null){
            when(selectedId){
                bind.radioButton1.id->if (bind.SumTxt.text.toString().toInt()%2==0){
                    activity.findViewById(R.id.schUser).value="1"
                }
                else{
                    dataModel.otvForUserFragment.value="0"
                }
                bind.radioButton2.id->if (bind.SumTxt.text.toString().toInt()%2!=0){
                    dataModel.otvForUserFragment.value="1"
                }
                else{
                    dataModel.otvForUserFragment.value="0"
                }
            }
        }
        else{
            dataModel.otvForUserFragment.value=null
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = UserFragment()
    }
}