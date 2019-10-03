package app.Repositories;

import app.Models.itemModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface itemRepo extends CrudRepository<itemModel,Integer> {
    @Query(value = "select item_Name from item I where I.listid = ?1", nativeQuery = true)
    List<String> findAllItemFromListID(Integer listid);
    @Query(value = "select itemdesc from item I where I.listid = ?1", nativeQuery = true)
    List<String> findAlldescFromListID(Integer listid);
}
