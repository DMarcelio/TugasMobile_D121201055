package com.d121201055.taskreminder.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.d121201055.taskreminder.R
import com.d121201055.taskreminder.adapter.TaskAdapter
import com.d121201055.taskreminder.databinding.FragmentHistoryBinding
import com.d121201055.taskreminder.viewmodel.TaskViewModel


class HistoryFragment : Fragment() {
        private var _binding: FragmentHistoryBinding?= null
        private val binding get() = _binding!!

        private lateinit var taskViewModel: TaskViewModel
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            _binding = FragmentHistoryBinding.inflate(inflater,container,false)
            val view = binding.root
            taskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]

            val adapter_task = TaskAdapter()
            binding.recycleTugas.adapter = adapter_task
            binding.recycleTugas.layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL,false)
            taskViewModel.readAllDataHistory.observe(viewLifecycleOwner){task->
                adapter_task.setData(task)
            }


            return view
        }

}