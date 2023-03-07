package com.r42914lg.trykmm.presentation

import com.r42914lg.trykmm.data.CategoryRepositoryImpl
import com.r42914lg.trykmm.domain.CategoryRepository
import com.r42914lg.trykmm.utils.doOnError
import com.r42914lg.trykmm.utils.doOnSuccess
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.launch
import trydb.DatabaseDriverFactory

class SimpleViewModel: ViewModel() {

    private lateinit var repo: CategoryRepository

    private val _messageLiveData: MutableLiveData<HomeState>
        = MutableLiveData(HomeState(Greeting().greet()))

    val messageLiveData: LiveData<HomeState> = _messageLiveData

    fun next() {
        val item = repo.requestNext()
        _messageLiveData.value = HomeState("Category # ${item.id} Title: ${item.title}")
    }

    fun setDatabaseDriverFactory(databaseDriverFactory: DatabaseDriverFactory) {
        repo = CategoryRepositoryImpl(databaseDriverFactory)

        viewModelScope.launch {
            repo.getCategories()
                .doOnSuccess {
                    repo.saveAll(it)
                }
                .doOnError {
                    it.printStackTrace()
                }
        }
    }
}

data class HomeState(
    val text: String,
)