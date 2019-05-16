package spx.baicai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spx.baicai.dao.UserDao;
import spx.baicai.model.User;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUser(Integer id) {
        User user = userDao.unique(id);
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
