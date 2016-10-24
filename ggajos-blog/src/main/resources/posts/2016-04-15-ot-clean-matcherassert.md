---
layout: otclean
title: ot-clean, MatcherAssert vs Assert, which assertThat?
date: 2016-04-15
categories: ot-clean assertions
keywords:
  - ot-clean MatcherAssert
  - ot-clean Assert
  - ot-clean assertThat
  - ot-clean fluent
  - ot-clean declarative
---

In unit tests of ot-clean, I’m using only MatcherAssert for matching purposes. Why?

 * more descriptive error messages,
 * operations that can take matchers as arguments,
 * rich matcher language and possibility of building connected assertions,
 * more precise type checks (no longer Long vs Integer issues).

### Look under the hood

I like to see how things are built. `MatcherAssert` is doing the assertion job and has only 3 methods. `Assert` has
almost 1k lines and contain the history of JUnit development.

#### MatcherAssert (source code snapshot)

{% highlight bash %}
public class MatcherAssert {
   public static <T> void assertThat(T actual, Matcher<? super T> matcher) {
       assertThat("", actual, matcher);
   }
  
   public static <T> void assertThat(String reason, T actual, Matcher<? super T> matcher) {
       if (!matcher.matches(actual)) {
           Description description = new StringDescription();
           description.appendText(reason)
                      .appendText("\nExpected: ")
                      .appendDescriptionOf(matcher)
                      .appendText("\n     but: ");
           matcher.describeMismatch(actual, description);
          
           throw new AssertionError(description.toString());
       }
   }
  
   public static void assertThat(String reason, boolean assertion) {
       if (!assertion) {
           throw new AssertionError(reason);
       }
   }
}
{% endhighlight %}

#### Assert (source code snapshot)

{% highlight bash %}
public class Assert {
   protected Assert() {
   }

   static public void assertTrue(String message, boolean condition) {
       if (!condition) {
           fail(message);
       }
   }

   static public void assertTrue(boolean condition) {
       assertTrue(null, condition);
   }

   static public void assertFalse(String message, boolean condition) {
       assertTrue(message, !condition);
   }

   static public void assertFalse(boolean condition) {
       assertFalse(null, condition);
   }

   static public void fail(String message) {
       if (message == null) {
           throw new AssertionError();
       }
       throw new AssertionError(message);
   }

   static public void fail() {
       fail(null);
   }

   static public void assertEquals(String message, Object expected,
           Object actual) {
       if (equalsRegardingNull(expected, actual)) {
           return;
       } else if (expected instanceof String && actual instanceof String) {
           String cleanMessage = message == null ? "" : message;
           throw new ComparisonFailure(cleanMessage, (String) expected,
                   (String) actual);
       } else {
           failNotEquals(message, expected, actual);
       }
   }

   private static boolean equalsRegardingNull(Object expected, Object actual) {
       if (expected == null) {
           return actual == null;
       }

       return isEquals(expected, actual);
   }

   private static boolean isEquals(Object expected, Object actual) {
       return expected.equals(actual);
   }

   static public void assertEquals(Object expected, Object actual) {
       assertEquals(null, expected, actual);
   }

   static public void assertNotEquals(String message, Object unexpected,
           Object actual) {
       if (equalsRegardingNull(unexpected, actual)) {
           failEquals(message, actual);
       }
   }

   static public void assertNotEquals(Object unexpected, Object actual) {
       assertNotEquals(null, unexpected, actual);
   }

   private static void failEquals(String message, Object actual) {
       String formatted = "Values should be different. ";
       if (message != null) {
           formatted = message + ". ";
       }

       formatted += "Actual: " + actual;
       fail(formatted);
   }

   static public void assertNotEquals(String message, long unexpected, long actual) {
       if (unexpected == actual) {
           failEquals(message, Long.valueOf(actual));
       }
   }

   static public void assertNotEquals(long unexpected, long actual) {
       assertNotEquals(null, unexpected, actual);
   }

   static public void assertNotEquals(String message, double unexpected,
           double actual, double delta) {
       if (!doubleIsDifferent(unexpected, actual, delta)) {
           failEquals(message, Double.valueOf(actual));
       }
   }

