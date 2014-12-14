package cn.nit.beauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.nit.beauty.service.PersonService;

@Controller
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value="notify")
    @ResponseBody
    public String Notify(@RequestParam("sessionid") String sessionid, @RequestParam("type") String type, @RequestParam("tradeno") String tradeno) {
        return personService.Notify(sessionid, type, tradeno);
    }
}
