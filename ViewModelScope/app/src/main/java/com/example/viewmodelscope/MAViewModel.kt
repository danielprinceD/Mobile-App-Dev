package com.example.viewmodelscope

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodelscope.Model.User
import com.example.viewmodelscope.Model.UserList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MAViewModel : ViewModel() {
    private val ul = UserList()
    val liveData : MutableLiveData<List<User>>  = MutableLiveData()
    fun model(){
        viewModelScope.launch {
            val userList : List<User>
            withContext(Dispatchers.IO){
                userList = ul.getList()
            }
            liveData?.value = userList
        }
    }
}