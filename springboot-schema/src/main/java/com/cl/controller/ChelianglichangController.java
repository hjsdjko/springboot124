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

import com.cl.entity.ChelianglichangEntity;
import com.cl.entity.view.ChelianglichangView;

import com.cl.service.ChelianglichangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;


/**
 * 车辆离场
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 19:03:50
 */
@RestController
@RequestMapping("/chelianglichang")
public class ChelianglichangController {
    @Autowired
    private ChelianglichangService chelianglichangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChelianglichangEntity chelianglichang, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			chelianglichang.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChelianglichangEntity> ew = new EntityWrapper<ChelianglichangEntity>();

		PageUtils page = chelianglichangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chelianglichang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChelianglichangEntity chelianglichang, 
		HttpServletRequest request){
        EntityWrapper<ChelianglichangEntity> ew = new EntityWrapper<ChelianglichangEntity>();

		PageUtils page = chelianglichangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chelianglichang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChelianglichangEntity chelianglichang){
       	EntityWrapper<ChelianglichangEntity> ew = new EntityWrapper<ChelianglichangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chelianglichang, "chelianglichang")); 
        return R.ok().put("data", chelianglichangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChelianglichangEntity chelianglichang){
        EntityWrapper< ChelianglichangEntity> ew = new EntityWrapper< ChelianglichangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chelianglichang, "chelianglichang")); 
		ChelianglichangView chelianglichangView =  chelianglichangService.selectView(ew);
		return R.ok("查询车辆离场成功").put("data", chelianglichangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChelianglichangEntity chelianglichang = chelianglichangService.selectById(id);
		chelianglichang = chelianglichangService.selectView(new EntityWrapper<ChelianglichangEntity>().eq("id", id));
        return R.ok().put("data", chelianglichang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChelianglichangEntity chelianglichang = chelianglichangService.selectById(id);
		chelianglichang = chelianglichangService.selectView(new EntityWrapper<ChelianglichangEntity>().eq("id", id));
        return R.ok().put("data", chelianglichang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChelianglichangEntity chelianglichang, HttpServletRequest request){
    	chelianglichang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chelianglichang);
        chelianglichangService.insert(chelianglichang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChelianglichangEntity chelianglichang, HttpServletRequest request){
    	chelianglichang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chelianglichang);
        chelianglichangService.insert(chelianglichang);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChelianglichangEntity chelianglichang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chelianglichang);
        chelianglichangService.updateById(chelianglichang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chelianglichangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	





    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<ChelianglichangEntity> ew = new EntityWrapper<ChelianglichangEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = chelianglichangService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<ChelianglichangEntity> ew = new EntityWrapper<ChelianglichangEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = chelianglichangService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<ChelianglichangEntity> ew = new EntityWrapper<ChelianglichangEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = chelianglichangService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,ChelianglichangEntity chelianglichang, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            chelianglichang.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<ChelianglichangEntity> ew = new EntityWrapper<ChelianglichangEntity>();
        int count = chelianglichangService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chelianglichang), params), params));
        return R.ok().put("data", count);
    }


}
