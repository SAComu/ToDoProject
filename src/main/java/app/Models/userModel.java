package app.Models;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
}
