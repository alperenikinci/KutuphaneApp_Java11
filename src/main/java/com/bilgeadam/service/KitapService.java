package com.bilgeadam.service;

import com.bilgeadam.repository.KitapRepository;
import com.bilgeadam.repository.entity.Kitap;

import java.util.List;
import java.util.Optional;

public class KitapService {

    KitapRepository kitapRepository;

    public KitapService(){
        this.kitapRepository = new KitapRepository();
    }

    public Kitap save(Kitap kitap){
        return kitapRepository.save(kitap);
    }

    public void update(Kitap kitap){
        kitapRepository.update(kitap);
    }

    public List<Kitap> findAll(){
        return kitapRepository.findAll();
    }

    public Optional<Kitap> findById(Long id){
        return kitapRepository.findById(id);
    }

    public List<Kitap> saveAll(List<Kitap> kitapList){
        return (List<Kitap>) kitapRepository.saveAll(kitapList);
    }

    public void delete(Kitap kitap){
        kitapRepository.delete(kitap);
    }

    public void deleteById(Long id){
        kitapRepository.deleteById(id);
    }

    public boolean existById(Long id){
        return kitapRepository.existById(id);
    }

    public List<Kitap> findByEntity(Kitap kitap){
        return kitapRepository.findByEntity(kitap);
    }

    public List<Kitap> findByColumnNameAndValue(String columnName, String columnValue){
        return kitapRepository.findByColumnNameAndValue(columnName, columnValue);
    }

    public List<Kitap> stoktakiKitaplariGoruntule() {
        return kitapRepository.stoktakiKitaplariGoruntule();
    }

    public List<Kitap> tureGoreKitapBul(String tur) {
        return  kitapRepository.tureGoreKitapBul(tur);
    }
}
