package cn.edu.smart.home.dao;

import cn.edu.smart.home.SuperMapper;
import cn.edu.smart.home.domain.User;
import org.springframework.stereotype.Repository;

/**
 * user的dao
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
@Repository
public interface UserDao extends SuperMapper<User> {
}
