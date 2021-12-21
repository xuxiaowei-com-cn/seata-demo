package cn.com.xuxiaowei.c.generator;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT;
import static com.baomidou.mybatisplus.annotation.FieldFill.UPDATE;

/**
 * 基础模型
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Data
@Accessors(chain = true)
public class BaseModel implements Serializable {


    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间，不为空
     */
    @TableField("create_date")
    private LocalDateTime createDate;

    /**
     * 更新时间，未更新时为空
     */
    @TableField(value = "update_date", fill = UPDATE)
    private LocalDateTime updateDate;

    /**
     * 创建人，不为空
     */
    @TableField(value = "create_username", fill = INSERT)
    private String createUsername;

    /**
     * 更新人，未更新时为空
     */
    @TableField(value = "update_username", fill = UPDATE)
    private String updateUsername;

    /**
     * 创建者IP，不为空
     */
    @TableField(value = "create_ip", fill = INSERT)
    private String createIp;

    /**
     * 更新者IP，未更新时为空
     */
    @TableField(value = "update_ip", fill = UPDATE)
    private String updateIp;

    /**
     * 逻辑删除，0 未删除，1 删除，MySQL 默认值 0，不为 NULL，注解@TableLogic。
     */
    @TableLogic
    private Boolean deleted;


    public static final String REMARK = "remark";

    public static final String CREATE_DATE = "create_date";

    public static final String UPDATE_DATE = "update_date";

    public static final String CREATE_USERNAME = "create_username";

    public static final String UPDATE_USERNAME = "update_username";

    public static final String CREATE_IP = "create_ip";

    public static final String UPDATE_IP = "update_ip";

    public static final String DELETED = "deleted";

}
