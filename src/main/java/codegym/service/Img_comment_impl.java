package codegym.service;

import codegym.model.ImgComment;
import codegym.repository.Img_comment_Repository;

import codegym.validWord.ValidWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class Img_comment_impl implements Img_comment {
//    private static SessionFactory sessionFactory;
//    private static EntityManager entityManager;

    @Autowired
    private Img_comment_Repository img_comment_repository;

    @Autowired
    private ValidWord validWord;


    @Override
    public void comment(ImgComment imgComment) throws RuntimeException {
        if(validWord.isValidComment(imgComment)){
            img_comment_repository.save(imgComment);
        }else {
            throw new RuntimeException("Feed Back including prohibit word");
        }

    }

    @Override
    public Page<ImgComment> showAllComment(Pageable pageable) {
        return img_comment_repository.findAll(pageable);
    }

//    @Override
//    public List<ImgComment> showAllComment() {
//        Timestamp timestampToday = new Timestamp(System.currentTimeMillis());
//        timestampToday.setHours(0);
//        timestampToday.setMinutes(0);
//        timestampToday.setSeconds(0);
//        String queryStr = "SELECT c FROM ImgComment AS c WHERE c.date >= :today ";
//        TypedQuery<ImgComment> query = entityManager.createQuery(queryStr,ImgComment.class);
//        query.setParameter("today",timestampToday);
//        return query.getResultList();
//    }

    @Override
    public ImgComment findByid(Long id) {
        return img_comment_repository.findOne(id);

    }

    @Override
    public void like(ImgComment imgComment) {
        imgComment.setLikes(imgComment.getLikes()+1);
        img_comment_repository.save(imgComment);

    }




}
