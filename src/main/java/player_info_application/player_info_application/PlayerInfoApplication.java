package player_info_application.player_info_application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class PlayerInfoApplication {
	private static final Logger log = LoggerFactory.getLogger(PlayerInfoApplication.class);
			public static void main(String[] args) {

				SpringApplication.run(PlayerInfoApplication.class, args);
				log.info("Welcome To Player Information Application..");
			}
}