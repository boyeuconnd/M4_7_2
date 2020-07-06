package codegym.service;

import codegym.model.ImgComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Img_comment {
    void comment(ImgComment imgComment);

    Page<ImgComment> showAllComment(Pageable pageable);

    ImgComment findByid(Long id);

    void like(ImgComment imgComment);
}
