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
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("AutoBoxClothCheckFail 包装箱NG从表")
public class AutoBoxClothCheckFail implements Serializable {
    //NG从表ID
    @ApiModelProperty("uuid")
    @JsonProperty(value = "autoBoxClothFailId")
    private String autoBoxClothFailId;
    //NG主表ID
    @ApiModelProperty("主表uuid")
    @JsonProperty(value = "autoBoxFailId")
    private String autoBoxFailId;
    //吊牌条码
    @ApiModelProperty("吊牌号")
    @JsonProperty(value = "tagCode")
    private String tagCode;
    //颜色
    @ApiModelProperty("色号")
    @JsonProperty(value = "colorNo")
    private String colorNo;
    //尺码
    @ApiModelProperty("尺码")
    @JsonProperty(value = "size")
    private String size;
    //数量
    @ApiModelProperty("件数")
    @JsonProperty(value = "count")
    private String count;
    //记录时间
    @ApiModelProperty("建立时间")
    @JsonProperty(value = "updateTime")
    private String saveTime;
}
