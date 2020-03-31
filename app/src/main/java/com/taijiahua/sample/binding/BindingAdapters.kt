package com.taijiahua.sample.binding

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("visibleGone")
fun showHide(view: View, show: Boolean) {
  view.visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter("image")
fun bindImage(v: ImageView, url: String) {
  Glide.with(v).load(url).into(v)
}

@BindingAdapter("defaultImage", "image")
fun bindImage(v: ImageView, defaultImage: Drawable, url: String) {
  Glide.with(v).load(url).placeholder(defaultImage).into(v)
}

@BindingAdapter("defaultImage", "image", "circle")
fun bindImage(v: ImageView, defaultImage: Drawable, url: String, isCircle: Boolean) {
  if (isCircle) {
    Glide.with(v).load(url).circleCrop().placeholder(defaultImage).into(v)
  } else {
    Glide.with(v).load(url).placeholder(defaultImage).into(v)
  }
}
