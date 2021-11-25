package com.shenzhou.service;

import com.alibaba.fastjson.JSONObject;
import com.shenzhou.entities.AutoBoxBasketState;
import com.shenzhou.entities.AutoBoxCheckFail;
import com.shenzhou.entities.AutoBoxMachineState;
import com.shenzhou.entities.ResultEntity;
import com.shenzhou.vo.ReceiveCartonVo;


public interface AutomateInterfaceService {
    //取得所有衣物
    public ResultEntity getBoxAllInfo(JSONObject json);
    //写入设备运行状态
    public ResultEntity insertMachineState(AutoBoxMachineState autoBoxMachineState);
    //修改中转框上机状态
    public ResultEntity insertBoxBasketState(AutoBoxBasketState autoBoxBasketState);
    //衣服数量不符逻辑
    public ResultEntity clothException(AutoBoxCheckFail autoBoxCheckFail);
    //验针异常逻辑
    public ResultEntity needleException(JSONObject json);
    //吊牌未识别接口处理逻辑
    public ResultEntity signIdentify(JSONObject json);
    //尺码错误数据处理逻辑
    public ResultEntity identifyError(JSONObject json);
    //装箱抓取失败处理逻辑
    public ResultEntity grabFail (JSONObject json);
    //包装箱出位接口处理逻辑
    public ResultEntity insertPackOut(JSONObject json);
    //包装箱封箱完成接口处理逻辑
    public ResultEntity insertPackOver(JSONObject json);
    //包装箱中转仓接收接口逻辑
    public ResultEntity getReceiveCarton(ReceiveCartonVo receiveCartonVo);
}
