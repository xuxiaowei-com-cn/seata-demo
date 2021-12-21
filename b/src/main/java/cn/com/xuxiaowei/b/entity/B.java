package cn.com.xuxiaowei.b.entity;

import cn.com.xuxiaowei.b.generator.BaseModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * B表
 * </p>
 *
 * @author xuxiaowei
 * @since 2021-12-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("b")
public class B extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * B表，主键，自增
     */
    @TableId(value = "b_id", type = IdType.AUTO)
    private Long bId;

    /**
     * 数量
     */
    private Integer num;


    public static final String B_ID = "b_id";

    public static final String NUM = "num";

}
