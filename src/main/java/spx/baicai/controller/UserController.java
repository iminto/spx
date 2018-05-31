package spx.baicai.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spx.baicai.model.User;
import spx.baicai.service.UserService;
import java.util.*;

@RestController
@RequestMapping(value="/users")
public class UserController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    @RequestMapping(value={"/list"}, method= RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

   @RequestMapping(value="/add", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        User user=userService.getUser(id);
        int count=userService.getCount("baide");
        log.info("userService.getCount(\"baide\")="+count);
        return user;
    }


    @RequestMapping(value="/getFirst")
    public User getFirst() {
        return userService.getFirstUser();
    }


}

