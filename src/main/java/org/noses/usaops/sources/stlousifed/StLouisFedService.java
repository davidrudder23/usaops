package org.noses.usaops.sources.stlousifed;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class StLouisFedService {

    @Autowired
    ManufacturingEmploymentRepository manufacturingEmploymentRepository;

    @Autowired
    TaxReceiptsRepository taxReceiptsRepository;

    @Autowired
    GovernmentSpendingRepository governmentSpendingRepository;

    @Autowired
    StLouisFedSource stLouisFedSource;

    public List<ManufacturingEmployment> loadManufacturingEmployment() {
        List<ManufacturingEmployment> manufacturingEmploymentList = stLouisFedSource.getManufacturingEmployment();

        manufacturingEmploymentRepository.save(manufacturingEmploymentList);
        manufacturingEmploymentRepository.flush();
        return manufacturingEmploymentList;
    }

    public List<TaxReceipts> loadTaxReceipts() {
        List<TaxReceipts> taxReceiptsList = stLouisFedSource.getTaxReceipts();

        taxReceiptsRepository.save(taxReceiptsList);
        taxReceiptsRepository.flush();
        return taxReceiptsList;
    }

    public List<GovernmentSpending> loadGovernmentSpending() {
        List<GovernmentSpending> governmentSpendingList = stLouisFedSource.getGovernmentSpending();

        governmentSpendingRepository.save(governmentSpendingList);
        governmentSpendingRepository.flush();
        return governmentSpendingList;
    }


}
