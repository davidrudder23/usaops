package org.noses.usaops.sources.stlousifed;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigInteger;
import java.util.Date;

@Data
@ToString
@Entity
public class ManufacturingEmployment {

    public long year;

    public BigInteger amount;


    @Id
    @Temporal(TemporalType.DATE)
    Date date;


}
