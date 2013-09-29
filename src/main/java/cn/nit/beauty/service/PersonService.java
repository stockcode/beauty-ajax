package cn.nit.beauty.service;

import cn.nit.beauty.domain.Person;

public interface PersonService {
	public Person getRandom();
	public Person getById(Integer id);
	public Person save(Person person);
    public Person getByUsername(String username);

    public Boolean isExpired(String username);

    public Person login(Person person);
}
