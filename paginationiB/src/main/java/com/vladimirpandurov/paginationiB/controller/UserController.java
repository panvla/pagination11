package com.vladimirpandurov.paginationiB.controller;

import com.vladimirpandurov.paginationiB.domain.HttpResponse;
import com.vladimirpandurov.paginationiB.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<HttpResponse>getUsers(@RequestParam Optional<String> name,
                                                @RequestParam Optional<Integer> page,
                                                @RequestParam Optional<Integer> size){
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                .timeStamp(LocalDateTime.now().toString())
                .data(Map.of("page", this.userService.getUsers(name.orElse(""), page.orElse(0), size.orElse(10))))
                .message("Users Retrieved")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }
}
