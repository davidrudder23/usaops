package org.noses.usaops.sources.usafacts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetirementSavingsRepository extends JpaRepository<RetirementSavings, Long> {

    RetirementSavings findByYear(Long year);
}
