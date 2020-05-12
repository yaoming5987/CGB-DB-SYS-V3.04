package com.cy.pj.sys.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.common.vo.Node;
import com.cy.pj.common.vo.SysUserMenuVo;
import com.cy.pj.sys.entity.SysMenu;
@Mapper
public interface SysMenuDao {
	
	/**
	 * 基于菜单获取菜单信息
	 * 
	 */
	 List<SysUserMenuVo> findMenusByIds(List<Integer>  menuIds);
	/**
	 * 基于多个菜单id找到对应的授权标识
	 * @param menuIds
	 * @return
	 */
	List<String> findPermissions(Integer[] menuIds);
	/**
	 * 将菜单信息更新到数据库
	 * @param entity
	 * @return
	 */
	int updateObject(SysMenu entity);//update ... where id=..
	/**
	 * 将菜单信息持久化到数据库
	 * @param entity
	 * @return
	 */
	int insertObject(SysMenu entity);
	/**
	 * 查找所有的菜单节点信息
	 * @return
	 */
	@Select("select id,name,parentId from sys_menus")
	List<Node> findZtreeMenuNodes();

	
	/**
	 * 基于菜单id统计子菜单的个数
	 * @param id
	 * @return
	 */
	@Select("select count(*) from sys_menus where parentId=#{id}")
	int getChildCount(Integer id);
	/**
	 * 基于菜单id删除菜单自身信息
	 * @param id
	 * @return
	 */
	@Delete("delete from sys_menus where id=#{id}")
	int deleteObject(Integer id);
    /**
     * 查询所有菜单以及菜单对应的上级菜单名称
     * @return
     */
	List<Map<String,Object>> findObjects();
	
}
