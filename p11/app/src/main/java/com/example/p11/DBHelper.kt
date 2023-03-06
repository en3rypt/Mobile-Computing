package com.example.p11
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {

        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ROLL_COL + " TEXT PRIMARY KEY," +
                NAME_COl + " TEXT," +
                MARKS_COL + " NUMERIC" + ")")

        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addName(roll: String,name : String, marks : Int ){

        val values = ContentValues()

        values.put(ROLL_COL, roll)
        values.put(NAME_COl, name)
        values.put(MARKS_COL, marks)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)

        db.close()
    }
    fun deleteRollNo(roll:String):Boolean{
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, ROLL_COL + "=" +'"'+ roll+'"', null) > 0
    }

    fun updateName(roll: String,name : String, marks : Int):Boolean{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME_COl, name)
        values.put(MARKS_COL, marks)
        return db.update(TABLE_NAME, values, ROLL_COL + "=" +'"'+ roll+'"', null) > 0
    }

    fun getAll(): Cursor? {
        val db = this.readableDatabase

        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)

    }
    fun getRollNo(roll:String): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + ROLL_COL + " = " + '"'+roll+'"', null)
    }

    companion object{
        private val DATABASE_NAME = "COLLEGE_MC_DB"

        private val DATABASE_VERSION = 1

        val TABLE_NAME = "students_data"


        val ROLL_COL = "roll"

        val NAME_COl = "name"

        val MARKS_COL = "marks"
    }
}
