package ch.teko.wee.spring.service;

import org.springframework.stereotype.Service;

@Service("oracleDataServiceImpl")
public class OracleDataService implements DataService{
    @Override
    public String getFirstAndLastName() {
        //Simuliert einen Aufruf zur Datenbank
        System.out.println("SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM employees;");
        return "Oracle Max Mustermann";
    }
}
