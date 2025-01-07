package paagbi.api_eskatzaileak.metods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import jakarta.annotation.PostConstruct;
import paagbi.api_eskatzaileak.model.Eskatzailea;
import paagbi.api_eskatzaileak.model.Nori;
import paagbi.api_eskatzaileak.model.Oparia;
import static com.mongodb.client.model.Updates.set;


import static com.mongodb.client.model.Filters.eq;

@Repository
public class EskatzaileaAccess implements EskatzaileaRepository {
    @Autowired
    private MongoClient client;
    private MongoCollection<Eskatzailea> eskatzaileaCollection;

    @PostConstruct
    private void init() {
        eskatzaileaCollection = client.getDatabase("Gabonak").getCollection("eskatzaileak", Eskatzailea.class);
    }

    @Override
    public List<Eskatzailea> getAll() {
        return eskatzaileaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Eskatzailea findById(String id) {
        return eskatzaileaCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public Eskatzailea aurkituIzenarenBidez(String izena) {
        return eskatzaileaCollection.find(eq("izena", izena)).first();
    }

    @Override
    public List<Oparia> erabiltzailearenOpariak(String izena) {
        return eskatzaileaCollection.find(eq("izena", izena)).first().getOpariak();
    }

    @Override
    public int opariakErabiltzaileko(String izena) {
        return eskatzaileaCollection.find(eq("izena", izena)).first().getOpariak().size();
    }

    @Override
    public Map<String, Integer> zenbatOpariakNori() {
        Map<String, Integer> emailGiftCount = new HashMap<>();
        List<Eskatzailea> eskatzaileList = eskatzaileaCollection.find().into(new ArrayList<>());

        for (Eskatzailea eskatzailea : eskatzaileList) {
            List<Oparia> opariak = eskatzailea.getOpariak();

            if (opariak != null) {
                for (Oparia oparia : opariak) {
                    Nori nori = oparia.getNori();

                    if (nori != null) {
                        String noriIzena = nori.getIzena();
                        emailGiftCount.put(noriIzena, emailGiftCount.getOrDefault(noriIzena, 0) + 1);
                    }
                }
            }
        }
        return emailGiftCount;
    }

    @Override
    public List<String> findReceiversByNori(String giverName) {
        List<Eskatzailea> eskatzaileList = eskatzaileaCollection.find().into(new ArrayList<>());
        List<String> receivers = new ArrayList<>();

        for (Eskatzailea eskatzailea : eskatzaileList) {
            List<Oparia> opariak = eskatzailea.getOpariak();

            if (opariak != null) {
                for (Oparia oparia : opariak) {
                    Nori nori = oparia.getNori();

                    if (nori != null && nori.getIzena().equals(giverName)) {
                        String receiverName = eskatzailea.getIzena();
                        if (!receivers.contains(receiverName)) {
                            receivers.add(receiverName);
                        }
                    }
                }
            }
        }
        return receivers;
    }

    @Override
    public Eskatzailea opariGehien() {
        List<Eskatzailea> eskatzaileList = eskatzaileaCollection.find().into(new ArrayList<>());
        Eskatzailea maxEskatzailea = null;
        int maxGifts = 0;

        for (Eskatzailea eskatzailea : eskatzaileList) {
            int giftCount = eskatzailea.getOpariak() != null ? eskatzailea.getOpariak().size() : 0;
            if (giftCount > maxGifts) {
                maxGifts = giftCount;
                maxEskatzailea = eskatzailea;
            }
        }

        return maxEskatzailea;
    }

    @Override
    public Eskatzailea add(Eskatzailea eskatzailea) {
        eskatzaileaCollection.insertOne(eskatzailea);

        return eskatzailea;
    }

    @Override
    public long update(String id, Eskatzailea eskatzailea) {
        try {
            ObjectId objectId = new ObjectId(id);
            eskatzailea.setId(objectId);
    
            UpdateResult result = eskatzaileaCollection.replaceOne(
                eq("_id", objectId), 
                eskatzailea         
            );
            return result.getModifiedCount();
        } catch (IllegalArgumentException e) {
            System.err.println("ID inválido: " + id);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    
    @Override
    public long delete(String id) {
        DeleteResult result = eskatzaileaCollection.deleteMany(eq("_id", new ObjectId(id)));
        return result.getDeletedCount();
    }
}
