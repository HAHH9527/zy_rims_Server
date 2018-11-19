package cn.hnkjxy.zy.rims.utils;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableDishEntity;
import cn.hnkjxy.zy.rims.bean.json.TableDishAndBase64Image;

import java.util.ArrayList;
import java.util.List;

/**
 * 实体类转换管理工具类
 *
 * @author 10248
 */
public class BeanTransformUtils {

    /**
     * 给 List<TableDishEntity> 添加Base64Image
     * List<TableDishAndBase64Image>
     *
     * @param entityList 需要添加的List<TableDishEntity>
     * @return 添加完成的List<TableDishAndBase64Image>
     */
    public static List<TableDishAndBase64Image> menuListAddImageBase64(List<TableDishEntity> entityList) {
        List<TableDishAndBase64Image> menuList = new ArrayList<TableDishAndBase64Image>();
        entityList.forEach(tableDishEntity -> {
            TableDishAndBase64Image temp = tableDishAddImageBase64(tableDishEntity);
            if (temp != null) {
                menuList.add(temp);
            }
        });
        if (menuList.size() == 0) {
            return null;
        } else {
            return menuList;
        }
    }

    /**
     * 给 TableDishEntity 添加Base64Image
     * TableDishAndBase64Image
     *
     * @param tableDishEntity 需要添加的TableDishEntity
     * @return 添加完成的TableDishAndBase64Image
     */
    public static TableDishAndBase64Image tableDishAddImageBase64(TableDishEntity tableDishEntity) {
        TableDishAndBase64Image tableDishAndBase64Image = null;
        if (tableDishEntity != null) {
            tableDishAndBase64Image = new TableDishAndBase64Image();
            tableDishAndBase64Image.setDishId(tableDishEntity.getDishId());
            tableDishAndBase64Image.setDishName(tableDishEntity.getDishName());
            tableDishAndBase64Image.setDishPrice(tableDishEntity.getDishPrice());
            tableDishAndBase64Image.setDishIntroduced(tableDishEntity.getDishIntroduced());
            tableDishAndBase64Image.setDishImgName(tableDishEntity.getDishImgName());
            if (tableDishEntity.getDishImgName() != null) {
                tableDishAndBase64Image.setDishImgBase64Str(ImageBase64Utils.base64ImageReadByLocal(tableDishEntity.getDishImgName()));
            }
        }
        return tableDishAndBase64Image;
    }
}
