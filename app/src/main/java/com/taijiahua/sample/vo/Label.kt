package com.taijiahua.sample.vo

import com.google.gson.annotations.SerializedName

data class Label(
  @SerializedName("id")
  val id: Long,
  @SerializedName("pid")
  val pid: Long,
  @SerializedName("name")
  val name: String,
  @SerializedName("children")
  val children: List<Label>
)