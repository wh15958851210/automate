package com.shenzhou.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("AutoBoxPackOverDe 包装箱封箱从表")
public class AutoBoxPackOverDe implements Serializable {
    //uuid
    @NotNull(message = "缺少packOverDeId信息")
    @ApiModelProperty("从表uuid")
    @JsonProperty(value = "packOverDeId")
    private String packOverDeId;
    //uuid
    @NotNull(message = "缺少packOverId信息")
    @ApiModelProperty("主档uuid")
    @JsonProperty(value = "packOverId")
    private String packOverId;
    //颜色
    @NotNull(message = "缺少colorNo信息")
    @ApiModelProperty("颜色")
    @JsonProperty(value = "colorNo")
    private String colorNo;
    //尺码
    @NotNull(message = "缺少size信息")
    @ApiModelProperty("尺码")
    @JsonProperty(value = "size")
    private String size;
    //件数
    @NotNull(message = "缺少count信息")
    @ApiModelProperty("件数")
    @JsonProperty(value = "count")
    private String count;
    //吊牌码
    @NotNull(message = "缺少tagCode信息")
    @ApiModelProperty("吊牌")
    @JsonProperty(value = "tagCode")
    private String tagCode;
    //保存时间
    @NotNull(message = "缺少saveTime信息")
    @ApiModelProperty("记录时间")
    @JsonProperty(value = "saveTime")
    private String saveTime;

}
