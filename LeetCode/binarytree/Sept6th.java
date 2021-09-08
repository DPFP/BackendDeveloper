public class Sept6th {
    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int time = releaseTimes[0];
        char ans = keysPressed.charAt(0);
        for (int i = 1; i < keysPressed.length(); i++) {
            int cur_time = releaseTimes[i] - releaseTimes[i - 1];
            if (cur_time >= time) {
                if (cur_time > time) {
                    ans = keysPressed.charAt(i);
                    time = cur_time;
                } else
                    ans = ans > keysPressed.charAt(i) ? ans : keysPressed.charAt(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws java.lang.Exception {
        int[] releaseTimes = { 9, 29, 49, 50 };
        String keysPressed = "cbcd";
        System.out.print(slowestKey(releaseTimes, keysPressed));
    }
}
