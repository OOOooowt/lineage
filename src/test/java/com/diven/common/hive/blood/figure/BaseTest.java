package com.diven.common.hive.blood.figure;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import junit.framework.TestCase;

public class BaseTest extends TestCase {

    static String hqlss[] = {
            "create table temp.b1(id string, name string) row format delimited fields terminated by ',';",
            "create table temp.b2(id string, age int) row format delimited fields terminated by ',';",
            "create table temp.c1(id string, name string) row format delimited fields terminated by ',';",
            "create table temp.c2(id string, age int) row format delimited fields terminated by ',';",
            "create table temp.d1(id string, name string, age int) row format delimited fields terminated by ',';",
            "from temp.a1 insert into table temp.b1 select id, name insert into table temp.b2 select id, age;",
            "insert overwrite table temp.c1 select id, name from temp.b1;",
            "insert overwrite table temp.c2 select id, age from temp.b2;",
            "insert overwrite table temp.d1 select t1.id, t1.name, t2.age from temp.c1 t1 join temp.c2 t2 on t1.id = t2.id;"
    };


    static String hqls3[] = {
            "insert into target " +
                    "SELECT USER_ID AS PARTITION_ID, a.SERVICE_STATE_CODE AS USER_STATE_CODESET, NVL(b1.DEVELOP_STAFF_ID,'') AS DEVELOP_STAFF_ID," +
                    "nvl(a.CITY_CODE,'') AS DEVELOP_CITY_CODE," +
                    "nvl(a.DEVELOP_NO,'') AS DEVELOP_NO," +
                    "nvl(a.CREDIT_RULE_ID,'') AS CREDIT_RULE_ID," +
                    "nvl(a.CONTRACT_ID,'') AS CONTRACT_ID," +
                    "nvl(a.IN_NET_MODE,'') AS IN_NET_MODE,  " +
                    "a.PROVINCE_CODE " +
                    "FROM tf_f_user_hudi08 a \n" +
                    " join (select c.user_id,c.DEVELOP_STAFF_ID,c.DEVELOP_DEPART_ID " +
                    "          from tf_f_user_develop_hudi08 c " +
                    " where c.sub_type_value in('10','440','448','592','0010','31','1060') and c.delete = 0 " +
                    "  ) b1 on(a.user_id=b1.user_id and b1.rn=1)  where " +
                    " (a.REMOVE_TAG not in('S','F','W','Y') " +
                    " or a.REMOVE_TAG is null) " +
                    "and a.delete = 0;"

    };

    static String hqls2[] = {
            "insert into target " +
                    "SELECT USER_ID AS PARTITION_ID, a.SERVICE_STATE_CODE AS USER_STATE_CODESET, NVL(b1.DEVELOP_STAFF_ID,'') AS DEVELOP_STAFF_ID," +
                    "nvl(a.CITY_CODE,'') AS DEVELOP_CITY_CODE," +
                    "nvl(a.DEVELOP_NO,'') AS DEVELOP_NO," +
                    "nvl(a.CREDIT_RULE_ID,'') AS CREDIT_RULE_ID," +
                    "nvl(a.CONTRACT_ID,'') AS CONTRACT_ID," +
                    "nvl(a.IN_NET_MODE,'') AS IN_NET_MODE,  " +
                    "a.PROVINCE_CODE " +
                    "FROM tf_f_user_hudi08 a \n" +
                    " join (select c.user_id,c.DEVELOP_STAFF_ID,c.DEVELOP_DEPART_ID " +
                    "          from tf_f_user_develop_hudi08 c " +
                    " where c.sub_type_value in('10','440','448','592','0010','31','1060') and c.delete = 0 " +
                    "  ) b1 on(a.user_id=b1.user_id and b1.rn=1)  where " +
                    " (a.REMOVE_TAG not in('S','F','W','Y') " +
                    " or a.REMOVE_TAG is null) " +
                    "and a.delete = 0;"

    };

