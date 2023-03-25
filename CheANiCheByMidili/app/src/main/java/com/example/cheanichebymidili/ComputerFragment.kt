package com.example.cheanichebymidili

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.activityViewModels
import com.example.cheanichebymidili.databinding.FragmentComputerBinding
import kotlin.random.Random


class ComputerFragment : Fragment() {
    lateinit var bind:FragmentComputerBinding
    private val dataModel: DataModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind= FragmentComputerBinding.inflate(inflater)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bind.first2Txt.text=Random.nextInt(1,7).toString()
        bind.second2Txt.text=Random.nextInt(1,7).toString()
        bind.third2Txt.text=Random.nextInt(1,7).toString()
        bind.Sum2Txt.text=(bind.first2Txt.text.toString().toInt()+
                bind.second2Txt.text.toString().toInt()+
                bind.third2Txt.text.toString().toInt()).toString()
        when(Random.nextInt(1,3)){
            1->{
                dataModel.otvForComputerFragment.value=bind.radioButton1.text.toString()
                bind.radioButton1.isChecked=true
                bind.radioButton2.isChecked=false
                if (bind.Sum2Txt.text.toString().toInt()%2==0){
                    dataModel.otvForComputerFragment.value="1"
                }
                else{
                    dataModel.otvForComputerFragment.value="0"
                }
            }

            2->{
                dataModel.otvForComputerFragment.value=bind.radioButton2.text.toString()
                bind.radioButton2.isChecked=true
                bind.radioButton1.isChecked=false
                if (bind.Sum2Txt.text.toString().toInt()%2!=0){
                    dataModel.otvForComputerFragment.value="1"
                }
                else{
                    dataModel.otvForComputerFragment.value="0"
                }
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ComputerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = ComputerFragment()
    }
}