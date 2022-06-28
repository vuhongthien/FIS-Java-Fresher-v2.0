package com.example.Fistestfinal.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "tbl_customers")
@NamedEntityGraph(name = "Customer.orderEntityGraph"
        , attributeNodes = @NamedAttributeNode("orders"))
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;
    @Column(name = "name_customer")
    @NotNull
    private String name;

    @Column(name = "mobile_customer")
    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Length(min = 10, max = 10,message = "số điện thoại phải 10 kí tự")
    private String mobile;

    @Column(name = "address_customer")
    @NotNull
    @Length(min = 10, max = 100, message = "địa chỉ từ 10 ký tự đến 100 ký tự")
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}





