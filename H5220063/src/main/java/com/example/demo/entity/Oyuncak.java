package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Oyuncak {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private LocalDate alisTarihi;
    private Double alisFiyati;
    private String ad;
    private String tur;
    private Integer desi;
    private String notlar;

}
