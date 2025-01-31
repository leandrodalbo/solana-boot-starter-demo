package com.bootSolana.demo;

import org.bitcoinj.core.Base58;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static PrivateKey decodeBase58PrivateKey(String base58PrivateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String ALGORITHM = "Ed25519";
        byte[] pkcs8Header = new byte[]{
                0x30, 0x2e, 0x02, 0x01, 0x00, 0x30, 0x05, 0x06, 0x03, 0x2b, 0x65, 0x70, 0x04, 0x22, 0x04, 0x20
        };

        var keyBytes = Arrays.copyOfRange(Base58.decode(base58PrivateKey), 0, 32);

        byte[] toDecode = new byte[pkcs8Header.length + keyBytes.length];
        int i = 0;

        for (byte b : pkcs8Header) {
            toDecode[i] = b;
            i++;
        }

        for (byte b : keyBytes) {
            toDecode[i] = b;
            i++;
        }

        var keyFactory = KeyFactory.getInstance(ALGORITHM);
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(toDecode));
    }

    public static String encodePrivateKey(List<Integer> values) {
        return Base58.encode(keyBytesArray(values));
    }

    private static byte[] keyBytesArray(List<Integer> key) {
        byte[] byteArray = new byte[key.size()];

        for (int i = 0; i < key.size(); i++) {
            byteArray[i] = key.get(i).byteValue();
        }
        return byteArray;
    }

}
