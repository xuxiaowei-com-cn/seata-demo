package cn.com.xuxiaowei.c.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Data;

import java.io.File;
import java.util.Scanner;

/**
 * MyBatis Plus 代码生成器
 *
 * @author xuxiaowei
 * @see <a href="https://github.com/baomidou/generator">mybatis-plus-generator</a>
 * @since 0.0.1
 */
@Data
class MyBatisPlusGenerator {

    /**
     * 读取本地项目文件夹路径（Spring Boot）
     */
    private static String projectPath = System.getProperty("user.dir");

    /**
     * 主包名
     */
    private static String parent = "cn.com.xuxiaowei.c";

    /**
     * 逻辑删除数据库字段名称
     */
    private static String DELETED = "deleted";

    /**
     * 设置 主文件夹
     */
    public static String getMain() {
        return projectPath + "/c/src/main";
    }

    /**
     * 设置 java 文件夹
     */
    public static String getJava() {
        return getMain() + "/java";
    }

    /**
     * 数据库
     */
    enum Datasource {

        /**
         * MySQL 数据库 seata-demo-c
         */
        MYSQL_C("jdbc:p6spy:mysql://127.0.0.1:3306/seata-demo-c?useSSL=false&serverTimezone=GMT%2B8&characterEncoding=UTF-8",
                "root", "root", "MySQL 数据库 seata-demo-c"),

        ;

        /**
         * 数据库连接串
         */
        private final String url;

        /**
         * 数据库用户名
         */
        private final String username;

        /**
         * 数据库密码
         */
        private final String password;

        /**
         * 数据库说明
         */
        private final String explain;

        Datasource(String url, String username, String password, String explain) {
            this.url = url;
            this.username = username;
            this.password = password;
            this.explain = explain;
        }

    }

    /**
     * 选择数据库
     *
     * @return 返回 数据库序号
     */
    private static int scannerDataSource() {
        Datasource[] values = Datasource.values();

        for (int i = 0; i < values.length; i++) {
            Datasource value = values[i];
            System.out.printf("数据库序号：%s 数据库说明：%s 数据库连接串：%s 数据库用户名：%s%n",
                    i, value.explain, value.url, value.username);
        }

        String datasource = scanner("请选择数据库序号");

        int integer;

        try {
            integer = Integer.parseInt(datasource);

            if (integer >= 0 && integer < values.length) {
                System.out.println("输入数据库序号正常");
            } else {
                System.err.println("输入数据库序号不在有效范围内");
                return scannerDataSource();
            }

        } catch (Exception e) {
            System.err.println("输入数据库序号不正确");
            e.printStackTrace();
            return scannerDataSource();
        }

        return integer;
    }

    public static void main(String[] args) {

        int scannerDataSource = scannerDataSource();
        String author = scanner("作者");
        String include = scanner("表名，多个英文逗号分割");
        String moduleName = scanner("生成模块名，英文点（.）为跳过");

        String scannerOverride = scanner("是否覆盖：\n输入“f”时，覆盖原文件");

        // 文件是否覆盖
        String fileOverride = "f";

        String[] includeSplit = include.split(",");

        Datasource[] values = Datasource.values();
        Datasource datasource = values[scannerDataSource];

        FastAutoGenerator.create(datasource.url, datasource.username, datasource.password)
                .globalConfig(builder -> {
                    builder
                            // 开发人员
                            .author(author)
                            // 时间类型对应策略
                            .dateType(DateType.TIME_PACK)
                            // 是否打开输出目录
                            .openDir(false)
                            // 生成文件的输出目录【 windows:D:// linux or mac:/tmp 】
                            .outputDir(getJava());

                    if (fileOverride.equals(scannerOverride)) {
                        // 覆盖已有文件
                        builder.fileOverride();
                    }

                })
                .packageConfig(builder -> {
                    builder
                            // 指定父包名
                            .parent(parent);

                    if (!StringPool.DOT.equals(moduleName)) {
                        builder
                                // 指定模块名称
                                .moduleName(".");
                    }
                })
                .strategyConfig(builder -> {
                    builder
                            // 增加包含的表名
                            .addInclude(includeSplit)
                            // 实体配置构建者
                            .entityBuilder()
                            // 开启lombok模型
                            .enableLombok()
                            // 自定义继承的Entity类全称
                            .superClass(BaseModel.class)
                            // 添加父类公共字段
                            .addSuperEntityColumns("remark", "create_date", "update_date", "create_username", "update_username", "deleted")
                            // 数据库表映射到实体的命名策略-下划线转驼峰命名
                            .naming(NamingStrategy.underline_to_camel)
                            // 开启链式模型
                            .enableChainModel()
                            // 开启生成实体时生成字段注解
                            .enableTableFieldAnnotation()
                            // 逻辑删除数据库字段名称
                            .logicDeleteColumnName(DELETED)
                            // 开启生成serialVersionUID
                            .enableSerialVersionUID()
                            // 开启生成字段常量
                            .enableColumnConstant()
                            // 控制器配置构建者
                            .controllerBuilder()
                            // .superClass(BaseController.class)
                            // 开启生成@RestController控制器
                            .enableRestStyle()
                            // 开启驼峰转连字符
                            .enableHyphenStyle()
                            // Mapper配置构建者
                            .mapperBuilder()

                            // .enableMapperAnnotation()
                            // 开启baseResultMap
                            .enableBaseResultMap()
                            // 开启baseColumnList
                            .enableBaseColumnList()
                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine() {
                    /**
                     *  重写生成 Mapper XML 位置
                     */
                    @Override
                    protected String getPathInfo(String key) {
                        if (key.equals(ConstVal.XML_PATH)) {
                            PackageConfig packageConfig = getConfigBuilder().getPackageConfig();
                            String parent = packageConfig.getParent();
                            String parentPath = "java" + File.separator + parent.replace(StringPool.DOT, File.separator);
                            String pathInfo = super.getPathInfo(key);
                            assert pathInfo != null;
                            return pathInfo.replace(parentPath, "resources");
                        } else {
                            return super.getPathInfo(key);
                        }
                    }
                })
                .execute();

    }

    /**
     * 读取控制台内容
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("请输入" + tip + "："));
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

}
