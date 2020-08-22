package com.lagunita.recycler1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lagunita.recycler1.model.Person

class MainViewModel : ViewModel() {
    private var persons: MutableLiveData<ArrayList<Person>> = MutableLiveData()

    /*
    * persons.value?.add(person)
    * persons.value = persons.value
    * -- That can be simplified with and extension method
    * */

    private fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }

    init {
        persons.value = ArrayList()
    }

    fun getPersons(): LiveData<ArrayList<Person>> {
        return persons
    }

    fun addPerson(person: Person) {
        persons.value?.add(person)
        persons.notifyObserver()
    }
}