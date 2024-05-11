package org.d3if3109.assessmentdua.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3109.assessmentdua.model.Makanan

@Database(entities = [Makanan::class], version = 1, exportSchema = false)
abstract class MakananDb : RoomDatabase() {

    abstract val dao:MakananDao

    companion object {

        @Volatile
        private var INSTANCE:MakananDb? = null

        fun getInstance(context: Context): MakananDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MakananDb::class.java,
                        "makanan.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}