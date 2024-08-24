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

import com.cl.entity.TingchechangEntity;
import com.cl.entity.view.TingchechangView;

import com.cl.service.TingchechangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;


/**
 * 停车场
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 19:03:50
 */
@RestController
@RequestMapping("/tingchechang")
public class TingchechangController {
    @Autowired
    private TingchechangService tingchechangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TingchechangEntity tingchechang, 
		HttpServletRequest request){
        EntityWrapper<TingchechangEntity> ew = new EntityWrapper<TingchechangEntity>();

		PageUtils page = tingchechangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tingchechang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TingchechangEntity tingchechang, 
		HttpServletRequest request){
        EntityWrapper<TingchechangEntity> ew = new EntityWrapper<TingchechangEntity>();

		PageUtils page = tingchechangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tingchechang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TingchechangEntity tingchechang){
       	EntityWrapper<TingchechangEntity> ew = new EntityWrapper<TingchechangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tingchechang, "tingchechang")); 
        return R.ok().put("data", tingchechangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TingchechangEntity tingchechang){
        EntityWrapper< TingchechangEntity> ew = new EntityWrapper< TingchechangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tingchechang, "tingchechang")); 
		TingchechangView tingchechangView =  tingchechangService.selectView(ew);
		return R.ok("查询停车场成功").put("data", tingchechangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TingchechangEntity tingchechang = tingchechangService.selectById(id);
		tingchechang = tingchechangService.selectView(new EntityWrapper<TingchechangEntity>().eq("id", id));
        return R.ok().put("data", tingchechang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TingchechangEntity tingchechang = tingchechangService.selectById(id);
		tingchechang = tingchechangService.selectView(new EntityWrapper<TingchechangEntity>().eq("id", id));
        return R.ok().put("data", tingchechang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TingchechangEntity tingchechang, HttpServletRequest request){
    	tingchechang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tingchechang);
        tingchechangService.insert(tingchechang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TingchechangEntity tingchechang, HttpServletRequest request){
    	tingchechang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tingchechang);
        tingchechangService.insert(tingchechang);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TingchechangEntity tingchechang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tingchechang);
        tingchechangService.updateById(tingchechang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tingchechangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
