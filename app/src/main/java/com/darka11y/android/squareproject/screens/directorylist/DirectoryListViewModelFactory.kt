package com.darka11y.android.squareproject.screens.directorylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/** Generic [ViewModelProvider.Factory] that provides context to the ViewModel **/

class DirectoryListViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DirectoryListViewModel::class.java)) {
            return DirectoryListViewModel() as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")

    }
}