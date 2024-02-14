package com.example.shopbackend.controller;

import com.example.shopbackend.model.shop;
import com.example.shopbackend.repository.dataRepository;
import com.example.shopbackend.repository.shopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class dataController {

    @Autowired
    private dataRepository dataRep;

    @PostMapping("addItems")
    public shop shopAdd(@RequestBody shop shopAdd){
        return dataRep.save(shopAdd);
    }

    @GetMapping("showAll")
    public List<shop> showData(){
        return dataRep.allData();
    }
}
