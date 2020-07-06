package codegym.repository;


import codegym.model.ImgComment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Img_comment_Repository extends PagingAndSortingRepository<ImgComment,Long> {

}
