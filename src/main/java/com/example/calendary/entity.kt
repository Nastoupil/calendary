package com.example.calendary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class entity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="id") val id: Long = 0,
    val name: String,
    val datestart: Long,
    val dateend: Long
)