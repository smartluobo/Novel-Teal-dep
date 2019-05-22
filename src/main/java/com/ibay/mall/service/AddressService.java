package com.ibay.mall.service;

import java.util.List;

import com.ibay.mall.pojo.TbAddress;

public interface AddressService {

    List<TbAddress> getAddressList(Long userId);

    TbAddress getAddress(Long addressId);

    int addAddress(TbAddress tbAddress);

    int updateAddress(TbAddress tbAddress);

    int delAddress(TbAddress tbAddress);
}
