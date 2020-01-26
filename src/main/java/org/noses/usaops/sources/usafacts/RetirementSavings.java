package org.noses.usaops.sources.usafacts;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@ToString
@Entity
class RetirementSavings {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;

    private int year;
    private BigDecimal assets401k;
    private BigDecimal contributions401k;
    private BigInteger participants401k;
}
