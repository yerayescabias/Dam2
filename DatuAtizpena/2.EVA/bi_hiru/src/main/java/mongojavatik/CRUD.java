package mongojavatik;

import java.util.Scanner;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class CRUD {

    public static void main(String[] args) {

        // Reemplaza con tu cadena de conexión MongoDB
        String uri = "mongodb://localhost:27017/";

        // Instanciamos MongoClient
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Gabonak_database");
            MongoCollection<Document> collection = database.getCollection("eskatzaileak");

            System.out.println("MONGO MENU\n================\n1.FIND\n2.INSERT\n3.DELETE\n");
            Scanner sc = new Scanner(System.in);
            System.out.println("Zer egin nahi duzu? ");
            int option = sc.nextInt();

            while (option >= 1 && option <= 3) {
                switch (option) {
                    case 1:
                        find(collection);
                        break;
                    case 2:
                        insert(collection);
                        break;
                    case 3:
                        delete(collection);
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a valid operation.");
                }

                // Ask user again for next operation
                System.out.println("\nMONGO MENU\n================\n1. FIND\n2. INSERT\n3. DELETE\n");
                option = sc.nextInt();
            }

            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void find(MongoCollection<Document> collection) {
        System.out.println("FIND OPERATION\n====================\n\n");
        try {
            FindIterable<Document> result = collection.find();
            for (Document doc : result) {
                System.out.println(doc.toJson());
            }
        } catch (Exception e) {
            System.out.println("Error occur during the Find");
        }

    }

    public static void insert(MongoCollection<Document> collection) {
        System.out.println("INSERT OPERATION\n====================\n\n");
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter name: ");
            String name = sc.next();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            Document newDocument = new Document("name", name).append("age", age);
            collection.insertOne(newDocument);
            System.out.println("Document inserted successfully!");
            sc.close();
        } catch (Exception e) {
            System.out.println("Error during the insert");
        }

    }

    public static void delete(MongoCollection<Document> collection) {
        System.out.println("DELETE OPERATION\n====================\n\n");
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter name to delete: ");
            String nameToDelete = sc.next();
            collection.deleteOne(Filters.eq("name", nameToDelete));
            System.out.println("Document with name " + nameToDelete + " deleted.");
            sc.close();
        } catch (Exception e) {
            System.out.println("Error during the delete");
        }

    }
}
