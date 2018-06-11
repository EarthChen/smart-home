package cn.edu.chzu.smart.home;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * mapper 父类，注意这个类不要让 mp 扫描到！！
 *
 * @author: EarthChen
 * @date: 2018/03/31
 */
public interface SuperMapper<T> extends BaseMapper<T> {

    // 这里可以放一些公共的方法
}