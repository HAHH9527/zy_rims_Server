package cn.hnkjxy.zy.rims.datebase.impl;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableDishEntity;

import java.util.List;

/**
 * @author 10248
 */
public interface DishImpl {

    /**
     * 添加新菜品
     *
     * @param newDish 菜品实体类
     * @return 成功返回菜品id/失败返回-1
     */
    int insertNewDish(TableDishEntity newDish);

    /**
     * 通过菜品id查找菜品
     *
     * @param dishId 菜品id
     * @return 查询到的菜品数据
     */
    TableDishEntity findDishById(int dishId);

    /**
     * 通过菜品id更新菜品详情
     *
     * @param updateDish 菜品详情
     * @return 更新是否成功
     */
    boolean updateDish(TableDishEntity updateDish);

    /**
     * 通过id删除菜品
     *
     * @param dishId 菜品id
     * @return 删除是否成功
     */
    boolean deleteDishById(int dishId);

    /**
     * 获取所有的菜单
     *
     * @return 菜单list
     */
    List<TableDishEntity> getMenu();
}
