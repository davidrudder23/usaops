package org.noses.usaops.sources.worldbank;

import org.noses.usaops.sources.usafacts.USAFactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/worldbank")
public class WorldBankResource {

    @Autowired
    WorldBankService worldBankService;

    @RequestMapping("/deathrates")
    @ResponseBody
    @Transactional(readOnly = true)
    public String loadDeathRates() {
        worldBankService.loadDeathRates();

        return "loaded";
    }

    @RequestMapping("/fertilityrates")
    @ResponseBody
    @Transactional(readOnly = true)
    public String loadFertilityRates() {
        worldBankService.loadFertilityRates();

        return "loaded";
    }

    @RequestMapping("/suiciderates")
    @ResponseBody
    @Transactional(readOnly = true)
    public String loadSuicideRates() {
        worldBankService.loadSuicideRates();

        return "loaded";
    }
}
