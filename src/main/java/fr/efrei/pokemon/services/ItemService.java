package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Item;
import fr.efrei.pokemon.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Trouver tout les objets
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    // Trouver par ID
    public Item findById(String id) {
        return itemRepository.findById(id).orElse(null);
    }

    // Sauvegarder un objet
    public void save(Item item) {
        itemRepository.save(item);
    }

    // Supprimer un objet
    public void delete(String id) {
        itemRepository.deleteById(id);
    }

    // Mettre à jour un objet
    public void update(String id, Item itemBody) {
        Item existingItem = findById(id);
        existingItem.setName(itemBody.getName());
        existingItem.setType(itemBody.getType());
        existingItem.setDescription(itemBody.getDescription());
        itemRepository.save(existingItem);
    }
}
