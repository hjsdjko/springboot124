package com.cl.entity.view;

import com.cl.entity.CheweiyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 车位预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 19:03:50
 */
@TableName("cheweiyuyue")
public class CheweiyuyueView  extends CheweiyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CheweiyuyueView(){
	}
 
 	public CheweiyuyueView(CheweiyuyueEntity cheweiyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, cheweiyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
