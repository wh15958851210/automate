package com.shenzhou.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shenzhou.dao.AutomateInterfaceMapper;
import com.shenzhou.entities.*;
import com.shenzhou.service.AutomateInterfaceService;
import com.shenzhou.utils.HanlderUtil;
import com.shenzhou.vo.ReceiveCartonVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Slf4j
@Service
@Transactional
public class AutomateInterfaceServiceImpl implements AutomateInterfaceService {
    @Autowired
    AutomateInterfaceMapper automateInterfaceMapper;

    /**
     * 执行查询预装箱数据
     * @param json
     * @return
     */
    @Override
    public ResultEntity getBoxAllInfo(JSONObject json) {
        String basketId = (String) json.get("basketId");
        log.info("三部根据basketId获取数据："+basketId);
        try {
            //取得订单数据
            Map<String, String> info = automateInterfaceMapper.getBasketInfo(basketId);
            //取得成衣数据
            List<Map<String, String>> clothData = automateInterfaceMapper.getBasketClothData(basketId);
            //取得贴标数据
            List<Map<String, String>> labelRule = automateInterfaceMapper.getBasketLabelRule(basketId);
            //取得盖章数据
            List<Map<String, String>> markRule = automateInterfaceMapper.getBasketMarkRule(basketId);
            //检查数据
            automateInterfaceMapper.updateInfoPack(basketId);

            Map map = new HashMap();
            map.put("basketId",info.get("basketId"));
            map.put("seqNo",info.get("seqNo"));
            map.put("department",info.get("department"));
            map.put("factroyNo",info.get("factroyNo"));
            map.put("classNo",info.get("classNo"));
            map.put("poNo",info.get("poNo"));
            map.put("clothType",info.get("clothType"));
            map.put("artNo",info.get("artNo"));
            map.put("clothData",clothData);      //  json  数组格式
            map.put("countAll",info.get("countAll"));
            map.put("custNo",info.get("custNo"));
            map.put("maxCartonNo",info.get("maxCartonNo"));
            map.put("currCartonNo",info.get("currCartonNo"));
            map.put("cartonCode",info.get("cartonCode"));
            map.put("cartonLength",info.get("cartonLength"));
            map.put("cartonWidth",info.get("cartonWidth"));
            map.put("cartonHeight",info.get("cartonHeight"));
            map.put("emptyWeight",info.get("emptyWeight"));
            map.put("weight",info.get("weight"));
            map.put("fullWeight",info.get("fullWeight"));
            map.put("artName",info.get("artName"));
            map.put("colorWay",info.get("colorWay"));
            map.put("sku",info.get("sku"));
            map.put("dent",info.get("dent"));
            map.put("vender",info.get("vender"));
            map.put("sealMethod",info.get("sealMethod"));
            map.put("sens",info.get("sens"));
            map.put("markRule",markRule);      //  json 格式
            map.put("labelRule",labelRule);            // json 格式
            map.put("clothRow",info.get("clothRow"));
            map.put("clothColum",info.get("clothColum"));
            map.put("clothOrientation",info.get("clothOrientation"));
            map.put("changeRule",info.get("changeRule"));
            map.put("packWidth", HanlderUtil.changeType(info.get("PackWidth")));
            map.put("shipTo", HanlderUtil.changeType(info.get("shipTo")));
            map.put("sizeBeginCarton",info.get("sizeBeginCarton"));
            map.put("sizeEndCarton",info.get("sizeEndCarton"));
            map.put("endBoxSign",info.get("endBoxSign"));
            map.put("custOrderNo",info.get("custOrderNo"));//用来区隔德国的尾箱
            return new ResultEntity(200,"查询成功!",map);
        }catch (Exception e){
            if(e.getMessage() ==null){
                return new ResultEntity(502,"查无该资料");
            }
            log.debug(e.getMessage());
            return new ResultEntity(500,e.getMessage());
        }
    }

