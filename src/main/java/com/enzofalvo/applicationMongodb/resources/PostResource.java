package com.enzofalvo.applicationMongodb.resources;

import com.enzofalvo.applicationMongodb.domain.Post;
import com.enzofalvo.applicationMongodb.domain.User;
import com.enzofalvo.applicationMongodb.dto.UserDTO;
import com.enzofalvo.applicationMongodb.resources.util.URL;
import com.enzofalvo.applicationMongodb.services.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //this id with {id}
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity <List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        
        List<Post> list = service.findByTitle(text);
        
        return ResponseEntity.ok().body(list);
    }
}