    static String hqls[] = {"INSERT overwrite TABLE temp.d1 SELECT\n" +
            "t1.id,\n" +
            "t1.NAME,\n" +
            "t2.age \n" +
            "FROM\n" +
            "\ttemp.c1 t1\n" +
            "\tJOIN temp.c2 t2 ON t1.id = t2.id;"
//	,"insert overwrite table temp.ccccc1 select id, name from temp.bbbbb1;",
//	"insert overwrite table temp.ccccc1 select id, name from temp.bbb1;"
    };

    static String hqls4[] = {"insert overwrite table temp.c1 select id, name from temp.b1;"};

    static String hqls5[] = {"INSERT INTO target  SELECT\n" +
            "PRODUCT_TYPE AS PRODUCT_TYPE,\n" +
            "PRODUCT_ID AS PRODUCT_ID \n" +
            "FROM\n" +
            "\t(\n" +
            "\tSELECT\n" +
            "\t\tPRODUCT_TYPE AS PRODUCT_TYPE,\n" +
            "\t\tPRODUCT_ID AS PRODUCT_ID \n" +
            "\tFROM\n" +
            "\t\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tfilt.PRODUCT_ID AS PRODUCT_ID,\n" +
            "\t\t\tsrc_1.PRODUCT_TYPE AS PRODUCT_TYPE \n" +
            "\t\tFROM\n" +
            "\t\t\t( SELECT PRODUCT_ID AS PRODUCT_ID FROM SRC.SRC_D_BCD01010_CBSS_1101 src ) filt\n" +
            "\t\t\tLEFT JOIN DIM.DIM_CBSS_PROD_TYPE src_1 ON ( filt.PRODUCT_ID = src_1.PRODUCT_ID ) \n" +
            "\t\t) tjoin \n" +
            "\t) exp;"};

