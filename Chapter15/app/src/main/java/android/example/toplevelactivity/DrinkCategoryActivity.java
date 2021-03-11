package android.example.toplevelactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
        //Creamos el adaptador para acceder a los elementos del array
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Drink.drinks);
        //Agregamos el adaptador a la lista para mostrar los valores
        ListView listDrinks = (ListView)findViewById(R.id.list_drinks);
        listDrinks.setAdapter(listAdapter);

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
}