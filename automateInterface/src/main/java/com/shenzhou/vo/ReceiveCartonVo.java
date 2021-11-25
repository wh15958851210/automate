package com.shenzhou.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("中转仓接收包装箱成功！")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiveCartonVo {
    @JsonProperty(value="uccCode")
    @ApiModelProperty("uccCode码")
    private String uccCode;

}
