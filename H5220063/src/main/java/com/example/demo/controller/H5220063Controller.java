package com.example.demo.controller;
import com.example.demo.dto.Oyuncakdto;
import com.example.demo.entity.Oyuncak;
import com.example.demo.service.OyuncakService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class H5220063Controller {
    @Autowired
    OyuncakService oyuncakService;

    @PostMapping("/ekle")
    public String ekle(@RequestBody Oyuncakdto oyuncakdto) {
        log.info("Ekle servisi çağırıldı. İsteğin geldiği zaman: " + LocalDateTime.now());
        try {
            Oyuncak oyuncak = new Oyuncak();
            oyuncak.setAd(oyuncakdto.getAd());
            oyuncak.setAlisTarihi(oyuncakdto.getAlisTarihi());
            oyuncak.setAlisFiyati(oyuncakdto.getAlisFiyati());
            oyuncak.setTur(oyuncakdto.getTur());
            oyuncak.setDesi(oyuncakdto.getDesi());
            oyuncak.setNotlar(oyuncakdto.getNotlar());
            Oyuncak eklenmisOyuncak = oyuncakService.ekle(oyuncak);
            return eklenmisOyuncak.getAd() + " adıyla yeni bir oyuncak eklendi";

        } catch (Exception e) {
            log.error("Ekle servisi çalışırken hata oluştu."
            +"Parametreler:" + oyuncakdto
            +"Hata:" + e.getMessage());
        }
        return null;
    }


    @GetMapping("/getir")
    public ResponseEntity<String> getir(@RequestParam Long id) {

        log.info("Getir servisi çağırıldı. İsteğin geldiği zaman: " + LocalDateTime.now());

        Oyuncak oyuncak = oyuncakService.getir(id);

        if (oyuncak != null) {
            return ResponseEntity.ok("Oyuncak Bilgileri: " +
                    "\nID: " + oyuncak.getID() +
                    "\nAd: " + oyuncak.getAd() +
                    "\nAlış Tarihi: " + oyuncak.getAlisTarihi() +
                    "\nAlış Fiyatı: " + oyuncak.getAlisFiyati() +
                    "\nTür: " + oyuncak.getTur() +
                    "\nDesi: " + oyuncak.getDesi() +
                    "\nNotlar: " + oyuncak.getNotlar());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Oyuncak bulunamadı. ID: " + id);
        }
    }

    @Transactional
    @PutMapping("/guncelle/{id}")
    public Oyuncakdto guncelle(@PathVariable Long id, @RequestBody Oyuncakdto oyuncakdto) {
        log.info("Güncelle servisi çağırıldı. İsteğin geldiği zaman: " + LocalDateTime.now());
        Oyuncak oyuncak = oyuncakService.getir(id);
        oyuncak.setAlisTarihi(oyuncakdto.getAlisTarihi());
        oyuncak.setAlisFiyati(oyuncakdto.getAlisFiyati());
        oyuncak.setAd(oyuncakdto.getAd());
        oyuncak.setTur(oyuncakdto.getTur());
        oyuncak.setDesi(oyuncakdto.getDesi());
        oyuncak.setNotlar(oyuncakdto.getNotlar());

        return new Oyuncakdto(
                oyuncak.getID(),
                oyuncak.getAlisTarihi(),
                oyuncak.getAlisFiyati(),
                oyuncak.getAd(),
                oyuncak.getTur(),
                oyuncak.getDesi(),
                oyuncak.getNotlar()
        );
    }
    @DeleteMapping("/sil")
    public String sil(Long id){
        log.info("Sil servisi çağırıldı. İsteğin geldiği zaman: " + LocalDateTime.now());
        oyuncakService.sil(id);
        return "Oyuncak bilgisi silindi.";
    }

    @GetMapping("/listele")
    public List<Oyuncakdto> listele(){
        log.info("Listele servisi çağırıldı. İsteğin geldiği zaman: " + LocalDateTime.now());
        List<Oyuncak> oyuncakListesi= oyuncakService.listele();
        List<Oyuncakdto> tumOyuncaklar = new ArrayList<>();
        for (Oyuncak k: oyuncakListesi){
            Oyuncakdto kdto = new Oyuncakdto(k.getID(),k.getAlisTarihi(),k.getAlisFiyati(),k.getAd(),k.getTur(),k.getDesi(),k.getNotlar());
            tumOyuncaklar.add(kdto);
        }
     return tumOyuncaklar;
    }
}

