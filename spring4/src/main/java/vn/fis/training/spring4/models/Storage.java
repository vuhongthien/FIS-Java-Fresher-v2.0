package vn.fis.training.spring4.models;

import lombok.*;
import javax.persistence.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_storage")
public class Storage extends AbstractEntity {
    protected String name;

    protected String location;

}
