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


import com.cl.dao.TingchechangDao;
import com.cl.entity.TingchechangEntity;
import com.cl.service.TingchechangService;
import com.cl.entity.view.TingchechangView;

@Service("tingchechangService")
public class TingchechangServiceImpl extends ServiceImpl<TingchechangDao, TingchechangEntity> implements TingchechangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TingchechangEntity> page = this.selectPage(
                new Query<TingchechangEntity>(params).getPage(),
                new EntityWrapper<TingchechangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TingchechangEntity> wrapper) {
		  Page<TingchechangView> page =new Query<TingchechangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
	
	@Override
	public List<TingchechangView> selectListView(Wrapper<TingchechangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TingchechangView selectView(Wrapper<TingchechangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
