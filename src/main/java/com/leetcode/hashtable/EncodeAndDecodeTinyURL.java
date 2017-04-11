package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/10.
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Random;

public class EncodeAndDecodeTinyURL {

    @Test
    public void test() {
        System.out.println(encode("http://www.baidu.com/"));
        System.out.println(decode("http://tinyurl.com/2bOFb8"));
    }

    HashMap<String, String> hashToUrl = new HashMap<String, String>();
    HashMap<String, String> urlToHash = new HashMap<String, String>();
    String tinyUrlBase = "http://tinyurl.com/";
    String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random random = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (urlToHash.containsKey(longUrl))
            return tinyUrlBase + urlToHash.get(longUrl);

        StringBuilder hash = new StringBuilder();
        do {
            for (int i=0; i<6; i++) {
                hash.append(characters.charAt(random.nextInt(characters.length())));
            }
        } while (hashToUrl.containsKey(hash.toString()));

        hashToUrl.put(hash.toString(), longUrl);
        urlToHash.put(longUrl, hash.toString());
        return tinyUrlBase + hash.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hashToUrl.get(shortUrl.substring(tinyUrlBase.length()));
    }
}
