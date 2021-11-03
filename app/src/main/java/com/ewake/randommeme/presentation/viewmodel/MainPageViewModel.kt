package com.ewake.randommeme.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ewake.randommeme.domain.usecase.MemesUseCase
import com.ewake.randommeme.presentation.model.MemeItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@HiltViewModel
class MainPageViewModel @Inject constructor(
    private val memesUseCase: MemesUseCase,
) : ViewModel() {

    private val _memeItemsLiveData = MutableLiveData<List<MemeItemModel>>()
    val memeItemsLiveData: LiveData<List<MemeItemModel>> = _memeItemsLiveData

    fun load() {
        CoroutineScope(Dispatchers.Main).launch {
            memesUseCase.invoke("itmemes", 50)
                .onSuccess {
                    _memeItemsLiveData.postValue(it)
                }
                .onFailure {
                    Log.e("MainPage", it.message.toString())
                }
        }
    }
}