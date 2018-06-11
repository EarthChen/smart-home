package cn.edu.chzu.smart.home.service.impl;

import cn.edu.chzu.smart.home.dao.SysUserRoleDao;
import cn.edu.chzu.smart.home.domain.SysUserRole;
import cn.edu.chzu.smart.home.enums.ResultEnum;
import cn.edu.chzu.smart.home.exception.AuthException;
import cn.edu.chzu.smart.home.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户角色关系服务
 *
 * @author: EarthChen
 * @date: 2018/06/04
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {


    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public void saveUserRole(long userId, long roleId) {
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setRoleId(roleId);
        sysUserRole.setUserId(userId);
        sysUserRoleDao.insert(sysUserRole);

    }

    @Override
    public void saveNewUserRole(long userId, long roleId) {
        // 判断当前userId和roleId的记录是否已经存在
        SysUserRole existUserRole = sysUserRoleDao.findOneByUserIdAndRoleId(userId, roleId);
        if (existUserRole != null) {
            throw new AuthException(ResultEnum.CURRENT_USER_ALREADY_HAVE_THIS_ROLE);
        }
        // 不存在保存
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setRoleId(roleId);
        sysUserRole.setUserId(userId);
        sysUserRoleDao.insert(sysUserRole);
    }
}
