package cn.edu.chzu.smart.home.dao;

import cn.edu.chzu.smart.home.ApplicationTests;
import cn.edu.chzu.smart.home.domain.auth.SysRole;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: EarthChen
 * @date: 2018/06/03
 */
@Slf4j
public class SysRoleDaoTest extends ApplicationTests {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysAuthorityDao sysAuthorityDao;


    @Test
    public void testSelectOne() {

        SysRole sysRole = sysRoleDao.selectById(1111L);
        log.info(sysRole.toString());

    }

    @Test
    public void testFindById() {
        SysRole sysRole=sysRoleDao.findById(11L);
        log.info(sysRole.toString());

    }


}