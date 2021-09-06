package com.ewake.randommeme.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ewake.randommeme.presentation.model.MemeItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@HiltViewModel
class MainPageViewModel @Inject constructor() : ViewModel() {

    private val _memeItemsLiveData = MutableLiveData<List<MemeItemModel>>()
    val memeItemsLiveData: LiveData<List<MemeItemModel>> = _memeItemsLiveData

    fun load() {

    }
}