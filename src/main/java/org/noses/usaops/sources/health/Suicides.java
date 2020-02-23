package org.noses.usaops.sources.health;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Suicides {

    @Id
    private long year=System.nanoTime();

    private BigDecimal rate;

    @Temporal(TemporalType.DATE)
    Date date;
}