    /**
     * 执行写入设备运行状态数据
     * @param autoBoxMachineState
     * @return
     */
    @Override
    public ResultEntity insertMachineState(AutoBoxMachineState autoBoxMachineState) {
        log.info("设备运行状态接口数据："+autoBoxMachineState);
        try {
            autoBoxMachineState.setUpdateTime(HanlderUtil.changeTime(autoBoxMachineState.getUpdateTime()));
            automateInterfaceMapper.insertMachineState(autoBoxMachineState);
            return new ResultEntity(200,"设备运行数据写入成功呢！");
        }catch (Exception e){
            log.debug(e.getMessage());
            return new ResultEntity(500,"设备运行数据写入成失败！");
        }
    }


    /**
     * 执行修改中转框状态
     * @param autoBoxBasketState
     * @return
     */
    public ResultEntity insertBoxBasketState(AutoBoxBasketState autoBoxBasketState){
        log.info("中转箱修改接口数据："+autoBoxBasketState);
        try {
            autoBoxBasketState.setUpdateTime(HanlderUtil.changeTime(autoBoxBasketState.getUpdateTime()));
            int count =  automateInterfaceMapper.insertBoxBasketState(autoBoxBasketState);
            return new ResultEntity(200,"写入中转框状态数据成功！");
        }catch (Exception e){
            log.debug(e.getMessage());
            return new ResultEntity(500,"写入中转框状态数据失败！");
        }
    }

    /**
     * 衣物数量不符
     * @param autoBoxCheckFail
     * @return
     */
    @Override
    public ResultEntity clothException(AutoBoxCheckFail autoBoxCheckFail) {
        log.info("衣物异常接口数据："+autoBoxCheckFail);
        try {
            String uuid = UUID.randomUUID().toString();
            autoBoxCheckFail.setFailType("衣物数量异常");
            autoBoxCheckFail.setCheckFailId(uuid);
            autoBoxCheckFail.setUpdateTime(HanlderUtil.changeTime(autoBoxCheckFail.getUpdateTime()));
            int count = automateInterfaceMapper.insertErrorLog(autoBoxCheckFail);
            if(count==200){
                List list = autoBoxCheckFail.getAutoBoxClothCheckFailList();
                if(list.size()>0){
                    for(int i=0;i<list.size();i++){
                        AutoBoxClothCheckFail autoBoxClothCheckFail = (AutoBoxClothCheckFail)list.get(i);
                        autoBoxClothCheckFail.setAutoBoxFailId(uuid);
                        autoBoxClothCheckFail.setSaveTime(autoBoxCheckFail.getUpdateTime());
                        automateInterfaceMapper.insertCloth(autoBoxClothCheckFail);
                    }
                }
            }
            return new ResultEntity(200,"成衣数量不符写入成功！");
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.debug(e.getMessage());
            return new ResultEntity(500,"成衣数量不符写入失败！");
        }
    }

    /**
     * 验针失败处理逻辑
     * @param json
     * @return
     */
    public ResultEntity needleException(JSONObject json){
        log.info("验针失败接口数据："+json);
        try {
            String uuid = UUID.randomUUID().toString();
            int count = handleAutoBoxCheckFail(uuid, "验针失败", json);
            if(count == 200){
                handleAutoBoxClothCheckFail(uuid,json);
            }
            return new ResultEntity(200,"验针失败数据写入成功！");
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.debug(e.getMessage());
            return new ResultEntity(500,"验针失败数据写入失败！");
        }

    }

    /**
     * 吊牌未识别处理逻辑
     * @param json
     * @return
     */
    public ResultEntity signIdentify(JSONObject json){
        log.info("吊牌未识别接口数据："+json);
        try {
            String uuid = UUID.randomUUID().toString();
            handleAutoBoxCheckFail(uuid, "吊牌未识别!", json);
            return new ResultEntity(200,"吊牌未识别数据写入成功!");
        }catch (Exception e){
            log.debug(e.getMessage());
            return new ResultEntity(500,"吊牌未识别数据写入失败!");
        }

    }

