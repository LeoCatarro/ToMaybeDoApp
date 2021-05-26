package com.example.tomaybedoapp.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tomaybedoapp.R
import com.example.tomaybedoapp.viewmodels.NoteViewModel
import kotlinx.android.synthetic.main.fragment_list_notes.view.*


class ListNotesFragment : Fragment() {

    private lateinit var mNoteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list_notes, container, false)

        //Recycler View
        val adapter = ListNoteAdapter()
        val recyclerView = view.recyclerNotesView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        //NoteViewModel
        mNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        mNoteViewModel.listAllNotes.observe(viewLifecycleOwner, Observer{ note ->
            adapter.setData(note)
        })

        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listNotes_to_addNotes)
        }

        return view
    }
}