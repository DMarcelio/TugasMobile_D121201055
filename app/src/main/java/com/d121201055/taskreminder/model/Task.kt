package com.d121201055.taskreminder.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "task")
data class Task (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val judul:String,
    val isi:String,
    val kategori:String,
    val status:String
    ):Parcelable
