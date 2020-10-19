
package com.enzofalvo.applicationMongodb.services;

import com.enzofalvo.applicationMongodb.domain.Post;
import com.enzofalvo.applicationMongodb.domain.User;
import com.enzofalvo.applicationMongodb.repository.PostRepository;
import com.enzofalvo.applicationMongodb.services.exception.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    
    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
    
    public List<Post> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }
}
   