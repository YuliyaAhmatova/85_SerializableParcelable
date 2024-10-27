package com.example.a85_serializableparcelable

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private var person: Person? = null

    private lateinit var nameTV: TextView
    private lateinit var addressTV: TextView
    private lateinit var phoneTV: TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nameTV = findViewById(R.id.nameTV)
        addressTV = findViewById(R.id.addressTV)
        phoneTV = findViewById(R.id.phoneTV)

        person = intent.extras?.getSerializable(Person::class.java.simpleName) as Person?

        val name: String = person?.name.toString()
        val secondName: String = person?.secondName.toString()
        val address: String = person?.address.toString()
        val phone: String = person?.phone.toString()

        nameTV.text = "$name $secondName"
        addressTV.text = "Адрес: $address"
        phoneTV.text = "Номер телефона: $phone"

    }
}