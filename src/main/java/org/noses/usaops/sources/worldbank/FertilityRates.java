package org.noses.usaops.sources.worldbank;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
@Entity
public class FertilityRates {

    @Id
    public long year;

    public BigDecimal rate;


    @Temporal(TemporalType.DATE)
    Date date;


}
