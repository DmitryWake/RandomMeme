package com.ewake.randommeme.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ewake.randommeme.data.api.Api
import com.ewake.randommeme.domain.usecase.MemeUseCase
import com.ewake.randommeme.domain.usecase.MemesUseCase
import com.ewake.randommeme.presentation.mapper.MemeResponseMapper
import com.ewake.randommeme.presentation.model.MemeItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@HiltViewModel
class MainPageViewModel @Inject constructor(
    private val memesUseCase: MemesUseCase,
    private val mapper: MemeResponseMapper,
) : ViewModel() {

    private val _memeItemsLiveData = MutableLiveData<List<MemeItemModel>>()
    val memeItemsLiveData: LiveData<List<MemeItemModel>> = _memeItemsLiveData

    fun load() {
        CoroutineScope(Dispatchers.Main).launch {
            memesUseCase.invoke("it", 50)
                .onSuccess {
                    _memeItemsLiveData.postValue(mapper.responseListToModelList(it.memes))
                }
        }
    }
}