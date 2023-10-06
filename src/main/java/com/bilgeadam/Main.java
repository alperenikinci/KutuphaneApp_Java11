package com.bilgeadam;

import com.bilgeadam.controller.KitapController;
import com.bilgeadam.controller.KullaniciController;
import com.bilgeadam.controller.YazarController;
import com.bilgeadam.enums.ETur;
import com.bilgeadam.repository.entity.Kitap;
import com.bilgeadam.repository.entity.Kullanici;
import com.bilgeadam.repository.entity.Yazar;
import com.bilgeadam.utility.DataGenerator;
//import com.bilgeadam.utility.DataGenerator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    Scanner scanner;
    KitapController kitapController;
    KullaniciController kullaniciController;
    YazarController yazarController;

    public Main() {
        this.scanner = new Scanner(System.in);
        this.kitapController = new KitapController();
        this.kullaniciController = new KullaniciController();
        this.yazarController = new YazarController();
    }

    public static void main(String[] args) {
        DataGenerator dataGenerator = new DataGenerator();
        dataGenerator.verileriOlustur();


        Main main = new Main();
        main.libraryApp();
    }


    private List<Kitap> turuneGoreKitapAra() {
        Arrays.stream(ETur.values()).forEach(System.out::println);
        System.out.print("Lutfen bir tur seciniz : ");
        String tur = scanner.nextLine();
        return kitapController.tureGoreKitapBul(tur.toUpperCase());
    }

    public void libraryApp(){
        Integer secim = 0;
        do {
            secim = menu();
            switch(secim){
                case 1:{
                    Optional<Kullanici> kullanici = girisDogrulama();
                    if(kullanici.isPresent()){
                        kullanciMenusu(kullanici.get());
                    }
                    break;
                }
                case 2:{
                    kitapController.findAll().forEach(System.out::println);
                    break;
                }
                case 3:{
                    kitapController.stoktakiKitaplariGoruntule().forEach(System.out::println);
//                   kitapController.findAll().stream().filter(kitap -> kitap.getSatistaMi()==true).collect(Collectors.toList()).forEach(System.out::println);
                    break;
                }
                case 4:{
                    yazarController.findAll().forEach(System.out::println);
                    break;
                }
                case 5: {
                    kitapEkle();
                    break;
                }
                case 6: {
                    yazarEkle();
                    break;
                }
                case 7: {
                    kullaniciEkle();
                    break;
                }
                case 8: {
                    turuneGoreKitapAra().forEach(System.out::println);
                }
            }
        }while (secim!=0);
    }

    private Integer menu() {
        System.out.println("### Kutuphaneye Hosgeldiniz! ####");
        System.out.println("1- Giris Yap");
        System.out.println("2- Tum Kitaplari Goster");
        System.out.println("3- Stoktaki Kitaplar");
        System.out.println("4- Yazarlari Goster");
        System.out.println("5- Kitap Ekle");
        System.out.println("6- Yazar Ekle");
        System.out.println("7- Kullanici Ekle");
        System.out.println("8- Turune Gore Kitap Ara");
        System.out.println("0 - Cikis");
        System.out.print("Secim yapiniz : ");
        Integer secim = Integer.parseInt(scanner.nextLine());
        return secim;
    }

    private void kullaniciEkle() {
        System.out.print("Kullanici Adini Giriniz : ");
        String ad = scanner.nextLine();
        System.out.print("Kullanici Soyadini Giriniz : ");
        String soyad = scanner.nextLine();
        System.out.print("Kullanici TC Kimlik No Giriniz : ");
        String tcKimlik = scanner.nextLine();
        System.out.print("Kullanici Telefon No Giriniz : ");
        String telefonNo = scanner.nextLine();
        System.out.print("Kullanici Bakiyesini Giriniz : ");
        Double bakiye = Double.parseDouble(scanner.nextLine());

        Kullanici kullanici = Kullanici.builder()
                .ad(ad)
                .soyad(soyad)
                .tcKimlik(tcKimlik)
                .paraMiktari(bakiye)
                .telefonNo(telefonNo)
                .build();
        kullaniciController.save(kullanici);

        System.out.println("Kullanici basariyla kaydedildi... ");
    }
    private Yazar yazarEkle() {
        Yazar yazar;
        System.out.print("Yazar Adini Giriniz : ");
        String ad = scanner.nextLine();
        System.out.print("Yazar Soyadini Giriniz : ");
        String soyad = scanner.nextLine();
        System.out.print("Yazar Biyografisini Giriniz : ");
        String biyografi =scanner.nextLine();
        System.out.print("Yazar Ulkesini Giriniz : ");
        String ulke = scanner.nextLine();
        System.out.print("Yazarin Dogdugu Yili Giriniz : ");
        Integer yil= Integer.parseInt(scanner.nextLine());
        System.out.print("Yazarin Dogdugu Ayi Giriniz : ");
        Integer ay= Integer.parseInt(scanner.nextLine());
        System.out.print("Yazarin Dogdugu Gunu Giriniz : ");
        Integer gun = Integer.parseInt(scanner.nextLine());
        System.out.print("Yazar hala hayatta mi? (E/H) : ");
        if(scanner.nextLine().equalsIgnoreCase("H")){
            System.out.print("Yazarin Oldugu Yili Giriniz : ");
            Integer olumYil= Integer.parseInt(scanner.nextLine());
            System.out.print("Yazarin Oldugu Ayi Giriniz : ");
            Integer olumAy= Integer.parseInt(scanner.nextLine());
            System.out.print("Yazarin Oldugu Gunu Giriniz : ");
            Integer olumGun = Integer.parseInt(scanner.nextLine());

            yazar = Yazar.builder()
                    .ad(ad)
                    .soyad(soyad)
                    .biyografi(biyografi)
                    .ulke(ulke)
                    .dogumTarihi(LocalDate.of(yil,gun,ay))
                    .olumTarihi(LocalDate.of(olumYil,olumAy,olumGun))
                    .build();
        } else {
            yazar = Yazar.builder()
                    .ad(ad)
                    .soyad(soyad)
                    .biyografi(biyografi)
                    .ulke(ulke)
                    .dogumTarihi(LocalDate.of(yil,gun,ay))
                    .build();
        }
        System.out.println("Yazar basariyla eklendi...");
        return yazarController.save(yazar);

    }
    private Kitap kitapEkle() {
        System.out.print("Kitap Adini Giriniz : ");
        String kitapAdi = scanner.nextLine();
        System.out.print("Kitap Turunu Giriniz : ");
        String kitapTuru = scanner.nextLine();
        System.out.print("Kitap Adedini Giriniz : ");
        Integer kitapAdedi =Integer.parseInt(scanner.nextLine());
        System.out.print("Kitap Yayinevini Giriniz : ");
        String yayinEvi = scanner.nextLine();
        System.out.print("Kitap Yayinlanma Yilini Giriniz : ");
        Integer yayinlanmaYili= Integer.parseInt(scanner.nextLine());
        System.out.print("Kitap Yayinlanma Ayini Giriniz : ");
        Integer yayinlanmaAyi= Integer.parseInt(scanner.nextLine());
        System.out.print("Kitap Yayinlanma Gununu Giriniz : ");
        Integer yayinlanmaGunu= Integer.parseInt(scanner.nextLine());
        System.out.print("Kitap Fiyatini Giriniz : ");
        Double fiyat = Double.parseDouble(scanner.nextLine());
        System.out.print("Kitap ISBN Giriniz : ");
        String isbn= scanner.nextLine();
        System.out.print("Kitap Yazar Adini Giriniz : ");
        String yazarAdi= scanner.nextLine();
        System.out.print("Kitap Sayfa Sayisini Giriniz : ");
        Integer sayfaSayisi = Integer.parseInt(scanner.nextLine());


        Kitap kitap = Kitap.builder()
                .ad(kitapAdi)
                .tur(ETur.valueOf(kitapTuru))
                .adet(kitapAdedi)
                .yayinEvi(yayinEvi)
                .satistaMi(true)
                .yayinTarihi(LocalDate.of(yayinlanmaYili,yayinlanmaAyi,yayinlanmaGunu))
                .fiyat(fiyat)
                .isbn(isbn)
                .yazarAdi(yazarAdi)
                .sayfaSayisi(sayfaSayisi)
                .build();

        return kitapController.save(kitap);
    }

    private void kullanciMenusu(Kullanici kullanici) {
        Integer secim  =0;
        do {
            System.out.println("1- Kitap Satin Al");
            System.out.println("2- Bakiye Yukle");
            System.out.println("0- Cikis Yap");
            System.out.print("Secim yapiniz : ");
            secim = Integer.parseInt(scanner.nextLine());
            switch (secim){
                case 1 : {
                    kitapSatinAl(kullanici);
                    break;
                }
                case 2: {
                    bakiyeYukle(kullanici);
                    break;
                }
                case 0:{
                    break;
                }
            }

        }while (secim!=0);
    }

    private void bakiyeYukle(Kullanici kullanici) {
        System.out.print("Yuklemek istediginiz miktari giriniz : ");
        Double miktar = Double.parseDouble(scanner.nextLine());
        kullanici.setParaMiktari(kullanici.getParaMiktari()+miktar);
        kullaniciController.update(kullanici);
        System.out.println("Bakiye yukleme islemi basarili! Guncel bakiyeniz : " + kullanici.getParaMiktari());
    }

    private void kitapSatinAl(Kullanici kullanici) {
        List<Kitap> stoktakiKitaplar = kitapController.stoktakiKitaplariGoruntule();
        stoktakiKitaplar.forEach(kitap -> System.out.println("Kitap Numarasi : "+kitap.getId() +" Kitap Adi : "+ kitap.getAd()
                + " Yazar : "+kitap.getYazarAdi()+" Yayin Evi : "+kitap.getYayinEvi()));
        System.out.print("Lutfen satin almak istediginiz kitabin id'sini giriniz : ");
        Long kitapId = Long.parseLong(scanner.nextLine());
        Optional<Kitap> kitap = kitapController.findById(kitapId);
        if(kitap.isPresent() && kitap.get().getSatistaMi()==true){
            System.out.println("Satin almak istediginiz kitap : " + kitap.get().getAd() + " Fiyati : " + kitap.get().getFiyat()+" TL");
            if(kullanici.getParaMiktari()>=kitap.get().getFiyat()){
                kullanici.setParaMiktari(kullanici.getParaMiktari()-kitap.get().getFiyat());
                kitap.get().setAdet(kitap.get().getAdet()-1);
                if(kitap.get().getAdet()==0){
                    kitap.get().setSatistaMi(false);
                }
                kullaniciController.update(kullanici);
                kitapController.update(kitap.get());
                System.out.println(kitap.get().getAd()+ " Basariyla satin alinmistir... Guncel bakiyeniz : " + kullanici.getParaMiktari() + " TL'dir");
            } else {
                System.out.println("Yetersiz Bakiye!!!");
            }

        } else if(kitap.get().getSatistaMi()==false) {
            System.out.println("Istediginiz kitap stoklarimizda bulunmamaktadir.");
        } else {
            System.out.println("Girdiginiz kitap bulunmamaktadir.");
        }
    }

    private Optional<Kullanici> girisDogrulama() {
        System.out.print("Lutfen TC Kimlik Numaranizi giriniz : ");
        String tcKimlikNo = scanner.nextLine();
        Optional<Kullanici> kullanici = kullaniciController.tcKimligeGoreKullaniciBul(tcKimlikNo);
        if(kullanici.isPresent()){
            System.out.println("Hosgeldin " + kullanici.get().getAd());
        } else {
            System.out.println("Girdiginiz bilgilerle eslesen bir kullanici bulunmamaktadir. ");
        }
        return kullanici;
    }


}