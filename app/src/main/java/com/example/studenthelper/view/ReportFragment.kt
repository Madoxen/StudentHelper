package com.example.studenthelper.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.VM.ReportViewModel
import com.example.studenthelper.view.Adapter.MarkListAdapter

class ReportFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var viewAdapter: MarkListAdapter
    private val viewModel: ReportViewModel by viewModels();
    private lateinit var recyclerView: RecyclerView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_report, container, false)
        recyclerView = v.findViewById(R.id.report_recyclerView)
        return v
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val linearLayoutManager = LinearLayoutManager(this.context)
        navController = view.findNavController()
        viewAdapter = MarkListAdapter(
            viewModel.todaysMarks
        )

        recyclerView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            // use a linear layout manager
            layoutManager = linearLayoutManager
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

        viewModel.todaysMarks.observe(viewLifecycleOwner) {
            viewAdapter.notifyDataSetChanged()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ReportFragment()
    }
}