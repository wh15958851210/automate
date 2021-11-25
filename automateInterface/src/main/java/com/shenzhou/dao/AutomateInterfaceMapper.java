package com.shenzhou.dao;

import com.shenzhou.entities.*;
import com.shenzhou.vo.ReceiveCartonVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AutomateInterfaceMapper {
    /** tag 0 ******************************************************************************/
    //查询成衣订单信息
    Map getBasketInfo(@Param("basketId") String basketId);
    //查询成衣信息
    List<Map<String,String>> getBasketClothData(@Param("basketId") String basketId);
    //查询成衣盖章信息
    List<Map<String,String>> getBasketMarkRule(@Param("basketId") String basketId);
    //查询成衣贴标信息
    List<Map<String,String>> getBasketLabelRule(@Param("basketId") String basketId);
    //中转框上线更新状态
    int updateInfoPack(@Param("basketId") String basketId);
    /** tag 1 ******************************************************************************/
    //写入设备状态数据
    int insertMachineState(AutoBoxMachineState autoBoxMachineState);
    /** tag 2 ******************************************************************************/
    //写入框状态数据
    int insertBoxBasketState(AutoBoxBasketState autoBoxBasketState);
    /** tag 3 ******************************************************************************/
    //写入NG数据
    int insertErrorLog(AutoBoxCheckFail autoBoxCheckFail);
    //写入NG从表数据
    int insertCloth(AutoBoxClothCheckFail autoBoxClothCheckFail);
    //通过ID查询NG数据
    int findClothById(@Param("id")String id);
    /** tag 4 ******************************************************************************/
    //写入纸箱出位数据
    int insertPackOut(AutoBoxPackOut autoBoxPackOut);
    //写入纸箱出位从表数据
    int insertPackOutDe(AutoBoxPackOutDe autoBoxPackOutDe);
    //通过ID查询纸箱出位信息
    int findNumById(@Param("id") String id);
    /** tag 5 ******************************************************************************/
    //写入纸箱封箱数据
    int insertPackOver(AutoBoxPackOver autoBoxPackOver);
    //写入纸箱封箱从表数据
    int insertPackOverDe(AutoBoxPackOverDe autoBoxPackOverDe);
    //通过ID查询纸箱封箱完成数据
    int findPackOverNumById(@Param("id") String id);
    //包装箱中转仓接收接口逻辑
    int getReceiveCarton(String uccCode);


}
