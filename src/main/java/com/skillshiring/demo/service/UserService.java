package com.skillshiring.demo.service;

import com.skillshiring.demo.exceptions.UserException;
import com.skillshiring.demo.models.User;

import java.util.List;

public interface UserService {

    public User registerUser(User user);

    public User findUserById(Integer userId) throws UserException;

    public User findUserByEmail(String email);

    public User followUser(Integer userId1, Integer followerId) throws UserException;

    public User unfollowUser(Integer userId1, Integer followerId);

    public User updateUser(User user,Integer userId) throws UserException;

    public List<User> searchUser(String query);

    public User findUserByJwtToken(String jwtToken);
}
