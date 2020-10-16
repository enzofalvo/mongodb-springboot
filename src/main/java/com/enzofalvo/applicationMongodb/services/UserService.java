
package com.enzofalvo.applicationMongodb.services;

import com.enzofalvo.applicationMongodb.domain.User;
import com.enzofalvo.applicationMongodb.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;
    
    public List<User> findAll() {
        return repo.findAll();
    }
}
