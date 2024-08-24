package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.CheweileixingEntity;
import com.cl.entity.view.CheweileixingView;

import com.cl.service.CheweileixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;


/**
 * 车位类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 19:03:50
 */
@RestController
@RequestMapping("/cheweileixing")
public class CheweileixingController {
    @Autowired
    private CheweileixingService cheweileixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CheweileixingEntity cheweileixing, 
		HttpServletRequest request){
        EntityWrapper<CheweileixingEntity> ew = new EntityWrapper<CheweileixingEntity>();

		PageUtils page = cheweileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheweileixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CheweileixingEntity cheweileixing, 
		HttpServletRequest request){
        EntityWrapper<CheweileixingEntity> ew = new EntityWrapper<CheweileixingEntity>();

		PageUtils page = cheweileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheweileixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CheweileixingEntity cheweileixing){
       	EntityWrapper<CheweileixingEntity> ew = new EntityWrapper<CheweileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cheweileixing, "cheweileixing")); 
        return R.ok().put("data", cheweileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CheweileixingEntity cheweileixing){
        EntityWrapper< CheweileixingEntity> ew = new EntityWrapper< CheweileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cheweileixing, "cheweileixing")); 
		CheweileixingView cheweileixingView =  cheweileixingService.selectView(ew);
		return R.ok("查询车位类型成功").put("data", cheweileixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CheweileixingEntity cheweileixing = cheweileixingService.selectById(id);
		cheweileixing = cheweileixingService.selectView(new EntityWrapper<CheweileixingEntity>().eq("id", id));
        return R.ok().put("data", cheweileixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CheweileixingEntity cheweileixing = cheweileixingService.selectById(id);
		cheweileixing = cheweileixingService.selectView(new EntityWrapper<CheweileixingEntity>().eq("id", id));
        return R.ok().put("data", cheweileixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CheweileixingEntity cheweileixing, HttpServletRequest request){
    	cheweileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheweileixing);
        cheweileixingService.insert(cheweileixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CheweileixingEntity cheweileixing, HttpServletRequest request){
    	cheweileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheweileixing);
        cheweileixingService.insert(cheweileixing);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CheweileixingEntity cheweileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheweileixing);
        cheweileixingService.updateById(cheweileixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cheweileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
