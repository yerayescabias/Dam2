package paagbi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import jakarta.annotation.PostConstruct;
import paagbi.model.Eskatzaileak;

@Repository
public class MongoDBRepository implements EskatzaileaRepository {

    @Autowired
    private MongoClient client;
    private MongoCollection<Eskatzaileak> eskatzaileakCollection;

    @PostConstruct
    void init(){
        eskatzaileakCollection = client.getDatabase("gabonak").getCollection("eskatzaileak",Eskatzaileak.class);
    }

    @Override
    public List<Eskatzaileak> findAll() {
        return eskatzaileakCollection.find().into(new ArrayList<Eskatzaileak>());
    }

  
    
    
}
