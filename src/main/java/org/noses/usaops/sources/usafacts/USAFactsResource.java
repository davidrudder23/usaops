package org.noses.usaops.sources.usafacts;

import org.noses.usaops.sources.usafacts.USAFactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/usafacts")
public class USAFactsResource {

    @Autowired
    USAFactsService usaFactsService;

    @RequestMapping("/retirementsavings")
    @ResponseBody
    @Transactional(readOnly = true)
    public String loadRetirementSavings() {
        usaFactsService.loadUSAFacts();

        return "loaded";
    }
}
