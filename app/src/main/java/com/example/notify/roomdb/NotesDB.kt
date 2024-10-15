package com.example.notify.roomdb
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Note::class], version = 1)
abstract class NotesDB: RoomDatabase(){
    abstract val noteDao:NoteDao

    //singleton design so multiple db creation can be avoided
    // Companion obj. defines a static singleton instance of this db class
    //@Volatile: prevents any race condition same as synchronize in java

    companion object{
        @Volatile
        private var INSTANCE: NotesDB?= null

        fun getInstance(context: Context):NotesDB{
            synchronized(this){
                var instance= INSTANCE
                if(instance==null){
                    instance= Room.databaseBuilder(
                        context = context.applicationContext,
                        NotesDB::class.java,
                        "notes_db"
                    ).build()
                }
                INSTANCE=instance
                return instance
                }
            }
        }
    }

