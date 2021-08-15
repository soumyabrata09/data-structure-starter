/*
package com.sam09.lib.datastructurestarter;

import com.sam09.lib.datastructurestarter.services.lists.SinglyList;
import com.sam09.lib.datastructurestarter.services.stack.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
    SinglyList singlyList;
	@Autowired
    Stack stack;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("::Navigate to Test Class::");
		singlyList.prepend(4);
		singlyList.prepend(9);
		singlyList.prepend(5);
		log.info("List contains: " + singlyList.traverse() + " & size: " + singlyList.sizeOf());
		log.info("------------------");
		singlyList.insertAt(3,2);
		singlyList.insertAt(11,singlyList.sizeOf() -1);
		singlyList.insertAt(7,3);
		log.info("List contains: " + singlyList.traverse() + " & size: " + singlyList.sizeOf());
		log.info("------------------");
		singlyList.removeFirst();
		log.info("List contains: " + singlyList.traverse() + " & size: " + singlyList.sizeOf());
		log.info("------------------");
		singlyList.removeAt(2);
		log.info("List contains: " + singlyList.traverse() + " & size: " + singlyList.sizeOf());
		log.info("------------------");
		log.info("Stack Size: " + stack.sizeOf());
	}
}
*/
