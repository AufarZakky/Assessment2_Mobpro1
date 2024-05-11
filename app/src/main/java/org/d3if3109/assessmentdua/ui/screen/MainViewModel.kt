package org.d3if3109.assessmentdua.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3109.assessmentdua.database.MakananDao
import org.d3if3109.assessmentdua.model.Makanan


class MainViewModel(dao: MakananDao) : ViewModel() {

    val data: StateFlow<List<Makanan>> = dao.getMakanan().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}