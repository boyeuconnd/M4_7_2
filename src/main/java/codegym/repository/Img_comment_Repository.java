package codegym.repository;


import codegym.model.Img;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Img_comment_Repository extends PagingAndSortingRepository<Img,Long> {

}
