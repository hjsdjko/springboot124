package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.CheweixinxiDao;
import com.cl.entity.CheweixinxiEntity;
import com.cl.service.CheweixinxiService;
import com.cl.entity.view.CheweixinxiView;

@Service("cheweixinxiService")
public class CheweixinxiServiceImpl extends ServiceImpl<CheweixinxiDao, CheweixinxiEntity> implements CheweixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheweixinxiEntity> page = this.selectPage(
                new Query<CheweixinxiEntity>(params).getPage(),
                new EntityWrapper<CheweixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheweixinxiEntity> wrapper) {
		  Page<CheweixinxiView> page =new Query<CheweixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
	
	@Override
	public List<CheweixinxiView> selectListView(Wrapper<CheweixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheweixinxiView selectView(Wrapper<CheweixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<CheweixinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<CheweixinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<CheweixinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
