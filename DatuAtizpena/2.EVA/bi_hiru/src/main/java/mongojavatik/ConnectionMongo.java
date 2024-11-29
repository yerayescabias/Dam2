package mongojavatik;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class ConnectionMongo {
    
    public static void main( String[] args ) {

        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb://localhost:27017/";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Gabonak_database");
            MongoCollection<Document> collection = database.getCollection("eskatzaileak");
            //System.out.println("\n\n\n\n\n\taasdas");
            Document doc = collection.find(eq("izena", "Pepa")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
            
        }
         catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
}
