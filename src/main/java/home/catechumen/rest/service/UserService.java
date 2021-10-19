package home.catechumen.rest.service;

import home.catechumen.rest.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getById(long id);
    void save(User user);
    void update(User updatedUser);
    void delete(Long id);
    User findByUserName(String userName);

}
