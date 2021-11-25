package com.shenzhou.entities;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("AutoBoxMachineState 设备运行状态实体")
public class AutoBoxMachineState implements Serializable {
    //uuid
    @JsonProperty(value="machineStateId")
    @ApiModelProperty("uuid")
    private String machineStateId;
    // 包装线
    @JsonProperty(value="machineNo")
    @ApiModelProperty("设备号")
    private String machineNo;
    //状态 0-停止；1-运行
    @JsonProperty(value="status")
    @ApiModelProperty("状态")
    private String status;
    // 生产方式
    @JsonProperty(value="method")
    @ApiModelProperty("生产方式")
    private String method;
    //停机原因
    @JsonProperty(value="stopReason")
    @ApiModelProperty("停机原因")
    private String stopReason;
    // 当值人员工号
    @JsonProperty(value="userNo")
    @ApiModelProperty("工号")
    private String userNo;
    //修改状态时间
    @JsonProperty(value="updateTime")
    @ApiModelProperty("建立时间")
    private String updateTime;
}
