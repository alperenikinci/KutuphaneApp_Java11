package com.bilgeadam.service;


import com.bilgeadam.repository.KullaniciRepository;
import com.bilgeadam.repository.entity.Kullanici;

import java.util.List;
import java.util.Optional;

public class KullaniciService {

    KullaniciRepository kullaniciRepository;

    public KullaniciService(){
        this.kullaniciRepository = new KullaniciRepository();
    }


    public Kullanici save(Kullanici kullanici){
        return kullaniciRepository.save(kullanici);
    }

    public void update(Kullanici kullanici){
        kullaniciRepository.update(kullanici);
    }

    public List<Kullanici> findAll(){
        return kullaniciRepository.findAll();
    }

    public Optional<Kullanici> findById(Long id){
        return kullaniciRepository.findById(id);
    }

    public List<Kullanici> saveAll(List<Kullanici> kullaniciList){
        return (List<Kullanici>) kullaniciRepository.saveAll(kullaniciList);
    }

    public void delete(Kullanici kullanici){
        kullaniciRepository.delete(kullanici);
    }

    public void deleteById(Long id){
        kullaniciRepository.deleteById(id);
    }

    public boolean existById(Long id){
        return kullaniciRepository.existById(id);
    }

    public List<Kullanici> findByEntity(Kullanici kullanici){
        return kullaniciRepository.findByEntity(kullanici);
    }

    public List<Kullanici> findByColumnNameAndValue(String columnName, String columnValue){
        return kullaniciRepository.findByColumnNameAndValue(columnName, columnValue);
    }

    public Optional<Kullanici> tcKimligeGoreKullaniciBul(String tcKimlikNo) {
        return kullaniciRepository.tcKimligeGoreKullaniciBul(tcKimlikNo);
    }
}
