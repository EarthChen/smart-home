package cn.edu.chzu.smart.home.service.impl;

import cn.edu.chzu.smart.home.dao.MattressDao;
import cn.edu.chzu.smart.home.domain.bedroom.MattressData;
import cn.edu.chzu.smart.home.service.MattressService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 床垫服务实现类
 *
 * @author: EarthChen
 * @date: 2018/06/12
 */
@Service
public class MattressServiceImpl implements MattressService {

    @Autowired
    private MattressDao mattressDao;

    @Override
    public List<MattressData> getMattressPage(Pageable pageable) {
        EntityWrapper<MattressData> mattressDataEntityWrapper = new EntityWrapper<>();
        return mattressDao.selectPage(new Page<MattressData>(pageable.getPageNumber(), pageable.getPageSize()),
                mattressDataEntityWrapper);
    }

    @Override
    public List<MattressData> getMattressPageWithSn(Pageable pageable, String sn) {
        EntityWrapper<MattressData> mattressDataEntityWrapper = new EntityWrapper<>();
        mattressDataEntityWrapper.eq("sn", sn);
        return mattressDao.selectPage(new Page<MattressData>(pageable.getPageNumber(), pageable.getPageSize()),
                mattressDataEntityWrapper);
    }
}
