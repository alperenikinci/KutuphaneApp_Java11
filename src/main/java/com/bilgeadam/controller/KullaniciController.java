package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.Kullanici;
import com.bilgeadam.service.KullaniciService;

import java.util.List;
import java.util.Optional;

public class KullaniciController {

    KullaniciService kullaniciService;

    public KullaniciController(){
        this.kullaniciService = new KullaniciService();
    }
    public List<Kullanici> saveAll(List<Kullanici> kullaniciList){
        return (List<Kullanici>) kullaniciService.saveAll(kullaniciList);
    }


    public Optional<Kullanici> tcKimligeGoreKullaniciBul(String tcKimlikNo) {
        return kullaniciService. tcKimligeGoreKullaniciBul(tcKimlikNo);
    }

    public Kullanici save(Kullanici kullanici) {
        return kullaniciService.save(kullanici);
    }

    public void update(Kullanici kullanici){
        kullaniciService.update(kullanici);
    }
}
