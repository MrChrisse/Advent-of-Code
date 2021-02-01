package Math;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class marriage_date {

    public static void main(String[] args) throws ParseException {
        ArrayList<Date> acceptedDates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        String month;
        int month_counter;
        for (int i = 1908; i < 2008; i++) {
            for (month_counter = 1; month_counter < 4; month_counter++) {
                month = "1";
                switch (month_counter) {
                    case 1:
                        month = "1";
                        break;
                    case 2:
                        month = "6";
                        break;
                    case 3:
                        month = "7";
                        break;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
                String monday_date_str = "13/" + month + "/" + i;
                Date cur_date = sdf.parse(monday_date_str);
                calendar.setTime(cur_date);
                if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                    System.out.println("Cur_Date: " + cur_date);
                    calendar.add(Calendar.YEAR, -8);
                    Date old_date = calendar.getTime();
                    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        acceptedDates.add(old_date);
                    }
                }
            }
        }
        System.out.println(acceptedDates.toString());
        System.out.println(acceptedDates.size());
    }
}
