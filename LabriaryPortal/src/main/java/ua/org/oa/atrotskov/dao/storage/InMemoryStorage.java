package ua.org.oa.atrotskov.dao.storage;

import ua.org.oa.atrotskov.model.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jdev on 17.12.2015.
 */
public class InMemoryStorage {
    private static InMemoryStorage storage;

    private InMemoryStorage() {
    }

    Map<Long, User> userStorage = new HashMap<>();
    Map<Long, Long> userBookStorage = new HashMap<>();

    public User findUserById(Long id) {
        return userStorage.get(id);
    }

    public boolean create(User user) {
        User put = userStorage.put(1l, user);
        return true;
    }

    public synchronized static InMemoryStorage getInstance() {
        if (storage == null) {
            storage = new InMemoryStorage();
        }
        return storage;
    }
}
