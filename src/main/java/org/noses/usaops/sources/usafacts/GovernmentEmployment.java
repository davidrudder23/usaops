package org.noses.usaops.sources.usafacts;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Data
public class GovernmentEmployment {
    @Id
    Integer year;

    Date date;

    BigDecimal amount;
}
