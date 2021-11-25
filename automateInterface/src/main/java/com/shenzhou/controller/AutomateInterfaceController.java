package com.shenzhou.controller;

import com.alibaba.fastjson.JSONObject;
import com.shenzhou.entities.AutoBoxBasketState;
import com.shenzhou.entities.AutoBoxCheckFail;
import com.shenzhou.entities.AutoBoxMachineState;
import com.shenzhou.entities.ResultEntity;
import com.shenzhou.service.AutomateInterfaceService;
import com.shenzhou.vo.ReceiveCartonVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boxInfo/autoBox")
public class AutomateInterfaceController {

    @Autowired
    private AutomateInterfaceService automateInterfaceService;

    /**
     *  根据basketid 查询数据，回调信息给他们
     */
    @ApiOperation("取得缝制装框信息接口")
    @PostMapping("/getBoxInfo")
    public Object getBoxInfo(@RequestBody JSONObject json) {
        return automateInterfaceService.getBoxAllInfo(json);
    }


    /**
     *  设备监控运行接口
     * @param autoBoxMachineState
     * @return
     */
    @ApiOperation("设备运行状态接口")
    @PostMapping("/machine")
    public ResultEntity insertMachineState(@ApiParam("设备运行状态实体类") @RequestBody AutoBoxMachineState autoBoxMachineState){
        return automateInterfaceService.insertMachineState(autoBoxMachineState);
    }


    /**
     *  修改中转箱状态
     * @param autoBoxBasketState
     * @return
     */
    @ApiOperation("中转框下机接口")
    @PostMapping("/boxBasket")
    public ResultEntity insertBoxBasketState(@ApiParam("中转框下机实体类") @RequestBody AutoBoxBasketState autoBoxBasketState){
        return automateInterfaceService.insertBoxBasketState(autoBoxBasketState);
    }

    /**
     * 衣物数量异常
     * @param autoBoxCheckFail
     * @return
     */
    @ApiOperation("衣物数量不足接口")
    @PostMapping("/clother")
    public ResultEntity insertClothLog(@ApiParam("包装箱下机NG实体类") @RequestBody AutoBoxCheckFail autoBoxCheckFail){
        return automateInterfaceService.clothException(autoBoxCheckFail);
    }


    /**
     * 验针失败接口
     * @param json
     * @return
     */
    @ApiOperation("验针失败接口")
    @PostMapping("/needle")
    public ResultEntity insertNeedleLog(@ApiParam("包装箱下机NG实体类")  @RequestBody JSONObject json){
        return automateInterfaceService.needleException(json);
    }


    /**
     *  吊牌未识别
     * @param json
     * @return
     */
    @ApiOperation("吊牌未识别接口")
    @PostMapping("/noIdentify")
    public ResultEntity signIdentify(@RequestBody JSONObject json){
        return automateInterfaceService.signIdentify(json);
    }


    /**
     *  吊牌错误
     * @param json
     * @return
     */
    @ApiOperation("尺码错误接口")
    @PostMapping("/identifyError")
    public ResultEntity identifyError(@RequestBody JSONObject json){
        return automateInterfaceService.identifyError(json);
    }



    /**
     *  装箱抓取失败
     * @param json
     * @return
     */
    @ApiOperation("装箱抓取失败接口")
    @PostMapping("/grabFail")
    public ResultEntity grabFail(@RequestBody JSONObject json){
        return automateInterfaceService.grabFail(json);
    }



    /**
     * 包装箱出位
     * @param
     * @return
     */
    @ApiOperation("包装箱出位接口")
    @PostMapping("/packOut")
    public ResultEntity insertPackOut(@RequestBody JSONObject json){
        return automateInterfaceService.insertPackOut(json);
    }


    /**
     *  封箱完成
     * @param
     * @return
     */
    @ApiOperation("包装箱封箱接口接口")
    @PostMapping("/packOver")
    public ResultEntity insertPackOver(@RequestBody JSONObject json){
        return automateInterfaceService.insertPackOver(json);
    }

    /**
     * 包装箱接收反馈
     * @param receiveCartonVo
     * @return
     */
    @ApiOperation("中转仓包装箱接收接口")
    @PostMapping("/getReceiveCarton")
    public ResultEntity getReceiveCarton(@ApiParam("中转仓接收包装箱VO") @RequestBody ReceiveCartonVo receiveCartonVo){
        return automateInterfaceService.getReceiveCarton(receiveCartonVo);
    }
}
