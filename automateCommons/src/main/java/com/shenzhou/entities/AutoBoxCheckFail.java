package com.shenzhou.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "autoBoxClothCheckFailList")
@ApiModel("AutoBoxCheckFail 包装箱NG信息主档")
public class AutoBoxCheckFail implements Serializable {
    //  id
    @ApiModelProperty("uuid")
    @JsonProperty(value ="checkFailId")
    private String checkFailId;
    // 失败类型
    @ApiModelProperty("失败原因")
    @JsonProperty(value ="failType")
    private String failType;
    //中转框条码
    @ApiModelProperty("中转框号")
    @JsonProperty(value ="basketId")
    private String basketId;
    //周转记录号
    @ApiModelProperty("流转号")
    @JsonProperty(value ="seqNo")
    private String seqNo;
    //箱条码
    @ApiModelProperty("箱条码")
    @JsonProperty(value ="cartonCode")
    private String cartonCode;
    //当前箱号
    @ApiModelProperty("箱号")
    @JsonProperty(value ="currCartonNo")
    private String currCartonNo;
    //当值人员工号
    @ApiModelProperty("工号")
    @JsonProperty(value ="userNo")
    private String userNo;
    // 修改状态时间
    @ApiModelProperty("更新日期")
    @JsonProperty(value ="updateTime")
    private String updateTime;
    //NG类型
    @ApiModelProperty("NG类型")
    @JsonProperty(value="countError")
    private String countError;
    //纸箱ID
    @ApiModelProperty("包装箱uuid")
    @JsonProperty(value="cartonId")
    private String cartonId;
    @ApiModelProperty("关联NG从表明细信息")
    @JsonProperty(value="lackCloth")
    private List<AutoBoxClothCheckFail> autoBoxClothCheckFailList;
}
