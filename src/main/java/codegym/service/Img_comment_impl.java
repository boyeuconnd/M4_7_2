package codegym.service;

import codegym.model.Img;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.sql.Timestamp;

import java.util.List;

public class Img_comment_impl implements Img_comment {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void comment(Img img) {
        Session session =null;
        Transaction transaction = null;
        try{
            session=sessionFactory.openSession();
            transaction = session.beginTransaction();
            Img commentImg = new Img();
            commentImg.setAuthor(img.getAuthor());
            commentImg.setFeedback(img.getFeedback());
            commentImg.setPoint(img.getPoint());
            commentImg.setDate(new Timestamp(System.currentTimeMillis()));
            session.save(commentImg);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }

        }finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<Img> showAllComment() {
        Timestamp timestampToday = new Timestamp(System.currentTimeMillis());
        timestampToday.setHours(0);
        timestampToday.setMinutes(0);
        timestampToday.setSeconds(0);
        String queryStr = "SELECT c FROM Img AS c WHERE c.date >= :today ";
        TypedQuery<Img> query = entityManager.createQuery(queryStr,Img.class);
        query.setParameter("today",timestampToday);
        return query.getResultList();
    }
}
