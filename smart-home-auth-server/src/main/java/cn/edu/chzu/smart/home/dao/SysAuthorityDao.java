package cn.edu.chzu.smart.home.dao;

import cn.edu.chzu.smart.home.SuperMapper;
import cn.edu.chzu.smart.home.domain.auth.SysAuthority;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * 权限dao
 *
 * @author: EarthChen
 * @date: 2018/06/03
 */
@Repository
public interface SysAuthorityDao extends SuperMapper<SysAuthority> {

    /**
     * 根据角色名查找权限集合
     *
     * @param roleName
     * @return
     */
    Set<SysAuthority> findAuthoritiesByRoleName(String roleName);
}
