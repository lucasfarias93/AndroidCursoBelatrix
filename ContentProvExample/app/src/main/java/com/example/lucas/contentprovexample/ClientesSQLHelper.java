package com.example.lucas.contentprovexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LUCAS on 18/01/2017.
 * La base de datos creata sera lo mas sencilla posible a fin de mostrar la conexion con
 * el content provider y mostrar datos mediante su comunicacion
 */
public class ClientesSQLHelper extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de Clientes
    String sqlCreate = "CREATE TABLE Clientes " +
            "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " nombre TEXT, " +
            " telefono TEXT, " +
            " email TEXT )";

    public ClientesSQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.sqlCreate = sqlCreate;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creaci�n de la tabla
        db.execSQL(sqlCreate);

        //Insertamos 5 clientes de ejemplo
        for(int i=1; i<=15; i++)
        {
            //Generamos los datos de muestra
            String nombre = "Cliente" + i;
            String telefono = "900-123-00" + i;
            String email = "email" + i + "@mail.com";

            //Insertamos los datos en la tabla Clientes
            db.execSQL("INSERT INTO Clientes (nombre, telefono, email) " +
                    "VALUES ('" + nombre + "', '" + telefono +"', '" + email + "')");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS Clientes");
        db.execSQL(sqlCreate);
    }

}
