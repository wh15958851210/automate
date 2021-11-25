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
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("包装箱出位从表")
public class AutoBoxPackOutDe implements Serializable {
    //出位从表UUID
    @NotNull(message = "缺少参数packOutDeId")
    @ApiModelProperty("从表uuid")
    @JsonProperty(value = "packOutDeId")
    private String packOutDeId;
    //出位UUID
    @NotNull(message = "缺少参数packOutId")
    @ApiModelProperty("主表uuid")
    @JsonProperty(value = "packOutId")
    private String packOutId;
    //颜色
    @NotNull(message = "缺少参数colorNo")
    @ApiModelProperty("颜色")
    @JsonProperty(value = "colorNo")
    private String colorNo;
    //尺码
    @NotNull(message = "缺少参数size")
    @ApiModelProperty("尺码")
    @JsonProperty(value = "size")
    private String size;
    //件数
    @NotNull(message = "缺少参数count")
    @ApiModelProperty("数量")
    @JsonProperty(value = "count")
    private String count;
    //吊牌码
    @NotNull(message = "缺少参数tagCode")
    @ApiModelProperty("吊牌")
    @JsonProperty(value = "tagCode")
    private String tagCode;
    //保存时间
    @NotNull(message = "缺少参数saveTime")
    @ApiModelProperty("记录时间")
    @JsonProperty(value = "saveTime")
    private String saveTime;
}
