package com.darka11y.android.squareproject

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.darka11y.android.squareproject.screens.directorylist.EmployeeDirectoryApiStatus

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String) {
    imageUrl.let {
        val employeeImageSmallUrl = imageUrl.toUri()
            .buildUpon().scheme("https")
            .build()

        // Load images with Glide
        Glide.with(imageView.context)
            .load(employeeImageSmallUrl)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC))
            .into(imageView)
    }
}

@BindingAdapter("employeeDirectoryApiStatus")
fun bindStatus(statusImageView: ImageView, status: EmployeeDirectoryApiStatus) {
    when(status) {
        EmployeeDirectoryApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
            statusImageView.contentDescription = "Loading"
        }

        EmployeeDirectoryApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
            statusImageView.contentDescription = "An error occurred"
        }

        EmployeeDirectoryApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

