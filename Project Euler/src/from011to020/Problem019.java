package from011to020;

public class Problem019 {
  public static enum Day {
    SUN(0), MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6);
    private int value;

    private Day(int value) {
      this.value = value;
    }

    public int getValue() {
      return this.value;
    }

    public static Day valueOf(int value) {
      switch (value) {
        case 0:
          return SUN;
        case 1:
          return MON;
        case 2:
          return TUE;
        case 3:
          return WED;
        case 4:
          return THU;
        case 5:
          return FRI;
        case 6:
          return SAT;
        default:
          return null;
      }
    }
  }
  
  public static boolean isNextYearSunday(Day[] firstDayOfMonth, int month, int offset) {
    firstDayOfMonth[month] = Day.valueOf((firstDayOfMonth[month].value + offset) % 7);
    
    return firstDayOfMonth[month] == Day.SUN;
  }
  
  public static boolean isLeapYear(int year) {
    return (year % 100 == 0) ? (year % 400 == 0) : (year % 4 == 0);
  }
  
  public static void main(String[] args) {
    final int leftFrom28 = 28 % 7;
    final int leftFrom29 = 29 % 7;
    final int leftFrom30 = 30 % 7;
    final int leftFrom31 = 31 % 7;
    
    int initialYear = 1900;
    int startYear = 1901;
    int endYear = 2000;
    
    Day[] firstDayOfMonth = new Day[12];
    
    firstDayOfMonth[0] = Day.MON;
    firstDayOfMonth[1] = Day.valueOf((firstDayOfMonth[0].value + leftFrom31) % 7);
    firstDayOfMonth[2] = Day.valueOf(((isLeapYear(initialYear) ? leftFrom29 : leftFrom28)
        + firstDayOfMonth[1].getValue()) % 7);
    firstDayOfMonth[3] = Day.valueOf((firstDayOfMonth[2].value + leftFrom31) % 7);
    firstDayOfMonth[4] = Day.valueOf((firstDayOfMonth[3].value + leftFrom30) % 7);
    firstDayOfMonth[5] = Day.valueOf((firstDayOfMonth[4].value + leftFrom31) % 7);
    firstDayOfMonth[6] = Day.valueOf((firstDayOfMonth[5].value + leftFrom30) % 7);
    firstDayOfMonth[7] = Day.valueOf((firstDayOfMonth[6].value + leftFrom31) % 7);
    firstDayOfMonth[8] = Day.valueOf((firstDayOfMonth[7].value + leftFrom31) % 7);
    firstDayOfMonth[9] = Day.valueOf((firstDayOfMonth[8].value + leftFrom30) % 7);
    firstDayOfMonth[10] = Day.valueOf((firstDayOfMonth[9].value + leftFrom31) % 7);
    firstDayOfMonth[11] = Day.valueOf((firstDayOfMonth[10].value + leftFrom30) % 7);
    
    int offset = isLeapYear(initialYear) ? 2 : 1;
    for (int y = initialYear + 1; y < startYear; y++) {
      isNextYearSunday(firstDayOfMonth, 0, offset);
      isNextYearSunday(firstDayOfMonth, 1, offset);
      
      offset = isLeapYear(y) ? 2 : 1;
      for (int m = 3; m <= 12; m++) {
        isNextYearSunday(firstDayOfMonth, m - 1, offset);
      }
    }
    
    int count = 0;
    for (int y = startYear; y <= endYear; y++) {
      count += isNextYearSunday(firstDayOfMonth, 0, offset) ? 1 : 0;
      count += isNextYearSunday(firstDayOfMonth, 1, offset) ? 1 : 0;  
      
      offset = isLeapYear(y) ? 2 : 1;
      for (int m = 3; m <= 12; m++) {
        count += isNextYearSunday(firstDayOfMonth, m - 1, offset) ? 1 : 0;
      }
    }
    
    System.out.println(count);
  }
}
