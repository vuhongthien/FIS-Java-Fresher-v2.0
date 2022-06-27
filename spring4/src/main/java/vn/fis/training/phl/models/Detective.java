package vn.fis.training.phl.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vn.fis.training.phl.models.AbstractEntity;
import vn.fis.training.phl.models.CriminalCase;
import vn.fis.training.phl.models.enums.EmployeeStatus;
import vn.fis.training.phl.models.enums.Rank;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_detective")
public class Detective extends AbstractEntity {
    // INFO USER
    protected String username;

    protected String firstName;

    protected String lastName;

    protected String password;

    protected LocalDateTime hiringDate;

    // DETAILS USER


    protected String badgeNumber;

    @Column(name = "ranked")
    @Enumerated(EnumType.STRING)
    protected Rank rank;

    protected Boolean armed;

    @Enumerated(EnumType.STRING)
    protected EmployeeStatus status;

}
