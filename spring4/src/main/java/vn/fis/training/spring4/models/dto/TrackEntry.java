package vn.fis.training.spring4.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vn.fis.training.spring4.models.AbstractEntity;
import vn.fis.training.spring4.models.enums.TrackAction;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_trackEntry")
public class TrackEntry extends AbstractEntity {

    protected LocalDateTime date;

    @Column(name = "idEvidence")
    protected Long idEvidence;

    @Column(name = "idDetective")
    protected Long idDetective;

    @Enumerated(EnumType.STRING)
    protected TrackAction action;

    protected String reason;


}
