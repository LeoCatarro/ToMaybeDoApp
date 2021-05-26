package com.example.tomaybedoapp.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tomaybedoapp.R
import kotlinx.android.synthetic.main.fragment_list_notes.view.*


class ListNotesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list_notes, container, false)

        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listNotes_to_addNotes)
        }

        return view
    }
}