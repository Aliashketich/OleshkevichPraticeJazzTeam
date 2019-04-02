package util.strings;

public class SplitStringWithMyRegex {
    public static String[] splitStringWithMyRegex(String string) {
        return string.split("[\\\\s\\\\-\\\\-\\\\.\\\\'\\\\@\\\\!\\\\?\\\\,\\\\_\\\\ ]+");
    }
}
