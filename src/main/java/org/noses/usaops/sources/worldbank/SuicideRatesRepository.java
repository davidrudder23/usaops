package org.noses.usaops.sources.worldbank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuicideRatesRepository extends JpaRepository<SuicideRates, Long> {
}
