package android.example.toplevelactivity.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.example.toplevelactivity.R;

//Clase auxiliar para el tratamiento de la base de datos
public class StarbuzzDataBaseHelper extends SQLiteOpenHelper{

    //Constantes para definir los parametros básicos para crear la BD
    private static final String DB_NAME = "starbuzz"; //Nombre de la BD
    private static final int DB_VERSION = 1; //Version de la BD

    //Constructor de la clase, llamamos al constructor de la superclase
    StarbuzzDataBaseHelper(Context context){
        super(context, DB_NAME,null,DB_VERSION);

    }
    /*Metodo que crea la base de datos
     *Añadimos la sentencia SQL necesaria para crear la BD mediante el uso de
     * la sentencia SQL
     */

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*Metodo auxiliar para tener todo el tratamiento de  la BD
        *en la misma ubicacion
        */
        updateMyDataBase(db,0,DB_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDataBase(db,oldVersion,newVersion);

    }

    private void updateMyDataBase(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*Control de versiones
        * si la BD no existe se crea (oldVersion<1)
        * posteriormente a su creación se actualiza (oldVersion<2)
        */
        if(oldVersion<1){
            db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +"NAME TEXT, "
                    +"DESCRIPTION TEXT, "
                    +"IMAGE_RESOURCE_ID INTEGER);");
            //El metodo auxiliar insertDrink lo creamos para insertar varios filas
            insertDrink(db, "Latte","Espresso and steamed milk", R.drawable.latte);
            insertDrink(db, "Capuccino","Espresso, hot milk and steamed-milk foam",
                    R.drawable.cappuccino);
            insertDrink(db, "Filter", "Our best drip coffe", R.drawable.filter);
        }
        if(oldVersion<2){
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC");
        }
    }

    /*Definicion del metodo auxiliar
    *db base de datos de trabajo
    * name campo tipo de cafe
    * description campo descripcion del producto
    * resourceId campo identificador numerico de la imagen
     */
    private void insertDrink(SQLiteDatabase db,
                             String name,
                             String description,
                             int resourceId) {
        /*Objeto que nos va a permitir indicar que valores queremos
        insertar en la BD*/
        ContentValues drinkValues = new ContentValues();
        /*
        * creamos cada uno de los campos de la fila a insertar
         */
        drinkValues.put("NAME",name);
        drinkValues.put("DESCRIPTION",description);
        drinkValues.put("IMAGE_RESOURCE_ID",resourceId);
        db.insert("DRINK",null,drinkValues);
    }


}
