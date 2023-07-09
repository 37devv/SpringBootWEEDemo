package ch.teko.wee.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackageClasses = Application.class)
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public void run(String... args) throws Exception {
		String[] beans = applicationContext.getBeanDefinitionNames();
		System.out.println("------------------------------------------------------------------------");
		for (String bean : beans) {
			System.out.println(bean);
		}
		System.out.println("------------------------------------------------------------------------");
	}
}
