package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Battle;
import fr.efrei.pokemon.repositories.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleService {

    private final BattleRepository battleRepository;

    @Autowired
    public BattleService(BattleRepository battleRepository) {

        this.battleRepository = battleRepository;
    }


    public List<Battle> findAll(){
        return battleRepository.findAll();

    }


    public Battle findById(String id) {
        return battleRepository.findById(id).orElse(null);
    }



    public void save(Battle battle){
        battleRepository.save(battle);

    }


    public void delete(String id){
        battleRepository.deleteById(id); }


    public void update(String id, Battle battleBody) {
        Battle existingBattle = findById(id);
        existingBattle.setPokemon1Id(battleBody.getPokemon1Id());
        existingBattle.setPokemon2Id(battleBody.getPokemon2Id());
        existingBattle.setWinnerId(battleBody.getWinnerId());
        battleRepository.save(existingBattle);
    }
}
