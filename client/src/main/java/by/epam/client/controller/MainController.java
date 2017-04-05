package by.epam.client.controller;

import by.epam.client.model.User;
import by.epam.client.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@Controller
@SessionAttributes("user")
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = {"/saveUserInSession/{id}"}, method = RequestMethod.GET)
    public ModelAndView saveUserInSession(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserById(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = {"/getUser/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable(value = "id") Long id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = {"/getUserAsync/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    @Async
    public Future<User> getUserByIdAsync(@PathVariable(value = "id") long id){
        User user = userService.getUserById(id);
        return new AsyncResult<>(user);
    }

    @RequestMapping(value = {"/getUsers/{id}"}, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> getUsersById(@MatrixVariable Map<String, Long[]> objectMap){
        Long[] ids = objectMap.get("users");
        return userService.getUsersById(ids);
    }

    @RequestMapping(value = "/addUserByAjax", method = RequestMethod.POST, consumes = "application/json")
    public void addUserByAjax(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(value = "/addUserByForm", method = RequestMethod.POST)
    private void addUserByForm(@ModelAttribute("user") User user){
        userService.addUser(user);
    }
}
