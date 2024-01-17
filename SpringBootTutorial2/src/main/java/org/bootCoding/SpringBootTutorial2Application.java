package org.bootCoding;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class SpringBootTutorial2Application implements CommandLineRunner {

	private final DataSource dataSource;

	public SpringBootTutorial2Application(final DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorial2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("DataSource" + dataSource.toString());
		final JdbcTemplate template = new JdbcTemplate(dataSource);
		template.execute("select 1");
	}
}
