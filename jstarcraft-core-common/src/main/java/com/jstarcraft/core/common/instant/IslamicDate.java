package com.jstarcraft.core.common.instant;

import java.time.LocalDate;
import java.time.chrono.HijrahDate;
import java.time.temporal.ChronoField;

public class IslamicDate implements CalendarDate {

    private HijrahDate date;

    public IslamicDate(LocalDate date) {
        this.date = HijrahDate.from(date);
    }

    public IslamicDate(int year, int month, int day) {
        this.date = HijrahDate.of(year, month, day);
    }

    @Override
    public CalendarType getType() {
        return CalendarType.Islamic;
    }

    @Override
    public int getYear() {
        return date.get(ChronoField.YEAR);
    }

    @Override
    public int getMonth() {
        return date.get(ChronoField.MONTH_OF_YEAR);
    }

    @Override
    public int getDay() {
        return date.get(ChronoField.DAY_OF_MONTH);
    }

    @Override
    public boolean isLeap() {
        return date.isLeapYear();
    }

    @Override
    public LocalDate getDate() {
        return LocalDate.ofEpochDay(date.toEpochDay());
    }

    /**
     * 获取指定年份的天数
     * 
     * @param year
     * @return
     */
    public static int getDaySize(int year) {
        HijrahDate date = HijrahDate.of(year, 1, 1);
        return date.lengthOfYear();
    }

    /**
     * 获取指定月份的天数
     * 
     * @param year
     * @param month
     * @return
     */
    public static int getDaySize(int year, int month) {
        HijrahDate date = HijrahDate.of(year, month, 1);
        return date.lengthOfMonth();
    }

}
