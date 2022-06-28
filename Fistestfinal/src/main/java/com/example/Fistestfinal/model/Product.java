package com.example.Fistestfinal.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "tbl_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;

    @Column(name = "name_product")
    @NotNull
    private String name;

    @Column(name = "price_product")
    @NotNull
    private Double price;

    @Column(name = "avaiable_product")
    @NotNull
    private Double avaiable;
}
