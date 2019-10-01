package app.Repositories;

import app.Models.userModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userRepo extends CrudRepository<userModel,Integer> {
    userModel findByUser(String user);
    @Query(value = "select * from user u where u.user = ?1 and u.password = ?2 ",nativeQuery = true)
    userModel findByUserAndPass(String user, String password);
}
