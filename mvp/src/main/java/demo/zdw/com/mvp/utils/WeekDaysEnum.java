package demo.zdw.com.mvp.utils;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by yidatec on 2019/3/1.
 */

public class WeekDaysEnum {
    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY})
    public @interface WeekDays {}

    private @WeekDays int day = SUNDAY;

    private void setDay(@WeekDays int day) {
    }

    private void test() {
        setDay(WEDNESDAY);
    }
}
