package eus.urko.recyclerviewfragments;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface ElementsDAO {
    @Query("SELECT * FROM Element")
    LiveData<List<Element>> getElements();

    @Query("SELECT * FROM Element ORDER BY rating DESC")
    LiveData<List<Element>> bestRated();

    @Query("SELECT * FROM Element WHERE name LIKE '%' || :t || '%'")
    LiveData<List<Element>> search(String t);
    //:t it refers to t argument of search function

    @Insert
    void insert(Element elemento);

    @Update
    void update(Element elemento);

    @Delete
    void delete(Element elemento);
}
