package org.noses.usaops.sources.cpj;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@IdClass(JournalistsKilledID.class)
public class JournalistsKilled {
    @Id
    int year;

    @Id
    String location;

    @Temporal(TemporalType.DATE)
    Date date;


    int numKilled;

}

@Data
class JournalistsKilledID implements Serializable {

    int year;
    String location;
}
