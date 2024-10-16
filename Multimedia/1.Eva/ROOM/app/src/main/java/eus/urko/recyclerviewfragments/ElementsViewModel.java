package eus.urko.recyclerviewfragments;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ElementsViewModel extends AndroidViewModel {

    ElementsRepository elementsRepository;

    MutableLiveData<Element> elementSelected= new MutableLiveData<>();

    public ElementsViewModel(@NonNull Application application) {
        super(application);

        elementsRepository = new ElementsRepository(application);

    }




    void insert(Element element){
        elementsRepository.insert(element);
    }

    void delete(Element element){
        elementsRepository.delete(element);
    }

    void update(Element element, float rating){
        elementsRepository.update(element, rating);
    }

    void select(Element element){
        elementSelected.setValue(element);
    }

    MutableLiveData<Element> selected(){
        return elementSelected;
    }

    LiveData<List<Element>> obtain(){
        return elementsRepository.get();
    }
}