   static public void assertNotEquals(double unexpected, double actual, double delta) {
       assertNotEquals(null, unexpected, actual, delta);
   }

   static public void assertNotEquals(float unexpected, float actual, float delta) {
       assertNotEquals(null, unexpected, actual, delta);
   }

   public static void assertArrayEquals(String message, Object[] expecteds,
           Object[] actuals) throws ArrayComparisonFailure {
       internalArrayEquals(message, expecteds, actuals);
   }

   public static void assertArrayEquals(Object[] expecteds, Object[] actuals) {
       assertArrayEquals(null, expecteds, actuals);
   }
  
   public static void assertArrayEquals(String message, boolean[] expecteds,
           boolean[] actuals) throws ArrayComparisonFailure {
       internalArrayEquals(message, expecteds, actuals);
   }   
  
   public static void assertArrayEquals(boolean[] expecteds, boolean[] actuals) {
       assertArrayEquals(null, expecteds, actuals);
   }

   public static void assertArrayEquals(String message, byte[] expecteds,
           byte[] actuals) throws ArrayComparisonFailure {
       internalArrayEquals(message, expecteds, actuals);
   }

   public static void assertArrayEquals(byte[] expecteds, byte[] actuals) {
       assertArrayEquals(null, expecteds, actuals);
   }

   public static void assertArrayEquals(String message, char[] expecteds,
           char[] actuals) throws ArrayComparisonFailure {
       internalArrayEquals(message, expecteds, actuals);
   }

   public static void assertArrayEquals(char[] expecteds, char[] actuals) {
       assertArrayEquals(null, expecteds, actuals);
   }

   public static void assertArrayEquals(String message, short[] expecteds,
           short[] actuals) throws ArrayComparisonFailure {
       internalArrayEquals(message, expecteds, actuals);
   }

   public static void assertArrayEquals(short[] expecteds, short[] actuals) {
       assertArrayEquals(null, expecteds, actuals);
   }

   public static void assertArrayEquals(String message, int[] expecteds,
           int[] actuals) throws ArrayComparisonFailure {
       internalArrayEquals(message, expecteds, actuals);
   }

   public static void assertArrayEquals(int[] expecteds, int[] actuals) {
       assertArrayEquals(null, expecteds, actuals);
   }

   public static void assertArrayEquals(String message, long[] expecteds,
           long[] actuals) throws ArrayComparisonFailure {
       internalArrayEquals(message, expecteds, actuals);
   }

   public static void assertArrayEquals(long[] expecteds, long[] actuals) {
       assertArrayEquals(null, expecteds, actuals);
   }

   public static void assertArrayEquals(String message, double[] expecteds,
           double[] actuals, double delta) throws ArrayComparisonFailure {
       new InexactComparisonCriteria(delta).arrayEquals(message, expecteds, actuals);
   }

   public static void assertArrayEquals(double[] expecteds, double[] actuals, double delta) {
       assertArrayEquals(null, expecteds, actuals, delta);
   }

   public static void assertArrayEquals(String message, float[] expecteds,
           float[] actuals, float delta) throws ArrayComparisonFailure {
       new InexactComparisonCriteria(delta).arrayEquals(message, expecteds, actuals);
   }


   public static void assertArrayEquals(float[] expecteds, float[] actuals, float delta) {
       assertArrayEquals(null, expecteds, actuals, delta);
   }

   private static void internalArrayEquals(String message, Object expecteds,
           Object actuals) throws ArrayComparisonFailure {
       new ExactComparisonCriteria().arrayEquals(message, expecteds, actuals);
   }

   static public void assertEquals(String message, double expected,
           double actual, double delta) {
       if (doubleIsDifferent(expected, actual, delta)) {
           failNotEquals(message, Double.valueOf(expected), Double.valueOf(actual));
       }
   }

   static public void assertEquals(String message, float expected,
           float actual, float delta) {
       if (floatIsDifferent(expected, actual, delta)) {
           failNotEquals(message, Float.valueOf(expected), Float.valueOf(actual));
       }
   }

   static public void assertNotEquals(String message, float unexpected,
           float actual, float delta) {
       if (!floatIsDifferent(unexpected, actual, delta)) {
           failEquals(message, Float.valueOf(actual));
       }
   }

