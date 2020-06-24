package codegym.service;

import codegym.model.Img;
import codegym.repository.Img_comment_Repository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.sql.Timestamp;

import java.util.List;

public class Img_comment_impl implements Img_comment {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    @Autowired
    private Img_comment_Repository img_comment_repository;


    @Override
    public void comment(Img img) {
        img_comment_repository.save(img);

    }

    @Override
    public Page<Img> showAllComment(Pageable pageable) {
        return img_comment_repository.findAll(pageable);
    }

//    @Override
//    public List<Img> showAllComment() {
//        Timestamp timestampToday = new Timestamp(System.currentTimeMillis());
//        timestampToday.setHours(0);
//        timestampToday.setMinutes(0);
//        timestampToday.setSeconds(0);
//        String queryStr = "SELECT c FROM Img AS c WHERE c.date >= :today ";
//        TypedQuery<Img> query = entityManager.createQuery(queryStr,Img.class);
//        query.setParameter("today",timestampToday);
//        return query.getResultList();
//    }

    @Override
    public Img findByid(Long id) {
        return img_comment_repository.findOne(id);

    }

    @Override
    public void like(Img img) {
        img.setLikes(img.getLikes()+1);
        img_comment_repository.save(img);

    }
}
