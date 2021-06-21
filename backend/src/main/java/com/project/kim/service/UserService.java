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
            return userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
        }else{
            return userRepository.findByEmailAndSnsGb(user.getEmail(),user.getSnsGb());
        }
    }

    @Override
    public User signup(User user) {
        //저장은 그냥 save 하면 되는데 , 제대로 들어갔는지 확인하려면 save and flush
        return userRepository.saveAndFlush(user);
    }
}
