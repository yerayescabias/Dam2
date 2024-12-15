package paagbi.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;

import jakarta.annotation.PostConstruct;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBUmeaRepository implements UmeaRepository {

    // private static final TransactionOptions txnOptions =
    // TransactionOptions.builder()
    // .readPreference(ReadPreference.primary())
    // .readConcern(ReadConcern.MAJORITY)
    // .writeConcern(WriteConcern.MAJORITY)
    // .build();

    @Autowired
    private MongoClient client;
    private MongoCollection<Umea> umeaCollection;

    @PostConstruct
    void init() {
        umeaCollection = client.getDatabase("gabonak").getCollection("umeak", Umea.class);
    }

    @Override
    public List<Umea> findAll() {
        return umeaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Umea findById(String id) {
        return umeaCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public int findOpariKopuruaUmeko(String izena) {
        Umea u = umeaCollection.find(eq("izena", izena), Umea.class).first();
        return u.getOpariak().size();
    }

    @Override
    public List<String> findOpariakUmeko(String izena) {

        Umea u = umeaCollection.find(eq("izena", izena), Umea.class).first();
        return u.getOpariak();
    }

    /** Opari bat daukatenak ez dira agertuko.
     * 
     * Algoritmo ez-efizientea. Mongo queryak eta aggregateak erabili beharko ziren
     * honen ordez.
     * 
     * 
     */
    @Override
    public List<Umea> findUmeOpariAskodunak() {
        ArrayList<Umea> uk = umeaCollection.find().into(new ArrayList<>());
        uk.removeIf(u -> u.getOpariak().size()< 3);

        return uk;
    }

    // public List<Umea> findUmeOpariAskodunak() {
    // ArrayList<Umea> uk = umeaCollection.aggregate(
    // Arrays.asList(
    // Aggregates.project(
    // Projections.fields(
    // Projections.excludeId(),
    // Projections.include("izena"),
    // Projections.computed(
    // "opariKopurua",
    // new Document("$size", "opariak")))))).into(new ArrayList<>());
    // return uk;
    // }

    @Override
    public Umea save(Umea umea) {
        umea.setId(new ObjectId());
        umeaCollection.insertOne(umea);
        return umea;
    }

    @Override
    public long delete(String izena) {
        return umeaCollection.deleteMany(eq("izena", izena)).getDeletedCount();
    }
}
