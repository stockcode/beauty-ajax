package cn.nit.beauty.service;

import cn.nit.beauty.domain.Person;

public interface PersonService {
	public Person getRandom();
	public Person getById(Long id);
	public void save(Person person);
    public Person getByUsername(String username);
}
