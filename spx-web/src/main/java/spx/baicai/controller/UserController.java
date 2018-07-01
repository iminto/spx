package spx.baicai.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spx.baicai.service.UserService;
import spx.baicai.model.User;

@RestController
@RequestMapping(value="/users")
public class UserController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;


    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        User user=userService.getUser(id);
        return user;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public int addUser(@RequestBody User user) {
        return userService.insertUser(user);
    }


    @RequestMapping(value="/getFirst")
    public User getFirst() {
        return userService.getFirstUser();
    }


}

