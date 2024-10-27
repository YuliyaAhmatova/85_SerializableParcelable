package com.example.a85_serializableparcelable

import java.io.Serializable

class Person(val name: String, val secondName: String, val address: String, val phone: String) :
    Serializable {
    override fun toString(): String {
        return "$name $secondName"
    }
}