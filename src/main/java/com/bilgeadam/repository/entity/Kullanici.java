package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_kullanici")
@Entity
public class Kullanici {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 30)
    private String ad;
    @Column(nullable = false,length = 30)
    private String soyad;
    @Column(nullable = false,unique = true, length = 11)
    private String tcKimlik;

    @Column(nullable = false,unique = true)
    private String telefonNo;

    @Column(nullable = false)
    private Double paraMiktari;

}
