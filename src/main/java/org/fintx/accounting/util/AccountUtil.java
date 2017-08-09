package org.fintx.accounting.util;

public class AccountUtil {

    /**
     * Parse code of accounts number from account nnumber
     * 
     * @param accountNo the account number
     * @return String of the code of accounts number
     */
    public static String parseAccountsCodeNo(String accountNo) {
        if (accountNo.length() == 38) {
            String accountsNo = accountNo.substring(0, 8);
            // if (accountsNo.endsWith("00")) {
            // accountsNo = accountsNo.substring(0, 6);
            // if (accountsNo.endsWith("00")) {
            // accountsNo = accountsNo.substring(0, 4);
            // }
            // }
            return accountsNo;
        } else {
            throw new RuntimeException("Wrong accountNo for parsing:" + accountNo);
        }
    }

    /**
     * Parse the customer type from customer number or account number
     * 
     * @param custNoOrAcctNo customer number or account number
     * @return string of the customer type
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

    /**
     * Parse the account serial number
     * 
     * @param accountNo the account number
     * @return string of account serial number
     */
    public static String parseAcctSn(String accountNo) {
        if (accountNo.length() == 38) {
            return accountNo.substring(30, 38);
        } else {
            throw new RuntimeException("Invalid Parameter: " + accountNo + " with length:" + accountNo.length());
        }
    }

    /**
     * Parse the customer number from account number
     * 
     * @param accountNo the account number
     * @return string the customer number
     */
    public String parseCustNo(String accountNo) {
        int len = 0;
        if (null != accountNo) {
            len = accountNo.length();
        } else {
            throw new NullPointerException("Parameter could not be NULL");
        }
        if (0 == len) {
            throw new RuntimeException("Parameter length could not be 0");
        }
        if (38 == len) {
            return accountNo.substring(8, 28);
        } else {
            throw new RuntimeException("Invalid Parameter: " + accountNo + " with length:" + accountNo.length());
        }
    }

}
