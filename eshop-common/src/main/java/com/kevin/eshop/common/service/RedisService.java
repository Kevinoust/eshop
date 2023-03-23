package com.kevin.eshop.common.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Redis service
 * data is stored as JSON
 */
public interface RedisService {
    /* -------------Generic type related operations------------- */
    /**
     * Set data
     * @param key
     * @param value
     */
    void set(String key, Object value);

    /**
     * Set data
     * @param key
     * @param value
     * @param expireTime
     */
    void set(String key, Object value, long expireTime);

    /**
     * Get data
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * Remove data
     * @param key
     */
    Boolean remove(String key);

    /**
     * Remove data in batch
     * @param keys
     * @return
     */
    Long remove(List<String> keys);

    /**
     * Set expire time of data
     * @param key
     * @param expireTime
     * @return
     */
    Boolean setExpire(String key, long expireTime);

    /**
     * Get expire time of data
     * @param key
     * @return
     */
    Long getExpire(String key);

    /**
     * Check if key presents
     */
    Boolean hasKey(String key);

    /**
     * increase the value of data
     * @param key
     * @param delta
     * @return
     */
    Long increase(String key, long delta);

    /**
     * decrease the value of data
     * @param key
     * @param delta
     * @return
     */
    Long decrease(String key, long delta);

    /* -------------HashTable related operations------------- */

    /**
     * Get value from HashTable
     * @param key
     * @param hashKey
     * @return
     */
    Object hGet(String key, String hashKey);


    /**
     * Set value to hashTable
     * @param key
     * @param hashKey
     * @param value
     * @param expireTime
     * @return
     */
    Boolean hSet(String key, String hashKey, Object value, long expireTime);

    /**
     * Set value to hashTable
     * @param key
     * @param hashKey
     * @param value
     */
    void hSet(String key, String hashKey, Object value);

    /**
     * Get the entire hashTable
     * @param key
     * @return
     */
    Map<Object, Object> hGetAll(String key);

    /**
     * Set the entire hashTable
     * @param key
     * @param map
     * @param expireTime
     * @return
     */
    Boolean hSetAll(String key, Map<String, ?> map, long expireTime);

    /**
     * Set the entire hashTable
     * @param key
     * @param map
     */
    void hSetAll(String key, Map<String, ?> map);

    /**
     * Delete the entries in hashTable
     * @param key
     * @param hashKeys
     */
    void hRemove(String key, Object... hashKeys);

    /**
     * Check if entries exists in hashTable
     * @param key
     * @param hashKey
     * @return
     */
    Boolean hHasKey(String key, String hashKey);

    /**
     * Increase the value of entry in hashTable
     * @param key
     * @param hashKey
     * @param delta
     * @return
     */
    Long hIncrease(String key, String hashKey, Long delta);

    /**
     * Decrease the value of entry in hashTable
     * @param key
     * @param hashKey
     * @param delta
     * @return
     */
    Long hDecrease(String key, String hashKey, Long delta);

    /* -------------Set related operations------------- */
    /**
     * Get Set
     * @param key
     * @return
     */
    Set<Object> sGet(String key);

    /**
     * Add data to Set
     * @param key
     * @param values
     * @return
     */
    Long sAdd(String key, Object... values);

    /**
     * Add data to Set
     * @param key
     * @param expireTime
     * @param values
     * @return
     */
    Long sAdd(String key, long expireTime, Object... values);

    /**
     * Check if Set contains data
     * @param key
     * @param value
     * @return
     */
    Boolean sContains(String key, Object value);

    /**
     * Get size of Set
     * @param key
     * @return
     */
    Long sSize(String key);

    /**
     * Remove data in Set
     * @param key
     * @param values
     * @return
     */
    Long sRemove(String key, Object... values);

    /* -------------List related operations------------- */
    /**
     * Get data from List
     * @param key
     * @param index
     * @return
     */
    Object lGet(String key, long index);

    /**
     * Get data from List between [start, end]
     * @param key
     * @param startIndex
     * @param endIndex
     * @return
     */
    List<Object> lGet(String key, long startIndex, long endIndex);

    /**
     * Get size of List
     * @param key
     * @return
     */
    Long lSize(String key);

    /**
     * Add data to List
     * @param key
     * @param value
     * @return
     */
    Long lAdd(String key, Object value);

    /**
     * Add data to List
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    Long lAdd(String key, Object value, long expireTime);

    /**
     * Add data to List in batch
     * @param key
     * @param values
     * @return
     */
    Long lAddAll(String key, Object... values);

    /**
     * Add data to List in batch
     * @param key
     * @param expireTime
     * @param values
     * @return
     */
    Long lAddAll(String key, Long expireTime, Object... values);

    /**
     * Remove data from List
     *
     * count > 0: remove {count} elements from head to tail
     * count < 0: remove {count} elements from tail to head
     * count = 0: remove all elements
     * @param key
     * @param count
     * @param value
     * @return
     */
    Long lRemove(String key, long count, Object value);
}
