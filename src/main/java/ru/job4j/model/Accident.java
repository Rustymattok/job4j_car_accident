package ru.job4j.model;
import lombok.*;
import javax.persistence.*;
/**
 * Model for Accident. Coonection with Data table.
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="accident")
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ToString.Exclude private Integer id;
    @NonNull
    @Column(name = "accidentName")
    private String accidentName;
    @NonNull
    @Column(name = "accidentInfo")
    private String accidentInfo;
    @NonNull
    @Column(name = "accidentAddress")
    private String accidentAddress;
    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="user_id")
    private User author;

    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }
}
