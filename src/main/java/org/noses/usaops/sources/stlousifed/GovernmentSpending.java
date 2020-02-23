package org.noses.usaops.sources.stlousifed;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class GovernmentSpending {
    int year;

    @Id
    Date date;

    BigDecimal amount;
}
