package org.noses.usaops.sources.health;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@ToString
public class OpiodOverdoses {

    @Id
    int year;

    BigDecimal rate;

    String type;
}
