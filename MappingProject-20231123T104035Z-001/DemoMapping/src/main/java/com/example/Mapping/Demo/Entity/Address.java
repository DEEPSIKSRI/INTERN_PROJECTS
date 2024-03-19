package com.example.Mapping.Demo.Entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Address")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int A_id;

    private String A_Type;

    private String A_city;

    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;
}

