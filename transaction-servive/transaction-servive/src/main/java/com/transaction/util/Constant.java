package com.transaction.util;

public class Constant {

    public enum RESPONSE {
        APPROVED("00", "Approved"),
        INTERNAL_ERROR("X5", "Service Internal Error"),
        INVALID_TRANSACTION("12", "Transaksi Gagal"),
        DATA_NOT_FOUND("14", "Data tidak ditemukan");

        private String code, description;

        RESPONSE(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return this.code;
        }

        public String getDescription() {
            return this.description;
        }
    }

    public interface STATUS_ORDER {
        public String CANCEL = "0";
        public String SUCCESS = "1";
    }
}
