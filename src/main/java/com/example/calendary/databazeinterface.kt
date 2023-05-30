package com.example.calendary

import androidx.room.*

@Dao
public interface databazeinterface {
        @Query("SELECT * FROM events")
        fun getAll () : List<entity>
        @Query ("SELECT * FROM events WHERE name LIKE :title LIMIT 1")
        fun findByTitle ( title : String): entity
        @Insert
        fun insert(note: entity): Long
        @Delete
        fun delete(note: entity)
        @Update
        fun update(notes: List<entity>) : Int
}