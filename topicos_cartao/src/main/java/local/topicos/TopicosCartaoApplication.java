package local.topicos;


import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TopicosCartaoApplication {


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TopicosCartaoApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8081"));
        app.run(args);
        
        System.out.println("running.......");

    }
}
