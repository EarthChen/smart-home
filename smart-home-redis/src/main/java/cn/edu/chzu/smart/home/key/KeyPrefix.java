package cn.edu.chzu.smart.home.key;

/**
 * redis缓存前缀
 *
 * @author: EarthChen
 * @date: 2018/06/05
 */
public interface KeyPrefix {

    /**
     * 过期时间
     *
     * @return
     */
    int expireSeconds();

    /**
     * 前缀
     *
     * @return
     */
    String getPrefix();

}