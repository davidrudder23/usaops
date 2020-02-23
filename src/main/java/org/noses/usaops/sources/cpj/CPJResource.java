package org.noses.usaops.sources.cpj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cpj")
public class CPJResource {

    @Autowired
    CPJService cpjService;

    @RequestMapping("/numJournalistsKilledInUS")
    @ResponseBody
    @Transactional(readOnly = true)
    public String loadDeathRatesInUS() {
        cpjService.loadNumJournalistsKilledInUS();

        return "loaded";
    }

    @RequestMapping("/numJournalistsKilledInWorld")
    @ResponseBody
    @Transactional(readOnly = true)
    public String loadDeathRatesInWorld() {
        cpjService.loadNumJournalistsKilledInWorld();

        return "loaded";
    }

}
