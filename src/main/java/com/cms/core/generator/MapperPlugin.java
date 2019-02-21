package com.cms.core.generator;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.util.JavaBeansUtil;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.mybatis.generator.api.dom.OutputUtilities.javaIndent;
import static org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities.getSelectListPhrase;
import static org.mybatis.generator.internal.util.StringUtility.escapeStringForJava;
import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

public class MapperPlugin extends PluginAdapter {

    private String daoTargetPackage;

    @Override
    public boolean validate(List<String> warnings) {

        boolean valid1 = stringHasValue(properties.getProperty("targetProject"));

        daoTargetPackage = properties.getProperty("targetPackage");
        boolean valid2 = stringHasValue(daoTargetPackage);
        System.out.println(valid1 && valid2);
        return valid1 && valid2;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        //获取所有生成的文件
        List<GeneratedJavaFile> generatedJavaFiles = introspectedTable.getGeneratedJavaFiles();
        for (GeneratedJavaFile javaFile : generatedJavaFiles) {
            //获取编辑项(存放了生成文件时所需要的信息)
            CompilationUnit unit = javaFile.getCompilationUnit();
            FullyQualifiedJavaType baseModelJavaType = unit.getType();
            String shortName = baseModelJavaType.getShortName();
            //判断生成的文件是否是Mapper接口
            if (shortName.endsWith("Mapper")) {
                if (stringHasValue(daoTargetPackage)) {
                    if (unit instanceof Interface) {
                        /*为文件添加扩展的方法*/
                        //添加import项
                        unit.addImportedType(new FullyQualifiedJavaType("java.util.List"));
                        unit.addImportedType(new FullyQualifiedJavaType("java.util.Map"));

                        //新建一个方法
                        Method method = new Method();
                        //设置访问权限
                        method.setVisibility(JavaVisibility.PUBLIC);
                        //设置方法名称
                        method.setName("selectListByObject");
                        //设置返回类型
                        FullyQualifiedJavaType returnFullyQualifiedJavaType = new FullyQualifiedJavaType(String.format("List<%s>", introspectedTable.getBaseRecordType()));
                        method.setReturnType(returnFullyQualifiedJavaType);
                        // 设置参数类型是对象
                        FullyQualifiedJavaType parameterType;
                        /*parameterType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());*/
                        parameterType = new FullyQualifiedJavaType("Map<String, Object>");

                        // 为方法添加参数，变量名称record
                        method.addParameter(new Parameter(parameterType, "record")); //$NON-NLS-1$

                        //设置注解
                        AnnotatedSelectAllMethodGengrator annotatedSelectAllMethodGengrator = new AnnotatedSelectAllMethodGengrator(introspectedTable, false, false);
                        annotatedSelectAllMethodGengrator.addMapperAnnotations(((Interface) unit), method);
                        //把方法添加到编辑项
                        ((Interface) unit).addMethod(method);

                        /*为文件添加扩展的方法*/
                        //添加import项
                        unit.addImportedType(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
                        //新建一个方法
                        Method method2 = new Method();
                        //设置访问权限
                        method2.setVisibility(JavaVisibility.PUBLIC);
                        //设置方法名称
                        method2.setName("selectByObject");
                        //设置返回类型
                        returnFullyQualifiedJavaType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
                        method2.setReturnType(returnFullyQualifiedJavaType);

                        // 为方法添加参数，变量名称record
                        method2.addParameter(new Parameter(parameterType, "record")); //$NON-NLS-1$
                        method2.addAnnotation("@SelectProvider(type="+introspectedTable.getMyBatis3SqlProviderType().substring(introspectedTable.getMyBatis3SqlProviderType().lastIndexOf(".") + 1)+".class, method=\"selectByObject\")");
                        method2.addAnnotation(String.format("@ResultMap(value = \""+introspectedTable.getBaseRecordType().substring(introspectedTable.getBaseRecordType().lastIndexOf(".") + 1).toLowerCase())+"\")");
                        //把方法添加到编辑项
                        ((Interface) unit).addMethod(method2);


                        /*为文件添加扩展的方法*/
                        //添加import项
                        unit.addImportedType(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
                        //新建一个方法
                        Method method3 = new Method();
                        //设置访问权限
                        method3.setVisibility(JavaVisibility.PUBLIC);
                        //设置方法名称
                        method3.setName("deleteByObject");
                        //设置返回类型
                        returnFullyQualifiedJavaType = new FullyQualifiedJavaType("int");
                        method3.setReturnType(returnFullyQualifiedJavaType);


                        // 设置参数类型是对象
                        FullyQualifiedJavaType parameterType2;
                        /*parameterType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());*/
                        parameterType2 = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());


                        // 为方法添加参数，变量名称record
                        method3.addParameter(new Parameter(parameterType2, "record")); //$NON-NLS-1$
                        method3.addAnnotation("@DeleteProvider(type="+introspectedTable.getMyBatis3SqlProviderType().substring(introspectedTable.getMyBatis3SqlProviderType().lastIndexOf(".") + 1)+".class, method=\"deleteByObject\")");
                        //把方法添加到编辑项
                        ((Interface) unit).addMethod(method3);


                    }
                }
            }else if (shortName.endsWith("SqlProvider")) {
                if (stringHasValue(daoTargetPackage)) {
                    if (unit instanceof TopLevelClass) {
                        Set importedTypes = new TreeSet();
                        importedTypes.add(new FullyQualifiedJavaType("java.util.Map"));
                        //新建一个方法
                        Method method = new Method();
                        //设置访问权限
                        method.setVisibility(JavaVisibility.PUBLIC);
                        //设置方法名称
                        method.setName("selectByObject");
                        //设置返回类型 String
                        FullyQualifiedJavaType returnFullyQualifiedJavaType = new FullyQualifiedJavaType("java.lang.String");
                        method.setReturnType(returnFullyQualifiedJavaType);
                        // 设置参数类型是对象
                        FullyQualifiedJavaType parameterType;
                        //parameterType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()); 参数类型对象
                        parameterType = new FullyQualifiedJavaType("Map<String,Object>");
                        // 为方法添加参数，变量名称record
                        method.addParameter(new Parameter(parameterType, "record")); //$NON-NLS-1$
                        FullyQualifiedJavaType returnType = method.getReturnType();
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sbWhere = new StringBuilder();

                        if (returnType != null) {
                            sb.append("SQL sql = new SQL();");
                        }
                        method.addBodyLine(sb.toString());
                        Iterator<IntrospectedColumn> iter = introspectedTable.getAllColumns().iterator();
                        sb.setLength(0);
                        sb.append("sql.SELECT(\"");

                        while (iter.hasNext()) {
                            IntrospectedColumn column =iter.next();
                            String one =escapeStringForJava(getSelectListPhrase(column));
                            String two = column.getJavaProperty();

                            sb.append(one);
                            sbWhere.append("\n");
                            javaIndent(sbWhere, 2);
                            sbWhere.append("if (record.get(\"");
                            sbWhere.append(two);
                            sbWhere.append("\") != null) {\n");
                            javaIndent(sbWhere, 3);
                            sbWhere.append("sql.WHERE(\""+one+"=#{"+two+",jdbcType="+column.getJdbcTypeName()+"}\");\n");
                            javaIndent(sbWhere, 2);
                            sbWhere.append("}");
                            if (iter.hasNext()) {
                                sb.append(", ");
                                sbWhere.append("\n");
                            }
                        }
                        sb.append(" from ");
                        sb.append(escapeStringForJava(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));
                        sb.append("\");");
                        method.addBodyLine(sb.toString());
                        method.addBodyLine(sbWhere.toString());


                        Method method1 = deleteByObject(introspectedTable);

                        if (returnType != null) {
                            sb.setLength(0);
                            sb.append("return sql.toString();");
                            method.addBodyLine(sb.toString());
                        }

                        if (this.context.getPlugins().clientInsertSelectiveMethodGenerated(method, ((TopLevelClass) unit), introspectedTable))
                        {
                            ((TopLevelClass) unit).addImportedTypes(importedTypes);
                            ((TopLevelClass) unit).addMethod(method);
                            ((TopLevelClass) unit).addMethod(method1);

                        }
                    }
                }
            }
        }
        return generatedJavaFiles;
    }


    public Method deleteByObject(IntrospectedTable introspectedTable){
        //新建一个方法
        Method method = new Method();
        //设置访问权限
        method.setVisibility(JavaVisibility.PUBLIC);
        //设置方法名称
        method.setName("deleteByObject");
        //设置返回类型 String
        FullyQualifiedJavaType returnFullyQualifiedJavaType = new FullyQualifiedJavaType("java.lang.String");
        method.setReturnType(returnFullyQualifiedJavaType);
        // 设置参数类型是对象
        FullyQualifiedJavaType parameterType;
        //parameterType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()); 参数类型对象
        parameterType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        // 为方法添加参数，变量名称record
        method.addParameter(new Parameter(parameterType, "record")); //$NON-NLS-1$
        FullyQualifiedJavaType returnType = method.getReturnType();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbWhere = new StringBuilder();

        if (returnType != null) {
            sb.append("SQL sql = new SQL();");
        }
        method.addBodyLine(sb.toString());
        Iterator<IntrospectedColumn> iter = introspectedTable.getAllColumns().iterator();
        sb.setLength(0);
        sb.append("sql.DELETE_FROM(\"");

        while (iter.hasNext()) {
            IntrospectedColumn column =iter.next();
            String one =escapeStringForJava(getSelectListPhrase(column));
            String two = column.getJavaProperty();
            sbWhere.append("\n");
            javaIndent(sbWhere, 2);
            sbWhere.append(String.format("if (record.%s() != null) {", new Object[] {
                    JavaBeansUtil.getGetterMethodName(column
                            .getJavaProperty(), column
                            .getFullyQualifiedJavaType()) }));
            sbWhere.append("\n");
            javaIndent(sbWhere, 3);
            sbWhere.append("sql.WHERE(\""+one+"=#{"+two+",jdbcType="+column.getJdbcTypeName()+"}\");\n");
            javaIndent(sbWhere, 2);
            sbWhere.append("}");
            if (iter.hasNext()) {
                sbWhere.append("\n");
            }
        }
        //源代码
        /*for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns()) {
            method.addBodyLine(String.format("%sWHERE(\"%s = %s\");", new Object[] { this.builderPrefix,
                    StringUtility.escapeStringForJava(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn)),
                    MyBatis3FormattingUtilities.getParameterClause(introspectedColumn) }));
        }*/


        sb.append(escapeStringForJava(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));
        sb.append("\");");
        method.addBodyLine(sb.toString());
        method.addBodyLine(sbWhere.toString());
        if (returnType != null) {
            sb.setLength(0);
            sb.append("return sql.toString();");
            method.addBodyLine(sb.toString());
        }

        return method;
    }


}