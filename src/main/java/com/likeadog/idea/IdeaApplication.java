package com.likeadog.idea;

import com.likeadog.idea.api.HelloKAS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

import static com.likeadog.idea.api.NumberGen.numberGen;
import static com.likeadog.idea.api.NumberGen.numberGenLoop;

@SpringBootApplication
public class IdeaApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(IdeaApplication.class, args);
		HelloKAS.getBlockNumber();
		System.out.println(numberGenLoop());

	}

}
