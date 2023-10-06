package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Kitap;
import com.bilgeadam.utility.HibernateUtility;
import com.bilgeadam.utility.MyFactoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class KitapRepository extends MyFactoryRepository<Kitap,Long> {

    EntityManager entityManager;
    CriteriaBuilder criteriaBuilder;
    public KitapRepository() {
        super(new Kitap());
        this.entityManager = HibernateUtility.getSessionFactory().createEntityManager();;
        this.criteriaBuilder =  entityManager.getCriteriaBuilder();

    }

    public List<Kitap> stoktakiKitaplariGoruntule() {
        CriteriaQuery<Kitap> criteriaQuery = criteriaBuilder.createQuery(Kitap.class);
        Root<Kitap> root = criteriaQuery.from(Kitap.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.get("satistaMi"),true));
        List<Kitap> kitapList =entityManager.createQuery(criteriaQuery).getResultList();
        return kitapList;

    }

    public List<Kitap> tureGoreKitapBul(String tur) {
        String sql = ("SELECT * FROM tbl_kitap as k WHERE k.tur =:tur");
        Query query = entityManager.createNativeQuery(sql, Kitap.class);
        query.setParameter("tur",tur);
        List<Kitap> kitapList = query.getResultList();
        return kitapList;
    }
}
