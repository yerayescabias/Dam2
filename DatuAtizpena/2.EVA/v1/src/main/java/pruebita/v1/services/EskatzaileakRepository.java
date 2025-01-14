package pruebita.v1.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

import jakarta.annotation.PostConstruct;
import pruebita.v1.model.Eskatzaileak;
import pruebita.v1.model.Opariak;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class EskatzaileakRepository implements IEskatzaileak {
    @Autowired
    private MongoClient mongoClient;
    private MongoCollection<Eskatzaileak> mongoCollection;

    @PostConstruct
    void init() {
        mongoCollection = mongoClient.getDatabase("gabonak").getCollection("eskatzaileak", Eskatzaileak.class);
    }

    @Override
    public List<Eskatzaileak> findAll() {
        return mongoCollection.find().into(new ArrayList<>());
    }

    @Override
    public Eskatzaileak create(Eskatzaileak eskatzaileak) {

        eskatzaileak.setId(new ObjectId());
        mongoCollection.insertOne(eskatzaileak);
        return eskatzaileak;
    }

    @Override
    public long delete(String izena) {
        return mongoCollection.deleteMany(eq("izena", izena)).getDeletedCount();
    }

    @Override
    public List<Eskatzaileak> findMeltxor() {

        return mongoCollection.find(eq("opariak.nori.izena: Meltxor")).into(new ArrayList<>());

    }

    

}
