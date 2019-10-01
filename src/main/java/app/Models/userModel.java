package app.Models;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class userModel {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "user")
    private String user;
    @Column(name = "password")
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    @Fetch(FetchMode.JOIN)
    private listModel list;
}
