package cn.edu.chzu.smart.home.dao;

import cn.edu.chzu.smart.home.SuperMapper;
import cn.edu.chzu.smart.home.domain.auth.SysRole;
import org.springframework.stereotype.Repository;

import java.util.Set;


/**
 * 角色dao
 *
 * @author: EarthChen
 * @date: 2018/06/03
 */
@Repository
public interface SysRoleDao extends SuperMapper<SysRole> {

    /**
     * 根据角色id查找角色
     *
     * @param id
     * @return
     */
    SysRole findById(long id);

    /**
     * 根据用户id查询角色
     *
     * @param userId
     * @return
     */
    Set<SysRole> findRoleByUserId(long userId);


}
