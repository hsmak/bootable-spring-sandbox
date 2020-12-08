package org.hsmak.jpaWithCrudRepositoryAndMappings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.spi.LoggerContext;
import org.hsmak.jpaWithCrudRepositoryAndMappings.config.AppConfig;
import org.hsmak.jpaWithCrudRepositoryAndMappings.entity.Address;
import org.hsmak.jpaWithCrudRepositoryAndMappings.entity.Car;
import org.hsmak.jpaWithCrudRepositoryAndMappings.entity.User;
import org.hsmak.jpaWithCrudRepositoryAndMappings.entity.UserDetails;
import org.hsmak.jpaWithCrudRepositoryAndMappings.repository.CarJpaRepository;
import org.hsmak.jpaWithCrudRepositoryAndMappings.repository.UserJpaRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class JpaWithCrudRepositoryAndMappingsAppRunner {
    public static void main(String[] args) {
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);

        UserJpaRepository userJpaRepository = appCtx.getBean(UserJpaRepository.class);
        CarJpaRepository carJpaRepository = appCtx.getBean(CarJpaRepository.class);

        // Add Users
//        userJpaRepository.save(new User("Matt", "John", "Matt.John@example.com"));
//        userJpaRepository.save(new User("David", "Miller", "david.miller@example.com"));
//        userJpaRepository.save(new User("Alice", "Biden", "Alice.Biden@example.com"));
//        userJpaRepository.save(new User("Paul", "Smith", "paul.smith@example.com"));

        User user = new User("PaulUsername", "PaulPWD");
        user.setUserDetails(new UserDetails("Paul", "Smith", "Paul.Smith@example.com"));
        user.setAddresses(Set.of(
                new Address(123, "some street"),
                new Address(456, "Another street")));
        userJpaRepository.save(user);

        Car car1 = new Car("Ford", "Mustang", user);
        Car car2 = new Car("Ford2", "Mustang2", user);
        carJpaRepository.save(car1);
        carJpaRepository.save(car2);

        // Get Users
        userJpaRepository.findAll().forEach(System.out::println);
        System.out.println();

        carJpaRepository.findAll().forEach(System.out::println);
        System.out.println();

    }
}
