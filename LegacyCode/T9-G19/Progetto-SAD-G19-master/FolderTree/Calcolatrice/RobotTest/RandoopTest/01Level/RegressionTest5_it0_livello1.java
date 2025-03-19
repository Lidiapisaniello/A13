
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest5 {

  public static boolean debug = false;

  @Test
  public void test01() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test01"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-52), (-3));
    int i21 = calcolatrice0.divide((-32), (int)'#');
    int i24 = calcolatrice0.divide(17, (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test02() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test02"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((-50), 33);
    int i24 = calcolatrice0.divide((-33), (int)'4');
    int i27 = calcolatrice0.divide((int)(byte)1, (int)(short)10);
    int i30 = calcolatrice0.divide((-17), (int)(short)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 17);

  }

  @Test
  public void test03() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test03"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(short)10, 20);
    int i12 = calcolatrice0.divide((-52), 4);
    int i15 = calcolatrice0.divide(25, (-5));
    int i18 = calcolatrice0.divide((-7), (-14));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-13));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-5));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test04() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test04"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', 10);
    int i18 = calcolatrice0.divide(14, (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));

  }

  @Test
  public void test05() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test05"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(1, (-10));
    int i24 = calcolatrice0.divide((int)(short)-1, (int)'#');
    int i27 = calcolatrice0.divide(0, (-5));
    int i30 = calcolatrice0.divide((int)' ', (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test06() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test06"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide((int)(short)10, (-10));
    int i12 = calcolatrice0.divide((int)'a', (-32));
    int i15 = calcolatrice0.divide(16, (-10));
    int i18 = calcolatrice0.divide((-13), (-97));
    int i21 = calcolatrice0.divide((-6), 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test07() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test07"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(byte)1, 7);
    int i12 = calcolatrice0.divide((-16), (int)' ');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);

  }

  @Test
  public void test08() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test08"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide((-3), (-10));
    // The following exception was thrown during execution in test generation
    try {
    int i15 = calcolatrice0.divide(8, (int)(byte)0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);

  }

  @Test
  public void test09() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test09"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(10, 17);
    int i24 = calcolatrice0.divide(0, (int)'a');
    int i27 = calcolatrice0.divide(17, 4);
    int i30 = calcolatrice0.divide((int)(byte)-1, (-100));
    int i33 = calcolatrice0.divide((-33), 20);
    int i36 = calcolatrice0.divide((-5), 100);
    int i39 = calcolatrice0.divide(14, (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-7));

  }

  @Test
  public void test10() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test10"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)'#', (int)(byte)-1);
    int i12 = calcolatrice0.divide((int)(short)-1, (-100));
    int i15 = calcolatrice0.divide(100, 100);
    int i18 = calcolatrice0.divide(33, (-9));
    int i21 = calcolatrice0.divide((-10), (-4));
    int i24 = calcolatrice0.divide(20, (-1));
    int i27 = calcolatrice0.divide((-2), (-97));
    // The following exception was thrown during execution in test generation
    try {
    int i30 = calcolatrice0.divide((int)'a', (int)(short)0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test11() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test11"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide((int)(byte)100, (int)(short)-1);
    int i18 = calcolatrice0.divide((-19), 2);
    int i21 = calcolatrice0.divide((-33), 32);
    int i24 = calcolatrice0.divide((-20), (-97));
    int i27 = calcolatrice0.divide((-5), 14);
    int i30 = calcolatrice0.divide((-33), (-32));
    int i33 = calcolatrice0.divide((-2), 8);
    int i36 = calcolatrice0.divide(0, (int)'#');
    int i39 = calcolatrice0.divide((-26), 20);
    int i42 = calcolatrice0.divide(32, (int)(byte)1);
    int i45 = calcolatrice0.divide(17, 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-9));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i45 == 17);

  }

  @Test
  public void test12() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test12"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide((-3), (int)(short)1);
    int i24 = calcolatrice0.divide((-32), (-12));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 2);

  }

  @Test
  public void test13() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test13"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)' ', (int)(byte)1);
    int i18 = calcolatrice0.divide(5, (int)(byte)100);
    int i21 = calcolatrice0.divide((int)(byte)100, 6);
    int i24 = calcolatrice0.divide(3, (int)(short)100);
    int i27 = calcolatrice0.divide((-26), 1);
    int i30 = calcolatrice0.divide((-100), (-9));
    int i33 = calcolatrice0.divide((int)(short)1, (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-26));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test14() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test14"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)' ', (int)(byte)1);
    int i18 = calcolatrice0.divide(5, (int)(byte)100);
    int i21 = calcolatrice0.divide((int)(byte)100, 6);
    int i24 = calcolatrice0.divide(3, (int)(short)100);
    int i27 = calcolatrice0.divide((-26), 1);
    int i30 = calcolatrice0.divide(8, 24);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-26));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test15() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test15"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)10, 52);
    int i18 = calcolatrice0.divide(5, (int)'#');
    int i21 = calcolatrice0.divide(52, (-2));
    int i24 = calcolatrice0.divide((-10), (int)(byte)10);
    int i27 = calcolatrice0.divide((-32), 16);
    int i30 = calcolatrice0.divide((-26), 33);
    int i33 = calcolatrice0.divide((int)(short)0, (-33));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-26));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test16() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test16"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((int)'a', (-3));
    int i12 = calcolatrice0.divide((int)(byte)100, (-9));
    int i15 = calcolatrice0.divide((int)(short)-1, 2);
    int i18 = calcolatrice0.divide((-35), 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-32));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-17));

  }

  @Test
  public void test17() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test17"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((int)'a', (-3));
    int i12 = calcolatrice0.divide((-35), 35);
    int i15 = calcolatrice0.divide(6, 33);
    int i18 = calcolatrice0.divide((int)(byte)10, (-6));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-32));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));

  }

  @Test
  public void test18() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test18"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)'#', (int)(byte)-1);
    int i12 = calcolatrice0.divide((int)(short)-1, (-100));
    int i15 = calcolatrice0.divide(100, 100);
    int i18 = calcolatrice0.divide(0, (-3));
    int i21 = calcolatrice0.divide(0, (int)'a');
    int i24 = calcolatrice0.divide(11, 10);
    int i27 = calcolatrice0.divide((-2), (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test19() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test19"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-35), 6);
    int i21 = calcolatrice0.divide(17, 33);
    int i24 = calcolatrice0.divide((-19), (-20));
    int i27 = calcolatrice0.divide((-52), (int)(short)100);
    int i30 = calcolatrice0.divide((-4), 10);
    int i33 = calcolatrice0.divide(7, (-52));
    int i36 = calcolatrice0.divide((-5), 1);
    int i39 = calcolatrice0.divide(25, 19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-5));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-5));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 1);

  }

  @Test
  public void test20() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test20"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(byte)-1, 10);
    int i18 = calcolatrice0.divide(100, (-97));
    int i21 = calcolatrice0.divide((-35), (-17));
    int i24 = calcolatrice0.divide((-24), (-35));
    int i27 = calcolatrice0.divide(2, (int)(short)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test21() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest5.test21"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((int)(short)-1, (-33));
    int i24 = calcolatrice0.divide((int)(byte)1, 100);
    int i27 = calcolatrice0.divide((-5), 10);
    int i30 = calcolatrice0.divide((int)(short)1, (-50));
    int i33 = calcolatrice0.divide(17, (-9));
    int i36 = calcolatrice0.divide(13, 32);
    int i39 = calcolatrice0.divide((-20), (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 2);

  }

}
