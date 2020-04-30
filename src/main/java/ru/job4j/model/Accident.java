package ru.job4j.model;
import lombok.*;

import javax.persistence.*;
/**
 * Model for Accident. Coonection with Data table.
 */
@Entity
@Table(name="accident")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ToString.Exclude private int id;
    @NonNull
    @Column(name = "name")
    private String name;
    @NonNull
    @Column(name = "text")
    private String text;
    @NonNull
    @Column(name = "address")
    private String address;


}
