package vn.fis.training.ordermanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import vn.fis.training.ordermanagement.domain.OrderStatus;
import vn.fis.training.ordermanagement.service.OrderService;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class OrderManagementApplication {
	private static final Logger log = LoggerFactory.getLogger(OrderManagementApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApplication.class, args);
	}


	@Autowired
	private OrderService orderService;
	@Bean
	CommandLineRunner commandLineRunner() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				log.info("Welcome to spring application. Pls write test method in here to run for testing only");
//				log.info("Total order with wating status : {} order(s)", orderService.findOrdersByOrderStatus(OrderStatus.WAITING_APPROVAL).size());
			}
		};
	}
}
