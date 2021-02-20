package com.darka11y.android.squareproject.screens.directorylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darka11y.android.squareproject.network.Employee
import com.darka11y.android.squareproject.network.EmployeeDirectoryApi
import kotlinx.coroutines.launch

enum class EmployeeDirectoryApiStatus { LOADING, ERROR, DONE }

class DirectoryListViewModel : ViewModel() {

    // The Internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<EmployeeDirectoryApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<EmployeeDirectoryApiStatus> get() = _status

    // Employee List (internal and external values)
    private val _employeeList = MutableLiveData<List<Employee>>()
    val employeeList: LiveData<List<Employee>> get() = _employeeList

    /** Call getEmployees() on init so that we can display the list immediately **/
    init {
        getEmployees()
    }

    /** Gets Employee information from EmployeeDirectoryApiService Retrofit service, validates the data
     * and updates the [List] and the [LiveData]. The Retrofit servie returns a coroutine Deferred,
     * which we await to get the result of the transaction. **/

    private fun getEmployees() {
        viewModelScope.launch {
            _status.value = EmployeeDirectoryApiStatus.LOADING
            try {
                _employeeList.value = EmployeeDirectoryApi.RETROFIT_SERVICE.getEmployees().employees

                // Validate the state of the data
                val isMalformed = validateEmployees()

                if (_employeeList.value?.isEmpty() == true || isMalformed) {
                    _status.value = EmployeeDirectoryApiStatus.ERROR
                } else {
                    _status.value = EmployeeDirectoryApiStatus.DONE
                }
            } catch (e: Exception) {
                _status.value = EmployeeDirectoryApiStatus.ERROR
                _employeeList.value = ArrayList()
            }
        }
    }

    /** Validates that the data returned from the retrofit service, returns the health of the data
     * Required Data Elements
     * uuid : string
     * full_name : string
     * email_address : string
     * team : string
     * employee_type : enum (FULL_TIME, PART_TIME, CONTRACTOR)
     **/
    private fun validateEmployees(): Boolean {

        var isMalformed = false

        for (item in _employeeList.value?.indices!!) {
            val curName = _employeeList.value!![item].full_name
            val curEmail = _employeeList.value!![item].email_address
            val curTeam = _employeeList.value!![item].team
            val curEmpType = _employeeList.value!![item].employee_type

            // Toss the entire list if a single employee is malformed
            if (curName.isNullOrEmpty() || curEmail.isNullOrEmpty() || curTeam.isNullOrEmpty() || curEmpType.isNullOrEmpty()) {
                isMalformed = true
                _employeeList.value = ArrayList()
                break
            }
        }

        return isMalformed
    }
}