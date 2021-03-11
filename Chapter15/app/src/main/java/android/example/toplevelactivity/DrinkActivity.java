package android.example.toplevelactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKID = "drinkId" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        //Obtenemos el bebida seleccionada del intent
        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);
        Drink drink = Drink.drinks[drinkId];

        //Mostramos el nombre de la bebida
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(drink.getName());
        //Mostramos la descripcion de la bebida
        TextView description = (TextView)findViewById(R.id.description);
        description.setText(drink.getDescription());
        //Mostramos la imagen de la bebida
        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());
    }
}