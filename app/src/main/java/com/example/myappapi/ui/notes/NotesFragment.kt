package com.example.myappapi.ui.notes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappapi.R
import com.example.myappapi.databinding.FragmentNotesBinding
import com.example.myappapi.domain.TaskModel

class NotesFragment : Fragment() {

    private var binding: FragmentNotesBinding? = null
    private val taskAdapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }


    private fun initViews() {
        binding?.rvTasks?.layoutManager = LinearLayoutManager(requireContext())
        binding?.rvTasks?.adapter = taskAdapter
    }

    private fun initListeners() {
        binding?.btnFab?.setOnClickListener {
            findNavController().navigate(R.id.createNoteFragment)
        }


        setFragmentResultListener(
            CreateNoteFragment.CREATE_TASK_KEY
        ) { _: String, bundle: Bundle ->

            val taskModel = bundle.getSerializable(CreateNoteFragment.TASK_KEY) as TaskModel
            taskAdapter.add(taskModel)
            Log.d("task : ", taskModel.toString())
        }
    }

}