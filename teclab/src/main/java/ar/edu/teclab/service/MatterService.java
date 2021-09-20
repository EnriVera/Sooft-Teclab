package ar.edu.teclab.service;

import ar.edu.teclab.entity.Matter_entity;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatterService {
    private List<Matter_entity> matter = new ArrayList<Matter_entity>();
    public void AddMatter(String name) {
        Matter_entity Matter = new Matter_entity();
        Matter.setID_matter((long)(Math.random() * 10000));
        Matter.setName(name);
        this.matter.add(Matter);
    }
    public List<Matter_entity> getAllMatter() {
        return this.matter;
    }

    public Matter_entity GetOneMatter(Long id) {
        return this.matter.stream().filter( (Matter_entity e) -> e.getID_matter() == id).findFirst().get();
    }
}
