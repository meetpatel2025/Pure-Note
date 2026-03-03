package com.training.purenote.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

//import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
//@Parcelize
data class Note (
    @PrimaryKey(autoGenerate = true)
    val noteID : Int,
    val noteTitle : String,
    val noteBody : String
): Serializable
