package app.Models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "item")
public class itemModel {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "listid")
    private Integer listid;
    @Column(name = "item_Name")
    private String itemName;
    @Column(name = "itemdesc")
    private String itemdesc;
}
