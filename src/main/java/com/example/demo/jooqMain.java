package com.example.demo;

import com.example.demo.model.tables.JIsMtTbl;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static com.example.demo.Const.password;
import static com.example.demo.Const.url;
import static com.example.demo.Const.userName;
import static com.example.demo.model.tables.JIsMtTbl.IS_MT_TBL;

public class jooqMain {

    public static void main(String[] args) {

        // db connection
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {

            DSLContext jooq = DSL.using(conn, SQLDialect.MYSQL);
            List<ZipCodeVO> into = jooq.select()
                    .from(IS_MT_TBL)
                    .limit(10)
                    .fetch().into(ZipCodeVO.class);

            for (ZipCodeVO zipCodeVO : into) {
                System.out.println("zipCodeVO = " + zipCodeVO);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
