package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TingchechangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TingchechangView;


/**
 * 停车场
 *
 * @author 
 * @email 
 * @date 2024-03-26 19:03:50
 */
public interface TingchechangService extends IService<TingchechangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TingchechangView> selectListView(Wrapper<TingchechangEntity> wrapper);
   	
   	TingchechangView selectView(@Param("ew") Wrapper<TingchechangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TingchechangEntity> wrapper);
   	

}

