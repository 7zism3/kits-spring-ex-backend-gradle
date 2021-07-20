package com.example.exbackendgradle;

import com.example.exbackendgradle.entity.Product;
import com.example.exbackendgradle.reponsitory.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class ExBackendGradleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExBackendGradleApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/api/**");
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200/");
//                        .allowedMethods("PUT", "DELETE")
//                        .allowedHeaders("header1", "header2", "header3")
//                        .exposedHeaders("header1", "header2")
//                        .allowCredentials(false).maxAge(3600);
            }
        };
    }

//    @Bean
//    public CommandLineRunner demo(ProductRepository productRepository) {
//        return (args) -> {
//            //TEST JPA HERE!!!
//            Product product1 = new Product(Long.valueOf(1) , "name 10", "http://placeimg.com/640/480/business", 214);
//            System.out.println( productRepository.save(product1));
//
//
//            List<Product> products = productRepository.findAll();
//            for (Product product : products) {
//                product.toString();
//            }
//        };
//    }

}