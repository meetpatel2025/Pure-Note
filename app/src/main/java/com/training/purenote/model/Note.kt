package com.training.purenote.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes")
data class Note (
    @PrimaryKey(autoGenerate = true)
    val noteID : Int,
    val noteTitle : String,
    val noteBody : String
): Serializable
