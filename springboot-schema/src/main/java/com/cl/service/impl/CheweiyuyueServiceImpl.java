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


import com.cl.dao.CheweiyuyueDao;
import com.cl.entity.CheweiyuyueEntity;
import com.cl.service.CheweiyuyueService;
import com.cl.entity.view.CheweiyuyueView;

@Service("cheweiyuyueService")
public class CheweiyuyueServiceImpl extends ServiceImpl<CheweiyuyueDao, CheweiyuyueEntity> implements CheweiyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheweiyuyueEntity> page = this.selectPage(
                new Query<CheweiyuyueEntity>(params).getPage(),
                new EntityWrapper<CheweiyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheweiyuyueEntity> wrapper) {
		  Page<CheweiyuyueView> page =new Query<CheweiyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
	
	@Override
	public List<CheweiyuyueView> selectListView(Wrapper<CheweiyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheweiyuyueView selectView(Wrapper<CheweiyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
