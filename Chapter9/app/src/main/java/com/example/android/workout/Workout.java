package com.example.android.workout;

public class Workout {
    private String name;
    private String description;

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public static final Workout[] workouts = {
            new Workout("The Limb Loosener",
                    "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new Workout("Core Agony",
                    "100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new Workout("The Wimp Special",
                    "5 Pull-ups\n10 Push Ups\n15 Squats"),
            new Workout("Strength and Legth",
                    "500 meter run\n21 x 1.5 pood kettleball swing\n21 x pull-ups")
    };
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public static Workout[] getWorkouts() {
        return workouts;
    }
}
