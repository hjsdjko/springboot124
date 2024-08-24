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


import com.cl.dao.CheweileixingDao;
import com.cl.entity.CheweileixingEntity;
import com.cl.service.CheweileixingService;
import com.cl.entity.view.CheweileixingView;

@Service("cheweileixingService")
public class CheweileixingServiceImpl extends ServiceImpl<CheweileixingDao, CheweileixingEntity> implements CheweileixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheweileixingEntity> page = this.selectPage(
                new Query<CheweileixingEntity>(params).getPage(),
                new EntityWrapper<CheweileixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheweileixingEntity> wrapper) {
		  Page<CheweileixingView> page =new Query<CheweileixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
	
	@Override
	public List<CheweileixingView> selectListView(Wrapper<CheweileixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheweileixingView selectView(Wrapper<CheweileixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
