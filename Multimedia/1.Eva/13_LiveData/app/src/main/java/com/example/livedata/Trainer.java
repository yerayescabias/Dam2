package com.example.livedata;

import static java.util.concurrent.TimeUnit.SECONDS;

import androidx.lifecycle.LiveData;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class Trainer {
    interface TrainerListener {
        void onCommand(String command);
    }

    Random random = new Random();
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    ScheduledFuture<?> training;

    void beginTraining(TrainerListener trainerListener ) {
        if (training == null || training.isCancelled()) {
            training = scheduler.scheduleWithFixedDelay(new Runnable() {
                int exercise;
                int repetitions = -1;

                @Override
                public void run() {
                    if (repetitions < 0) {
                        repetitions = random.nextInt(3) + 3;
                        exercise = random.nextInt(5)+1;
                    }
                    trainerListener.onCommand("EXERCISE" + exercise + ":" + (repetitions== 0 ? "CHANGE" : repetitions));
                    repetitions--;
                }
            }, 0, 1, SECONDS);
        }
    }

    void stopTraining() {
        if (training != null) {
            training.cancel(true);
        }
    }

    LiveData<String> commandLiveData = new LiveData<String>() {
        @Override
        protected void onActive() {
            super.onActive();

            beginTraining(new TrainerListener() {
                @Override
                public void onCommand(String command) {
                    postValue(command);
                }
            });
        }

        @Override
        protected void onInactive() {
            super.onInactive();

            stopTraining();
        }
    };
}
