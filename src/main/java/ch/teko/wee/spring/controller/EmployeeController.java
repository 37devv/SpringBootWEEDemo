package ch.teko.wee.spring.controller;

import ch.teko.wee.spring.service.DataService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final ApplicationContext context;

    public EmployeeController(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/employees")
    public String getEmployee(@RequestParam String dataSource) {
        DataService service = null;

        if (dataSource.equals("p")) {
            service = context.getBean("postgresDataServiceImpl", DataService.class);
        } else if (dataSource.equals("o")) {
            service = context.getBean("oracleDataServiceImpl", DataService.class);
        }

        return service.getFirstAndLastName();

    }
}
