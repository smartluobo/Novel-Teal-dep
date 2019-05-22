package com.ibay.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibay.mall.mapper.TbExpressMapper;
import com.ibay.mall.pojo.TbExpress;
import com.ibay.mall.pojo.TbExpressExample;
import com.ibay.mall.service.ExpressService;

import java.util.Date;
import java.util.List;

/**
 * @author allen
 */
@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    private TbExpressMapper tbExpressMapper;

    @Override
    public List<TbExpress> getExpressList() {

        TbExpressExample example = new TbExpressExample();
        example.setOrderByClause("sort_order asc");
        return tbExpressMapper.selectByExample(example);
    }

    @Override
    public int addExpress(TbExpress tbExpress) {

        tbExpress.setCreated(new Date());
        tbExpressMapper.insert(tbExpress);
        return 1;
    }

    @Override
    public int updateExpress(TbExpress tbExpress) {

        tbExpress.setUpdated(new Date());
        tbExpressMapper.updateByPrimaryKey(tbExpress);
        return 1;
    }

    @Override
    public int delExpress(int id) {

        tbExpressMapper.deleteByPrimaryKey(id);
        return 1;
    }
}
