package com.library.test.library.tz.services;

import com.library.test.library.tz.models.Book;
import com.library.test.library.tz.models.User;
import com.library.test.library.tz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


  private  final   UserRepository userRepository;

  @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public  void addUser (User user){
        userRepository.save(user);
    }

    public void  updateUser(int user_id, User updatedUser){
        User userForUpdate = userRepository.findById(user_id).orElseThrow();

        userForUpdate.setUsername(updatedUser.getUsername());
        userRepository.save(userForUpdate);
        }

    public  void deleteUser(int user_id){
        userRepository.deleteById(user_id);
    }

    public  void set_sub(int user_id){
        User user = userRepository.findById(user_id).orElseThrow();
        user.setHas_subscription(true);
        userRepository.save( user);
    }

    public List<User> getAllUsers(){
        return  userRepository.findAll();
    }

    public  User getUserById(int user_id){
     return  userRepository.findById(user_id).orElseThrow();
    }

    public  void removeBook(User user, Book book){
      user.getBooks().remove(book);
    }


}
