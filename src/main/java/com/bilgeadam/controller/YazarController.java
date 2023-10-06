package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.Yazar;
import com.bilgeadam.service.YazarService;

import java.util.List;
import java.util.Optional;

public class YazarController {

    YazarService yazarService;
    public YazarController(){
        this.yazarService = new YazarService();
    }


    public void update(Yazar yazar){
        yazarService.update(yazar);
    }



    public List<Yazar> saveAll(List<Yazar> yazarList){
        return yazarService.saveAll(yazarList);
    }

    public List<Yazar> findAll() {
        return yazarService.findAll();
}

    public Yazar save(Yazar yazar) {
        return  yazarService.save(yazar);
    }
}
