package ua.zdoryk.TapTitlesRESTAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.zdoryk.TapTitlesRESTAPI.models.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> getAllByPlayerName(String name);

}
