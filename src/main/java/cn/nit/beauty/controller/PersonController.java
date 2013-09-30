package cn.nit.beauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.nit.beauty.domain.Person;
import cn.nit.beauty.service.PersonService;

@Controller
@RequestMapping("/api")
public class PersonController {

    @Autowired
	PersonService personService;
	
	@RequestMapping("person/random")
	@ResponseBody
	public Person randomPerson() {
		return personService.getRandom();
	}
	
	@RequestMapping("person/{id}")
	@ResponseBody
	public Person getById(@PathVariable Integer id) {
		return  personService.getById(id);
	}
	
	/* same as above method, but is mapped to
	 * /api/person?id= rather than /api/person/{id}
	 */
	@RequestMapping(value="person", params="id")
	@ResponseBody
	public Person getByIdFromParam(@RequestParam("id") Integer id) {
		return personService.getById(id);
	}
	
	/**
	 * Saves new person. Spring automatically binds the name
	 * and age parameters in the request to the person argument
	 * @param person
	 * @return String indicating success or failure of save
	 */
	@RequestMapping(value="register", method=RequestMethod.POST)
	@ResponseBody
	public Person savePerson(Person person) {
		return personService.save(person);
	}

    @RequestMapping(value="login", method=RequestMethod.POST)
    @ResponseBody
    public Person Login(Person person) {
        return personService.login(person);
    }
}
