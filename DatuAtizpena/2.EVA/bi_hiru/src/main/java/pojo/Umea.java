package pojo;

import org.bson.types.ObjectId;

public class Umea {
          private ObjectId id;
          private String name;
          private String oparia;
          
        public Umea() {
        }
        public Umea(ObjectId id, String name, String oparia) {
            this.id = id;
            this.name = name;
            this.oparia = oparia;
        }
        public ObjectId getId() {
            return id;
        }
        public void setId(ObjectId id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getOparia() {
            return oparia;
        }
        public void setOparia(String oparia) {
            this.oparia = oparia;
        }   
}
