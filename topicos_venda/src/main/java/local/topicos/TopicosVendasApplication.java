package local.topicos;


import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TopicosVendasApplication {


    public static void main(String[] args) {
//        SpringApplication.run(TopicosAvancadosApplication.class, args);
        SpringApplication app = new SpringApplication(TopicosVendasApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8082"));
        app.run(args);
        
        System.out.println("running.......");
    }
}
