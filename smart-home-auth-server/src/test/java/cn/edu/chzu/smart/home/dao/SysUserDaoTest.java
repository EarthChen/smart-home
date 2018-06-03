package cn.edu.chzu.smart.home.dao;

import cn.edu.chzu.smart.home.ApplicationTests;
import cn.edu.chzu.smart.home.dao.auth.SysUserDao;
import cn.edu.chzu.smart.home.domain.user.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @author: EarthChen
 * @date: 2018/06/03
 */
@Slf4j
public class SysUserDaoTest extends ApplicationTests {

    @Autowired
    private SysUserDao sysUserDao;


    @Test
    public void testSave() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("test");
        sysUser.setEmail("email");
        sysUser.setPassword("123456");
        sysUser.setImageUrl("sssss11");
        sysUserDao.insert(sysUser);
    }


    @Test
    public void testFindAll() {
        SysUser user = sysUserDao.selectById(1003135416750215169L);
        log.info(user.toString());
    }


    @Test
    public void testFindOneWithRolesByUsername() {
        SysUser sysUser = sysUserDao.findOneWithRolesByUsername("fpf");
        log.info(sysUser.getRoles().toString());

    }

}