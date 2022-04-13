package com.example.bus.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.bus.database.database
import com.example.bus.entity.loginInfo
import com.example.bus.repository.repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class busViewModel(application: Application) : AndroidViewModel(application) {
    private val readAllData: LiveData<List<loginInfo>>
    private val repository: repository

    init {
        val dao = database.getInstance(application).dao()
        repository = repository(dao = dao)
        readAllData = repository.readAllData
    }

    fun addInfo(item: List<loginInfo>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addInfo(item = item)
        }
    }

    fun updateInfo(item: loginInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateInfo(item = item)
        }
    }

    fun deleteInfo(item: loginInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteInfo(item = item)
        }
    }

}

class busViewModelFactory(
    private val application: Application
):  ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {  //ошибка может быть тут
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(busViewModel::class.java)) {
            return busViewModel(application) as T
        }
        throw IllegalArgumentException("Error")
    }
}