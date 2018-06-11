package cn.edu.chzu.smart.home.dao;

import cn.edu.chzu.smart.home.SuperMapper;
import cn.edu.chzu.smart.home.domain.SysUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户角色关系dao
 *
 * @author: EarthChen
 * @date: 2018/06/04
 */
@Repository
public interface SysUserRoleDao extends SuperMapper<SysUserRole> {

    /**
     * 根据userid和roleid查找
     *
     * @param userId
     * @param roleId
     * @return
     */
    SysUserRole findOneByUserIdAndRoleId(@Param("userId") long userId,
                                         @Param("roleId") long roleId);
}
