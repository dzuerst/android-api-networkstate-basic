package com.neonusa.apinetworkstatelearning.ui.home

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
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
import kotlinx.coroutines.delay

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

        if (requireContext().isInternetAvailable()) {
            viewModel.getChannelVideoList()
            viewModel.channelVideoList.observe(viewLifecycleOwner) {
                binding.rvHome.layoutManager = LinearLayoutManager(context)

                val adapter = VideoAdapter(it)
                binding.rvHome.adapter = adapter

//            Log.i("data", "$it")
                Log.i("HomeFragment", "hello from HomeFragment")
            }
        } else {
//            showErrorState()
        }

//        viewModel.getChannelVideoList()
//        viewModel.channelVideoList.observe(viewLifecycleOwner) {
//            binding.rvHome.layoutManager = LinearLayoutManager(context)
//
//            val adapter = VideoAdapter(it)
//            binding.rvHome.adapter = adapter
//
////            Log.i("data", "$it")
//            Log.i("HomeFragment", "hello from HomeFragment")
//        }

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

    fun Context.isInternetAvailable(): Boolean {
        var result = false

        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cm.run {
                cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                    result = when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                }
            }
        } else {
            cm.run {
                cm.activeNetworkInfo?.run {
                    if (type == ConnectivityManager.TYPE_WIFI) {
                        result = true
                    } else if (type == ConnectivityManager.TYPE_MOBILE) {
                        result = true
                    }
                }
            }
        }

        return result
    }
}


