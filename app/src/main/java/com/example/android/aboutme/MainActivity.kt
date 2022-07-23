package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.bind(findViewById(R.id.root))

        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {

        val editText = binding.nicknameEdit
        val nicknameTextView = binding.nicknameText

        nicknameTextView.text = editText.text

        // this hides the edit text
        editText.visibility = View.GONE

        // this hides the view aka the button
        view.visibility = View.GONE

        nicknameTextView.visibility = View.VISIBLE

        //hide the keyboard code
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}