/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.viettd.elasticsearch.utils;

/**
 *
 * @author viettd
 */
public class StringNormalizer {

    private static final char[] SRC_CHARS = {'á', 'à', 'ả', 'ã', 'ạ',
        'ă', 'ắ', 'ằ', 'ẳ', 'ẵ', 'ặ',
        'â', 'ấ', 'ầ', 'ẩ', 'ẫ', 'ậ',
        'đ',
        'é', 'è', 'ẻ', 'ẽ', 'ẹ',
        'ê', 'ế', 'ề', 'ể', 'ễ', 'ệ',
        'í', 'ì', 'ỉ', 'ĩ', 'ị',
        'ó', 'ò', 'ỏ', 'õ', 'ọ',
        'ô', 'ố', 'ồ', 'ổ', 'ỗ', 'ộ',
        'ơ', 'ớ', 'ờ', 'ở', 'ỡ', 'ợ',
        'ú', 'ù', 'ủ', 'ũ', 'ụ',
        'ư', 'ứ', 'ừ', 'ử', 'ữ', 'ự',
        'ý', 'ỳ', 'ỷ', 'ỹ', 'ỵ'};
    private static final char[] DEST_CHARS = {'a', 'a', 'a', 'a', 'a',
        'a', 'a', 'a', 'a', 'a', 'a',
        'a', 'a', 'a', 'a', 'a', 'a',
        'd',
        'e', 'e', 'e', 'e', 'e',
        'e', 'e', 'e', 'e', 'e', 'e',
        'i', 'i', 'i', 'i', 'i',
        'o', 'o', 'o', 'o', 'o',
        'o', 'o', 'o', 'o', 'o', 'o',
        'o', 'o', 'o', 'o', 'o', 'o',
        'u', 'u', 'u', 'u', 'u',
        'u', 'u', 'u', 'u', 'u', 'u',
        'y', 'y', 'y', 'y', 'y'};

    public static char normalize(char ch) {
        ch = Character.toLowerCase(ch);
        int index = -1;
        for (int i = 0; i < SRC_CHARS.length; i++) {
            if (SRC_CHARS[i] == ch) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            ch = DEST_CHARS[index];
        }
        return ch;
    }

    public static String normalize(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, normalize(sb.charAt(i)));
        }
        return sb.toString();
    }
}
