package cn.hnkjxy.zy.rims.utils;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableDishEntity;
import cn.hnkjxy.zy.rims.bean.json.TableDishAndBase64Image;
import cn.hnkjxy.zy.rims.datebase.dao.DishDao;
import com.google.gson.Gson;

import java.util.List;

/**
 * 管理菜单工具类
 *
 * @author 10248
 */
public class MenuMangerUtils {
    private static boolean updateStatus = false;
    private static List<TableDishEntity> tableDishEntityList;
    private static List<TableDishAndBase64Image> menuAndBase64List;
    private static String menuJson;

    /**
     * 添加菜品
     *
     * @param tableDishAndBase64Image 需要添加的菜品信息
     * @return 新菜品id(返回 - 1添加失败)
     */
    public static int addDish(TableDishAndBase64Image tableDishAndBase64Image) {
        int newDishId;

        //将Base64图片存至本地
        try {
            if (!ImageBase64Utils.base64ImageSaveToLocal(tableDishAndBase64Image.getDishImgBase64Str()
                    , tableDishAndBase64Image.getDishImgName())) {
                newDishId = -1;
                return newDishId;
            }
        } catch (Exception e) {
            newDishId = -1;
            e.printStackTrace();
            return newDishId;
        }

        //转换实体类
        TableDishEntity tableDishEntity = BeanTransformUtils.tableDishAndBase64ImageDeleteBase64(tableDishAndBase64Image);

        //操作数据库
        DishDao dao = new DishDao();
        try {
            newDishId = dao.insertNewDish(tableDishEntity);
        } catch (Exception e) {
            e.printStackTrace();
            newDishId = -1;
        }

        //更新内存中菜单数据
        updateMenu();

        return newDishId;
    }

    /**
     * 更新菜品
     *
     * @param tableDishAndBase64Image 需要更新的菜品信息
     * @return 更新成功或者失败
     */
    public static boolean updateDish(TableDishAndBase64Image tableDishAndBase64Image) {
        boolean ret;

        if (tableDishAndBase64Image.getDishImgBase64Str() == null || "".equals(tableDishAndBase64Image.getDishImgBase64Str())) {
        } else {
            try {
                if (!ImageBase64Utils.base64ImageSaveToLocal(tableDishAndBase64Image.getDishImgBase64Str()
                        , tableDishAndBase64Image.getDishImgName())) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        //转换实体类
        TableDishEntity tableDishEntity = BeanTransformUtils.tableDishAndBase64ImageDeleteBase64(tableDishAndBase64Image);

        //操作数据库
        DishDao dao = new DishDao();
        try {
            ret = dao.updateDishById(tableDishEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        updateMenu();
        return ret;
    }

    /**
     * 通过id删除菜品
     *
     * @param dishId 需要删除的菜品id
     * @return 删除成功或者失败
     */
    public static boolean deleteDish(int dishId) {
        boolean ret = new DishDao().deleteDishById(dishId);
        updateMenu();
        return ret;
    }

    /**
     * 更新菜单数据进入内存中
     */
    public static void updateMenu() {
        startUpdateMenuThread();
    }

    /**
     * 启动更新菜单线程,5000毫秒未完成则中断线程,更新失败
     */
    private static void startUpdateMenuThread() {
        UpdateMenuThread updateMenuThread = new UpdateMenuThread();
        updateMenuThread.start();
    }

    /**
     * 更新菜单线程,UpdateMenuThread内部类
     */
    private static class UpdateMenuThread extends Thread {
        @Override
        public void run() {
            updateStatus = false;
            if (updateMenuStep1()) {
                updateMenuStep2();
                updateMenuStep3();
                updateStatus = true;
            } else {
                updateStatus = false;
            }
        }
    }

    /**
     * 更新第一步,从数据库读取数据
     *
     * @return 从数据库读取是否成功
     */
    private static boolean updateMenuStep1() {
        DishDao dao = new DishDao();
        List<TableDishEntity> temp = dao.getMenu();

        //如果未查询到内容 返回false
        if (temp == null || temp.size() <= 0) {
            updateStatus = false;
            return false;
        } else {
            tableDishEntityList = temp;
            return true;
        }
    }

    /**
     * 更新第二步,将实体类进行转换,添加图片数据
     */
    private static void updateMenuStep2() {
        menuAndBase64List = BeanTransformUtils.menuListAddImageBase64(tableDishEntityList);
    }

    /**
     * 更新第三步,将图片实体类转换成json数据,等待发送
     */
    private static void updateMenuStep3() {
        menuJson = new Gson().toJson(menuAndBase64List);
    }

    public static String getMenuJson() {
        return menuJson;
    }

}


