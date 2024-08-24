package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 停车场
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-26 19:03:50
 */
@TableName("tingchechang")
public class TingchechangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TingchechangEntity() {
		
	}
	
	public TingchechangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 停车场名称
	 */
					
	private String tingchechangmingcheng;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 停车场位置
	 */
					
	private String tingchechangweizhi;
	
	/**
	 * 车位数
	 */
					
	private Integer cheweishu;
	
	/**
	 * 类型
	 */
					
	private String leixing;
	
	/**
	 * 配套实施
	 */
					
	private String peitaoshishi;
	
	/**
	 * 收费标准
	 */
					
	private String shoufeibiaozhun;
	
	/**
	 * 详情
	 */
					
	private String xiangqing;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：停车场名称
	 */
	public void setTingchechangmingcheng(String tingchechangmingcheng) {
		this.tingchechangmingcheng = tingchechangmingcheng;
	}
	/**
	 * 获取：停车场名称
	 */
	public String getTingchechangmingcheng() {
		return tingchechangmingcheng;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：停车场位置
	 */
	public void setTingchechangweizhi(String tingchechangweizhi) {
		this.tingchechangweizhi = tingchechangweizhi;
	}
	/**
	 * 获取：停车场位置
	 */
	public String getTingchechangweizhi() {
		return tingchechangweizhi;
	}
	/**
	 * 设置：车位数
	 */
	public void setCheweishu(Integer cheweishu) {
		this.cheweishu = cheweishu;
	}
	/**
	 * 获取：车位数
	 */
	public Integer getCheweishu() {
		return cheweishu;
	}
	/**
	 * 设置：类型
	 */
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	/**
	 * 获取：类型
	 */
	public String getLeixing() {
		return leixing;
	}
	/**
	 * 设置：配套实施
	 */
	public void setPeitaoshishi(String peitaoshishi) {
		this.peitaoshishi = peitaoshishi;
	}
	/**
	 * 获取：配套实施
	 */
	public String getPeitaoshishi() {
		return peitaoshishi;
	}
	/**
	 * 设置：收费标准
	 */
	public void setShoufeibiaozhun(String shoufeibiaozhun) {
		this.shoufeibiaozhun = shoufeibiaozhun;
	}
	/**
	 * 获取：收费标准
	 */
	public String getShoufeibiaozhun() {
		return shoufeibiaozhun;
	}
	/**
	 * 设置：详情
	 */
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	/**
	 * 获取：详情
	 */
	public String getXiangqing() {
		return xiangqing;
	}

}
