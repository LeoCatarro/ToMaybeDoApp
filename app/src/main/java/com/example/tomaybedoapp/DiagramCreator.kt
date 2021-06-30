package com.example.tomaybedoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_diagram_creator.*

class DiagramCreator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagram_creator)

        title="ToMaybeDoApp";

        ControlUndo.setOnClickListener {
            PaintArea.setUndo()
        }

        ControlRedo.setOnClickListener {
            PaintArea.setRedo()
        }

        ClearAllPaths.setOnClickListener {
            PaintArea.setDeleteAll()
        }
    }
}