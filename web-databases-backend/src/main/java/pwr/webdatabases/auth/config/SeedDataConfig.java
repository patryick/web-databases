package pwr.webdatabases.auth.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pwr.webdatabases.auth.data.model.Role;
import pwr.webdatabases.auth.data.model.User;
import pwr.webdatabases.auth.data.repo.UserJpaRepo;
import pwr.webdatabases.auth.service.UserService;

@Component
public class SeedDataConfig implements CommandLineRunner {

    private final UserJpaRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public SeedDataConfig(UserJpaRepo userRepository, PasswordEncoder passwordEncoder, UserService userService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {

            User student = new User();
            student.setUsername("student");
            student.setEmail("student@student.com");
            student.setPassword(passwordEncoder.encode("password"));
            student.setRole(Role.STUDENT);

            userService.save(student);
        }
    }
}
