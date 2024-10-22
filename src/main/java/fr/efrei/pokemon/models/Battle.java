package fr.efrei.pokemon.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Battle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String pokemon1Id; // ID du premier pokemon
    private String pokemon2Id; // ID du deuxieme pokemon
    private String winnerId;    // ID du gagnant

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPokemon1Id() {
        return pokemon1Id;
    }

    public void setPokemon1Id(String pokemon1Id) {
        this.pokemon1Id = pokemon1Id;
    }

    public String getPokemon2Id() {
        return pokemon2Id;
    }

    public void setPokemon2Id(String pokemon2Id) {
        this.pokemon2Id = pokemon2Id;
    }

    public String getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(String winnerId) {
        this.winnerId = winnerId;
    }
}
