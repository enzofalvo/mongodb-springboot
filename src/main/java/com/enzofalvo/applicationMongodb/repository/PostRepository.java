
package com.enzofalvo.applicationMongodb.repository;

import com.enzofalvo.applicationMongodb.domain.Post;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text);
}
