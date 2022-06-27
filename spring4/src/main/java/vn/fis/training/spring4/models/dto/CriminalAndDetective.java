package vn.fis.training.spring4.models.dto;


import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_criminal_detective")
public class CriminalAndDetective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idCriminal")
    private Long idCriminal;

    @Column(name = "idDetective")
    private Long idDetective;
}
