package com.darka11y.android.squareproject.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/** [Parcelable] that defines the [EmployeeData] which includes a list of employees **/

@Parcelize
class EmployeeData : Parcelable {
    var employees: List<Employee>? = null
}

/** [Parcelable] that defines the [Employee] which includes:
 * Key : Type : Required? : Notes
 * uuid : string : YES : The unique identifier for the employee. Represented as a UUID.
 * full_name : string: YES : The full name of the employee.
 * phone_number : string : NO : The phone number of the employee, sent as an unformatted string (eg, 5556661234).
 * email_address : string : YES : The email address of the employee.
 * biography : string : NO : A short, tweet-length (~300 chars) string that the employee provided to describe themselves.
 * photo_url_small : string : NO : The URL of the employee’s small photo. Useful for list view.
 * photo_url_large : string : NO : The URL of the employee’s full-size photo.
 * team : string : YES : The team they are on, represented as a human readable string.
 * employee_type : enum (FULL_TIME, PART_TIME, CONTRACTOR) : YES : How the employee is classified.**/

@Parcelize
class Employee : Parcelable {
    var uuid: String? = null
    var full_name: String? = null
    var phone_number: String? = null
    var email_address: String? = null
    var biography: String? = null
    var photo_url_small: String? = null
    var photo_url_large: String? = null
    var team: String? = null
    var employee_type: String? = null
}