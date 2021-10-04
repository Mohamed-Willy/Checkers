package com.example.checkers;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

public class Themes {
    private static int Theme;

    public final static int THEME_WHITE = 0;
    public final static int THEME_BLACK = 1;
    public final static int THEME_CYAN = 2;
    public final static int THEME_ORANGE = 3;
    public final static int THEME_GREEN = 4;
    public final static int THEME_COLORS = 5;

    public static void changeToTheme(Activity activity, int theme) {
        Theme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (Theme) {
            default:
            case THEME_WHITE:
                activity.setTheme(R.style.white_wood);
                break;
            case THEME_BLACK:
                activity.setTheme(R.style.black_wood);
                break;
            case THEME_CYAN:
                activity.setTheme(R.style.cyan);
                break;
            case THEME_ORANGE:
                activity.setTheme(R.style.orange);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.green);
                break;
            case THEME_COLORS:
                activity.setTheme(R.style.colors);
                break;

        }
    }

}
