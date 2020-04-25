package ru.job4j.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
/**
 * Model for Accident. Coonection with Data table.
 */
@Entity
@Table(name="accident")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
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
