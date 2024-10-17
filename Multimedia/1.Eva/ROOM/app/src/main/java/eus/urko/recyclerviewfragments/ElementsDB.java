package eus.urko.recyclerviewfragments;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Element.class}, version = 1, exportSchema = false)
public abstract class ElementsDB extends RoomDatabase {

    public abstract ElementsDAO getElementsDAO();
    private static volatile ElementsDB INSTANCE;//volatile->shared variable

    static ElementsDB obtainInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (ElementsDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                                    ElementsDB.class, "elements.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }//fallbackToDestructiveMigration() si cambia la estrucutra
            }    //se perderan los datos; solo para fases tempranas de desarrollo.
        }
        return INSTANCE;
    }

}