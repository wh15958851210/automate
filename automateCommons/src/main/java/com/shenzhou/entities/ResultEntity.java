package com.shenzhou.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("ResultEntity： 返回结果实体类")
public class ResultEntity<T> {
    @JsonProperty(value="code")
    @ApiModelProperty("信息码")
    private Integer code;
    @JsonProperty(value="msg")
    @ApiModelProperty("信息内容")
    private String msg;
    @JsonProperty(value="data")
    @ApiModelProperty("数据结果")
    private T data;

    public ResultEntity(Integer code,String msg){
        this(code,msg,null);
    }
}
