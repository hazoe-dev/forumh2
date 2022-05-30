package com.ha.forum.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ha.forum.model.Forum;
import com.ha.forum.model.User;
import com.ha.forum.repository.ForumRepository;
import com.ha.forum.repository.UserRepository;

@Configuration
public class Database {
	private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);
	@Bean
	CommandLineRunner initDatabaseUser (UserRepository userRepository, ForumRepository forumRepository) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				User userA = new User ("a","1","a@mail",new Date());
				LOGGER.info("insert data: "+userRepository.save(userA));
				Forum forumA = new Forum(1L,"aa");
				LOGGER.info("insert data: "+forumRepository.save(forumA));
			}
		};
	}
}
