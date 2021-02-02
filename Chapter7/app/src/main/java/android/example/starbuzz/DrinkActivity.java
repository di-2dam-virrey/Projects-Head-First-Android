package android.example.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKID="drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        //Obtenemos el valor que nos pasan en el intent
        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);
        //Creamos un objeto Drink y lo "llenamos" con el objeto del array indicado por el ID
        Drink drink = Drink.drinks[drinkId];

        //Rellenar los elementos del layout con el contenido del objeto Drink
        //Primero los referencio para usarlos
        ImageView photo = (ImageView)findViewById(R.id.photo);
        TextView name = (TextView)findViewById(R.id.name);
        TextView description = (TextView)findViewById(R.id.description);

        //Llenamos los elementos
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());

        name.setText(drink.getName());
        description.setText(drink.getDescription());
    }
}