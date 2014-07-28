package cn.nit.beauty.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import cn.nit.beauty.dao.PersonDAO;
import cn.nit.beauty.domain.Person;

import com.googlecode.genericdao.search.Search;

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
	public Person getById(Integer id) {
        return personDAO.find(id);
	}
	
	@Override
	public Person save(Person person) {
        if (person.getPkid() == null) {
            if (personDAO.findByUsername(person.getUsername()) != null) {
                person.setErr(person.getUsername() + "用户名已存在");
                return person;
            }
            Calendar calendar = Calendar.getInstance();  
            Date regDate = calendar.getTime();
            
            calendar.add(Calendar.DAY_OF_MONTH, 7);
            Date expiredDate = calendar.getTime();
            
            person.setRegDate(regDate);
            person.setExpiredDate(expiredDate);
            person.setScore(100);
        }

        personDAO.save(person);

        return person;
	}

    @Override
    public Person getByUsername(String username) {
        return null;
    }

    @Override
    public Boolean isExpired(String username) {
        return null;
    }

    @Override
    public Person login(Person person) {
        return personDAO.searchUnique(new Search().addFilterEqual("username", person.getUsername())
                .addFilterEqual("passwd", person.getPasswd()));

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
