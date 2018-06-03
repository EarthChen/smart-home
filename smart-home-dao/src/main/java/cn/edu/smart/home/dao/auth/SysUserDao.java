package cn.edu.smart.home.dao.auth;

import cn.edu.smart.home.SuperMapper;
import cn.edu.smart.home.domain.user.SysUser;
import org.springframework.stereotype.Repository;

/**
 * userdao
 *
 * @author: EarthChen
 * @date: 2018/06/03
 */
@Repository
public interface SysUserDao extends SuperMapper<SysUser> {
}