   static private boolean doubleIsDifferent(double d1, double d2, double delta) {
       if (Double.compare(d1, d2) == 0) {
           return false;
       }
       if ((Math.abs(d1 - d2) <= delta)) {
           return false;
       }

       return true;
   }

   static private boolean floatIsDifferent(float f1, float f2, float delta) {
       if (Float.compare(f1, f2) == 0) {
           return false;
       }
       if ((Math.abs(f1 - f2) <= delta)) {
           return false;
       }

       return true;
   }

   static public void assertEquals(long expected, long actual) {
       assertEquals(null, expected, actual);
   }

   static public void assertEquals(String message, long expected, long actual) {
       if (expected != actual) {
           failNotEquals(message, Long.valueOf(expected), Long.valueOf(actual));
       }
   }

   @Deprecated
   static public void assertEquals(double expected, double actual) {
       assertEquals(null, expected, actual);
   }

   @Deprecated
   static public void assertEquals(String message, double expected,
           double actual) {
       fail("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
   }

   static public void assertEquals(double expected, double actual, double delta) {
       assertEquals(null, expected, actual, delta);
   }

   static public void assertEquals(float expected, float actual, float delta) {
       assertEquals(null, expected, actual, delta);
   }

   static public void assertNotNull(String message, Object object) {
       assertTrue(message, object != null);
   }

   static public void assertNotNull(Object object) {
       assertNotNull(null, object);
   }

   static public void assertNull(String message, Object object) {
       if (object == null) {
           return;
       }
       failNotNull(message, object);
   }

   static public void assertNull(Object object) {
       assertNull(null, object);
   }

   static private void failNotNull(String message, Object actual) {
       String formatted = "";
       if (message != null) {
           formatted = message + " ";
       }
       fail(formatted + "expected null, but was:<" + actual + ">");
   }

   static public void assertSame(String message, Object expected, Object actual) {
       if (expected == actual) {
           return;
       }
       failNotSame(message, expected, actual);
   }

   static public void assertSame(Object expected, Object actual) {
       assertSame(null, expected, actual);
   }

   static public void assertNotSame(String message, Object unexpected,
           Object actual) {
       if (unexpected == actual) {
           failSame(message);
       }
   }

   static public void assertNotSame(Object unexpected, Object actual) {
       assertNotSame(null, unexpected, actual);
   }

   static private void failSame(String message) {
       String formatted = "";
       if (message != null) {
           formatted = message + " ";
       }
       fail(formatted + "expected not same");
   }

   static private void failNotSame(String message, Object expected,
           Object actual) {
       String formatted = "";
       if (message != null) {
           formatted = message + " ";
       }
       fail(formatted + "expected same:<" + expected + "> was not:<" + actual
               + ">");
   }

   static private void failNotEquals(String message, Object expected,
           Object actual) {
       fail(format(message, expected, actual));
   }

   static String format(String message, Object expected, Object actual) {
       String formatted = "";
       if (message != null && !message.equals("")) {
           formatted = message + " ";
       }
       String expectedString = String.valueOf(expected);
       String actualString = String.valueOf(actual);
       if (expectedString.equals(actualString)) {
           return formatted + "expected: "
                   + formatClassAndValue(expected, expectedString)
                   + " but was: " + formatClassAndValue(actual, actualString);
       } else {
           return formatted + "expected:<" + expectedString + "> but was:<"
                   + actualString + ">";
       }
   }

   private static String formatClassAndValue(Object value, String valueString) {
       String className = value == null ? "null" : value.getClass().getName();
       return className + "<" + valueString + ">";
   }

   @Deprecated
   public static void assertEquals(String message, Object[] expecteds,
           Object[] actuals) {
       assertArrayEquals(message, expecteds, actuals);
   }

   @Deprecated
   public static void assertEquals(Object[] expecteds, Object[] actuals) {
       assertArrayEquals(expecteds, actuals);
   }

   public static <T> void assertThat(T actual, Matcher<? super T> matcher) {
       assertThat("", actual, matcher);
   }

   public static <T> void assertThat(String reason, T actual,
           Matcher<? super T> matcher) {
       MatcherAssert.assertThat(reason, actual, matcher);
   }
}
{% endhighlight %}
