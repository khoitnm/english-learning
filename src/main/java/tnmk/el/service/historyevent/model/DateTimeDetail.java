package tnmk.el.service.historyevent.model;

/**
 * @author khoi.tran on 9/22/16.
 */
public enum DateTimeDetail {
    /**
     * Only information about year is correct.
     * Month, day, time is only default time.
     */
    YEAR_ONLY
    /**
     * Only information about year and month are correct.
     */
    , YEAR_MONTH
    /**
     * Only information about date (year-month-day) are correct, time is default.
     */
    , DATE
    /**
     * Only information about time is correct (don't know date)
     */
    , TIME
    /**
     * Have full information about date time.
     */
    , DATE_TIME;
}
