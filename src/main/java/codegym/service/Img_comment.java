package codegym.service;

import codegym.model.Img;

import java.util.List;

public interface Img_comment {
    void comment(Img img);

    List<Img> showAllComment();

    Img findByid(Long id);

    void like(Img img);
}
