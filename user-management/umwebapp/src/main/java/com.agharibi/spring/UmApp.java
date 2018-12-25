package com.agharibi.spring;

import com.agharibi.persistence.setup.MyApplicationContextInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        UmContextConfig.class,
        UmPersistenceJpaConfig.class,
        UmServiceConfig.class,
        UmWebConfig.class
})
public class UmApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(UmApp.class)
                .initializers(new MyApplicationContextInitializer())
                .listeners()
                .run(args);

    }
}
