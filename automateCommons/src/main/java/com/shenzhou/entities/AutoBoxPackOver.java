package com.shenzhou.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("AutoBoxPackOver 包装箱封箱表")
public class AutoBoxPackOver implements Serializable {
    //包装箱封箱主表ID
    @NotNull(message = "缺少参数packOverId")
    @ApiModelProperty("uuid")
    @JsonProperty(value="packOverId")
    private  String packOverId;
    //中转框号
    @NotNull(message = "缺少参数basketId")
    @ApiModelProperty("中转框号")
    @JsonProperty(value="basketId")
    private String basketId;
    //流转号
    @NotNull(message = "缺少参数seqNo")
    @ApiModelProperty("流转号")
    @JsonProperty(value="seqNo")
    private String  seqNo;
    //箱条码
    @NotNull(message = "缺少参数cartonCode")
    @ApiModelProperty("箱条码")
    @JsonProperty(value="cartonCode")
    private String  cartonCode;
    //箱号
    @NotNull(message = "缺少参数currCartonNo")
    @ApiModelProperty("箱号")
    @JsonProperty(value="currCartonNo")
    private String  currCartonNo;
    //分拣开始时间
    @NotNull(message = "缺少参数packBeginTime")
    @ApiModelProperty("装箱开始时间")
    @JsonProperty(value="packBeginTime")
    private String  packBeginTime;
    //分拣结束时间
    @NotNull(message = "缺少参数packEndTime")
    @ApiModelProperty("装箱结束时间")
    @JsonProperty(value="packEndTime")
    private String  packEndTime;
    //ng标识
    @NotNull(message = "缺少参数ngSign")
    @ApiModelProperty("ng标识")
    @JsonProperty(value="ngSign")
    private String  ngSign;
    //工字封箱开始时间（进入封箱线时间）
    @NotNull(message = "缺少参数firstSealBeginTime")
    @ApiModelProperty("进入封箱线时间")
    @JsonProperty(value="firstSealBeginTime")
    private String  firstSealBeginTime;
    //工字封箱结束时间
    @NotNull(message = "缺少参数firstSealEndTime")
    @ApiModelProperty("工字封箱结束时间")
    @JsonProperty(value="firstSealEndTime")
    private String  firstSealEndTime;
    //王字封箱开始时间
    @NotNull(message = "缺少参数secondSealBeginTime")
    @ApiModelProperty("王字封箱开始时间")
    @JsonProperty(value="secondSealBeginTime")
    private String  secondSealBeginTime;
    //王字封箱结束时间
    @NotNull(message = "缺少参数secondSealEndTime")
    @ApiModelProperty("王字封箱结束时间")
    @JsonProperty(value="secondSealEndTime")
    private String  secondSealEndTime;
    //盖章开始时间
    @NotNull(message = "缺少参数markBeginTime")
    @ApiModelProperty("喷印开始时间")
    @JsonProperty(value="markBeginTime")
    private String  markBeginTime;
    //盖章结束时间
    @NotNull(message = "缺少参数markEndTime")
    @ApiModelProperty("喷印结束时间")
    @JsonProperty(value="markEndTime")
    private String  markEndTime;
    //贴标开始时间
    @NotNull(message = "缺少参数lableTime")
    @ApiModelProperty("贴标时间")
    @JsonProperty(value="lableTime")
    private String  lableTime;
    //贴标截止时间
    @NotNull(message = "缺少参数stampTime")
    @ApiModelProperty("盖章时间")
    @JsonProperty(value="stampTime")
    private String  stampTime;
    //员工号
    @NotNull(message = "缺少参数userNo")
    @ApiModelProperty("员工工号")
    @JsonProperty(value="userNo")
    private String  userNo;
    //更新时间
    @NotNull(message = "缺少参数updateTime")
    @ApiModelProperty("记录时间")
    @JsonProperty(value="updateTime")
    private String  updateTime;
    //ip地址
    @NotNull(message = "缺少参数IpAddress")
    @ApiModelProperty("验针机IP")
    @JsonProperty(value="IpAddress")
    private String  IpAddress;
    //验针号
    @NotNull(message = "缺少参数input_id")
    @ApiModelProperty("验针机账号")
    @JsonProperty(value="input_id")
    private String  input_id;
    //ucc
    @NotNull(message = "缺少参数uccCode")
    @ApiModelProperty("uccCode")
    @JsonProperty(value="uccCode")
    private String  uccCode;
}
