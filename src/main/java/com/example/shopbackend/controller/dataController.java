package com.example.shopbackend.controller;

import com.example.shopbackend.model.shop;
import com.example.shopbackend.repository.dataRepository;
import com.example.shopbackend.repository.fetaureRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/")
public class dataController {

    @Autowired
    private dataRepository dataRep;
    @Autowired
    private fetaureRepository fetRep;

    @PostMapping("addItems")
    public shop shopAdd(@Valid @RequestBody shop shopAdd){
        return dataRep.save(shopAdd);
    }

    @GetMapping("showAll")
    public List<shop> showData(){
        return dataRep.all_Data();
    }

    @GetMapping("item_price")
    public List<Object[]> products(){
        return dataRep.select_Data();
    }

    @GetMapping("sale")
    public List<Object[]> sales(){
        return dataRep.sale_Data();
    }

    public boolean featuerValue(){
        return fetRep.saleValue();
    }

    @GetMapping("feature")
    public List<Object[]> feature(){
        if (featuerValue() == true){
            return products();
        } else {
            return sales();
        }
    }




}
