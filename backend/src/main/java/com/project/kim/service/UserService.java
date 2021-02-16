package com.project.kim.service;

import com.project.kim.domain.User;
import com.project.kim.domain.UserRepository;
import com.project.kim.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="UserService")
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(User user) {
        if(user.getSnsGb()==100){
            userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
        }else{
            userRepository.findByEmailAndSnsGb(user.getEmail(),user.getSnsGb());
        }
        return null;
    }
}
