package com.likeadog.idea;

import com.likeadog.idea.api.HelloKAS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


@SpringBootApplication
public class IdeaApplication {


	public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		SpringApplication.run(IdeaApplication.class, args);
		HelloKAS.getBlockNumber();
		HelloKAS.test();
	}

}
