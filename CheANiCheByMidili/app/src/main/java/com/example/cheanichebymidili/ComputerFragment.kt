package com.example.cheanichebymidili

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.cheanichebymidili.databinding.FragmentComputerBinding
import kotlin.random.Random


class ComputerFragment : Fragment() {
    lateinit var bind:FragmentComputerBinding
    private val dataModel: DataModel by activityViewModels()
    var countComp=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind= FragmentComputerBinding.inflate(inflater)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.startCheck.observe(activity as LifecycleOwner) {
            if (it == true) {
                bind.first2Txt.text = Random.nextInt(1, 7).toString()
                bind.second2Txt.text = Random.nextInt(1, 7).toString()
                bind.third2Txt.text = Random.nextInt(1, 7).toString()
                bind.Sum2Txt.text = (bind.first2Txt.text.toString().toInt() +
                        bind.second2Txt.text.toString().toInt() +
                        bind.third2Txt.text.toString().toInt()).toString()
                when ((1..2).random()) {
                    1 -> {
                        bind.chetComputer.isEnabled=true
                        bind.chetComputer.isChecked = true
                        bind.chetComputer.isEnabled=false
                        if (bind.Sum2Txt.text.toString().toInt() % 2 == 0) {
                            countComp = 1
                            bind.pickComp.setImageResource(R.drawable.galka)
                        }
                        else {
                            countComp = 0
                            bind.pickComp.setImageResource(R.drawable.krest)
                        }
                    }
                    2 -> {
                        bind.nechetComputer.isEnabled=true
                        bind.nechetComputer.isChecked = true
                        bind.nechetComputer.isEnabled=false
                        if (bind.Sum2Txt.text.toString().toInt() % 2 != 0) {
                            countComp = 1
                            bind.pickComp.setImageResource(R.drawable.galka)
                        }
                        else {
                            countComp = 0
                            bind.pickComp.setImageResource(R.drawable.krest)
                        }
                    }
                }
                bind.schComp2.text=(bind.schComp2.text.toString().toInt()+countComp).toString()
            }
            else {
                bind.first2Txt.text = "0"
                bind.second2Txt.text = "0"
                bind.third2Txt.text = "0"
                bind.Sum2Txt.text = "0"
                bind.pickComp.setImageResource(0)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ComputerFragment()
    }
}