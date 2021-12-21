package cn.com.xuxiaowei.a.entity;

import cn.com.xuxiaowei.a.generator.BaseModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * A表
 * </p>
 *
 * @author xuxiaowei
 * @since 2021-12-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("a")
public class A extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * A表，主键，自增
     */
    @TableId(value = "a_id", type = IdType.AUTO)
    private Long aId;

    /**
     * 数量
     */
    private Integer num;


    public static final String A_ID = "a_id";

    public static final String NUM = "num";

}
