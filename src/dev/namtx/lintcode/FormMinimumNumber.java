package dev.namtx.lintcode;

public class FormMinimumNumber {
    public static void main(String[] args) {
        System.out.println(new FormMinimumNumber().formMinimumNumber1("DDIID"));
    }

    public String formMinimumNumber1(String str) {
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int last = 0;
        for (int i = 0; i < str.length(); i++) {
            int sequencesOfD = 0;
            switch (str.charAt(i)) {
                case 'I': {
                    int j = i + 1;
                    while (j < str.length() && str.charAt(j) == 'D') {
                        j++;
                        sequencesOfD++;
                    }

                    if (i == 0) {
                        max += sequencesOfD + 2;
                        sb.append(++last);
                        sb.append(max);

                        last = max;
                    } else {
                        max += sequencesOfD + 1;
                        last = max;
                        sb.append(last);
                    }

                    for (int k = 0; k < sequencesOfD; k++) {
                        sb.append(--last);
                        i++;
                    }
                    break;
                }
                case 'D': {
                    if (i == 0) {
                        int j = i + 1;
                        while (j < str.length() && str.charAt(j) == 'D') {
                            sequencesOfD++;
                            j++;
                        }
                        max += sequencesOfD + 2;
                        sb.append(max);
                        sb.append(max - 1);
                        last = max - 1;
                    } else {
                        sb.append(last - 1);
                        last--;
                    }
                    break;
                }
            }
        }
        return sb.toString();
    }
}
