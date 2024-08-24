package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CheweileixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheweileixingView;


/**
 * 车位类型
 *
 * @author 
 * @email 
 * @date 2024-03-26 19:03:50
 */
public interface CheweileixingService extends IService<CheweileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheweileixingView> selectListView(Wrapper<CheweileixingEntity> wrapper);
   	
   	CheweileixingView selectView(@Param("ew") Wrapper<CheweileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheweileixingEntity> wrapper);
   	

}

