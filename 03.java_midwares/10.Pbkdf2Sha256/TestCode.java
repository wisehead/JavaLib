package com.nasa;

import java.io.IOException;

public class TestCode {

    public static void main(String[] args) throws IOException {

        //获取密文（密码加盐）
    	/*
        String salt = Pbkdf2Sha256.encode("123456");
        System.out.println("salt===" + salt);
        boolean verification = Pbkdf2Sha256.verification("123456", salt);
        System.out.println(verification);
        */

        /*
         password: "Admin123;"
		 hash: pbkdf2_sha256$180000$Kz2F4tek3D0e$diMJwvtIKs0D7L62pbmynY23yPbylav6P8xajovSh4Q=
         */
        String hash = Pbkdf2Sha256.encode("Admin123;");
        System.out.println("hash===" + hash);
        //pbkdf2_sha256$320000$2m0dhbDZQ4vIbwujHL8ygc$Y6hQPneCmJWneAFvcI/+7vntKFd/etYiDxnFd0l/k5A=
        //verification = Pbkdf2Sha256.verification("Admin123;", "pbkdf2_sha256$180000$Kz2F4tek3D0e$diMJwvtIKs0D7L62pbmynY23yPbylav6P8xajovSh4Q=");
        //boolean verification = Pbkdf2Sha256.verification("Admin123;", "pbkdf2_sha256$320000$2m0dhbDZQ4vIbwujHL8ygc$Y6hQPneCmJWneAFvcI/+7vntKFd/etYiDxnFd0l/k5A=");
        //System.out.println(verification);

        
        /**
         * Python生成的密码和密文
         * admin123456
         * PBKDF2&SHA256$2000$SzNgPdzz$50f22e207abec8e837bce97642a46f965f19d992217d7df9be496700b286345d
         * PBKDF2&SHA256$2000$VzmO4yOZ$71891148cfbdd9103aaa511d20dc52431c8947ce4a00d89708231ec76053f6f3
         * PBKDF2&SHA256$2000$3xuRb8AR$6bff0310fd35c88572633b00d36e9039fef3e68c6e37b14204958946e8738e93
         */
        /*
        String oldPassword7 = "PBKDF2&SHA256$2000$SzNgPdzz$50f22e207abec8e837bce97642a46f965f19d992217d7df9be496700b286345d";
        String oldPassword8 = "PBKDF2&SHA256$2000$VzmO4yOZ$71891148cfbdd9103aaa511d20dc52431c8947ce4a00d89708231ec76053f6f3";
        String oldPassword9 = "PBKDF2&SHA256$2000$3xuRb8AR$6bff0310fd35c88572633b00d36e9039fef3e68c6e37b14204958946e8738e93";
        boolean verification7 = Pbkdf2Sha256.verification("admin123456", oldPassword7);
        boolean verification8 = Pbkdf2Sha256.verification("admin123456", oldPassword8);
        boolean verification9 = Pbkdf2Sha256.verification("admin123456", oldPassword9);
        System.out.println(verification7);
        System.out.println(verification8);
        System.out.println(verification9);
        */
    }
}


