package cn.com.xuxiaowei.c.entity;

import cn.com.xuxiaowei.c.generator.BaseModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * C表
 * </p>
 *
 * @author xuxiaowei
 * @since 2021-12-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("c")
public class C extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * C表，主键，自增
     */
    @TableId(value = "c_id", type = IdType.AUTO)
    private Long cId;

    /**
     * 数量
     */
    private Integer num;


    public static final String C_ID = "c_id";

    public static final String NUM = "num";

}
