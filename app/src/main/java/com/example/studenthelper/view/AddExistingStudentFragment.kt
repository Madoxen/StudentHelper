package com.example.studenthelper.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.VM.CourseViewModel
import com.example.studenthelper.view.Adapter.CourseListAdapter

class AddExistingStudentFragment : Fragment() {

    private val viewModel: CourseViewModel by activityViewModels();
    private lateinit var recyclerView: RecyclerView;
    private lateinit var viewAdapter: CourseListAdapter;
    private lateinit var viewManager: LinearLayoutManager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_add_existing_student, container, false);


        return v;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)








    }
}