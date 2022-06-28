package com.example.Fistestfinal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "tbl_order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orderitem")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    private Order order;

    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;

    @Column(name = "quantity_orderitem")
    @NotNull
    @Min(0)
    private Long quantity;

    @Column(name = "amount_orderitem")
    @NotNull
    private Double amount;

}
