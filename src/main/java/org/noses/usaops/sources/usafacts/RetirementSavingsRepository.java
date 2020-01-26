package org.noses.usaops.sources.usafacts;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RetirementSavingsRepository extends CrudRepository<RetirementSavings, Long> {

    public List<RetirementSavings> findByYear(int year);
}
