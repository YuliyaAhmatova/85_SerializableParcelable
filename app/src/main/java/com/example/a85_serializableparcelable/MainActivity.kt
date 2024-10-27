package com.example.a85_serializableparcelable

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val persons: MutableList<Person> = mutableListOf()

    private lateinit var nameET: EditText
    private lateinit var secondNameET: EditText
    private lateinit var addressET: EditText
    private lateinit var phoneET: EditText
    private lateinit var saveBTN: Button
    private lateinit var listViewLV: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nameET = findViewById(R.id.nameET)
        secondNameET = findViewById(R.id.secondNameET)
        addressET = findViewById(R.id.addressET)
        phoneET = findViewById(R.id.phoneET)
        saveBTN = findViewById(R.id.saveBTN)

        listViewLV = findViewById(R.id.listViewLV)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, persons)
        listViewLV.adapter = adapter

        saveBTN.setOnClickListener {
            val person = Person(
                nameET.text.toString(),
                secondNameET.text.toString(),
                addressET.text.toString(),
                phoneET.text.toString()
            )
            persons.add(person)
            adapter.notifyDataSetChanged()
            nameET.text.clear()
            secondNameET.text.clear()
            addressET.text.clear()
            phoneET.text.clear()
        }

        listViewLV.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val person = adapter.getItem(position)
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(Person::class.java.simpleName, person)
                startActivity(intent)
            }
    }
}
