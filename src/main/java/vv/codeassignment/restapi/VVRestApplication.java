package vv.codeassignment.restapi;

import org.h2.server.web.WebServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import vv.codeassignment.model.ClientId;
import vv.codeassignment.model.User;
import vv.codeassignment.repository.ClientRepository;

@SpringBootApplication(scanBasePackages = { "vv.codeassignment" })
@EnableJpaRepositories(basePackages = { "vv.codeassignment.repository" })
public class VVRestApplication 
{
	private static final Logger logger = LoggerFactory.getLogger(VVRestApplication.class);
	
    public static void main( String[] args )
    {
       SpringApplication.run(VVRestApplication.class, args);
    }
    
    @Bean
	public CommandLineRunner setup(ClientRepository clientRepository) {
		return (args) -> {
			clientRepository.save(new User(new ClientId("client1@mail.com", "1234"), "Gustavo", "Ponce", "1324235", "some address", true));
			clientRepository.save(new User(new ClientId("client2@mail.com", "4321"), "John", "Smith", "325345", "client 2 address", true));
			clientRepository.save(new User(new ClientId("client3@mail.com", "5435"), "Jim ", "Morrison", "443535", "client 3 address", false));
			clientRepository.save(new User(new ClientId("client4@mail.com", "4535"), "David", "Gilmour", "65323", "client 4 address", true));
			logger.info("The sample data has been generated");
		};
	}
    
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }
}
