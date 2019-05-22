package com.ibay.mall.controller;


import com.ibay.mall.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibay.mall.pojo.common.DataTablesResult;
import com.ibay.mall.pojo.common.Result;
import com.ibay.mall.service.ThanksService;

/**
 * @author allen
 */
@RestController
public class ThanksFrontController {

    private final static Logger log= LoggerFactory.getLogger(ThanksFrontController.class);

    @Autowired
    private ThanksService thanksService;

    @RequestMapping(value = "/member/thanks",method = RequestMethod.GET)
    public Result<DataTablesResult> getThanksList(@RequestParam(defaultValue = "1") int page,
                                                  @RequestParam(defaultValue = "10") int size){

        DataTablesResult result=thanksService.getThanksListByPage(page,size);
        return new ResultUtil<DataTablesResult>().setData(result);
    }
}
