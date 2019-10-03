package app.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "list")
public class listModel {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "userid")
    private String userid;
    @Column(name = "list_name")
    private String listName;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "userid", nullable = false)
//    private userModel userid;
}
