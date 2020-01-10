public class Java13Features {

    private enum DAY_OF_WEEK { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};

    public static void main(String[] args) {
        System.out.println(traditionalSwitch(DAY_OF_WEEK.MONDAY));
        System.out.println(switchJava13(DAY_OF_WEEK.SATURDAY));
        System.out.println(enhancedSwitchCase(DAY_OF_WEEK.FRIDAY));
        textBlocks();
    }

    private static String traditionalSwitch(DAY_OF_WEEK dayOfWeek) {
        String result;
        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                result = "Weekday";
                break;
            case SATURDAY:
            case SUNDAY:
                result = "Weekend";
                break;
            default:
                result = "Invalid day!";
        }
        return result;
    }

    /* private String switchJava12(DAY_OF_WEEK dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                break "Weekday";
            case SATURDAY:
            case SUNDAY:
                break "Weekend";
        };
    } */

    private static String switchJava13(DAY_OF_WEEK dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                yield "Weekday";
            case SATURDAY:
            case SUNDAY:
                yield "Weekend";
        };
    }

    private static String enhancedSwitchCase(DAY_OF_WEEK dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
            case SATURDAY, SUNDAY -> "Weekend";
        };
    }

    private static void textBlocks() {

        String beforeQuery = "update products\n" +
                             "    set quantityInStock = ?\n" +
                             "    ,modifiedDate = ?\n" +
                             "    ,modifiedBy = ?\n" +
                             "where productCode = ?\n";

        String updateQuery = """
                update products
                    set quantityInStock = ?
                    ,modifiedDate = ?
                    ,modifiedBy = ?
                where productCode = ?
                """;
        System.out.println(updateQuery);
    }
}
