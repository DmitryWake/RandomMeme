package com.ewake.randommeme.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ewake.randommeme.data.api.Api
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
class MainPageViewModel @Inject constructor(private val api: Api) : ViewModel() {

    private val _memeItemsLiveData = MutableLiveData<List<MemeItemModel>>()
    val memeItemsLiveData: LiveData<List<MemeItemModel>> = _memeItemsLiveData

    fun load() {
        CoroutineScope(Dispatchers.Main).launch {
            val result = api.getRandomMemes(50)
            _memeItemsLiveData.postValue(
                result.memes.map {
                    MemeItemModel(
                        postLink = it.postLink,
                        title = it.title,
                        author = it.author,
                        url = it.url
                    )
                }
            )
        }
    }
}