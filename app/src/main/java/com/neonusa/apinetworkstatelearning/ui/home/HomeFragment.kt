package com.neonusa.apinetworkstatelearning.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.neonusa.apinetworkstatelearning.R
import com.neonusa.apinetworkstatelearning.adapter.VideoAdapter
import com.neonusa.apinetworkstatelearning.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel.getChannelVideoList()
//        initRecyclerView()

        viewModel.channelVideoList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            binding.rvHome.layoutManager = LinearLayoutManager(context)
            val adapter = VideoAdapter(it)
            binding.rvHome.adapter = adapter

            Log.i("data", "onCreateView: $it")
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView(){

    }
//
//    private fun initRecyclerView() = activity?.let{
//        binding.rvHome.layoutManager = LinearLayoutManager(it)
//        binding.rvHome.adapter = adapter
//
//
//    }
}