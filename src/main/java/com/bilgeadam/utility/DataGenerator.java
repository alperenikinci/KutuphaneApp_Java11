package com.bilgeadam.utility;

import com.bilgeadam.controller.KitapController;
import com.bilgeadam.controller.KullaniciController;
import com.bilgeadam.controller.YazarController;
import com.bilgeadam.enums.ETur;
import com.bilgeadam.repository.entity.Kitap;
import com.bilgeadam.repository.entity.Kullanici;
import com.bilgeadam.repository.entity.Yazar;

import java.time.LocalDate;
import java.util.List;

public class DataGenerator {

    KullaniciController kullaniciController;
    KitapController kitapController;
    YazarController yazarController;

    public DataGenerator(){
        this.kullaniciController = new KullaniciController();
        this.kitapController = new KitapController();
        this.yazarController = new YazarController();
    }

    public void verileriOlustur(){
       List<Kullanici> kullaniciList = kullaniciOlustur();
       List<Yazar> yazarList = yazarOlustur();
       List<Kitap> kitapList =kitapOlustur(yazarList);
       yazarKitaplariniGuncelle(kitapList,yazarList);
    }
    public List<Kullanici> kullaniciOlustur(){
        Kullanici kullanici1 = Kullanici.builder()
                .ad("Alperen")
                .soyad("Ikinci")
                .tcKimlik("12345678910")
                .paraMiktari(150D)
                .telefonNo("+905341235918")
                .build();
        Kullanici kullanici2 = Kullanici.builder()
                .ad("Mustafa")
                .soyad("Ozturk")
                .tcKimlik("02345678911")
                .paraMiktari(50D)
                .telefonNo("+905123785918")
                .build();
        Kullanici kullanici3 = Kullanici.builder()
                .ad("Cagri")
                .soyad("Turkmen")
                .tcKimlik("01345678912")
                .paraMiktari(300D)
                .telefonNo("+905341239918")
                .build();
        Kullanici kullanici4 = Kullanici.builder()
                .ad("Murat")
                .soyad("Ates")
                .tcKimlik("45678910123")
                .paraMiktari(70D)
                .telefonNo("+905371245918")
                .build();
        return kullaniciController.saveAll(List.of(kullanici1,kullanici2,kullanici3,kullanici4));
    }
    public List<Yazar> yazarOlustur(){
        Yazar yazar1 = Yazar.builder()
                .ad("Fyodor Mihaylovic")
                .soyad("Dostoyevski")
                .biyografi("Biyografi bilgilendirmesi...")
                .ulke("Rusya")
                .dogumTarihi(LocalDate.of(1821,11,11))
                .olumTarihi(LocalDate.of(1881,2,9))
                .build();
        Yazar yazar2 = Yazar.builder()
                .ad("Lev Nikolayevich ")
                .soyad("Tolstoy")
                .biyografi("Biyografi bilgilendirmesi...")
                .ulke("Rusya")
                .dogumTarihi(LocalDate.of(1828,9,9))
                .olumTarihi(LocalDate.of(1910,11,20))
                .build();
        Yazar yazar3 = Yazar.builder()
                .ad("J.R.R")
                .soyad("Tolkien")
                .biyografi("Biyografi bilgilendirmesi...")
                .ulke("Ingiltere")
                .dogumTarihi(LocalDate.of(1892,1,3))
                .olumTarihi(LocalDate.of(1973,9,2))
                .build();

        Yazar yazar4 = Yazar.builder()
                .ad("Frank")
                .soyad("Herbert")
                .biyografi("Biyografi bilgilendirmesi...")
                .ulke("Amerika")
                .dogumTarihi(LocalDate.of(1920,10,8))
                .olumTarihi(LocalDate.of(1986,2,11))
                .build();

        Yazar yazar5 = Yazar.builder()
                .ad("Jordan B.")
                .soyad("Peterson")
                .biyografi("Biyografi bilgilendirmesi...")
                .ulke("Kanada")
                .dogumTarihi(LocalDate.of(1962,6,12))
                .build();

       return yazarController.saveAll(List.of(yazar1,yazar2,yazar3,yazar4,yazar5));
    }
    public List<Kitap> kitapOlustur(List<Yazar> yazarList){
       Kitap kitap1 = Kitap.builder()
                .ad("Suc ve Ceza")
                .tur(ETur.ROMAN)
                .adet(10)
                .yayinEvi("İş Bankası Yayınları")
                .satistaMi(true)
                .yayinTarihi(LocalDate.of(1990,01,01))
                .fiyat(140D)
                .isbn("1231234-1234")
                .yazarAdi(yazarList.get(0).getAd()+" "+ yazarList.get(0).getSoyad())
                .sayfaSayisi(750)
                .yazarId(yazarList.get(0).getId())
                .build();
        Kitap kitap2 = Kitap.builder()
                .ad("Karamazov Kardeşler")
                .tur(ETur.ROMAN)
                .adet(15)
                .yayinEvi("İş Bankası Yayınları")
                .satistaMi(true)
                .yayinTarihi(LocalDate.of(2000,01,01))
                .fiyat(50D)
                .isbn("12312-4534-1234")
                .yazarAdi(yazarList.get(0).getAd()+" "+ yazarList.get(0).getSoyad())
                .sayfaSayisi(600)
                .yazarId(yazarList.get(0).getId())
                .build();

        Kitap kitap3 = Kitap.builder()
                .ad("Insan Ne Ile Yasar?")
                .tur(ETur.KLASIK)
                .adet(50)
                .yayinEvi("İş Bankası Yayınları")
                .satistaMi(true)
                .yayinTarihi(LocalDate.of(1970,01,01))
                .fiyat(30D)
                .isbn("12312-4534-1234-16523")
                .yazarAdi(yazarList.get(1).getAd()+" "+ yazarList.get(1).getSoyad())
                .sayfaSayisi(150)
                .yazarId(yazarList.get(1).getId())
                .build();

        Kitap kitap4 = Kitap.builder()
                .ad("Savaş ve Barış")
                .tur(ETur.KLASIK)
                .adet(50)
                .yayinEvi("İş Bankası Yayınları")
                .satistaMi(true)
                .yayinTarihi(LocalDate.of(1970,01,01))
                .fiyat(150D)
                .isbn("12312-4534-1234-123")
                .yazarAdi(yazarList.get(1).getAd()+" "+ yazarList.get(1).getSoyad())
                .sayfaSayisi(950)
                .yazarId(yazarList.get(1).getId())
                .build();

        Kitap kitap5 = Kitap.builder()
                .ad("Silmarillion")
                .tur(ETur.FANTASTIK)
                .adet(50)
                .yayinEvi("Marti Yayinlari")
                .satistaMi(true)
                .yayinTarihi(LocalDate.of(1980,03,13))
                .fiyat(110D)
                .isbn("12312-41534-1234-123")
                .yazarAdi(yazarList.get(2).getAd()+" "+ yazarList.get(2).getSoyad())
                .sayfaSayisi(600)
                .yazarId(yazarList.get(2).getId())
                .build();
        Kitap kitap6 = Kitap.builder()
                .ad("Hobbit")
                .tur(ETur.FANTASTIK)
                .adet(40)
                .yayinEvi("Marti Yayinlari")
                .satistaMi(true)
                .yayinTarihi(LocalDate.of(1970,11,13))
                .fiyat(100D)
                .isbn("12312-41534-16234-1123")
                .yazarAdi(yazarList.get(2).getAd()+" "+ yazarList.get(2).getSoyad())
                .sayfaSayisi(800)
                .yazarId(yazarList.get(2).getId())
                .build();

        Kitap kitap7 = Kitap.builder()
                .ad("Dune")
                .tur(ETur.FANTASTIK)
                .adet(20)
                .yayinEvi("Kaos Yayinlari")
                .satistaMi(true)
                .yayinTarihi(LocalDate.of(1965,6,6))
                .fiyat(70D)
                .isbn("12312-417534-1234-1123-1234")
                .yazarAdi(yazarList.get(3).getAd()+" "+ yazarList.get(3).getSoyad())
                .sayfaSayisi(500)
                .yazarId(yazarList.get(3).getId())
                .build();

        Kitap kitap8 = Kitap.builder()
                .ad("Dune Tanrı İmparatoru")
                .tur(ETur.FANTASTIK)
                .adet(10)
                .yayinEvi("Kaos Yayinlari")
                .satistaMi(true)
                .yayinTarihi(LocalDate.of(1965,6,6))
                .fiyat(60D)
                .isbn("12312-41534-1234-11723-12334")
                .yazarAdi(yazarList.get(3).getAd()+" "+ yazarList.get(3).getSoyad())
                .sayfaSayisi(700)
                .yazarId(yazarList.get(3).getId())
                .build();

        Kitap kitap9 = Kitap.builder()
                .ad("Hayat İçin 12 Kural")
                .tur(ETur.KISISEL_GELISIM)
                .adet(10)
                .yayinEvi("Pegasus Yayinlari")
                .satistaMi(true)
                .yayinTarihi(LocalDate.of(1965,6,6))
                .fiyat(85D)
                .isbn("12312-41534-1158234-11723-12334")
                .yazarAdi(yazarList.get(4).getAd()+" "+ yazarList.get(4).getSoyad())
                .sayfaSayisi(545)
                .yazarId(yazarList.get(4).getId())
                .build();

        Kitap kitap10 = Kitap.builder()
                .ad("Hayat İçin 12 Kural Daha")
                .tur(ETur.KISISEL_GELISIM)
                .adet(15)
                .yayinEvi("Pegasus Yayinlari")
                .satistaMi(true)
                .yayinTarihi(LocalDate.of(1965,6,6))
                .fiyat(65D)
                .isbn("12312-415434-1123164-11523-12334")
                .yazarAdi(yazarList.get(4).getAd()+" "+ yazarList.get(4).getSoyad())
                .sayfaSayisi(415)
                .yazarId(yazarList.get(4).getId())
                .build();

        return kitapController.saveAll(List.of(kitap1,kitap2,kitap3,kitap4,kitap5,kitap6,kitap7,kitap8,kitap9,kitap10));
    }

    public void yazarKitaplariniGuncelle(List<Kitap> kitapList,List<Yazar> yazarList){

        Yazar yazar1 = yazarList.get(0);
        Yazar yazar2 = yazarList.get(1);
        Yazar yazar3 = yazarList.get(2);
        Yazar yazar4 = yazarList.get(3);
        Yazar yazar5 = yazarList.get(4);

        yazar1.setKitaplari(List.of(kitapList.get(0).getAd(),kitapList.get(1).getAd()));
        yazar2.setKitaplari(List.of(kitapList.get(2).getAd(),kitapList.get(3).getAd()));
        yazar3.setKitaplari(List.of(kitapList.get(4).getAd(),kitapList.get(5).getAd()));
        yazar4.setKitaplari(List.of(kitapList.get(6).getAd(),kitapList.get(7).getAd()));
        yazar5.setKitaplari(List.of(kitapList.get(8).getAd(),kitapList.get(9).getAd()));
        yazarController.update(yazar1);
        yazarController.update(yazar2);
        yazarController.update(yazar3);
        yazarController.update(yazar4);
        yazarController.update(yazar5);
    }
}
