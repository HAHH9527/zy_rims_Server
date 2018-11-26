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
     * 将TableDishAndBase64Image中的Base64Str去除，转换成TableDishEntity
     *
     * @param tableDishAndBase64Image 需要去除的TableDishAndBase64Image
     * @return 处理完的TableDishEntity
     */
    public static TableDishEntity tableDishAndBase64ImageDeleteBase64(TableDishAndBase64Image tableDishAndBase64Image) {
        TableDishEntity tableDishEntity = new TableDishEntity();
        tableDishEntity.setDishId(tableDishAndBase64Image.getDishId());
        tableDishEntity.setDishName(tableDishAndBase64Image.getDishName());
        tableDishEntity.setDishPrice(tableDishAndBase64Image.getDishPrice());
        tableDishEntity.setDishImgName(tableDishAndBase64Image.getDishImgName());
        tableDishEntity.setDishIntroduced(tableDishAndBase64Image.getDishIntroduced());

        return tableDishEntity;
    }

    /**
     * 给 List<TableDishEntity> 添加Base64Image
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
