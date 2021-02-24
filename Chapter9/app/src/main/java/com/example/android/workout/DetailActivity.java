package com.example.android.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORKOUT_ID = "id" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        /*Obtenemos la referencia al fragment cargado en el layout
        **para trabajar con el desde el código Java
        */
        WorkoutDetailFragment fragment = (WorkoutDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        //int workoutId = 1;
        int workoutId = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        fragment.setWorkoutId(workoutId);
    }
}