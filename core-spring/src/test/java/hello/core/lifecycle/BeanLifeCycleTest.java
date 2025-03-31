package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LIfeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();

    }

    @Configuration
    static class LIfeCycleConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("https://hello-spring.dev");
            return networkClient;
        }
    }
}
