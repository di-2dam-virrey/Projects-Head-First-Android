package android.example.toplevelactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.example.toplevelactivity.database.StarbuzzDataBaseHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class DrinkCategoryActivity extends AppCompatActivity {

    /*Las añadimos como variables miembro de la clase
    *para poderlas utilizar en el metodo onDestroy
    */
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
        ListView listDrinks = (ListView)findViewById(R.id.list_drinks);

        //Obtenemos la referencia a la base de datos
        SQLiteOpenHelper starbuzzDatabasehelper = new StarbuzzDataBaseHelper(this);
        try{
            //Abrimos la BD para leer en ella
            db = starbuzzDatabasehelper.getReadableDatabase();
            /*Para usar un cursor con un cursor adapter tenemos que incluir la
            *columna _id para que funcione
            */
            cursor = db.query("DRINK",new String[]{"_id","NAME"},
                    null,null,null,null,null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1, //modo en el que se muestra
                    cursor, //cursor usado
                    new String[]{"NAME"}, //columnas queremos usar
                    new int[]{android.R.id.text1}, //que vista queremos usar para mostrarlas
                    0); //comportamiento del cursor, sin cambios por defecto a 0
            listDrinks.setAdapter(listAdapter);
        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Database unavailable",Toast.LENGTH_SHORT);
            toast.show();
        }

        //Creamos el listener
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> listDrinks,
                                            View itemView,
                                            int position,
                                            long id) {

                        Intent intent = new Intent(DrinkCategoryActivity.this,
                                                    DrinkActivity.class);
                        intent.putExtra(DrinkActivity.EXTRA_DRINKID,(int)id);
                        startActivity(intent);
                    }
                };
        listDrinks.setOnItemClickListener(itemClickListener);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}