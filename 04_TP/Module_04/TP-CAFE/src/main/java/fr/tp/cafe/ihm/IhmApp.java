package fr.tp.cafe.ihm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IhmApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		// CONTEXT SPRING ICI
		
		WorldApi theWorld = context.getBean("world", WorldApi.class);
		theWorld.bigBang();

		((ClassPathXmlApplicationContext) context).close();
	}

}
