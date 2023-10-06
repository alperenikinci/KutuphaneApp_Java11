package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_yazar")
@Entity
public class Yazar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 30)
    private String ad;
    @Column(nullable = false,length = 30)
    private String soyad;
    private LocalDate dogumTarihi;
    private LocalDate olumTarihi;
    private String ulke;
    private String biyografi;
    @ElementCollection
    private List<String> kitaplari;
}
