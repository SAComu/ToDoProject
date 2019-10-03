package app.Repositories;

import app.Models.listModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface listRepo extends CrudRepository<listModel,Integer> {
    @Query(value = "select list_name from list L where L.userid = ?1",nativeQuery = true)
    List<String> findAllListFromUserID(Integer userId);
    @Query(value = "select id from list L where L.userid = ?1",nativeQuery = true)
    List<String> findAllListFromUserIDAndGiveID(Integer userId);
}
