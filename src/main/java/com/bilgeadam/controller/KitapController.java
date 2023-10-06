package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.Kitap;
import com.bilgeadam.service.KitapService;

import java.util.List;
import java.util.Optional;

public class KitapController {

    KitapService kitapService;

    public KitapController(){
        this.kitapService = new KitapService();
    }

    public List<Kitap> saveAll(List<Kitap> kitapList){
        return (List<Kitap>) kitapService.saveAll(kitapList);
    }

    public List<Kitap> findAll() {
        return kitapService.findAll();
    }

    public List<Kitap> stoktakiKitaplariGoruntule() {
        return kitapService.stoktakiKitaplariGoruntule();
    }

    public Kitap save(Kitap kitap) {
        return kitapService.save(kitap);
    }

    public List<Kitap> tureGoreKitapBul(String tur) {
        return kitapService.tureGoreKitapBul(tur);
    }

    public Optional<Kitap> findById(Long kitapId) {
        return kitapService.findById(kitapId);
    }

    public void update(Kitap kitap) {
        kitapService.update(kitap);
    }
}
