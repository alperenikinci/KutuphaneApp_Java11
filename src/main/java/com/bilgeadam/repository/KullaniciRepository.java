package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Kullanici;
import com.bilgeadam.utility.HibernateUtility;
import com.bilgeadam.utility.MyFactoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class KullaniciRepository extends MyFactoryRepository<Kullanici,Long> {

    EntityManager entityManager;
    CriteriaBuilder criteriaBuilder;
    public KullaniciRepository(){
        super(new Kullanici());
        this.entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        this.criteriaBuilder = entityManager.getCriteriaBuilder();

    }

    public Optional<Kullanici> tcKimligeGoreKullaniciBul(String tcKimlikNo) {
        Kullanici kullanici =null;
        CriteriaQuery<Kullanici> criteriaQuery = criteriaBuilder.createQuery(Kullanici.class);
        Root<Kullanici> root = criteriaQuery.from(Kullanici.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("tcKimlik"),tcKimlikNo));

        try {
            kullanici = entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (Exception e){
            System.out.println(e.toString());
        }
        return Optional.ofNullable(kullanici);
    }
}
