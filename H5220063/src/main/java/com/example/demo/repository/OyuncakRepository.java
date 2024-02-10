package com.example.demo.repository;
import com.example.demo.entity.Oyuncak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OyuncakRepository extends JpaRepository<Oyuncak,Long> {

}
