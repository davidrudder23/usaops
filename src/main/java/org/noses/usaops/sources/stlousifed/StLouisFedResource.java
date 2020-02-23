package org.noses.usaops.sources.stlousifed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/fred")
public class StLouisFedResource {

    @Autowired
    StLouisFedService stLouisFedService;

    @RequestMapping("/manufacturing")
    @ResponseBody
    @Transactional(readOnly = true)
    public String loadDeathRates() {
        stLouisFedService.loadManufacturingEmployment();

        return "loaded";
    }

    @RequestMapping("/taxReceipts")
    @ResponseBody
    @Transactional(readOnly = true)
    public String loadTaxReceipts() {
        stLouisFedService.loadTaxReceipts();

        return "loaded";
    }

    @RequestMapping("/governmentSpending")
    @ResponseBody
    @Transactional(readOnly = true)
    public String loadGovernmentSpending() {
        stLouisFedService.loadGovernmentSpending();

        return "loaded";
    }

}
