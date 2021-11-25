package com.shenzhou.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import java.io.Serializable;//序列化分部署可能用得到

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("AutoBoxBasketState 中转框下机记录实体类")
public class AutoBoxBasketState implements Serializable {
    @ApiModelProperty("UUID")
    @JsonProperty(value="basketStateId")
    private String basketStateId;
    // 中转框条码
    @ApiModelProperty("框号")
    @JsonProperty(value="basketId")
    private String basketId;
    //周转记录号
    @ApiModelProperty("流转号")
    @JsonProperty(value="seqNo")
    private String seqNo;
    //状态
    @ApiModelProperty("状态")
    @JsonProperty(value="status")
    private int status;
    //员工号
    @ApiModelProperty("工号")
    @JsonProperty(value="userNo")
    private String userNo;
    //修改时间
    @ApiModelProperty("新增时间")
    @JsonProperty(value="updateTime")
    private String updateTime;
    //设备号
    @ApiModelProperty("设备号")
    @JsonProperty(value="machineNo")
    private String machineNo;
    //通道号
    @ApiModelProperty("通道号")
    @JsonProperty(value="channelNo")
    private String channelNo;
}
