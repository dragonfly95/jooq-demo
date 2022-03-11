package com.example.demo;

import com.example.demo.model.tables.JIsMtTbl;
import com.example.demo.model.tables.records.JIsMtTblRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.User;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.Const.password;
import static com.example.demo.Const.url;
import static com.example.demo.Const.userName;

public class TestMain {


    public static void main(String[] args) {

        List<ZipDate> zipData = new ArrayList<>();
        zipData.add(new ZipDate("제주도","63000 ~ 63644"));
        zipData.add(new ZipDate("인천 중구 섬지역","22386 ~ 22388"));
        zipData.add(new ZipDate("인천 강화 섬지역","23004 ~ 23010"));
        zipData.add(new ZipDate("인천 옹진 섬지역1","23100 ~ 23116"));
        zipData.add(new ZipDate("인천 옹진 섬지역2","23124 ~ 23136"));
        zipData.add(new ZipDate("충남 당진 섬지역","31708"));
        zipData.add(new ZipDate("충남 태안 섬지역","32133"));
        zipData.add(new ZipDate("충남 보령 섬지역","33411"));
        zipData.add(new ZipDate("경북 울릉도 전지역","40200 ~ 40240"));
        zipData.add(new ZipDate("부산 강서구 섬지역","46768 ~ 46771"));
        zipData.add(new ZipDate("경남 사천 섬지역","52570 ~ 52571"));
        zipData.add(new ZipDate("경남 통영 섬지역1","53031 ~ 53033"));
        zipData.add(new ZipDate("경남 통영 섬지역2","53089 ~ 53104"));
        zipData.add(new ZipDate("경남 통영 섬지역3","54000"));
        zipData.add(new ZipDate("전북 부안 섬지역","56347 ~ 56349"));
        zipData.add(new ZipDate("전남 영광 섬지역","57068 ~ 57069"));
        zipData.add(new ZipDate("전남 목포 섬지역","58760 ~ 58762"));
        zipData.add(new ZipDate("전남 신안 섬지역1","58800 ~ 58810"));
        zipData.add(new ZipDate("전남 신안 섬지역2","58816 ~ 58818"));
        zipData.add(new ZipDate("전남 신안 섬지역3","28826"));
        zipData.add(new ZipDate("전남 신안 섬지역4","58828 ~ 58866"));
        zipData.add(new ZipDate("전남 진도 섬지역","58953 ~ 58958"));
        zipData.add(new ZipDate("전남 완도 섬지역1","59102 ~ 59103"));
        zipData.add(new ZipDate("전남 완도 섬지역2","59106"));
        zipData.add(new ZipDate("전남 완도 섬지역3","59127"));
        zipData.add(new ZipDate("전남 완도 섬지역4","59129"));
        zipData.add(new ZipDate("전남 완도 섬지역5","59137 ~ 59166"));
        zipData.add(new ZipDate("전남 여수시 섬지역1","59650"));
        zipData.add(new ZipDate("전남 여수시 섬지역2","59766"));
        zipData.add(new ZipDate("전남 여수시 섬지역3","59781 ~ 59790"));




        // db connection
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {

            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            for (ZipDate dt : zipData) {
                String[] arr = dt.getZip().split(" ~ ");
                String address = dt.getAddress();
                if (arr.length == 2) {
                    int start = Integer.parseInt(arr[0]);
                    int end = Integer.parseInt(arr[1]);

                    for (int i = start; i < end ; i++) {

                        ZipCodeVO zipCodeVO = new ZipCodeVO(address, String.valueOf(i));
                        System.out.println("i = " + zipCodeVO);

                        create.insertInto(JIsMtTbl.IS_MT_TBL)
                                .set(JIsMtTbl.IS_MT_TBL.ZIP_CD, i)
                                .set(JIsMtTbl.IS_MT_TBL.ADDRESS, address )
                                .execute();

                    }
                    System.out.println("end = " +( end - start));
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
