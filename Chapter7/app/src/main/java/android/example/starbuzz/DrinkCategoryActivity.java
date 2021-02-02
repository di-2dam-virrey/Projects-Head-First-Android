package android.example.starbuzz;

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

        //Creamos el adaptador para acceder a los datos de la clase Java Drink
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>
                (this,
                        android.R.layout.simple_list_item_1,
                        Drink.drinks);
        //Asignamos el adaptador al elemento gráfico que lo va a usar
        ListView listDrinks = (ListView)findViewById(R.id.list_drinks);
        listDrinks.setAdapter(listAdapter);

        //Creamos el listener sobre el listView
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> listDrinks,
                                            View itemView,
                                            int position,
                                            long id) {

                        //Al hacer clic sobre algún elemento paso un intent
                        Intent intent = new Intent(DrinkCategoryActivity.this,
                                DrinkActivity.class);
                        intent.putExtra(DrinkActivity.EXTRA_DRINKID,(int) id);
                        startActivity(intent);
                    }
                };
        //Asignamos el listener al elemento que queremos que lo use
        listDrinks.setOnItemClickListener(itemClickListener);
    }
}