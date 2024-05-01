package com.example.ordereasy

// Importar las bibliotecas necesarias de Android
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Declarar la clase miSQLiteHelper que extiende de SQLiteOpenHelper
class miSQLiteHelper(context: Context) : SQLiteOpenHelper(
    context, "orderEasy.db", null, 1) {

    // Método llamado al crear la base de datos por primera vez
    override fun onCreate(db: SQLiteDatabase?) {
        // Crear la tabla OrderEasy con columnas para nombre, apellido, usuario, teléfono, correo y edad
        val orderEasy = "CREATE TABLE OrderEasy" + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellido TEXT, usuario TEXT, telefono INTEGER, correo TEXT, edad INTEGER)"
        db!!.execSQL(orderEasy)
    }

    // Método llamado al actualizar la base de datos
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Eliminar la tabla OrderEasy si existe
        val orderEasyBorrado = "DROP TABLE IF EXISTS OrderEasy"
        db!!.execSQL(orderEasyBorrado)
        // Crear la tabla nuevamente
        onCreate(db)
    }

    // Método para agregar datos a la base de datos
    fun anadirDato(nombre: String, apellido: String, usuario: String, telefono: String, correo: String, edad: String) {
        // Crear un ContentValues para almacenar los datos
        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("apellido", apellido)
        datos.put("usuario", usuario)
        datos.put("telefono", telefono)
        datos.put("correo", correo)
        datos.put("edad", edad)

        // Obtener una referencia a la base de datos en modo escritura
        val db = this.writableDatabase
        // Insertar los datos en la tabla OrderEasy
        db.insert("OrderEasy", null, datos)
        // Cerrar la conexión a la base de datos
        db.close()
    }
}
