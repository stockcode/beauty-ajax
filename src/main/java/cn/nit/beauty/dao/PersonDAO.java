package cn.nit.beauty.dao;

import cn.nit.beauty.domain.Person;
import com.googlecode.genericdao.search.Search;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 13-9-25.
 */
@Repository
public class PersonDAO extends BaseDAO<Person> {

    public Person findByUsername(String username) {
        return searchUnique(new Search().addFilterEqual("username", username));
    }
}
