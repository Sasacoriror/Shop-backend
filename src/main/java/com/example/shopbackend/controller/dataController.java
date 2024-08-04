package com.example.shopbackend.controller;

import com.example.shopbackend.model.shop;
import com.example.shopbackend.repository.dataRepository;
import com.example.shopbackend.repository.fetaureRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.URI;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("api/")
public class dataController {

    @Autowired
    private dataRepository dataRep;
    @Autowired
    private fetaureRepository fetRep;

    @PostMapping("add")
    public ResponseEntity<shop> shopAdd(@Valid @RequestBody shop shopAdd){
        shop shop = dataRep.save(shopAdd);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(shop.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("showAll")
    public List<shop> showData(){
        return dataRep.all_Data();
    }

    @GetMapping( "add/{id}")
    public EntityModel<shop> getItemById(@PathVariable long id){
        Optional<shop> shop = dataRep.findById(id);

        if(shop.isEmpty()){
            throw new RuntimeException("id: "+id);
        }

        EntityModel<shop> entityModel = EntityModel.of(shop.get());
        WebMvcLinkBuilder link = linkTo(methodOn(dataController.class).showData());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable long id){
        dataRep.deleteById(id);
    }

    public boolean featuerValue(){
        return fetRep.saleValue();
    }

    @GetMapping("feature")
    public List<Object[]> feature(){
        if (featuerValue() == true){
            return dataRep.select_Data();
        } else {
            return dataRep.sale_Data();
        }
    }
}
