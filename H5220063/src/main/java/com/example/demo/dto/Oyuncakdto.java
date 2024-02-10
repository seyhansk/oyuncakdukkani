package com.example.demo.dto;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data
public class Oyuncakdto {
    private Long ID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate alisTarihi;
    private Double alisFiyati;
    private String ad;
    private String tur;
    private Integer desi;
    private String notlar;
    public Oyuncakdto(Long ID, LocalDate alisTarihi, Double alisFiyati, String ad, String tur, Integer desi, String notlar) {
        this.ID= ID;
        this.ad = ad;
        this.alisTarihi = alisTarihi;
        this.alisFiyati = alisFiyati;
        this.tur = tur;
        this.desi = desi;
        this.notlar = notlar;
    }
}
