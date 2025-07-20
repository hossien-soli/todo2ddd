package dev.hspl.todo2ddd.user.infrastructure.persistence;

import dev.hspl.todo2ddd.user.application.User;
import dev.hspl.todo2ddd.user.application.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mongo")
public class MongoDBUserRepository implements UserRepository {

    @Override
    public void save(User user) {

    }
}
