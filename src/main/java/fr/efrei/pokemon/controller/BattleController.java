package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Battle;
import fr.efrei.pokemon.services.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/battles")
public class BattleController {

    private final BattleService service;

    @Autowired
    public BattleController(BattleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Battle>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Battle> findById(@PathVariable String id) {
        Battle battle = service.findById(id);
        if (battle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(battle, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Battle battle) {
        service.save(battle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Battle> update(@PathVariable String id, @RequestBody Battle battle) {
        Battle existingBattle = service.findById(id);
        if (existingBattle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, battle);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Battle battle = service.findById(id);
        if (battle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
