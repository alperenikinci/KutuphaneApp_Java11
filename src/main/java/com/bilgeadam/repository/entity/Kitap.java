package com.bilgeadam.repository.entity;

import com.bilgeadam.enums.ETur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_kitap")
@Entity
public class Kitap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 60)
    String ad;
    @Column(nullable = true)
    Long yazarId;
    @Column(nullable = false)
    String yazarAdi;
    @Enumerated(EnumType.STRING)
    ETur tur;
    @Column(nullable = false)
    Integer sayfaSayisi;
    String yayinEvi;
    @Builder.Default
    LocalDate yayinTarihi = LocalDate.now();
    @Column(unique = true)
    String isbn;
    @Builder.Default
    Integer adet = 0;
    @Builder.Default
    Double fiyat = 0D;
    @Builder.Default
    Boolean satistaMi = false;
}
