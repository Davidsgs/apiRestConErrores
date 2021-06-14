package alkemy.challenge.Challenge.Alkemy.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;


    @NonNull
    private int age;

    @NonNull
    private String password ;

    private String photo;

    private Boolean deleted;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date create_at_register;

}
