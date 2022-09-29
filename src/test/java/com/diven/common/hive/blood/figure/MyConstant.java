package com.diven.common.hive.blood.figure;

/**
 * TODO
 *
 * @author laowang
 * @date 2022/9/29
 * @Version 1.0
 */
public class MyConstant {
    static String hql1[] = {"INSERT INTO t.target SELECT\n" +
            "MONTH_ID AS MONTH_ID,\n" +
            "CHARGE_ID AS CHARGE_ID,\n" +
            "AREA_ID AS AREA_ID,\n" +
            "EPARCHY_CODE AS AREA_ID_CBSS,\n" +
            "NULL AS CITY_ID,\n" +
            "CITY_CODE AS CITY_ID_CBSS,\n" +
            "CUST_ID AS CUST_ID,\n" +
            "USER_ID AS USER_ID,\n" +
            "SERIAL_NUMBER AS DEVICE_NUMBER,\n" +
            "NET_TYPE_CODE AS NET_TYPE_CBSS,\n" +
            "ACCT_ID AS ACCT_ID,\n" +
            "CHANNEL_ID AS CHANNEL_ID,\n" +
            "PAYMENT_ID AS PAYMENT_ID,\n" +
            "PAY_METHOD AS PAY_METHOD,\n" +
            "PAY_FEE_MODE_CODE AS PAY_FEE_MODE,\n" +
            "PAYMENT_OP AS PAYMENT_OP,\n" +
            "RECV_FEE AS RECV_FEE,\n" +
            "LIMIT_MONEY AS LIMIT_MONEY,\n" +
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
}
