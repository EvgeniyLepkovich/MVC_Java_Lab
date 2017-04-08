package by.epam.client.controller;

import by.epam.client.model.User;
import by.epam.client.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Controller
@SessionAttributes("savedUser")
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = {"/saveUserInSession/{id}"}, method = RequestMethod.POST)
    public ModelAndView saveUserInSession(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserById(id);
        modelAndView.addObject("savedUser", user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = {"/getUser/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable(value = "id") Long id){
        return userService.getUserById(id);
    }

    @ResponseBody
    @RequestMapping(value = {"/getUserAsync/{id}"}, method = RequestMethod.GET)
    public User getUserByIdAsync(@PathVariable(value = "id") long id) throws InterruptedException, ExecutionException {
        User user = userService.getUserByIdAsync(id).get();
        return user;
    }

    @RequestMapping(value = {"/getUserByIdMatrix/{id}"}, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getUserByIdMatrix(@MatrixVariable Map<String, String> objectMap){
        Long id = Long.parseLong(objectMap.get("id"));
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/addUserByAjax", method = RequestMethod.POST, consumes = "application/json")
    public ModelAndView addUserByAjax(@RequestBody User user){
        userService.addUser(user);
        return getIndex();
    }

    @RequestMapping(value = "/addUserByForm", method = RequestMethod.POST)
    public ModelAndView addUserByForm(@ModelAttribute("user") User user){
        userService.addUser(user);
        return getIndex();
    }
}
