package codegym.service;

import codegym.model.Img;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Img_comment {
    void comment(Img img);

    Page<Img> showAllComment(Pageable pageable);

    Img findByid(Long id);

    void like(Img img);
}
