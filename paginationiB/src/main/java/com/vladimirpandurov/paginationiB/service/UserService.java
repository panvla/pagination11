package com.vladimirpandurov.paginationiB.service;

import com.vladimirpandurov.paginationiB.domain.User;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> getUsers(String name, int page, int size);
}
