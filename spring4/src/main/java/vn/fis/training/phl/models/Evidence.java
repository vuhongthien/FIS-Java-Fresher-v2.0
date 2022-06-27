package vn.fis.training.phl.models;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_evidence")
public class Evidence extends AbstractEntity {

    @Column(name = "idCriminalCase")
    protected Long idCriminalCase;

    @Column(name = "idStorage")
    protected Long idStorage;

    protected String number;

    protected String itemName;

    protected String notes;

    protected Boolean archieved;



}
