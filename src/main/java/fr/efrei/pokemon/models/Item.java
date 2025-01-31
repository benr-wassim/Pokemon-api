package fr.efrei.pokemon.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String type;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id){

        this.id = id;
    }

    public String getName() {
        return name;

    }


    public void setName(String name){

        this.name = name;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getDescription() {
        return description;

    }

    public void setDescription(String description) {
        this.description = description;

    }
}
