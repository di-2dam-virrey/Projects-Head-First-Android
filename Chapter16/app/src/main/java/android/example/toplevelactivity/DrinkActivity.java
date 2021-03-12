package android.example.toplevelactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.example.toplevelactivity.database.StarbuzzDataBaseHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKID = "drinkId" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        //Obtenemos el bebida seleccionada del intent
        int drinkId = (Integer) getIntent().getExtras().get(EXTRA_DRINKID);

        //Creamos el cursor para traer los datos de la BD
        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDataBaseHelper(this);
        try {
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("DRINK",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id = ?",
                    new String[]{Integer.toString(drinkId)},
                    null, null, null);
            //Nos movemos al primer registro dentro del Cursor
            if (cursor.moveToFirst()) {
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);
                //Mostramos el nombre de la bebida
                TextView name = (TextView) findViewById(R.id.name);
                name.setText(nameText);
                //Mostramos la descripcion de la bebida
                TextView description = (TextView) findViewById(R.id.description);
                description.setText(descriptionText);
                //Mostramos la imagen de la bebida
                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this,
                    "Database unavailable",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}