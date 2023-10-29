package com.olympia.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountInf: ViewModel() {
    val userName: MutableLiveData<String?> by lazy { MutableLiveData<String?>() }
    val password: MutableLiveData<String?> by lazy { MutableLiveData<String?>() }
    val gender: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val dataOfBirth: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val email: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}