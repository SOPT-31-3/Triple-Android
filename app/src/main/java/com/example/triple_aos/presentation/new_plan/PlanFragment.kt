package com.example.triple_aos.presentation.new_plan

import android.os.Bundle
import android.view.View
import com.example.triple_aos.R
import com.example.triple_aos.base.BindingFragment
import com.example.triple_aos.data.dto.NewPlanData
import com.example.triple_aos.databinding.FragmentPlanBinding

class PlanFragment : BindingFragment<FragmentPlanBinding>(R.layout.fragment_plan) {

    private lateinit var firstAdapter: FirstPlanAdapter
    private lateinit var secondAdapter: SecondPlanAdapter
    private lateinit var thirdAdapter: ThirdPlanAdapter

    private var firstPlanList: MutableList<NewPlanData> = mutableListOf()
    private var secondPlanList: MutableList<NewPlanData> = mutableListOf()
    private var thirdPlanList: MutableList<NewPlanData> = mutableListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initRecyclerView()
    }

    private fun initListener() {
        binding.btnPlanPlus.setOnClickListener {
            binding.layoutPlanInsert.visibility = View.GONE
            binding.layoutPlans.visibility = View.VISIBLE
        }
        binding.btnFirstPlan.setOnClickListener {
            if (binding.dvFirst.visibility == View.INVISIBLE) {//펼쳐진 상태
                binding.rvFirstPlan.visibility = View.GONE
                binding.btnAddFirstPlan.visibility = View.GONE
                binding.dvFirst.visibility = View.VISIBLE
                binding.btnFirstPlan.setImageResource(R.drawable.ic_folder_close)
            } else {
                binding.rvFirstPlan.visibility = View.VISIBLE
                binding.btnAddFirstPlan.visibility = View.VISIBLE
                binding.dvFirst.visibility = View.INVISIBLE
                binding.btnFirstPlan.setImageResource(R.drawable.ic_folder_open)
            }
        }
        binding.btnSecondPlan.setOnClickListener {
            if (binding.dvSecond.visibility == View.INVISIBLE) {
                binding.rvSecondPlan.visibility = View.GONE
                binding.btnAddSecondPlan.visibility = View.GONE
                binding.dvSecond.visibility = View.VISIBLE
                binding.btnSecondPlan.setImageResource(R.drawable.ic_folder_close)
            } else {
                binding.rvSecondPlan.visibility = View.VISIBLE
                binding.btnAddSecondPlan.visibility = View.VISIBLE
                binding.dvSecond.visibility = View.INVISIBLE
                binding.btnSecondPlan.setImageResource(R.drawable.ic_folder_open)
            }
        }
        binding.btnThirdPlan.setOnClickListener {
            if (binding.dvThird.visibility == View.INVISIBLE) {//펼쳐진 상태
                binding.rvThirdPlan.visibility = View.GONE
                binding.btnAddThirdPlan.visibility = View.GONE
                binding.dvThird.visibility = View.VISIBLE
                binding.btnThirdPlan.setImageResource(R.drawable.ic_folder_close)
            } else {//안 펼쳐진 상태
                binding.rvThirdPlan.visibility = View.VISIBLE
                binding.btnAddThirdPlan.visibility = View.VISIBLE
                binding.dvThird.visibility = View.INVISIBLE
                binding.btnThirdPlan.setImageResource(R.drawable.ic_folder_open)
            }
        }
        binding.btnAddFirstPlan.setOnClickListener {
            firstPlanList.add(NewPlanData())
            firstAdapter.setItems(firstPlanList)
        }
        binding.btnAddSecondPlan.setOnClickListener {
            secondPlanList.add(NewPlanData())
            secondAdapter.setItems(secondPlanList)
        }
        binding.btnAddThirdPlan.setOnClickListener {
            thirdPlanList.add(NewPlanData())
            thirdAdapter.setItems(thirdPlanList)
        }

    }

    private fun initRecyclerView() {
        firstAdapter = FirstPlanAdapter()
        secondAdapter = SecondPlanAdapter()
        thirdAdapter = ThirdPlanAdapter()
        binding.rvFirstPlan.adapter = firstAdapter
        binding.rvSecondPlan.adapter = secondAdapter
        binding.rvThirdPlan.adapter = thirdAdapter
    }
}