    /**
     * 尺码错误接口处理逻辑
     * @param json
     * @return
     */
    public ResultEntity identifyError(JSONObject json){
        log.info("吊牌错误接口数据："+json);
        try {
            String uuid = UUID.randomUUID().toString();
            int count = handleAutoBoxCheckFail(uuid, "吊牌错误", json);
            if(count == 200){
                handleAutoBoxClothCheckFail(uuid,json);
            }
            return new ResultEntity(200,"尺码错误数据写入成功！");
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.debug(e.getMessage());
            return new ResultEntity(500,"尺码错误数据写入失败！");
        }

    }


    /**
     * 装箱抓取失败接口处理逻辑
     * @param json
     * @return
     */
    public ResultEntity grabFail (JSONObject json){
        log.info("装箱抓取失败接口数据："+json);
        try {
            String uuid = UUID.randomUUID().toString();
            int count = handleAutoBoxCheckFail(uuid, "装箱抓取失败", json);
            if(count == 200){
                handleAutoBoxClothCheckFail(uuid,json);
            }
            return new ResultEntity(200,"装箱抓取失败数据写入成功！");
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.debug(e.getMessage());
            return new ResultEntity(500,"装箱抓取失败数据写入失败！");
        }

    }

    /**
     * NG主表写入数据
     * @param uuid
     * @param failType
     * @param json
     * @return
     */
    public int handleAutoBoxCheckFail(String uuid,String failType,JSONObject json){
        AutoBoxCheckFail autoBoxCheckFail = json.toJavaObject(AutoBoxCheckFail.class);
        autoBoxCheckFail.setFailType(failType);
        autoBoxCheckFail.setCheckFailId(uuid);
        autoBoxCheckFail.setUpdateTime(HanlderUtil.changeTime((String) json.get("updateTime")));
        return automateInterfaceMapper.insertErrorLog(autoBoxCheckFail);
    }

    /**
     * 返回件数异常写入是否成功
     * @param uuid
     * @param json
     * @return
     */
    public int handleAutoBoxClothCheckFail(String uuid,JSONObject json){
        AutoBoxClothCheckFail autoBoxClothCheckFail = json.toJavaObject(AutoBoxClothCheckFail.class);
        autoBoxClothCheckFail.setAutoBoxFailId(uuid);
        autoBoxClothCheckFail.setSaveTime(HanlderUtil.changeTime((String) json.get("updateTime")));
        return automateInterfaceMapper.insertCloth(autoBoxClothCheckFail);
    }


    /**
     * 中转框出位接口处理逻辑
     * @param json
     * @return
     */
    public ResultEntity insertPackOut(JSONObject json){
        log.info("包装箱出位接口数据："+json);
        try{
            String uuid = UUID.randomUUID().toString();
            AutoBoxPackOut autoBoxPackOut = json.toJavaObject(AutoBoxPackOut.class);
            autoBoxPackOut.setPackOutId(uuid);
            autoBoxPackOut.setUpdateTime(HanlderUtil.changeTime(autoBoxPackOut.getUpdateTime()));
            int count = automateInterfaceMapper.insertPackOut(autoBoxPackOut);
            if(count==200){
                List list = (List) json.get("packCloth");
                if(list.size()>0){
                    for(int i=0;i<list.size();i++){
                        AutoBoxPackOutDe autoBoxPackOutDe = new AutoBoxPackOutDe();
                        HashMap mapDe = (HashMap)list.get(i);
                        autoBoxPackOutDe.setPackOutId(uuid);
                        autoBoxPackOutDe.setColorNo(mapDe.get("artNo")==null?"":mapDe.get("artNo").toString());
                        autoBoxPackOutDe.setSize(mapDe.get("size")==null?"":mapDe.get("size").toString());
                        autoBoxPackOutDe.setCount(mapDe.get("count")==null?"":mapDe.get("count").toString());
                        autoBoxPackOutDe.setTagCode(mapDe.get("tagCode")==null?"":mapDe.get("tagCode").toString());
                        autoBoxPackOutDe.setSaveTime(autoBoxPackOut.getUpdateTime());
                        automateInterfaceMapper.insertPackOutDe(autoBoxPackOutDe);
                    }
                }
            }
            return new ResultEntity(200,"包装箱出位数据写入成功!");
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.debug(e.getMessage());
            return new ResultEntity(500,"包装箱出位数据写入失败!");
        }
    }


