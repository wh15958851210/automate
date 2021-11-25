package com.shenzhou.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("AutoBoxPackOut 中转框出位主档")
public class AutoBoxPackOut implements Serializable {
    //UUID
    @NotNull(message = "缺少参数packOutId")
    @ApiModelProperty("uuid")
    @JsonProperty(value="packOutId")
    private String packOutId;
    //中转框号
    @NotNull(message = "缺少参数basketId")
    @ApiModelProperty("中转框号")
    @JsonProperty(value="basketId")
    private String basketId;
    //批次号
    @NotNull(message = "缺少参数seqNo")
    @ApiModelProperty("流转号")
    @JsonProperty(value="seqNo")
    private String seqNo;
    //NG标识
    @NotNull(message = "缺少参数ngSign")
    @ApiModelProperty("ng标识")
    @JsonProperty(value="ngSign")
    private String ngSign;
    //箱条码
    @NotNull(message = "缺少参数cartonCode")
    @ApiModelProperty("箱条码")
    @JsonProperty(value="cartonCode")
    private String cartonCode;
    //箱号
    @NotNull(message = "缺少参数currCartonNo")
    @ApiModelProperty("箱号")
    @JsonProperty(value="currCartonNo")
    private String currCartonNo;
    //用户
    @NotNull(message = "缺少参数userNo")
    @ApiModelProperty("工号")
    @JsonProperty(value="userNo")
    private String userNo;
    //更新日期
    @NotNull(message = "缺少参数updateTime")
    @ApiModelProperty("建立日期")
    @JsonProperty(value="updateTime")
    private String updateTime;
}
