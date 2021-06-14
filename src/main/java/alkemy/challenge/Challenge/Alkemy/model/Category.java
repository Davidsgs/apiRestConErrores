package alkemy.challenge.Challenge.Alkemy.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE categories SET deleted = true WHERE id_categories=?")
@Where(clause = "deleted=false")
@Table(name = "categories")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;
    private String description;
    private String images;

    @CreationTimestamp
    private Timestamp regdate;
    @UpdateTimestamp
    private Timestamp updatedate;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    @OneToMany(targetEntity = Book.class,mappedBy = "category", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Book> books;
}
