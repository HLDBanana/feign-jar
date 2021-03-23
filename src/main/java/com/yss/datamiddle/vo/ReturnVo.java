package com.yss.datamiddle.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户集合(供其他服务组件调用)
 */
@Data
@ApiModel("用户集合(供其他服务组件调用)")
@AllArgsConstructor
@NoArgsConstructor
public class ReturnVo {
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "用户id")
    private Integer userId;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    public static ReturnVo getList(SysUser user){
        ReturnVo vo = new ReturnVo();
        vo.setUserId(user.getUserId());
        vo.setUserName(user.getUsername());
        return vo;
    }
}
