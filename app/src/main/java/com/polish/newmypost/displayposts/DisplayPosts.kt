package com.polish.newmypost.displayposts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.polish.newmypost.R
import com.polish.newmypost.adapter.POSTAdapter
import com.polish.newmypost.databinding.FragmentDisplayPostsBinding

/**
 * A simple [Fragment] subclass.
 */
class DisplayPosts : Fragment() {

    lateinit var viewModel:DisplayPostViewModel
    lateinit var adapter:POSTAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_display_posts, container, false)

        val binding = FragmentDisplayPostsBinding.inflate(inflater)

        binding.setLifecycleOwner(this)



        viewModel = ViewModelProvider(this).get(DisplayPostViewModel::class.java)

        binding.displayPostViewModel = viewModel

        binding.viewButtonId.setOnClickListener {
            viewModel.viewMyPostHere()
        }

        // connect the recyclerview
        val recyclerview:RecyclerView = binding.myRecyclerViewId
        recyclerview.layoutManager = LinearLayoutManager(context)

        adapter = POSTAdapter(
            POSTAdapter.OnClickListener {
                Toast.makeText(context, "$it", Toast.LENGTH_LONG).show()
            }
        )
        recyclerview.adapter = adapter

        viewModel.myListOfPOST.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })


       return binding.root

    }

}
