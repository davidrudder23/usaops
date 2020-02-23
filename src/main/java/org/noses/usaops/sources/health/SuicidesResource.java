package org.noses.usaops.sources.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/suicides")
public class SuicidesResource {

    @Autowired
    SuicidesService suicidesService;

    @RequestMapping("")
    @ResponseBody
    @Transactional(readOnly = true)
    public String loadSuicides() {
        suicidesService.loadSuicides();

        return "loaded";
    }
}
