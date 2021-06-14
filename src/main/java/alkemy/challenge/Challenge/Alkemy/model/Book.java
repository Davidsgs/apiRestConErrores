package alkemy.challenge.Challenge.Alkemy.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotEmpty
    private String title;

    private String author;

    private int edition;

    private double price;

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    private Category category;
}
