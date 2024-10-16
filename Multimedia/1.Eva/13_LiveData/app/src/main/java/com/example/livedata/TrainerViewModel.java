package com.example.livedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import kotlin.jvm.functions.Function1;

public class TrainerViewModel extends AndroidViewModel {
    Trainer trainer;

    LiveData<Integer> exerciseLiveData;
    LiveData<String> repetitionLiveData;

    public TrainerViewModel(@NonNull Application application) {
        super(application);

        trainer= new Trainer();

        exerciseLiveData = Transformations.switchMap(trainer.commandLiveData, new Function1<String, LiveData<Integer>>() {
            String previousExercise;
            //The invoke method is called whenever trainer.commandLiveData changes.
            @Override
            public LiveData<Integer> invoke(String command) {
                String exercise= command.split(":")[0];

                if(!exercise.equals(previousExercise)){
                    previousExercise = exercise;
                    int image;
                    switch (exercise) {
                        case "EXERCISE1":
                        default:
                            image = R.drawable.e1;
                            break;
                        case "EXERCISE2":
                            image = R.drawable.e2;
                            break;
                        case "EXERCISE3":
                            image = R.drawable.e3;
                            break;
                        case "EXERCISE4":
                            image = R.drawable.e4;
                            break;
                    }
                    return new MutableLiveData<>(image);
                }
                //the observers are not notified, because is null the value
                return null;
            }
        });

        repetitionLiveData= Transformations.switchMap(trainer.commandLiveData, new Function1<String, LiveData<String>>() {
            @Override
            public LiveData<String> invoke(String command) {
                return new MutableLiveData<>(command.split(":")[1]);
            }
        });
    }

    LiveData<Integer> getExercise(){
        return exerciseLiveData;
    }
    LiveData<String> getRepetition(){return repetitionLiveData;}
}
