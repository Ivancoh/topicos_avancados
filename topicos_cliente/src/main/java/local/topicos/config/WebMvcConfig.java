package local.topicos.config;


import local.topicos.controller.ClienteFormatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring MVC configuration.
 */
@Controller
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addFormatter(new ClienteFormatter());
       
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //  registry.addViewController("/home").setViewName("home");
        //   registry.addViewController("/").setViewName("home");
        registry.addViewController("/").setViewName("pages/index");
        registry.addViewController("/login").setViewName("login");
    }

}
