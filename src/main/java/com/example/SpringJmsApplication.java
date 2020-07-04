package com.example;

import com.example.jms.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringJmsApplication {

  @Autowired
  Sender sender;

  public static void main(String[] args) {
    SpringApplication.run(SpringJmsApplication.class, args);

  }

  public void server() throws Exception {
    // Step 1. Configure security.
    /*SecurityConfiguration securityConfig = new SecurityConfiguration();
    securityConfig.addUser("admin", "admin");
    securityConfig.addRole("admin", "admin");
    securityConfig.setDefaultUser("admin");
    ActiveMQJAASSecurityManager securityManager = new ActiveMQJAASSecurityManager(InVMLoginModule.class.getName(), securityConfig);

    // Step 2. Create and start embedded broker.
    ActiveMQServer server = ActiveMQServers.newActiveMQServer("broker.xml", null, securityManager);
    server.start();
    System.out.println("Started Embedded Broker");*/
  }

  @PostConstruct
  public void onConstruct() throws Exception {
    server();
    for (int i = 0; i < 25; i++) {
      Thread.sleep(1000);
      sender.send("Hello World " + i);
    }
  }
}
