package cn.nit.beauty.dao;

import cn.nit.beauty.domain.Order;
import cn.nit.beauty.domain.Person;
import com.googlecode.genericdao.search.Search;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 13-9-25.
 */
@Repository
public class OrderDAO extends BaseDAO<Order> {

    public Order findByUsername(String username) {
        return searchUnique(new Search().addFilterEqual("username", username));
    }
}
