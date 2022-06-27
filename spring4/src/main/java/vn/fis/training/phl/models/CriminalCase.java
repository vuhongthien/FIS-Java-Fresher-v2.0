package vn.fis.training.phl.models;

import lombok.*;
import vn.fis.training.phl.models.enums.CaseStatus;
import vn.fis.training.phl.models.enums.CaseType;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_criminal")
public class CriminalCase extends AbstractEntity {

    protected String number;

    @Enumerated(EnumType.STRING)
    protected CaseType type;

    protected String shortDescription;

    protected String detailDescription;

    @Enumerated(EnumType.STRING)
    protected CaseStatus status;

    protected String notes;

    @Column(name = "idLeadInvestigator")
    protected Long idLeadInvestigator;
}
