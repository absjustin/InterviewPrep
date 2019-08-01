package com.liuxin.interview.string;

public class DecodeString {

    private int pos = 0;

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        String input = "3[a]2[b4[F]c]";
        System.out.println(ds.decodeString(input));
    }

    private String decodeString(String s) {
        pos = 0;
        StringBuilder sb = new StringBuilder();
        while (pos < s.length()) {
            sb.append(decodeSubString(s));
        }
        return sb.toString();
    }

    private String decodeSubString(String s) {
        StringBuilder sb = new StringBuilder();
        while (pos < s.length()) {
            if (isCharNumber(s.charAt(pos))) {
                int end = pos;
                while (isCharNumber(s.charAt(end))) {
                    end++;
                }
                int repeat = Integer.valueOf(s.substring(pos, end));
                pos = end + 1;
                String val = decodeSubString(s);
                sb.append(val.repeat(Math.max(0, repeat)));
            } else if (isCharLetter(s.charAt(pos))) {
                sb.append(s.charAt(pos));
                pos++;
            } else {
                // can only be ] here
                pos++;
                return sb.toString();
            }
        }
        //should never get here, returning empty
        return sb.toString();
    }

    private boolean isCharNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isCharLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
