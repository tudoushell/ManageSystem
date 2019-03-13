package service;

import entity.User;

public interface UserService {
    User isUser(String username, String password);
}
