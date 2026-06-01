package com.traderos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TraderOS API - Application Entry Point
 *
 * <p>This class bootstraps the entire Spring application context.
 * {@code @SpringBootApplication} is a composite annotation that activates:
 *
 *  <ul>
 *      <li>{@code @SpringBootConfiguration} - marks this class as a source of
 *          bean definitions, equivalent to {@code @Configuration}</li>
 *      <li>{@code @EnableAutoConfiguration} - instructs Spring Boot to
 *          auto-configure beans based on what is present on the classpath.
 *          For example: DataSource because postgresql is on the classpath,
 *          Flyway because flyway-core is present, SecurityFilterChain becasue
 *          spring-security is present.</li>
 *      <li>{@code @ComponentScan} - scans {@code com.traderos.api} and all
 *          sub-packages for {@code @Component}, {@code @Service},
 *          {@code @Repository}, and {@code @RestController} classes,
 *          registering them as Spring-managed beans.</li>
 *  </ul>
 *
 * <p><b>Startup sequence (what happens when main() is called):</b>
 * <ol>
 *     <li>Spring ApplicationContext is created and refreshed</li>
 *     <li>Auto-configuration classes are evaluated and applied</li>
 *     <li>Component scan registers all application beans</li>
 *     <li>Flyway runs pending DB migrations (V1, V2, ...)</li>
 *     <li>Hibernate validates schema against JPA entities</li>
 *     <li>Embedded Tomcat start on port 8080</li>
 *     <li>RAG startup runner indexes tax law chunks into pgvector</li>
 * </ol>
 *
 * <p><b>Package placement matters:</b> This class must remain in
 * {@code com.traderos.api} (the root package). Moving it into a sub-package
 * would cause {@code @ComponentScan} to miss sibling packages and beans
 * would not be discovered.
 */

@SpringBootApplication
public class ApiApplication {

    /**
     * Application entry point.
     *
     * @param args command-line arguments passed to {@link SpringApplication#run}.
     *             Spring Boot recognises property overrides here, e.g.
     *             {@code --server.port=9090} or {@code --spring.profiles.active=prod}.
     */
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
