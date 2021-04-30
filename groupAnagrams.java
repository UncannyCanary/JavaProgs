package JavaProgs;

class groupAnagrams {
    public static void main(String[] args) {
        String s = "cat";
        int[] a = new int[26];
        for (char letter: s.toCharArray()) {
            a[letter - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0)
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
}
