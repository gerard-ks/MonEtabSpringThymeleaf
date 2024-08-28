package ci.atos.monetab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {
    @GetMapping("/rapport")
    public String index() {
        return "/layout/report";
    }
}
