Square Assessment
=================

Instructions
------------

Create an [Employee Directory Application](https://sites.google.com/squareup.com/squaremobileproject/home?authuser=0)

Introduction
------------

This simple employee directory shows a list of employees (RecyclerView) that are pulled from a REST web service. 
Each item in the list contains a summary of the employee (i.e. photo, name, team, phone number, and email). 

This app also demonstrates the use of [Retrofit](https://square.github.io/retrofit/) to make REST requests to the 
web service, [Moshi](https://github.com/square/moshi) to handle the deserialization of the 
returned JSON to Kotlin data objects, and [Glide](https://bumptech.github.io/glide/) to load and 
cache images by URL.  

The app also leverages several Jetpack Libraries, including:
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) 
- [Data Binding](https://developer.android.com/topic/libraries/data-binding/) 
- [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) 

Current Endpoints
-----------------
- [Ficticious Employee List](https://s3.amazonaws.com/sq-mobile-interview/employees.json)
- [Malformed Employee List](https://s3.amazonaws.com/sq-mobile-interview/employees_malformed.json)
- [Empty Employee List](https://s3.amazonaws.com/sq-mobile-interview/employees_empty.json)

Build Tools & Versions
----------------------
Android Studio 4.1.2
Build #AI-201.8743.12.41.7042882, built on December 19, 2020
Runtime version: 1.8.0_242-release-1644-b3-6915495 x86_64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
macOS 10.16

My Focus Areas
--------------

I wanted to focus on showing my strengths using the new Android Architecture and MVVM Design pattern.

Copied Code/Dependencies
------------------------
- Drawables from Android Open Source Project
    - ic_broken_image.xml
    - loading_animation.xml
    - loading_img.xml
    - ic_connection_error.xml

Device Focus
------------

Phone: minSdkVersion 19 -> targetSdkVersion 30

Time Spent
----------

Short stints between interviews maybe 2 - 3 hours total. Then came back in and cleaned up and commented code 1 - 2 hours

Other Notes
-----------
