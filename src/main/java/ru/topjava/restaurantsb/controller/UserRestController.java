package ru.topjava.restaurantsb.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.topjava.restaurantsb.AuthUser;
import ru.topjava.restaurantsb.model.Role;
import ru.topjava.restaurantsb.model.User;
import ru.topjava.restaurantsb.repository.UserRepository;
import ru.topjava.restaurantsb.util.ValidationUtil;

import javax.validation.Valid;
import java.net.URI;
import java.util.EnumSet;

@RestController
@RequestMapping(value = "/api/account")
@AllArgsConstructor
@Slf4j
public class UserRestController {
    private final UserRepository userRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@AuthenticationPrincipal AuthUser authUser) {
        log.info("get {}", authUser);
        return authUser.getUser();
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<User> register(@Valid @RequestBody User user) {
        log.info("register {}", user);
        ValidationUtil.checkNew(user);
        user.setRoles(EnumSet.of(Role.USER));
        user = userRepository.save(user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/account")
                .build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(user);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@AuthenticationPrincipal AuthUser authUser){
        log.info("delete {}", authUser);
        userRepository.deleteById(authUser.id());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public User update(@Valid @RequestBody User user, @AuthenticationPrincipal AuthUser authUser) {
        log.info("update {} to {}", authUser, user);
        User oldUser = authUser.getUser();
        ValidationUtil.assureIdConsistent(user, oldUser.id());
        user.setRoles(oldUser.getRoles());
        if (user.getPassword() == null) {
            user.setPassword(oldUser.getPassword());
        }
        return userRepository.save(user);
    }
}
