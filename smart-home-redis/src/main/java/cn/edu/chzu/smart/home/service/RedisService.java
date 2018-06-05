package cn.edu.chzu.smart.home.service;

import cn.edu.chzu.smart.home.key.KeyPrefix;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * redis服务，提供操作
 *
 * @author: EarthChen
 * @date: 2018/06/05
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    /**
     * 获取单个对象
     *
     * @param prefix
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        String realKey = prefix.getPrefix() + ":" + key;
        String str = redisTemplate.opsForValue().get(realKey);
        return stringToBean(str, clazz);
    }

    /**
     * 设置对象
     *
     * @param prefix
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(KeyPrefix prefix, String key, T value) {

        String str = beanToString(value);
        if (str == null || str.length() <= 0) {
            return false;
        }
        //生成真正的key
        String realKey = prefix.getPrefix() + ":" + key;

        // 获取失效时间
        int seconds = prefix.expireSeconds();
        if (seconds <= 0) {
            redisTemplate.opsForValue().set(realKey, str);
        } else {
            redisTemplate.opsForValue().set(realKey, str, seconds, TimeUnit.SECONDS);
        }
        return true;

    }

    /**
     * 判断key是否存在
     *
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> boolean exists(KeyPrefix prefix, String key) {
        String realKey = prefix.getPrefix() + ":" + key;
        return redisTemplate.hasKey(realKey);
    }


    /**
     * 删除指定键
     *
     * @param prefix
     * @param key
     */
    public void delete(KeyPrefix prefix, String key) {
        //生成真正的key
        String realKey = prefix.getPrefix() + ":" + key;
        redisTemplate.delete(realKey);
    }


    /**
     * 增加1
     *
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> Long incr(KeyPrefix prefix, String key) {
        String realKey = prefix.getPrefix() + ":" + key;
        return redisTemplate.opsForValue().increment(realKey, 1);

    }

    /**
     * 增加n
     *
     * @param prefix
     * @param key
     * @param n
     * @param <T>
     * @return
     */
    public <T> Long incr(KeyPrefix prefix, String key, long n) {
        String realKey = prefix.getPrefix() + ":" + key;
        return redisTemplate.opsForValue().increment(realKey, n);

    }

    /**
     * 减少n
     *
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> Long decr(KeyPrefix prefix, String key, long n) {
        String realKey = prefix.getPrefix() + ":" + key;
        return redisTemplate.opsForValue().increment(realKey, -n);
    }


    /**
     * 减少n
     *
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> Long decr(KeyPrefix prefix, String key) {
        String realKey = prefix.getPrefix() + ":" + key;
        return redisTemplate.opsForValue().increment(realKey, -1);
    }

    public static <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T stringToBean(String str, Class<T> clazz) {
        if (str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        } else if (clazz == String.class) {
            return (T) str;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(str);
        } else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }


}
