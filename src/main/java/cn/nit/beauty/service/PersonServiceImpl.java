package cn.nit.beauty.service;

import java.util.Random;

import cn.nit.beauty.dao.PersonDAO;
import cn.nit.beauty.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonDAO personDAO;

	String[] names = {"Nikolaus Otto", "Robert Ford", "Gottlieb Daimler", "Lt. General Masaharu Homma"};

	@Override
	public Person getRandom() {
		Person person = new Person();
		//person.setName(randomName());
		//person.setAge(randomAge());
		return person;
	}

	@Override
	public Person getById(Long id) {
		Person person = new Person();
		//person.setName(names[id.intValue()]);
		//person.setAge(50);
		return person;
	}
	
	@Override
	public void save(Person person) {
        personDAO.save(person);
	}

    @Override
    public Person getByUsername(String username) {
        return null;
    }

    @Override
    public Boolean isExpired(String username) {
        return null;
    }

    private Integer randomAge() {
		Random random = new Random();
		return 10 + random.nextInt(100);
	}

	private String randomName() {
		Random random = new Random();
		return names[random.nextInt(names.length)];
	}

}
