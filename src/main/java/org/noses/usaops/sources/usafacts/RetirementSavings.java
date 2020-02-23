package org.noses.usaops.sources.usafacts;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@ToString
@Entity
public class RetirementSavings {

    @Id Long year;

    BigDecimal assets401k;
    BigDecimal contributions401k;
    BigInteger participants401k;
}