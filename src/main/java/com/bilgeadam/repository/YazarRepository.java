package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Yazar;
import com.bilgeadam.utility.MyFactoryRepository;

public class YazarRepository  extends MyFactoryRepository<Yazar,Long> {
    public YazarRepository() {
        super(new Yazar());
    }
}
