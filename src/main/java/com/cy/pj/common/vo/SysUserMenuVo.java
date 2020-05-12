package com.cy.pj.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class SysUserMenuVo implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 5418673238731957483L;
private Integer id;
   private String name;
   private String url;
   private List<SysUserMenuVo> childs;
}
