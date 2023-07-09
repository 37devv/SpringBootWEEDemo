package ch.teko.wee.spring.service;

import org.springframework.stereotype.Service;

@Service("postgresDataServiceImpl")
public class PostgresDataService implements DataService {
    @Override
    public String getFirstAndLastName() {
        //Simuliert einen Aufruf zur Datenbank
        System.out.println("SELECT first_name || ' ' || last_name AS full_name FROM employees;");
        return "Postgres Max Mustermann";
    }
}
