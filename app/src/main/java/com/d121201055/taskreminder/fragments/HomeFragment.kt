package com.d121201055.taskreminder.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.d121201055.taskreminder.adapter.TaskAdapter
import com.d121201055.taskreminder.databinding.FragmentHomeBinding
import com.d121201055.taskreminder.viewmodel.TaskViewModel


class HomeFragment : Fragment() {
   private var _binding:FragmentHomeBinding ?= null
   private val binding get() = _binding!!
   private lateinit var taskViewModel: TaskViewModel

   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      _binding = FragmentHomeBinding.inflate(inflater,container,false)
      val view = binding.root

      val adapter_task = TaskAdapter()
      binding.recycleTugas.adapter = adapter_task
      binding.recycleTugas.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
      taskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]
      taskViewModel.readAllData.observe(viewLifecycleOwner){task->
         adapter_task.setData(task)
      }


      return view
   }
}