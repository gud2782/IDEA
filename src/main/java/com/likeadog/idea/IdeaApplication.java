package com.likeadog.idea;

import com.likeadog.idea.api.HelloKAS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class IdeaApplication {


	public static void main(String[] args) throws IOException {

		SpringApplication.run(IdeaApplication.class, args);

		HelloKAS.getBlockNumber();
	}

}
