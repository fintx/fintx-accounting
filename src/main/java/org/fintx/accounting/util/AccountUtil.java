package org.fintx.accounting.util;

public class AccountUtil {

    /**
     * 根据客户号获取科目号，如果是二级科目号，截取前六位；如果是三级科目号，截取前八位
     * 
     * @param acctNo
     * @return
     */
    public static String parseAccountsNo(String acctNo) {
        if (acctNo.length() == 38 || acctNo.length() == 30) {
            String accountsNo = acctNo.substring(0, 8);
            if (accountsNo.endsWith("00")) {
                accountsNo = accountsNo.substring(0, 6);
                if (accountsNo.endsWith("00")) {
                    accountsNo = accountsNo.substring(0, 4);
                }
            }
            return accountsNo;
        } else {
            throw new RuntimeException("Wrong accountNo for parsing:" + acctNo);
        }
    }

    /**
     * 根据客户或账号解析 客户类型
     * 
     * @param
     * @return
     */
    public static String parseCustType(String custNoOrAcctNo) {
        int len = 0;
        if (null != custNoOrAcctNo) {
            len = custNoOrAcctNo.length();
        } else {
            throw new NullPointerException("Parameter could not be NULL");
        }
        if (0 == len) {
            throw new RuntimeException("Parameter length could not be 0");
        }
        if (20 == len) {
            return custNoOrAcctNo.substring(0, 2);
        } else if (38 == len) {
            return custNoOrAcctNo.substring(8, 10);
        } else if (0 != len && 30 == len) {
            return "00";// stand for internal account
        } else {
            throw new RuntimeException("Invalid Parameter: " + custNoOrAcctNo + " with length:" + len);
        }
    }

    public static String parseAcctSn(String acctNo) {
        if (acctNo.length() == 38) {
            return acctNo.substring(30, 38);
        } else if (acctNo.length() == 30) {
            return acctNo.substring(24, 30);
        } else {
            throw new RuntimeException("Invalid Parameter: " + acctNo + " with length:" + acctNo.length());
        }
    }

    /**
     * 获取客户号
     * 
     * @param acctNo
     * @return
     */
    public String parseCustNo(String acctNo) {
        int len = 0;
        if (null != acctNo) {
            len = acctNo.length();
        } else {
            throw new NullPointerException("Parameter could not be NULL");
        }
        if (0 == len) {
            throw new RuntimeException("Parameter length could not be 0");
        }
        if (38 == len) {
            return acctNo.substring(8, 28);
        } else if (30 == len) {
            return acctNo.substring(8, 16);
        } else {
            throw new RuntimeException("Invalid Parameter: " + acctNo + " with length:" + acctNo.length());
        }
    }

}
