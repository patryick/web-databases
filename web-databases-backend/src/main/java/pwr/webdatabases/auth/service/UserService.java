package pwr.webdatabases.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pwr.webdatabases.auth.data.model.User;
import pwr.webdatabases.auth.data.repo.UserJpaRepo;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserJpaRepo userRepo;

    public UserService(UserJpaRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

                return userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
            }
        };
    }

    public User save(User user) {

        if (null == user.getId()) {
            user.setCreatedAt(LocalDateTime.now());
        }
        user.setUpdatedAt(LocalDateTime.now());

        return userRepo.save(user);
    }
}
