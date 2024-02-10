package com.example.demo.service;
import com.example.demo.entity.Oyuncak;
import com.example.demo.repository.OyuncakRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@Component
public class OyuncakServicelmpl implements OyuncakService{

    @Autowired
    OyuncakRepository oyuncakRepository;
    @Override
    public Oyuncak getir(Long id) {
        return oyuncakRepository.getReferenceById(id);
    }

    @Override
    public Oyuncak ekle(Oyuncak oyuncak) {
        return oyuncakRepository.save(oyuncak);
    }

    @Override
    public List<Oyuncak> listele() {
        return oyuncakRepository.findAll();
    }

    @Override
    public Oyuncak guncelle(Oyuncak oyuncak) {
        return oyuncakRepository.save(oyuncak);
    }

    @Override
    public void sil(Long id) {
        oyuncakRepository.deleteById(id);
    }
}
