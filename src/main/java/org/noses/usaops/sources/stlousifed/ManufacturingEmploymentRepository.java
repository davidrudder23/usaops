package org.noses.usaops.sources.stlousifed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturingEmploymentRepository extends JpaRepository<ManufacturingEmployment, Long> {
}
