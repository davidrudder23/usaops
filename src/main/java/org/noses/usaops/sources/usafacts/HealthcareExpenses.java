package org.noses.usaops.sources.usafacts;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Data
@ToString
@Entity
class HealthcareExpenses {

    @Id
    public long year;

    public BigInteger spending;
}
