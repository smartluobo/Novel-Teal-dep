package com.ibay.mall.service;

import com.ibay.mall.pojo.dto.EsInfo;

/**
 * @author allen
 */
public interface SearchItemService {

	/**
	 * 同步索引
	 * 
	 * @return
	 */
	int importAllItems();

	/**
	 * 同步单个商品索引
	 * 
	 * @param type
	 * @param itemId
	 * @return
	 */
	int refreshItem(int type, Long itemId);

	/**
	 * 获取ES基本信息
	 * 
	 * @return
	 */
	EsInfo getEsInfo();
}
