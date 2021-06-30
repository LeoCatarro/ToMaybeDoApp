package com.example.tomaybedoapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_diagram_creator.*


class DiagramCreator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagram_creator)

        title="ToMaybeDoApp22";

        ControlUndo.setOnClickListener {
            PaintArea.setUndo()
        }

        ControlRedo.setOnClickListener {
            PaintArea.setRedo()
        }

        ClearAllPaths.setOnClickListener {
            PaintArea.setDeleteAll()
        }

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);     //Back button to return to main activity
    }
}