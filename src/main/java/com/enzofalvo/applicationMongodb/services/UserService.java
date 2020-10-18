
package com.enzofalvo.applicationMongodb.services;

import com.enzofalvo.applicationMongodb.domain.User;
import com.enzofalvo.applicationMongodb.repository.UserRepository;
import com.enzofalvo.applicationMongodb.services.exception.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;
    
    public List<User> findAll() {
        return repo.findAll();
    }
    
    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