    static String hqls6[] = {"INSERT INTO t.target SELECT\n" +
            "AREA_ID AS AREA_ID,\n" +
            "EPARCHY_CODE AS AREA_ID_CBSS,\n" +
            "PAYMENT_ID AS PAYMENT_ID,\n" +
            "PAYMENT_OP AS PAYMENT_OP,\n" +
            "RECV_TIME AS RECV_TIME,\n" +
            "RECV_AREA_ID AS RECV_AREA_ID,\n" +
            "RECV_EPARCHY_CODE AS RECV_AREA_ID_CBSS,\n" +
            "NULL AS RECV_CITY_ID,\n" +
            "RECV_CITY_CODE AS RECV_CITY_ID_CBSS,\n" +
            "RECV_DEPART_ID AS RECV_DEPART_ID,\n" +
            "RECV_STAFF_ID AS RECV_STAFF_ID,\n" +
            "PAYMENT_REASON_CODE AS PAYMENT_REASON_CODE,\n" +
            "INPUT_NO AS INPUT_NO,\n" +
            "INPUT_MODE AS INPUT_MODE,\n" +
            "OUTER_TRADE_ID AS OUTER_TRADE_ID,\n" +
            "ACT_TAG AS ACT_FLAG,\n" +
            "EXTEND_TAG AS IS_EXTEND,\n" +
            "ACTION_CODE AS ACTION_CODE,\n" +
            "ACTION_EVENT_ID AS ACTION_EVENT_ID,\n" +
            "PAYMENT_RULE_ID AS PAYMENT_RULE_ID,\n" +
            "CANCEL_TAG AS CANCEL_FLAG,\n" +
            "CANCEL_STAFF_ID AS CANCEL_STAFF_ID,\n" +
            "CANCEL_DEPART_ID AS CANCEL_DEPART_ID,\n" +
            "NULL AS CANCEL_CITY_ID,\n" +
            "CANCEL_CITY_CODE AS CANCEL_CITY_ID_CBSS,\n" +
            "CANCEL_AREA_ID AS CANCEL_AREA_ID,\n" +
            "CANCEL_EPARCHY_CODE AS CANCEL_AREA_ID_CBSS,\n" +
            "CANCEL_TIME AS CANCEL_TIME,\n" +
            "CANCEL_CHARGE_ID AS CANCEL_CHARGE_ID,\n" +
            "RSRV_FEE1 AS RSRV_FEE1,\n" +
            "RSRV_FEE2 AS RSRV_FEE2,\n" +
            "RSRV_INFO1 AS RSRV_INFO1,\n" +
            "RSRV_INFO2 AS RSRV_INFO2,\n" +
            "STANDARD_KIND_CODE AS STANDARD_KIND_CODE,\n" +
            "REMARK AS REMARK \n" +
            "FROM\n" +
            "\t(\n" +
            "\tSELECT\n" +
            "\t\tfilt.MONTH_ID AS MONTH_ID,\n" +
            "\t\tfilt.CHARGE_ID AS CHARGE_ID,\n" +
            "\t\tsrc.AREA_ID AS AREA_ID,\n" +
            "\t\tfilt.EPARCHY_CODE AS EPARCHY_CODE,\n" +
            "\t\tfilt.CITY_CODE AS CITY_CODE,\n" +
            "\t\tfilt.CUST_ID AS CUST_ID,\n" +
            "\t\tfilt.USER_ID AS USER_ID,\n" +
            "\t\tfilt.SERIAL_NUMBER AS SERIAL_NUMBER,\n" +
            "\t\tfilt.NET_TYPE_CODE AS NET_TYPE_CODE,\n" +
            "\t\tfilt.ACCT_ID AS ACCT_ID,\n" +
            "\t\tfilt.CHANNEL_ID AS CHANNEL_ID,\n" +
            "\t\tfilt.PAYMENT_ID AS PAYMENT_ID,\n" +
            "\t\tsrc_1.PAY_METHOD AS PAY_METHOD,\n" +
            "\t\tfilt.PAY_FEE_MODE_CODE AS PAY_FEE_MODE_CODE,\n" +
            "\t\tfilt.PAYMENT_OP AS PAYMENT_OP,\n" +
            "\t\tfilt.RECV_FEE AS RECV_FEE,\n" +
            "\t\tfilt.LIMIT_MONEY AS LIMIT_MONEY,\n" +
            "\t\tfilt.RECV_TIME AS RECV_TIME,\n" +
            "\t\texp.RECV_AREA_ID AS RECV_AREA_ID,\n" +
            "\t\tfilt.RECV_EPARCHY_CODE AS RECV_EPARCHY_CODE,\n" +
            "\t\tfilt.RECV_CITY_CODE AS RECV_CITY_CODE,\n" +
            "\t\tfilt.RECV_DEPART_ID AS RECV_DEPART_ID,\n" +
            "\t\tfilt.RECV_STAFF_ID AS RECV_STAFF_ID,\n" +
            "\t\tfilt.PAYMENT_REASON_CODE AS PAYMENT_REASON_CODE,\n" +
            "\t\tfilt.INPUT_NO AS INPUT_NO,\n" +
            "\t\tfilt.INPUT_MODE AS INPUT_MODE,\n" +
            "\t\tfilt.OUTER_TRADE_ID AS OUTER_TRADE_ID,\n" +
            "\t\tfilt.ACT_TAG AS ACT_TAG,\n" +
            "\t\tfilt.EXTEND_TAG AS EXTEND_TAG,\n" +
            "\t\tfilt.ACTION_CODE AS ACTION_CODE,\n" +
            "\t\tfilt.ACTION_EVENT_ID AS ACTION_EVENT_ID,\n" +
            "\t\tfilt.PAYMENT_RULE_ID AS PAYMENT_RULE_ID,\n" +
            "\t\tfilt.CANCEL_TAG AS CANCEL_TAG,\n" +
            "\t\tfilt.CANCEL_STAFF_ID AS CANCEL_STAFF_ID,\n" +
            "\t\tfilt.CANCEL_DEPART_ID AS CANCEL_DEPART_ID,\n" +
            "\t\tfilt.CANCEL_CITY_CODE AS CANCEL_CITY_CODE,\n" +
            "\t\texp_1.CANCEL_AREA_ID AS CANCEL_AREA_ID,\n" +
            "\t\tfilt.CANCEL_EPARCHY_CODE AS CANCEL_EPARCHY_CODE,\n" +
            "\t\tfilt.CANCEL_TIME AS CANCEL_TIME,\n" +
            "\t\tfilt.CANCEL_CHARGE_ID AS CANCEL_CHARGE_ID,\n" +
            "\t\tfilt.RSRV_FEE1 AS RSRV_FEE1,\n" +
            "\t\tfilt.RSRV_FEE2 AS RSRV_FEE2,\n" +
            "\t\tfilt.RSRV_INFO1 AS RSRV_INFO1,\n" +
            "\t\tfilt.RSRV_INFO2 AS RSRV_INFO2,\n" +
            "\t\tfilt.STANDARD_KIND_CODE AS STANDARD_KIND_CODE,\n" +
            "\t\tfilt.REMARK AS REMARK,\n" +
            "\t\tfilt.PROVINCE_CODE AS PROVINCE_CODE,\n" +
            "\t\tsrc.AREA_ID_CBSS AS AREA_ID_CBSS,\n" +
            "\t\texp.RECV_AREA_ID_CBSS AS RECV_AREA_ID_CBSS,\n" +
            "\t\texp_1.CANCEL_AREA_ID_CBSS AS CANCEL_AREA_ID_CBSS,\n" +
            "\t\tsrc_1.PAYMENT_ID AS PAYMENT_ID_1 \n" +
            "\tFROM\n" +
            "\t\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tCHARGE_ID AS CHARGE_ID,\n" +
            "\t\t\tEPARCHY_CODE AS EPARCHY_CODE,\n" +
            "\t\t\tCITY_CODE AS CITY_CODE,\n" +
            "\t\t\tCUST_ID AS CUST_ID,\n" +
            "\t\t\tUSER_ID AS USER_ID,\n" +
            "\t\t\tSERIAL_NUMBER AS SERIAL_NUMBER,\n" +
            "\t\t\tNET_TYPE_CODE AS NET_TYPE_CODE,\n" +
            "\t\t\tACCT_ID AS ACCT_ID,\n" +
            "\t\t\tCHANNEL_ID AS CHANNEL_ID,\n" +
            "\t\t\tPAYMENT_ID AS PAYMENT_ID,\n" +
            "\t\t\tPAY_FEE_MODE_CODE AS PAY_FEE_MODE_CODE,\n" +
            "\t\t\tPAYMENT_OP AS PAYMENT_OP,\n" +
            "\t\t\tRECV_FEE AS RECV_FEE,\n" +
            "\t\t\tLIMIT_MONEY AS LIMIT_MONEY,\n" +
            "\t\t\tRECV_TIME AS RECV_TIME,\n" +
            "\t\t\tRECV_EPARCHY_CODE AS RECV_EPARCHY_CODE,\n" +
            "\t\t\tRECV_CITY_CODE AS RECV_CITY_CODE,\n" +
            "\t\t\tRECV_DEPART_ID AS RECV_DEPART_ID,\n" +
            "\t\t\tRECV_STAFF_ID AS RECV_STAFF_ID,\n" +
            "\t\t\tPAYMENT_REASON_CODE AS PAYMENT_REASON_CODE,\n" +
            "\t\t\tINPUT_NO AS INPUT_NO,\n" +
            "\t\t\tINPUT_MODE AS INPUT_MODE,\n" +
            "\t\t\tOUTER_TRADE_ID AS OUTER_TRADE_ID,\n" +
            "\t\t\tACT_TAG AS ACT_TAG,\n" +
            "\t\t\tEXTEND_TAG AS EXTEND_TAG,\n" +
            "\t\t\tACTION_CODE AS ACTION_CODE,\n" +
            "\t\t\tACTION_EVENT_ID AS ACTION_EVENT_ID,\n" +
            "\t\t\tPAYMENT_RULE_ID AS PAYMENT_RULE_ID,\n" +
            "\t\t\tREMARK AS REMARK,\n" +
            "\t\t\tCANCEL_TAG AS CANCEL_TAG,\n" +
            "\t\t\tCANCEL_STAFF_ID AS CANCEL_STAFF_ID,\n" +
            "\t\t\tCANCEL_DEPART_ID AS CANCEL_DEPART_ID,\n" +
            "\t\t\tCANCEL_CITY_CODE AS CANCEL_CITY_CODE,\n" +
            "\t\t\tCANCEL_EPARCHY_CODE AS CANCEL_EPARCHY_CODE,\n" +
            "\t\t\tCANCEL_TIME AS CANCEL_TIME,\n" +
            "\t\t\tCANCEL_CHARGE_ID AS CANCEL_CHARGE_ID,\n" +
            "\t\t\tRSRV_FEE1 AS RSRV_FEE1,\n" +
            "\t\t\tRSRV_FEE2 AS RSRV_FEE2,\n" +
            "\t\t\tRSRV_INFO1 AS RSRV_INFO1,\n" +
            "\t\t\tPROVINCE_CODE AS PROVINCE_CODE,\n" +
            "\t\t\tRSRV_INFO2 AS RSRV_INFO2,\n" +
            "\t\t\tSTANDARD_KIND_CODE AS STANDARD_KIND_CODE,\n" +
            "\t\t\tMONTH_ID AS MONTH_ID \n" +
            "\t\tFROM\n" +
            "\t\t\tsrc.src_d_bcd07018_hive src_3 \n" +
            "\t\t) filt\n" +
            "\t\tLEFT JOIN dim.dim_map_cbss_area src ON ( filt.EPARCHY_CODE = src.AREA_ID_CBSS )\n" +
            "\t\tLEFT JOIN ( SELECT AREA_ID AS RECV_AREA_ID, AREA_ID_CBSS AS RECV_AREA_ID_CBSS FROM dim.dim_map_cbss_area src_6 ) exp ON ( filt.RECV_EPARCHY_CODE = exp.RECV_AREA_ID_CBSS )\n" +
            "\t\tLEFT JOIN ( SELECT AREA_ID AS CANCEL_AREA_ID, AREA_ID_CBSS AS CANCEL_AREA_ID_CBSS FROM dim.dim_map_cbss_area src_8 ) exp_1 ON ( filt.CANCEL_EPARCHY_CODE = exp_1.CANCEL_AREA_ID_CBSS )\n" +
            "\tLEFT JOIN dim.dim_ref_cbss_paymod_hive src_1 ON ( filt.PAYMENT_ID = src_1.PAYMENT_ID ) \n" +
            "\t) mjoin;"};
    /**
     * 输出标准的json字符串
     *
     * @param obj
     */
    public static void printJsonString(Object obj) {
        String str = JSON.toJSONString(obj,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.PrettyFormat);
        System.out.println(str);
//        System.exit(1);
// -------------------------------------------------------

//        JSONObject arr = JSONObject.parseObject(str);
//        JSONArray edges = arr.getJSONArray("edges");
////		System.out.println(edges);
//        Map<String, List<String>> map = new HashMap<>();
//        List<String> list = new ArrayList<>();
//        for (Object edge : edges) {
////			System.out.println(edge);
//            JSONObject edgestring = JSONObject.parseObject(edge.toString());
//            String targetName = JSONObject.parseObject(edgestring.getString("target")).getString("tableName");
//            String sourceName = JSONObject.parseObject(edgestring.getString("source")).getString("tableName");
//            list.add(sourceName);
//            map.put(targetName, list);
//        }
//        String mapJson = JSON.toJSONString(map);
//        System.out.println(mapJson);

    }

}
