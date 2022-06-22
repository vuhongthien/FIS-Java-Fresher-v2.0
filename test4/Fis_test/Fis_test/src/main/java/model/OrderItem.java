package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)

    private OrderCart order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // số lượng
    @Column(name = "quantity")
    private Integer quantity;

    // tổng cộng
    @Column(name = "amount")
    private Double amount;
}
