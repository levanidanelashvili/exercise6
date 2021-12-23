package com.example.myapplicationn6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplicationn6.adapter.ViewPagerFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPagerFragmentAdapter: ViewPagerFragmentAdapter
    private lateinit var editTextNote: EditText
    private lateinit var buttonAdd: Button
    private lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("juno", MODE_PRIVATE)
        val text1 = sharedPreferences.getString("jemala", "jora")

        init()
        textView.text = text1
        viewPager2.adapter = viewPagerFragmentAdapter
        TabLayoutMediator(tabLayout, viewPager2){tab, position->
            tab.text = "tab ${position+1}"
        }.attach()

        buttonAdd.setOnClickListener {
            val note = editTextNote.text.toString()
            val text = textView.text.toString()
            val result = note + "\n" + text
            textView.text = result
            sharedPreferences.edit().putString("jemala", result).apply()
        }

    }
    private fun init() {
        viewPager2 = findViewById(R.id.viewPager2)
        tabLayout = findViewById(R.id.tabLayout)
        viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)
        editTextNote = findViewById(R.id.editTextNote)
        buttonAdd = findViewById(R.id.buttonAdd)
        textView = findViewById(R.id.textView)

    }
}