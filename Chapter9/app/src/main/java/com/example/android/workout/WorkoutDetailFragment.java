package com.example.android.workout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WorkoutDetailFragment extends Fragment {
    //Variable que va contener el ID del ejercicio que estamos realizando
    private long workoutId;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_workout_detail,container,false);
        return v;
    }
    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }
    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view!=null){
            TextView title = (TextView) view.findViewById(R.id.tvTexTitle);
            TextView description = (TextView) view.findViewById(R.id.tvTextDescription);
            Workout workout = Workout.workouts[(int) workoutId];
            title.setText(workout.getName());
            description.setText(workout.getDescription());
        }
    }
}
