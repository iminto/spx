package spx.baicai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spx.baicai.dao.UserDao;
import spx.baicai.model.User;
import spx.baicai.mq.KafkaSender;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    KafkaSender<User> kafkaSender;

    public User getUser(Integer id) {
        User user = userDao.unique(id);
        for (int i = 0; i < 5; i++) {
            kafkaSender.send("kafka.tut",user);
        }
        return user;
    }

    public int getCount(String name) {
        return userDao.getCountWithName(name);
    }

    public User getFirstUser() {
        return userDao.getFirstUser();
    }

    @Transactional
    public int insertUser(User user) {
        userDao.insert(user, true);
        return user.getId();
    }

}
