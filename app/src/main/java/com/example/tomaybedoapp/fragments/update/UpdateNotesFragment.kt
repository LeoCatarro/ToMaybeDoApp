package com.example.tomaybedoapp.fragments.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tomaybedoapp.R
import com.example.tomaybedoapp.models.Note
import com.example.tomaybedoapp.viewmodels.NoteViewModel
import kotlinx.android.synthetic.main.fragment_update_notes.*
import kotlinx.android.synthetic.main.fragment_update_notes.view.*

class UpdateNotesFragment : Fragment() {

    //Used safe args to when user clicks in a note will be redirected to the update fragment with all fields filled ready to be updated and safe the current note ID,
    // to update the correct one
    private val args by navArgs<UpdateNotesFragmentArgs>()
    private lateinit var mNoteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_update_notes, container, false)

        mNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        view.updateNotesTitle_et.setText(args.currentNote.title)
        view.updateNotesDescription_et.setText(args.currentNote.description)

        view.updateNoteButton.setOnClickListener {
            updateNote()
        }

        return view
    }

    private fun updateNote(){
        val title = updateNotesTitle_et.text.toString()
        val description = updateNotesDescription_et.text.toString()

        if(checkInput(title, description))
        {
            //Create updated note
            val updatedNote = Note(args.currentNote.id, title, description)
            //Update into DB
            mNoteViewModel.updateNote(updatedNote)
            //Successfully Updated Note Message
            Toast.makeText(requireContext(), "Successfuly Updated!", Toast.LENGTH_SHORT).show()
            //Navigate back to ListNotes Fragment
            findNavController().navigate(R.id.action_updateNotesFragment_to_listNotes)
        }

        else
        {
            Toast.makeText(requireContext(), "Fill all Fields, please!", Toast.LENGTH_SHORT).show()
        }
    }

    //Check if input data for title and description are null or not
    //Return true if all fields are filled correctly
    private fun checkInput(title: String, description: String): Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(description))
    }
}