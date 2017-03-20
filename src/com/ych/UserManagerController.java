package com.ych;

import com.ych.util.annotations.Controller;
import com.ych.util.annotations.RequestMapping;

/**
 * Created by hua on 2017/2/14.
 */
@Controller
@RequestMapping(value = "/user")
public class UserManagerController {

    @RequestMapping(value = "list")
    public void listUsers(){

    }
}
