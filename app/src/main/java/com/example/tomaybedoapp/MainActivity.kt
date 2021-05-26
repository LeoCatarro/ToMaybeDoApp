package com.example.tomaybedoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="ToMaybeDoApp";

        //Calendar Activity Button
        val calendarButton:Button = findViewById(R.id.btnOpenCalendar);
        calendarButton.setOnClickListener {
            val intent = Intent(this@MainActivity, Calendar::class.java)
            startActivity(intent)
        }

        //DataDashboard Activity Button
        val dataDashboardButton:Button = findViewById(R.id.btnOpenDataDashboard);
        dataDashboardButton.setOnClickListener {
            val intent = Intent(this@MainActivity, DataDashboard::class.java)
            startActivity(intent)
        }

        //DiagramCreator Activity Button
        val diagramCreatorButton:Button = findViewById(R.id.btnOpenDiagramCreator);
        diagramCreatorButton.setOnClickListener {
            val intent = Intent(this@MainActivity, DiagramCreator::class.java)
            startActivity(intent)
        }

        //NotesActivity Activity Button
        val notesBoardButton:Button = findViewById(R.id.btnOpenNotesBoard);
        notesBoardButton.setOnClickListener {
            val intent = Intent(this@MainActivity, NotesActivity::class.java)
            startActivity(intent)
        }
    }
}