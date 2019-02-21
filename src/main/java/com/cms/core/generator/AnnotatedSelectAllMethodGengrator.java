package com.cms.core.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;

import java.util.Iterator;

import static org.mybatis.generator.api.dom.OutputUtilities.javaIndent;

public class AnnotatedSelectAllMethodGengrator extends SelectAllMethodGengrator {

    private boolean useResultMapIfAvailable;

    AnnotatedSelectAllMethodGengrator(IntrospectedTable introspectedTable, boolean useResultMapIfAvailable, boolean isSimple) {
        super(isSimple);
        this.useResultMapIfAvailable = useResultMapIfAvailable;
        this.introspectedTable = introspectedTable;
    }

    @Override
    public void addMapperAnnotations(Interface interfaze, Method method) {
        interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Select"));
        StringBuilder sb = new StringBuilder();
        method.addAnnotation("@SelectProvider(type="+introspectedTable.getMyBatis3SqlProviderType().substring(introspectedTable.getMyBatis3SqlProviderType().lastIndexOf(".") + 1)+".class, method=\"selectByObject\")");
        if (introspectedTable.isConstructorBased()) {
            interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Arg"));
            interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.ConstructorArgs"));
            method.addAnnotation("@ConstructorArgs({");
        } else {
            interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Result"));
            interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Results"));
            method.addAnnotation(String.format("@Results(id = \"%s\", value= {", introspectedTable.getBaseRecordType().substring(introspectedTable.getBaseRecordType().lastIndexOf(".") + 1).toLowerCase()));
        }

        Iterator<IntrospectedColumn> iterPk = introspectedTable.getPrimaryKeyColumns().iterator();
        Iterator<IntrospectedColumn> iterNonPk = introspectedTable.getNonPrimaryKeyColumns().iterator();
        while (iterPk.hasNext()) {
            IntrospectedColumn introspectedColumn = iterPk.next();
            sb.setLength(0);
            javaIndent(sb, 1);
            sb.append(getResultAnnotation(interfaze, introspectedColumn, true, introspectedTable.isConstructorBased()));

            if (iterPk.hasNext() || iterNonPk.hasNext()) {
                sb.append(',');
            }
            method.addAnnotation(sb.toString());
        }

        while (iterNonPk.hasNext()) {
            IntrospectedColumn introspectedColumn = iterNonPk.next();
            sb.setLength(0);
            javaIndent(sb, 1);
            sb.append(getResultAnnotation(interfaze, introspectedColumn, false, introspectedTable.isConstructorBased()));

            if (iterNonPk.hasNext()) {
                sb.append(',');
            }
            method.addAnnotation(sb.toString());
        }
        method.addAnnotation("})");
        javaIndent(sb, 1);
    }
}