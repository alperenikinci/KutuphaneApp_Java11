package com.bilgeadam.service;

import com.bilgeadam.repository.YazarRepository;
import com.bilgeadam.repository.entity.Yazar;

import java.util.List;
import java.util.Optional;

public class YazarService {

    YazarRepository yazarRepository;

    public YazarService(){
        this.yazarRepository = new YazarRepository();
    }

    public Yazar save(Yazar yazar){
        return yazarRepository.save(yazar);
    }

    public void update(Yazar yazar){
        yazarRepository.update(yazar);
    }

    public List<Yazar> findAll(){
        return yazarRepository.findAll();
    }

    public Optional<Yazar> findById(Long id){
        return yazarRepository.findById(id);
    }

    public List<Yazar> saveAll(List<Yazar> yazarList){
        return (List<Yazar>) yazarRepository.saveAll(yazarList);
    }

    public void delete(Yazar yazar){
        yazarRepository.delete(yazar);
    }

    public void deleteById(Long id){
        yazarRepository.deleteById(id);
    }

    public boolean existById(Long id){
        return yazarRepository.existById(id);
    }

    public List<Yazar> findByEntity(Yazar yazar){
        return yazarRepository.findByEntity(yazar);
    }

    public List<Yazar> findByColumnNameAndValue(String columnName, String columnValue){
        return yazarRepository.findByColumnNameAndValue(columnName, columnValue);
    }
}
