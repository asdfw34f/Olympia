package com.olympia.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.olympia.model.entities.DComments
import com.olympia.model.entities.DPosts
import com.olympia.model.entities.DUsers
import javax.inject.Singleton

@Singleton
@Database(entities = [DUsers::class, DPosts::class, DComments::class], version = 1)
abstract class DB : RoomDatabase(){
    abstract val userDao: IUserActivity
    abstract val commentsDao: IComments
    abstract val postsDao: IPosts
    companion object {
        const val MAIN_DB = "MainDB.db"
    }
}