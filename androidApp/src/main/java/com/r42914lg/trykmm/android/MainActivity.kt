package com.r42914lg.trykmm.android

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.r42914lg.trykmm.presentation.SimpleViewModel
import androidx.activity.viewModels
import trydb.DatabaseDriverFactory

class MainActivity : AppCompatActivity() {

    private val simpleViewModel: SimpleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.my_text)
        val button = findViewById<TextView>(R.id.my_button)

        simpleViewModel.setDatabaseDriverFactory(DatabaseDriverFactory(this))

        button.setOnClickListener {
            simpleViewModel.next()
        }

        simpleViewModel.messageLiveData.addObserver {
            textView.text = it.text
        }
    }
}