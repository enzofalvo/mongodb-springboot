
package com.enzofalvo.applicationMongodb.repository;

import com.enzofalvo.applicationMongodb.domain.Post;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> SearchTitle(String text);
    
    List<Post> findByTitleContainingIgnoreCase(String text);
}