    /**
     * 包装箱封箱完成处理逻辑
     * @param json
     * @return
     */
    public ResultEntity insertPackOver(JSONObject json){
        log.info("封箱接口数据："+json);
        try{
            String uuid = UUID.randomUUID().toString();
            AutoBoxPackOver autoBoxPackOver = json.toJavaObject(AutoBoxPackOver.class);
            autoBoxPackOver.setPackOverId(uuid);
            autoBoxPackOver.setPackBeginTime(HanlderUtil.changeTime(autoBoxPackOver.getPackBeginTime()));
            autoBoxPackOver.setPackEndTime(HanlderUtil.changeTime(autoBoxPackOver.getPackEndTime()));
            autoBoxPackOver.setFirstSealBeginTime(HanlderUtil.changeTime(autoBoxPackOver.getFirstSealBeginTime()));
            autoBoxPackOver.setFirstSealEndTime(HanlderUtil.changeTime(autoBoxPackOver.getFirstSealEndTime()));
            autoBoxPackOver.setSecondSealBeginTime(HanlderUtil.changeTime(autoBoxPackOver.getSecondSealBeginTime()));
            autoBoxPackOver.setSecondSealEndTime(HanlderUtil.changeTime(autoBoxPackOver.getSecondSealEndTime()));
            autoBoxPackOver.setMarkBeginTime(HanlderUtil.changeTime(autoBoxPackOver.getMarkBeginTime()));
            autoBoxPackOver.setMarkEndTime(HanlderUtil.changeTime(autoBoxPackOver.getMarkEndTime()));
            autoBoxPackOver.setLableTime(HanlderUtil.changeTime(autoBoxPackOver.getLableTime()));
            autoBoxPackOver.setStampTime(HanlderUtil.changeTime(autoBoxPackOver.getStampTime()));
            autoBoxPackOver.setUpdateTime(HanlderUtil.changeTime(autoBoxPackOver.getUpdateTime()));
            int count = automateInterfaceMapper.insertPackOver(autoBoxPackOver);
            if(count==200){
                List list = (List) json.get("packCloth");
                if(list.size()>0){
                    for(int i=0;i<list.size();i++){
                        AutoBoxPackOverDe autoBoxPackOverDe = new AutoBoxPackOverDe();
                        HashMap mapDe = (HashMap)list.get(i);
                        autoBoxPackOverDe.setPackOverId(uuid);
                        autoBoxPackOverDe.setColorNo(mapDe.get("artNo")==null?"":mapDe.get("artNo").toString());
                        autoBoxPackOverDe.setSize(mapDe.get("size")==null?"":mapDe.get("size").toString());
                        autoBoxPackOverDe.setCount(mapDe.get("count")==null?"":mapDe.get("count").toString());
                        autoBoxPackOverDe.setTagCode(mapDe.get("tagCode")==null?"":mapDe.get("tagCode").toString());
                        autoBoxPackOverDe.setSaveTime(autoBoxPackOver.getUpdateTime());
                        automateInterfaceMapper.insertPackOverDe(autoBoxPackOverDe);
                    }
                }
            }
            return new ResultEntity(200,"包装箱封箱完成数据写入成功!");
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.debug(e.getMessage());
            return new ResultEntity(500,"包装箱封箱完成数据写入失败!");
        }
    }

    /**
     * 中转仓接收包装箱状态修改
     * @param receiveCartonVo
     * @return
     */
    @Override
    public ResultEntity getReceiveCarton(ReceiveCartonVo receiveCartonVo) {
        try {
            automateInterfaceMapper.getReceiveCarton(receiveCartonVo.getUccCode());
            return new ResultEntity(200,"中转仓包装箱接收信息修改成功!");
        }catch (Exception e){
            return new ResultEntity(500,"中转仓包装箱接收信息修改失败!");
        }

    }


}
