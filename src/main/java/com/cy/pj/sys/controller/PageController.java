package com.cy.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.pj.common.util.ShiroUtils;
import com.cy.pj.sys.entity.SysUser;
/**
 * 在此Controller中处理所有的页面请求
 * @author qilei
 *
 */
@RequestMapping("/")
@Controller
public class PageController {

	  @RequestMapping("doIndexUI")
	  public String doIndexUI(Model model) {
		  SysUser user=ShiroUtils.getUser();
		  model.addAttribute("loginUser", user.getUsername());
		  
		  /** 动态权限管理*/
		  
		  return "starter";
	  }
	  @RequestMapping("doLoginUI")
	  public String doLoginUI() {
		  return "login";
	  }
	  @RequestMapping("doPageUI")
	  public String doPageUI() {
		  return "common/page";
	  }
//	  @RequestMapping("log/log_list")
//	  public String doLogUI() {
//		  return "sys/log_list";//系统底层会将返回的字符串封装ModelAndView
//	  }
	  
//	  @RequestMapping("menu/menu_list")
//	  public String doMenuUI() {
//		  return "sys/menu_list";
//	  }	    
	  //rest风格的url设计，此风格的url可以{a}/{b}/{c}/{d}/.....以这种结构进行定义
	  //为什么rest url？简化url映射的定义，更加标准
	  //方法参数中假如要获取url中的数据，可以借助@PathVariable注解对方法参数进行描述
	  @RequestMapping("{module}/{moduleUI}")
	  public String doModuleUI(@PathVariable String moduleUI) {
		  return "sys/"+moduleUI;
	  }
	  
	  
}
