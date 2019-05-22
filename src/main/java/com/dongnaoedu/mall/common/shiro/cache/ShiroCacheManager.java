package com.dongnaoedu.mall.common.shiro.cache;

import org.apache.shiro.cache.Cache;

/**
 * shiro cache manager 接口
 * 
 * @author allen
 *
 */
public interface ShiroCacheManager {

	<K, V> Cache<K, V> getCache(String name);

	void destroy();

}
