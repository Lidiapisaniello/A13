
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest3 {

  public static boolean debug = false;

  @Test
  public void test001() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test001"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(byte)100, (-2));
    int i24 = calcolatrice0.divide((int)(byte)0, (-1));
    int i27 = calcolatrice0.divide((-3), 4);
    int i30 = calcolatrice0.divide((int)'#', (int)(byte)100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test002() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test002"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(byte)-1, 10);
    int i18 = calcolatrice0.divide((int)(byte)-1, 100);
    int i21 = calcolatrice0.divide(2, (int)(short)-1);
    int i24 = calcolatrice0.divide((int)(byte)100, (-26));
    int i27 = calcolatrice0.divide((-14), 7);
    int i30 = calcolatrice0.divide((-25), (int)(short)-1);
    int i33 = calcolatrice0.divide(33, (int)(short)10);
    int i36 = calcolatrice0.divide((-4), (-2));
    int i39 = calcolatrice0.divide((-52), (int)(short)-1);
    int i42 = calcolatrice0.divide((int)(byte)0, (-5));
    
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
    org.junit.Assert.assertTrue(i21 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 52);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);

  }

  @Test
  public void test003() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test003"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide(3, (int)' ');
    int i18 = calcolatrice0.divide((-1), (-2));
    int i21 = calcolatrice0.divide(9, (int)(short)1);
    int i24 = calcolatrice0.divide(11, 97);
    int i27 = calcolatrice0.divide(12, 3);
    
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
    org.junit.Assert.assertTrue(i21 == 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 4);

  }

  @Test
  public void test004() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test004"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide((-33), (int)(byte)10);
    int i27 = calcolatrice0.divide((-5), 2);
    int i30 = calcolatrice0.divide(25, 17);
    int i33 = calcolatrice0.divide((-13), 20);
    int i36 = calcolatrice0.divide(14, 52);
    int i39 = calcolatrice0.divide((int)(byte)10, (-7));
    int i42 = calcolatrice0.divide(20, (-32));
    int i45 = calcolatrice0.divide(0, (-11));
    int i48 = calcolatrice0.divide((-10), (int)'4');
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i45 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i48 == 0);

  }

  @Test
  public void test005() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test005"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide(3, (-1));
    int i18 = calcolatrice0.divide(0, (-25));
    int i21 = calcolatrice0.divide((-4), (int)(short)1);
    int i24 = calcolatrice0.divide(17, (-97));
    int i27 = calcolatrice0.divide(52, (int)'a');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test006() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test006"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)10, 52);
    int i18 = calcolatrice0.divide(5, (int)'#');
    int i21 = calcolatrice0.divide(0, (-10));
    int i24 = calcolatrice0.divide((-20), (-4));
    int i27 = calcolatrice0.divide((int)'4', 10);
    int i30 = calcolatrice0.divide(17, (-6));
    
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
    org.junit.Assert.assertTrue(i24 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-2));

  }

  @Test
  public void test007() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test007"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((-1), (int)(short)100);
    int i18 = calcolatrice0.divide(32, (-3));
    int i21 = calcolatrice0.divide((int)' ', 1);
    int i24 = calcolatrice0.divide(2, 35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test008() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test008"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide(0, (-50));
    int i24 = calcolatrice0.divide(52, 9);
    int i27 = calcolatrice0.divide((int)(short)100, 2);
    int i30 = calcolatrice0.divide((-7), (-10));
    int i33 = calcolatrice0.divide((-16), 6);
    int i36 = calcolatrice0.divide((-48), 33);
    
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
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-1));

  }

  @Test
  public void test009() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test009"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)'4', (int)(byte)1);
    int i15 = calcolatrice0.divide(0, (-97));
    int i18 = calcolatrice0.divide((int)'#', (-32));
    int i21 = calcolatrice0.divide((int)(byte)100, 20);
    int i24 = calcolatrice0.divide(33, (-9));
    int i27 = calcolatrice0.divide(8, (-2));
    int i30 = calcolatrice0.divide(12, 33);
    int i33 = calcolatrice0.divide((-14), 8);
    int i36 = calcolatrice0.divide((int)' ', (-32));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 52);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-1));

  }

  @Test
  public void test010() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test010"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((-1), (int)(short)100);
    int i18 = calcolatrice0.divide(1, (-32));
    int i21 = calcolatrice0.divide((int)' ', (-33));
    int i24 = calcolatrice0.divide((-33), (int)'#');
    int i27 = calcolatrice0.divide(0, (int)(byte)-1);
    int i30 = calcolatrice0.divide(4, (-12));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
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

  }

  @Test
  public void test011() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test011"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-52), 32);
    int i6 = calcolatrice0.divide((-35), (-16));
    int i9 = calcolatrice0.divide((-6), 12);
    int i12 = calcolatrice0.divide(50, (-33));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-1));

  }

  @Test
  public void test012() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test012"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((-1), 10);
    int i18 = calcolatrice0.divide(3, 33);
    
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

  }

  @Test
  public void test013() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test013"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide(100, (int)(byte)-1);
    int i18 = calcolatrice0.divide(52, (-35));
    int i21 = calcolatrice0.divide((int)'a', (-5));
    int i24 = calcolatrice0.divide(0, (-5));
    int i27 = calcolatrice0.divide((-26), (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-19));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 2);

  }

  @Test
  public void test014() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test014"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide(4, (-35));
    int i12 = calcolatrice0.divide(6, (int)'a');
    int i15 = calcolatrice0.divide((-11), (int)(short)1);
    int i18 = calcolatrice0.divide(0, (-4));
    int i21 = calcolatrice0.divide(26, (-25));
    int i24 = calcolatrice0.divide(8, (int)(short)10);
    int i27 = calcolatrice0.divide((-25), 50);
    int i30 = calcolatrice0.divide((int)(byte)10, (int)(short)100);
    int i33 = calcolatrice0.divide(33, 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 33);

  }

  @Test
  public void test015() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test015"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide((int)(byte)100, (int)(short)-1);
    int i18 = calcolatrice0.divide((-19), 2);
    int i21 = calcolatrice0.divide(97, 11);
    int i24 = calcolatrice0.divide(100, (-12));
    int i27 = calcolatrice0.divide(7, (-7));
    
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
    org.junit.Assert.assertTrue(i21 == 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-1));

  }

  @Test
  public void test016() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test016"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(byte)100, (-2));
    int i24 = calcolatrice0.divide((-4), (-19));
    int i27 = calcolatrice0.divide((-9), (int)' ');
    // The following exception was thrown during execution in test generation
    try {
    int i30 = calcolatrice0.divide(11, 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test017() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test017"); }


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
    int i30 = calcolatrice0.divide(16, 10);
    int i33 = calcolatrice0.divide(48, 7);
    int i36 = calcolatrice0.divide((-50), 10);
    
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
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-5));

  }

  @Test
  public void test018() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test018"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide((int)'4', (int)'a');
    int i24 = calcolatrice0.divide((int)(byte)10, (-5));
    int i27 = calcolatrice0.divide((-52), (-100));
    int i30 = calcolatrice0.divide((-26), (-5));
    int i33 = calcolatrice0.divide((int)(short)10, (-100));
    int i36 = calcolatrice0.divide((-97), (-7));
    int i39 = calcolatrice0.divide(3, 1);
    int i42 = calcolatrice0.divide((-19), (int)(byte)1);
    int i45 = calcolatrice0.divide((-13), (int)(byte)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == (-19));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i45 == 13);

  }

  @Test
  public void test019() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test019"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-33), (int)'a');
    int i24 = calcolatrice0.divide(0, 97);
    int i27 = calcolatrice0.divide((-10), (-3));
    int i30 = calcolatrice0.divide(17, (int)(byte)10);
    int i33 = calcolatrice0.divide(32, (int)'#');
    int i36 = calcolatrice0.divide(52, (-12));
    int i39 = calcolatrice0.divide((-35), 35);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-1));

  }

  @Test
  public void test020() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test020"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide(3, (int)' ');
    int i18 = calcolatrice0.divide((-1), (-2));
    int i21 = calcolatrice0.divide((-19), (-97));
    int i24 = calcolatrice0.divide((-1), (-32));
    int i27 = calcolatrice0.divide(25, 97);
    
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

  }

  @Test
  public void test021() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test021"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((-32), 3);
    int i21 = calcolatrice0.divide((-100), (-100));
    // The following exception was thrown during execution in test generation
    try {
    int i24 = calcolatrice0.divide(0, 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);

  }

  @Test
  public void test022() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test022"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-33), (int)'a');
    int i24 = calcolatrice0.divide(0, 97);
    int i27 = calcolatrice0.divide((-10), (-3));
    int i30 = calcolatrice0.divide(17, (int)(byte)10);
    int i33 = calcolatrice0.divide(32, (int)'#');
    int i36 = calcolatrice0.divide(9, 16);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test023() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test023"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(97, (-50));
    int i24 = calcolatrice0.divide((-14), 100);
    
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
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test024() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test024"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(byte)0, (-26));
    int i21 = calcolatrice0.divide(97, (-20));
    int i24 = calcolatrice0.divide(0, (-9));
    
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
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test025() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test025"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide(33, (-26));
    int i27 = calcolatrice0.divide(0, 7);
    int i30 = calcolatrice0.divide((-7), (int)(byte)100);
    int i33 = calcolatrice0.divide(6, (-16));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test026() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test026"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((int)(byte)10, (int)(short)10);
    int i21 = calcolatrice0.divide((-1), (int)(short)1);
    int i24 = calcolatrice0.divide((-26), 16);
    int i27 = calcolatrice0.divide((-14), 3);
    int i30 = calcolatrice0.divide((int)(byte)0, (-10));
    int i33 = calcolatrice0.divide((-100), (int)(short)10);
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-10));

  }

  @Test
  public void test027() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test027"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)(byte)-1, (-5));
    int i18 = calcolatrice0.divide(33, (-3));
    int i21 = calcolatrice0.divide((-35), (-12));
    int i24 = calcolatrice0.divide((-17), 2);
    int i27 = calcolatrice0.divide(97, 10);
    int i30 = calcolatrice0.divide((-24), 24);
    
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
    org.junit.Assert.assertTrue(i18 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-1));

  }

  @Test
  public void test028() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test028"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide(0, 52);
    int i12 = calcolatrice0.divide((-4), (int)(byte)10);
    int i15 = calcolatrice0.divide(2, (-7));
    int i18 = calcolatrice0.divide((-1), (-4));
    
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

  }

  @Test
  public void test029() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test029"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((int)'a', (-3));
    int i12 = calcolatrice0.divide(6, (-1));
    int i15 = calcolatrice0.divide((-6), (int)(short)10);
    int i18 = calcolatrice0.divide((-26), 8);
    int i21 = calcolatrice0.divide((-100), (int)(byte)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-32));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-6));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-10));

  }

  @Test
  public void test030() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test030"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide(0, 5);
    int i21 = calcolatrice0.divide((int)(byte)100, (-10));
    int i24 = calcolatrice0.divide((-20), 2);
    
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
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-10));

  }

  @Test
  public void test031() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test031"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(10, 1);
    int i15 = calcolatrice0.divide(100, (-5));
    int i18 = calcolatrice0.divide(0, 50);
    int i21 = calcolatrice0.divide(0, (-13));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test032() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test032"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(byte)100, (-2));
    int i24 = calcolatrice0.divide((-3), (-52));
    int i27 = calcolatrice0.divide((-4), 97);
    int i30 = calcolatrice0.divide((-8), 100);
    int i33 = calcolatrice0.divide(52, 17);
    int i36 = calcolatrice0.divide(5, (-12));
    int i39 = calcolatrice0.divide(11, (-50));
    int i42 = calcolatrice0.divide(5, (int)' ');
    int i45 = calcolatrice0.divide((int)(byte)0, 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i45 == 0);

  }

  @Test
  public void test033() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test033"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(byte)0, (-26));
    int i21 = calcolatrice0.divide(97, (-20));
    int i24 = calcolatrice0.divide((-6), 5);
    int i27 = calcolatrice0.divide(50, (int)(short)-1);
    
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
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-50));

  }

  @Test
  public void test034() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test034"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((int)(short)100, (int)(short)100);
    int i24 = calcolatrice0.divide(0, (int)'#');
    int i27 = calcolatrice0.divide((int)(short)100, (int)(short)1);
    int i30 = calcolatrice0.divide(35, (int)'#');
    int i33 = calcolatrice0.divide((-6), (-100));
    int i36 = calcolatrice0.divide((-52), (-9));
    int i39 = calcolatrice0.divide((int)(short)10, 3);
    int i42 = calcolatrice0.divide((int)'4', (-52));
    
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
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == (-1));

  }

  @Test
  public void test035() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test035"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide(1, (-35));
    int i9 = calcolatrice0.divide((int)'#', (-100));
    int i12 = calcolatrice0.divide(5, (-52));
    int i15 = calcolatrice0.divide((-13), (-6));
    int i18 = calcolatrice0.divide(50, (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-16));

  }

  @Test
  public void test036() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test036"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((-1), (int)(short)100);
    int i18 = calcolatrice0.divide(1, (-32));
    int i21 = calcolatrice0.divide((int)' ', (-33));
    int i24 = calcolatrice0.divide((-20), (int)(short)10);
    int i27 = calcolatrice0.divide(0, 9);
    int i30 = calcolatrice0.divide((int)(byte)100, (int)(byte)10);
    int i33 = calcolatrice0.divide((-52), (-9));
    int i36 = calcolatrice0.divide((-6), (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test037() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test037"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(byte)0, (-6));
    int i12 = calcolatrice0.divide(2, (int)(byte)100);
    int i15 = calcolatrice0.divide(0, (-100));
    
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

  }

  @Test
  public void test038() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test038"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((-26), (int)'a');
    int i21 = calcolatrice0.divide((-50), (int)(short)-1);
    int i24 = calcolatrice0.divide(0, 33);
    int i27 = calcolatrice0.divide((-14), (-16));
    
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
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test039() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test039"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide((int)'4', (int)'a');
    int i24 = calcolatrice0.divide((int)(byte)0, 20);
    int i27 = calcolatrice0.divide((int)'4', 11);
    int i30 = calcolatrice0.divide((-17), 25);
    int i33 = calcolatrice0.divide((-35), 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test040() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test040"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide(0, (-50));
    int i24 = calcolatrice0.divide(0, (int)'4');
    int i27 = calcolatrice0.divide(52, (-4));
    
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
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-13));

  }

  @Test
  public void test041() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test041"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((-2), (-52));
    int i21 = calcolatrice0.divide((int)'a', 11);
    int i24 = calcolatrice0.divide(100, 11);
    int i27 = calcolatrice0.divide((int)(short)0, 11);
    int i30 = calcolatrice0.divide(0, 4);
    int i33 = calcolatrice0.divide((-1), (-32));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test042() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test042"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((-4), (int)(byte)1);
    int i21 = calcolatrice0.divide(5, 2);
    int i24 = calcolatrice0.divide((int)(short)0, 100);
    // The following exception was thrown during execution in test generation
    try {
    int i27 = calcolatrice0.divide(48, 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test043() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test043"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(10, 17);
    int i24 = calcolatrice0.divide((-11), (-10));
    int i27 = calcolatrice0.divide(97, 97);
    int i30 = calcolatrice0.divide((-1), (-35));
    int i33 = calcolatrice0.divide(0, (-97));
    int i36 = calcolatrice0.divide((-14), 8);
    
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
    org.junit.Assert.assertTrue(i24 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-1));

  }

  @Test
  public void test044() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test044"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide((int)'#', (int)'a');
    int i27 = calcolatrice0.divide((-17), (-1));
    int i30 = calcolatrice0.divide((-1), (int)(byte)-1);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);

  }

  @Test
  public void test045() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test045"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide((-97), (-8));
    int i21 = calcolatrice0.divide(25, 6);
    int i24 = calcolatrice0.divide((int)(short)-1, (-17));
    int i27 = calcolatrice0.divide((-4), 12);
    
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
    org.junit.Assert.assertTrue(i18 == 12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test046() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test046"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((-1), (int)(short)100);
    int i18 = calcolatrice0.divide(1, (-32));
    int i21 = calcolatrice0.divide((int)' ', (-33));
    int i24 = calcolatrice0.divide((-20), (int)(short)10);
    int i27 = calcolatrice0.divide((int)(short)10, 10);
    int i30 = calcolatrice0.divide(13, 17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test047() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test047"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide(1, (-35));
    int i9 = calcolatrice0.divide(100, (-1));
    int i12 = calcolatrice0.divide(24, (int)(byte)100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);

  }

  @Test
  public void test048() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test048"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide(100, 5);
    int i24 = calcolatrice0.divide(20, 2);
    int i27 = calcolatrice0.divide(97, 35);
    
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
    org.junit.Assert.assertTrue(i21 == 20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 2);

  }

  @Test
  public void test049() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test049"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)10, 52);
    int i18 = calcolatrice0.divide(52, (-26));
    int i21 = calcolatrice0.divide((int)'4', 1);
    int i24 = calcolatrice0.divide(13, 26);
    int i27 = calcolatrice0.divide(19, 50);
    int i30 = calcolatrice0.divide((-1), (-2));
    int i33 = calcolatrice0.divide((int)(short)0, (-100));
    
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
    org.junit.Assert.assertTrue(i18 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 52);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test050() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test050"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(10, 1);
    int i15 = calcolatrice0.divide((-3), 20);
    int i18 = calcolatrice0.divide(9, 2);
    int i21 = calcolatrice0.divide((-25), (-16));
    int i24 = calcolatrice0.divide((int)'4', 9);
    int i27 = calcolatrice0.divide(97, 12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 8);

  }

  @Test
  public void test051() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test051"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide(35, (int)(short)-1);
    int i21 = calcolatrice0.divide(50, (-14));
    int i24 = calcolatrice0.divide((-8), (-48));
    int i27 = calcolatrice0.divide((-13), 7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-1));

  }

  @Test
  public void test052() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test052"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)'4', (int)(byte)1);
    int i15 = calcolatrice0.divide(0, (-97));
    int i18 = calcolatrice0.divide((int)'#', (-32));
    int i21 = calcolatrice0.divide((int)(byte)100, 20);
    int i24 = calcolatrice0.divide(33, (-9));
    int i27 = calcolatrice0.divide(8, 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 52);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test053() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test053"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide(0, (-50));
    int i24 = calcolatrice0.divide(52, 9);
    int i27 = calcolatrice0.divide((int)(short)100, 2);
    int i30 = calcolatrice0.divide(0, 32);
    int i33 = calcolatrice0.divide((-13), 1);
    int i36 = calcolatrice0.divide(26, 7);
    int i39 = calcolatrice0.divide(0, 8);
    int i42 = calcolatrice0.divide(5, (-14));
    
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
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-13));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);

  }

  @Test
  public void test054() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test054"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)10, 52);
    int i18 = calcolatrice0.divide(5, (int)'#');
    int i21 = calcolatrice0.divide(52, (-2));
    int i24 = calcolatrice0.divide((int)'4', (-1));
    // The following exception was thrown during execution in test generation
    try {
    int i27 = calcolatrice0.divide((-8), (int)(short)0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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
    org.junit.Assert.assertTrue(i24 == (-52));

  }

  @Test
  public void test055() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test055"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)'4', (int)'#');
    int i21 = calcolatrice0.divide((-50), (int)(short)-1);
    int i24 = calcolatrice0.divide(6, (int)(byte)10);
    int i27 = calcolatrice0.divide((int)(short)-1, (-32));
    int i30 = calcolatrice0.divide(0, (int)'#');
    int i33 = calcolatrice0.divide((int)'a', (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-48));

  }

  @Test
  public void test056() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test056"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide((int)(short)-1, (-1));
    int i21 = calcolatrice0.divide(0, 10);
    int i24 = calcolatrice0.divide((int)(short)1, (-11));
    int i27 = calcolatrice0.divide((-7), (-12));
    int i30 = calcolatrice0.divide((-3), (-19));
    int i33 = calcolatrice0.divide(1, (int)(short)10);
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
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

  }

  @Test
  public void test057() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test057"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((int)(short)-1, (-33));
    int i24 = calcolatrice0.divide((-3), (-5));
    int i27 = calcolatrice0.divide(3, 25);
    int i30 = calcolatrice0.divide((int)(byte)100, (-9));
    int i33 = calcolatrice0.divide((-48), 48);
    
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
    org.junit.Assert.assertTrue(i30 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-1));

  }

  @Test
  public void test058() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test058"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)'4', (int)'#');
    int i21 = calcolatrice0.divide((-26), 2);
    int i24 = calcolatrice0.divide(10, (-20));
    int i27 = calcolatrice0.divide((-13), 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-13));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-1));

  }

  @Test
  public void test059() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test059"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(32, 5);
    int i12 = calcolatrice0.divide((-11), (-97));
    int i15 = calcolatrice0.divide(17, 16);
    int i18 = calcolatrice0.divide(35, (int)'#');
    int i21 = calcolatrice0.divide(52, 16);
    int i24 = calcolatrice0.divide((int)'4', (int)(short)100);
    int i27 = calcolatrice0.divide((int)(short)1, (-32));
    int i30 = calcolatrice0.divide(16, 20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test060() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test060"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide((int)(short)10, (-10));
    int i12 = calcolatrice0.divide((int)'#', 1);
    int i15 = calcolatrice0.divide(0, (int)(short)1);
    int i18 = calcolatrice0.divide(16, (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test061() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test061"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((-35), (int)' ');
    int i15 = calcolatrice0.divide((-2), 1);
    int i18 = calcolatrice0.divide(24, (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test062() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test062"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)' ', (int)(byte)1);
    int i18 = calcolatrice0.divide(5, (int)(byte)100);
    int i21 = calcolatrice0.divide(20, 32);
    int i24 = calcolatrice0.divide((int)(short)100, 48);
    int i27 = calcolatrice0.divide(19, 97);
    
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
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test063() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test063"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(byte)100, (-2));
    int i24 = calcolatrice0.divide((-3), (-52));
    int i27 = calcolatrice0.divide((-4), 97);
    int i30 = calcolatrice0.divide((-8), 100);
    int i33 = calcolatrice0.divide(52, 17);
    int i36 = calcolatrice0.divide(5, (-12));
    int i39 = calcolatrice0.divide((-100), 12);
    int i42 = calcolatrice0.divide(0, (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);

  }

  @Test
  public void test064() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test064"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide(3, (int)' ');
    int i18 = calcolatrice0.divide((-100), 48);
    int i21 = calcolatrice0.divide((-20), 12);
    
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
    org.junit.Assert.assertTrue(i18 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));

  }

  @Test
  public void test065() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test065"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide((int)(short)100, 16);
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 6);

  }

  @Test
  public void test066() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test066"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(byte)100, (int)' ');
    int i24 = calcolatrice0.divide((-12), 1);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-12));

  }

  @Test
  public void test067() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test067"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)'#', (int)(byte)-1);
    int i12 = calcolatrice0.divide((int)(short)-1, (-100));
    int i15 = calcolatrice0.divide((int)'#', (-5));
    int i18 = calcolatrice0.divide(0, (-17));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-7));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test068() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test068"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-100), (-32));
    int i12 = calcolatrice0.divide((int)(short)100, 6);
    int i15 = calcolatrice0.divide((-35), 35);
    int i18 = calcolatrice0.divide((-26), (-1));
    int i21 = calcolatrice0.divide(6, (-33));
    int i24 = calcolatrice0.divide(9, (int)'4');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test069() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test069"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(32, 5);
    int i12 = calcolatrice0.divide((int)(short)100, (int)(short)100);
    int i15 = calcolatrice0.divide((-26), (-32));
    int i18 = calcolatrice0.divide((-52), 32);
    int i21 = calcolatrice0.divide((int)(short)-1, 13);
    int i24 = calcolatrice0.divide(26, (-26));
    int i27 = calcolatrice0.divide(13, (-3));
    int i30 = calcolatrice0.divide((-11), (-13));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test070() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test070"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide(10, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(short)-1, (-52));
    int i21 = calcolatrice0.divide(20, 2);
    int i24 = calcolatrice0.divide(24, 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 2);

  }

  @Test
  public void test071() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test071"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide(1, (-35));
    int i9 = calcolatrice0.divide(100, (-1));
    int i12 = calcolatrice0.divide((int)'#', 25);
    int i15 = calcolatrice0.divide((int)'a', 35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 2);

  }

  @Test
  public void test072() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test072"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide(8, (int)(byte)1);
    int i27 = calcolatrice0.divide((int)(byte)-1, (int)(byte)-1);
    int i30 = calcolatrice0.divide((-6), (-48));
    int i33 = calcolatrice0.divide((-11), 5);
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-2));

  }

  @Test
  public void test073() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test073"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide((int)(byte)100, (int)(short)-1);
    int i18 = calcolatrice0.divide((-19), 2);
    int i21 = calcolatrice0.divide((-33), 32);
    int i24 = calcolatrice0.divide((-35), (int)(short)1);
    int i27 = calcolatrice0.divide(50, (-52));
    int i30 = calcolatrice0.divide(0, (int)(byte)-1);
    int i33 = calcolatrice0.divide((-7), 1);
    int i36 = calcolatrice0.divide(7, (int)(byte)-1);
    int i39 = calcolatrice0.divide((int)(byte)-1, 13);
    int i42 = calcolatrice0.divide((-32), (-35));
    
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
    org.junit.Assert.assertTrue(i24 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-7));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-7));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);

  }

  @Test
  public void test074() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test074"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(short)0, 33);
    int i24 = calcolatrice0.divide(33, 35);
    // The following exception was thrown during execution in test generation
    try {
    int i27 = calcolatrice0.divide(0, 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test075() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test075"); }


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
    int i36 = calcolatrice0.divide(50, (-1));
    int i39 = calcolatrice0.divide(8, (-33));
    
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
    org.junit.Assert.assertTrue(i36 == (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);

  }

  @Test
  public void test076() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test076"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-3), (-100));
    int i24 = calcolatrice0.divide((int)' ', (-100));
    int i27 = calcolatrice0.divide((-14), (int)'a');
    int i30 = calcolatrice0.divide((int)'a', (-52));
    int i33 = calcolatrice0.divide((-35), (-12));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 2);

  }

  @Test
  public void test077() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test077"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)10);
    int i15 = calcolatrice0.divide((int)(short)-1, 16);
    int i18 = calcolatrice0.divide((-19), 7);
    int i21 = calcolatrice0.divide((int)'#', (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-3));

  }

  @Test
  public void test078() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test078"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide((int)(short)0, (-10));
    int i15 = calcolatrice0.divide((-8), (-11));
    int i18 = calcolatrice0.divide((-2), (int)'#');
    int i21 = calcolatrice0.divide((int)(short)1, 35);
    // The following exception was thrown during execution in test generation
    try {
    int i24 = calcolatrice0.divide((-97), (int)(short)0);
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
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test079() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test079"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((int)(short)-1, (-33));
    int i24 = calcolatrice0.divide((int)(byte)1, 100);
    int i27 = calcolatrice0.divide((-26), (-10));
    int i30 = calcolatrice0.divide(8, (-50));
    int i33 = calcolatrice0.divide((int)(short)0, 4);
    int i36 = calcolatrice0.divide((-14), (-33));
    
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
    org.junit.Assert.assertTrue(i27 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test080() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test080"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide(0, (-50));
    int i24 = calcolatrice0.divide(52, 9);
    int i27 = calcolatrice0.divide((int)(short)0, 25);
    int i30 = calcolatrice0.divide(17, (-11));
    
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
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-1));

  }

  @Test
  public void test081() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test081"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)'4', 3);
    int i21 = calcolatrice0.divide(12, 20);
    int i24 = calcolatrice0.divide(50, 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 10);

  }

  @Test
  public void test082() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test082"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(3, (int)(short)100);
    int i15 = calcolatrice0.divide((-52), (int)(byte)100);
    int i18 = calcolatrice0.divide(32, 16);
    int i21 = calcolatrice0.divide((int)'4', 32);
    int i24 = calcolatrice0.divide((int)(short)-1, 32);
    int i27 = calcolatrice0.divide(52, (int)' ');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 1);

  }

  @Test
  public void test083() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test083"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((-2), (-52));
    int i21 = calcolatrice0.divide((int)'a', 11);
    int i24 = calcolatrice0.divide(100, 11);
    int i27 = calcolatrice0.divide(48, (-25));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-1));

  }

  @Test
  public void test084() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test084"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (-35));
    int i15 = calcolatrice0.divide((int)' ', (-5));
    int i18 = calcolatrice0.divide((int)(byte)0, 17);
    int i21 = calcolatrice0.divide(0, 100);
    int i24 = calcolatrice0.divide((int)(short)1, (-8));
    int i27 = calcolatrice0.divide((-6), 7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-6));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test085() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test085"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide((int)(short)10, (-10));
    int i12 = calcolatrice0.divide((int)'a', (-32));
    int i15 = calcolatrice0.divide(16, (-10));
    int i18 = calcolatrice0.divide(8, (-52));
    int i21 = calcolatrice0.divide((-19), (-8));
    int i24 = calcolatrice0.divide((-19), (-32));
    int i27 = calcolatrice0.divide(2, (-11));
    
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
    org.junit.Assert.assertTrue(i21 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test086() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test086"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide(3, (int)' ');
    int i18 = calcolatrice0.divide((int)(byte)-1, 10);
    int i21 = calcolatrice0.divide(0, (-8));
    int i24 = calcolatrice0.divide(35, 35);
    int i27 = calcolatrice0.divide((int)'4', 17);
    int i30 = calcolatrice0.divide((-17), 17);
    int i33 = calcolatrice0.divide((int)(byte)10, 8);
    
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
    org.junit.Assert.assertTrue(i24 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 1);

  }

  @Test
  public void test087() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test087"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(10, 1);
    int i15 = calcolatrice0.divide(100, (-5));
    int i18 = calcolatrice0.divide((-7), 52);
    int i21 = calcolatrice0.divide((-50), (int)(byte)100);
    int i24 = calcolatrice0.divide(48, 24);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 2);

  }

  @Test
  public void test088() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test088"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-52), 32);
    int i6 = calcolatrice0.divide((-35), (-16));
    int i9 = calcolatrice0.divide((-33), (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 11);

  }

  @Test
  public void test089() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test089"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide((-33), (int)(byte)10);
    int i27 = calcolatrice0.divide((-5), 2);
    int i30 = calcolatrice0.divide(25, 17);
    int i33 = calcolatrice0.divide((-13), 20);
    int i36 = calcolatrice0.divide(14, 52);
    int i39 = calcolatrice0.divide((-12), 17);
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);

  }

  @Test
  public void test090() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test090"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((-1), (int)(short)100);
    int i18 = calcolatrice0.divide(1, (-32));
    int i21 = calcolatrice0.divide((int)' ', (-33));
    int i24 = calcolatrice0.divide((-19), (-5));
    int i27 = calcolatrice0.divide(52, (int)(short)100);
    // The following exception was thrown during execution in test generation
    try {
    int i30 = calcolatrice0.divide((-24), (int)(byte)0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test091() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test091"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)'#', (int)(byte)-1);
    int i12 = calcolatrice0.divide((int)(short)-1, (-100));
    int i15 = calcolatrice0.divide(100, 100);
    int i18 = calcolatrice0.divide((-32), (-97));
    int i21 = calcolatrice0.divide(1, (-9));
    int i24 = calcolatrice0.divide(1, 1);
    
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

  }

  @Test
  public void test092() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test092"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(short)0, (int)(byte)10);
    int i18 = calcolatrice0.divide(20, (int)(byte)1);
    int i21 = calcolatrice0.divide((int)'a', (-13));
    
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
    org.junit.Assert.assertTrue(i18 == 20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-7));

  }

  @Test
  public void test093() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test093"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide(100, (int)(byte)-1);
    int i18 = calcolatrice0.divide(7, (-100));
    int i21 = calcolatrice0.divide((-12), (int)(byte)10);
    int i24 = calcolatrice0.divide((int)'#', (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-11));

  }

  @Test
  public void test094() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test094"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(byte)-1, (-35));
    int i18 = calcolatrice0.divide(0, 9);
    int i21 = calcolatrice0.divide((-26), (-7));
    
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
    org.junit.Assert.assertTrue(i21 == 3);

  }

  @Test
  public void test095() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test095"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((-1), (int)' ');
    int i12 = calcolatrice0.divide(1, (int)(short)10);
    int i15 = calcolatrice0.divide((-9), (-5));
    
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

  }

  @Test
  public void test096() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test096"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(byte)0, (-26));
    int i21 = calcolatrice0.divide((-5), (-6));
    
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
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test097() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test097"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((int)(short)-1, (-33));
    int i24 = calcolatrice0.divide((int)(short)0, (-52));
    int i27 = calcolatrice0.divide(97, 20);
    int i30 = calcolatrice0.divide((-3), (int)(short)100);
    int i33 = calcolatrice0.divide((int)(byte)0, (-11));
    int i36 = calcolatrice0.divide((-4), 26);
    
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
    org.junit.Assert.assertTrue(i27 == 4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test098() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test098"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 52);
    int i12 = calcolatrice0.divide(3, (-50));
    int i15 = calcolatrice0.divide(10, (-1));
    int i18 = calcolatrice0.divide(33, 17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);

  }

  @Test
  public void test099() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test099"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(32, 5);
    int i12 = calcolatrice0.divide((int)(short)100, (int)(short)100);
    int i15 = calcolatrice0.divide((-26), (-32));
    int i18 = calcolatrice0.divide((-52), 32);
    int i21 = calcolatrice0.divide((int)(short)-1, 13);
    int i24 = calcolatrice0.divide(26, (-26));
    int i27 = calcolatrice0.divide((int)(byte)-1, (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test100() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test100"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(50, 6);
    int i12 = calcolatrice0.divide((int)' ', 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);

  }

  @Test
  public void test101() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test101"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide((-100), 10);
    int i24 = calcolatrice0.divide(12, 10);
    int i27 = calcolatrice0.divide((-97), 100);
    int i30 = calcolatrice0.divide(0, (int)(short)10);
    int i33 = calcolatrice0.divide((-1), (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test102() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test102"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide((int)(short)10, (-10));
    int i12 = calcolatrice0.divide((int)(byte)10, (-33));
    int i15 = calcolatrice0.divide(25, (int)(byte)100);
    int i18 = calcolatrice0.divide(1, 7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test103() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test103"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)10, 52);
    int i18 = calcolatrice0.divide(52, (-26));
    int i21 = calcolatrice0.divide(50, 52);
    int i24 = calcolatrice0.divide((-48), 14);
    
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
    org.junit.Assert.assertTrue(i18 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));

  }

  @Test
  public void test104() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test104"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-33), (int)'a');
    int i24 = calcolatrice0.divide(0, 97);
    int i27 = calcolatrice0.divide((-10), (-3));
    int i30 = calcolatrice0.divide(5, (int)'#');
    int i33 = calcolatrice0.divide((-11), 6);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-1));

  }

  @Test
  public void test105() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test105"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    // The following exception was thrown during execution in test generation
    try {
    int i18 = calcolatrice0.divide((-17), (int)(byte)0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);

  }

  @Test
  public void test106() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test106"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(32, 5);
    int i12 = calcolatrice0.divide((int)(short)100, (int)(short)100);
    int i15 = calcolatrice0.divide((-97), (-13));
    int i18 = calcolatrice0.divide((int)(byte)1, (-35));
    int i21 = calcolatrice0.divide((int)(short)-1, 12);
    int i24 = calcolatrice0.divide(13, 11);
    int i27 = calcolatrice0.divide(4, 4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 1);

  }

  @Test
  public void test107() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test107"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)(byte)-1, (-5));
    int i18 = calcolatrice0.divide(33, (-3));
    int i21 = calcolatrice0.divide((-35), (-12));
    int i24 = calcolatrice0.divide((-17), 2);
    int i27 = calcolatrice0.divide(97, 10);
    int i30 = calcolatrice0.divide((-52), (-24));
    
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
    org.junit.Assert.assertTrue(i18 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 2);

  }

  @Test
  public void test108() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test108"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(byte)100, (-2));
    int i24 = calcolatrice0.divide((-3), (-52));
    int i27 = calcolatrice0.divide((-4), 97);
    int i30 = calcolatrice0.divide((-8), 100);
    int i33 = calcolatrice0.divide(52, 17);
    int i36 = calcolatrice0.divide(5, (-12));
    int i39 = calcolatrice0.divide(11, (-19));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);

  }

  @Test
  public void test109() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test109"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(short)0, (int)(byte)10);
    int i18 = calcolatrice0.divide((-16), (-3));
    int i21 = calcolatrice0.divide((-97), 26);
    
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
    org.junit.Assert.assertTrue(i18 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-3));

  }

  @Test
  public void test110() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test110"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide((-52), 7);
    int i21 = calcolatrice0.divide((-32), (-14));
    
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
    org.junit.Assert.assertTrue(i18 == (-7));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 2);

  }

  @Test
  public void test111() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test111"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide((int)(short)100, (-1));
    int i21 = calcolatrice0.divide((-10), (-52));
    int i24 = calcolatrice0.divide(12, 1);
    
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
    org.junit.Assert.assertTrue(i18 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 12);

  }

  @Test
  public void test112() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test112"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide(35, (int)(short)-1);
    int i21 = calcolatrice0.divide((-20), (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 6);

  }

  @Test
  public void test113() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test113"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(short)0, 33);
    int i24 = calcolatrice0.divide(52, 100);
    int i27 = calcolatrice0.divide((-8), 33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test114() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test114"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide((-4), (-16));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test115() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test115"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)'4', (int)'#');
    int i21 = calcolatrice0.divide((-50), (int)(short)-1);
    int i24 = calcolatrice0.divide(6, (int)(byte)10);
    int i27 = calcolatrice0.divide((int)(short)-1, (-32));
    int i30 = calcolatrice0.divide(10, 48);
    int i33 = calcolatrice0.divide((int)'#', (-97));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test116() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test116"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide(1, (int)'#');
    int i24 = calcolatrice0.divide((-2), (int)(byte)1);
    int i27 = calcolatrice0.divide((-7), (-1));
    int i30 = calcolatrice0.divide((-3), (-48));
    
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
    org.junit.Assert.assertTrue(i24 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test117() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test117"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)'#', (int)(byte)-1);
    int i12 = calcolatrice0.divide((int)(short)-1, (-100));
    int i15 = calcolatrice0.divide((-48), (-35));
    
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

  }

  @Test
  public void test118() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test118"); }


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
    int i33 = calcolatrice0.divide(14, 11);
    // The following exception was thrown during execution in test generation
    try {
    int i36 = calcolatrice0.divide((int)(byte)1, 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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
    org.junit.Assert.assertTrue(i33 == 1);

  }

  @Test
  public void test119() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test119"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide(10, 1);
    int i12 = calcolatrice0.divide((-4), (-50));
    int i15 = calcolatrice0.divide(2, (int)(byte)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 2);

  }

  @Test
  public void test120() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test120"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide(0, 52);
    int i12 = calcolatrice0.divide((-7), (-16));
    int i15 = calcolatrice0.divide((-52), (-9));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 5);

  }

  @Test
  public void test121() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test121"); }


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
    int i33 = calcolatrice0.divide((-9), (-16));
    
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

  }

  @Test
  public void test122() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test122"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(byte)100, (-2));
    int i24 = calcolatrice0.divide((int)(byte)0, (-1));
    int i27 = calcolatrice0.divide(14, (-50));
    int i30 = calcolatrice0.divide((int)(byte)0, (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test123() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test123"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide((int)(byte)100, (int)(short)-1);
    int i18 = calcolatrice0.divide((-19), 2);
    int i21 = calcolatrice0.divide((-33), 32);
    int i24 = calcolatrice0.divide((-20), (-97));
    int i27 = calcolatrice0.divide(10, 6);
    int i30 = calcolatrice0.divide(6, (int)(short)10);
    int i33 = calcolatrice0.divide(33, (-8));
    int i36 = calcolatrice0.divide(3, 11);
    
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
    org.junit.Assert.assertTrue(i27 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test124() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test124"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-3), (-100));
    int i24 = calcolatrice0.divide(35, 1);
    int i27 = calcolatrice0.divide(35, (-3));
    int i30 = calcolatrice0.divide(6, 5);
    int i33 = calcolatrice0.divide((-26), 11);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-2));

  }

  @Test
  public void test125() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test125"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide((-100), 10);
    int i24 = calcolatrice0.divide((-16), (-2));
    int i27 = calcolatrice0.divide((-9), (int)(byte)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test126() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test126"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((-1), (int)(short)100);
    int i18 = calcolatrice0.divide(32, (-3));
    int i21 = calcolatrice0.divide((int)' ', 1);
    int i24 = calcolatrice0.divide(0, (-100));
    int i27 = calcolatrice0.divide((-4), (-16));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test127() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test127"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)10);
    int i15 = calcolatrice0.divide((int)(byte)1, (-3));
    int i18 = calcolatrice0.divide(1, (-25));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test128() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test128"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide((int)(short)10, (-10));
    int i12 = calcolatrice0.divide((int)(byte)10, (-33));
    int i15 = calcolatrice0.divide(0, (-50));
    int i18 = calcolatrice0.divide(0, 7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test129() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test129"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide((int)(byte)100, (int)(short)-1);
    int i18 = calcolatrice0.divide((-19), 2);
    int i21 = calcolatrice0.divide((-33), 32);
    int i24 = calcolatrice0.divide(17, (-33));
    int i27 = calcolatrice0.divide((-10), (-97));
    int i30 = calcolatrice0.divide(35, (-35));
    int i33 = calcolatrice0.divide(11, (int)'#');
    
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
    org.junit.Assert.assertTrue(i30 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test130() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test130"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(byte)-1, 10);
    int i18 = calcolatrice0.divide((int)(byte)-1, 100);
    int i21 = calcolatrice0.divide((int)(short)-1, (-52));
    int i24 = calcolatrice0.divide((int)'4', 33);
    
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
    org.junit.Assert.assertTrue(i24 == 1);

  }

  @Test
  public void test131() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test131"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)(byte)-1, (-5));
    int i18 = calcolatrice0.divide(33, (-3));
    int i21 = calcolatrice0.divide((int)(byte)1, (int)(short)1);
    
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
    org.junit.Assert.assertTrue(i18 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);

  }

  @Test
  public void test132() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test132"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)'#', (int)(byte)-1);
    int i12 = calcolatrice0.divide((int)(short)-1, (-100));
    int i15 = calcolatrice0.divide((int)(byte)1, (int)'a');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test133() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test133"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)10, 52);
    int i18 = calcolatrice0.divide(5, (int)'#');
    int i21 = calcolatrice0.divide(52, (-2));
    int i24 = calcolatrice0.divide((-25), (-50));
    int i27 = calcolatrice0.divide((int)'a', (-9));
    int i30 = calcolatrice0.divide((int)(byte)-1, 16);
    
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
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test134() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test134"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((int)'a', (-3));
    int i12 = calcolatrice0.divide(32, (-2));
    int i15 = calcolatrice0.divide(7, (-48));
    int i18 = calcolatrice0.divide((-12), (int)(byte)1);
    int i21 = calcolatrice0.divide((int)'a', (-48));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-32));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-16));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-12));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-2));

  }

  @Test
  public void test135() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test135"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((-1), (int)' ');
    int i12 = calcolatrice0.divide(25, 4);
    int i15 = calcolatrice0.divide((int)(byte)-1, 7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test136() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test136"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(short)0, (int)(byte)10);
    int i18 = calcolatrice0.divide(0, (int)(byte)10);
    int i21 = calcolatrice0.divide(25, (-33));
    int i24 = calcolatrice0.divide((int)'4', 33);
    
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
    org.junit.Assert.assertTrue(i24 == 1);

  }

  @Test
  public void test137() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test137"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-52), 32);
    int i6 = calcolatrice0.divide((-35), (-16));
    int i9 = calcolatrice0.divide(20, (-1));
    int i12 = calcolatrice0.divide(11, (-9));
    int i15 = calcolatrice0.divide(0, 11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test138() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test138"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide((int)(short)-1, (-1));
    int i21 = calcolatrice0.divide(0, 10);
    int i24 = calcolatrice0.divide((int)'#', (-33));
    int i27 = calcolatrice0.divide((int)(byte)0, 17);
    int i30 = calcolatrice0.divide((int)(short)10, 20);
    int i33 = calcolatrice0.divide((int)(byte)0, (-6));
    int i36 = calcolatrice0.divide((-1), (int)' ');
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test139() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test139"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(short)10, 20);
    int i12 = calcolatrice0.divide((-4), (-1));
    int i15 = calcolatrice0.divide(0, 11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test140() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test140"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((-16), (-5));
    int i18 = calcolatrice0.divide((-32), 3);
    int i21 = calcolatrice0.divide((-16), (-10));
    int i24 = calcolatrice0.divide((-13), (-7));
    int i27 = calcolatrice0.divide(35, (int)(byte)100);
    int i30 = calcolatrice0.divide(0, 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test141() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test141"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide(4, (-35));
    int i12 = calcolatrice0.divide((-25), 16);
    int i15 = calcolatrice0.divide((int)(short)1, 10);
    int i18 = calcolatrice0.divide(7, 6);
    int i21 = calcolatrice0.divide((int)(byte)100, 16);
    int i24 = calcolatrice0.divide((-1), 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test142() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test142"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(10, 17);
    int i24 = calcolatrice0.divide((-11), (-10));
    int i27 = calcolatrice0.divide(97, 97);
    int i30 = calcolatrice0.divide((-12), (-48));
    
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
    org.junit.Assert.assertTrue(i24 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test143() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test143"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)(byte)-1, (-5));
    int i18 = calcolatrice0.divide(33, (-3));
    int i21 = calcolatrice0.divide((-6), 11);
    int i24 = calcolatrice0.divide((int)(byte)100, (int)(short)100);
    int i27 = calcolatrice0.divide(50, 10);
    int i30 = calcolatrice0.divide((-33), 4);
    
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
    org.junit.Assert.assertTrue(i18 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-8));

  }

  @Test
  public void test144() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test144"); }


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
    int i30 = calcolatrice0.divide(0, 7);
    int i33 = calcolatrice0.divide((-52), 16);
    
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
    org.junit.Assert.assertTrue(i33 == (-3));

  }

  @Test
  public void test145() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test145"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((-1), (int)(short)100);
    int i18 = calcolatrice0.divide(1, (-32));
    int i21 = calcolatrice0.divide((int)' ', (-33));
    int i24 = calcolatrice0.divide((-33), (int)'#');
    int i27 = calcolatrice0.divide((int)(short)1, (int)' ');
    int i30 = calcolatrice0.divide((-9), (int)' ');
    int i33 = calcolatrice0.divide((-16), 4);
    int i36 = calcolatrice0.divide((int)(short)100, 100);
    int i39 = calcolatrice0.divide((-2), 33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
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
    org.junit.Assert.assertTrue(i33 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);

  }

  @Test
  public void test146() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test146"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((int)'a', (-3));
    int i12 = calcolatrice0.divide(6, (-1));
    int i15 = calcolatrice0.divide((-6), (int)(short)10);
    int i18 = calcolatrice0.divide(25, (-19));
    int i21 = calcolatrice0.divide(11, (-97));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-32));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-6));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test147() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test147"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(byte)100, (int)'#');
    int i9 = calcolatrice0.divide((-33), 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-33));

  }

  @Test
  public void test148() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test148"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(byte)100, (int)'#');
    int i9 = calcolatrice0.divide(0, (-9));
    int i12 = calcolatrice0.divide(48, 35);
    int i15 = calcolatrice0.divide(11, 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test149() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test149"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide(10, (int)(byte)-1);
    // The following exception was thrown during execution in test generation
    try {
    int i18 = calcolatrice0.divide((-2), (int)(byte)0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-10));

  }

  @Test
  public void test150() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test150"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)'4', (int)(byte)1);
    int i15 = calcolatrice0.divide(3, (-1));
    int i18 = calcolatrice0.divide((-35), (-24));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 52);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);

  }

  @Test
  public void test151() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test151"); }


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
    int i30 = calcolatrice0.divide(100, 5);
    int i33 = calcolatrice0.divide((-32), 9);
    int i36 = calcolatrice0.divide(33, (-2));
    
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
    org.junit.Assert.assertTrue(i30 == 20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-16));

  }

  @Test
  public void test152() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test152"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(1, (-10));
    int i24 = calcolatrice0.divide((-33), (-97));
    int i27 = calcolatrice0.divide(0, (-17));
    
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

  }

  @Test
  public void test153() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test153"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide(3, (int)' ');
    int i18 = calcolatrice0.divide((-50), (-11));
    
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
    org.junit.Assert.assertTrue(i18 == 4);

  }

  @Test
  public void test154() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test154"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)-1, (int)' ');
    int i18 = calcolatrice0.divide((int)(byte)1, (-97));
    int i21 = calcolatrice0.divide((-33), 6);
    int i24 = calcolatrice0.divide((-14), (int)'a');
    int i27 = calcolatrice0.divide((int)(short)100, 7);
    int i30 = calcolatrice0.divide((-2), (int)' ');
    int i33 = calcolatrice0.divide(5, 48);
    
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
    org.junit.Assert.assertTrue(i21 == (-5));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test155() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test155"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-33), (int)'a');
    int i24 = calcolatrice0.divide(0, 97);
    int i27 = calcolatrice0.divide((-52), 6);
    int i30 = calcolatrice0.divide(52, 19);
    int i33 = calcolatrice0.divide(52, (-7));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-7));

  }

  @Test
  public void test156() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test156"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((-35), (int)' ');
    int i15 = calcolatrice0.divide(16, (int)(byte)10);
    int i18 = calcolatrice0.divide(10, 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);

  }

  @Test
  public void test157() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test157"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide(100, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)'#', 52);
    int i21 = calcolatrice0.divide(97, 97);
    int i24 = calcolatrice0.divide(5, 33);
    int i27 = calcolatrice0.divide((-32), (-50));
    int i30 = calcolatrice0.divide(25, (-19));
    int i33 = calcolatrice0.divide((-4), (-9));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test158() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test158"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)-1, (int)' ');
    int i18 = calcolatrice0.divide((int)(byte)1, (-97));
    int i21 = calcolatrice0.divide(2, (-2));
    int i24 = calcolatrice0.divide(35, (-17));
    int i27 = calcolatrice0.divide(16, (-2));
    int i30 = calcolatrice0.divide((int)(short)0, 6);
    int i33 = calcolatrice0.divide((int)(byte)100, (-26));
    int i36 = calcolatrice0.divide((-7), (-32));
    
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
    org.junit.Assert.assertTrue(i24 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test159() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test159"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(3, (int)(short)100);
    int i15 = calcolatrice0.divide((-52), (int)(byte)100);
    int i18 = calcolatrice0.divide((-10), (-33));
    int i21 = calcolatrice0.divide((int)(short)1, (-5));
    int i24 = calcolatrice0.divide((-25), (int)(byte)1);
    int i27 = calcolatrice0.divide((-33), 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-25));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test160() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test160"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide((int)(byte)100, (int)(short)-1);
    int i18 = calcolatrice0.divide((-19), 2);
    int i21 = calcolatrice0.divide((-33), 32);
    int i24 = calcolatrice0.divide((-35), (int)(short)1);
    int i27 = calcolatrice0.divide(50, (-52));
    int i30 = calcolatrice0.divide(3, 3);
    int i33 = calcolatrice0.divide((int)(byte)-1, (-11));
    int i36 = calcolatrice0.divide(5, 14);
    int i39 = calcolatrice0.divide(33, 48);
    int i42 = calcolatrice0.divide(50, 48);
    // The following exception was thrown during execution in test generation
    try {
    int i45 = calcolatrice0.divide(10, 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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
    org.junit.Assert.assertTrue(i24 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 1);

  }

  @Test
  public void test161() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test161"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-10), (int)(byte)1);
    int i6 = calcolatrice0.divide((-5), (-35));
    int i9 = calcolatrice0.divide((-9), 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));

  }

  @Test
  public void test162() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test162"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((-1), (int)(short)100);
    int i18 = calcolatrice0.divide(1, (-32));
    int i21 = calcolatrice0.divide((-2), 6);
    int i24 = calcolatrice0.divide((int)(byte)10, (int)'a');
    int i27 = calcolatrice0.divide(100, (-9));
    int i30 = calcolatrice0.divide((-24), (int)(byte)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-24));

  }

  @Test
  public void test163() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test163"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(3, (int)(short)100);
    int i15 = calcolatrice0.divide(0, (int)(short)100);
    int i18 = calcolatrice0.divide((-4), 7);
    int i21 = calcolatrice0.divide((-1), (-5));
    int i24 = calcolatrice0.divide(9, 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 3);

  }

  @Test
  public void test164() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test164"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide(10, (int)(byte)-1);
    int i18 = calcolatrice0.divide(100, (int)(short)-1);
    int i21 = calcolatrice0.divide((-32), (-100));
    int i24 = calcolatrice0.divide(1, (-24));
    int i27 = calcolatrice0.divide((-11), 20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test165() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test165"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide((-32), (int)'a');
    int i12 = calcolatrice0.divide((-10), (-1));
    int i15 = calcolatrice0.divide(7, 12);
    int i18 = calcolatrice0.divide(52, 25);
    int i21 = calcolatrice0.divide(1, (int)'4');
    int i24 = calcolatrice0.divide((-4), (int)(short)-1);
    int i27 = calcolatrice0.divide((-7), (-7));
    int i30 = calcolatrice0.divide((-35), 8);
    int i33 = calcolatrice0.divide((int)' ', (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-4));

  }

  @Test
  public void test166() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test166"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((-16), (-5));
    int i18 = calcolatrice0.divide((-13), (-8));
    int i21 = calcolatrice0.divide(32, 5);
    int i24 = calcolatrice0.divide(1, 12);
    int i27 = calcolatrice0.divide(24, (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test167() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test167"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((int)(short)-1, (-33));
    int i24 = calcolatrice0.divide((-3), (-5));
    int i27 = calcolatrice0.divide((int)(short)10, 10);
    int i30 = calcolatrice0.divide((-32), (-1));
    int i33 = calcolatrice0.divide(24, (-52));
    
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
    org.junit.Assert.assertTrue(i27 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test168() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test168"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)'#', (int)(byte)-1);
    int i12 = calcolatrice0.divide((-97), (-19));
    int i15 = calcolatrice0.divide(2, 25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test169() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test169"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(short)10, (int)'#');
    int i12 = calcolatrice0.divide((int)(byte)-1, 52);
    int i15 = calcolatrice0.divide(2, 100);
    int i18 = calcolatrice0.divide((int)(short)100, (-3));
    int i21 = calcolatrice0.divide(1, (int)(short)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-33));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);

  }

  @Test
  public void test170() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test170"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(short)10, (int)'#');
    int i12 = calcolatrice0.divide(52, (int)(byte)100);
    int i15 = calcolatrice0.divide((-13), (-50));
    int i18 = calcolatrice0.divide(12, (int)(short)1);
    int i21 = calcolatrice0.divide(17, 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);

  }

  @Test
  public void test171() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test171"); }


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
    int i30 = calcolatrice0.divide(52, 8);
    
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
    org.junit.Assert.assertTrue(i30 == 6);

  }

  @Test
  public void test172() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test172"); }


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
    int i36 = calcolatrice0.divide(9, (-26));
    int i39 = calcolatrice0.divide(2, 6);
    
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
    org.junit.Assert.assertTrue(i39 == 0);

  }

  @Test
  public void test173() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test173"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide(0, (int)'a');
    int i12 = calcolatrice0.divide((int)(short)10, (-6));
    int i15 = calcolatrice0.divide((-6), (-24));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test174() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test174"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide(10, (-10));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((int)'a', 2);
    int i21 = calcolatrice0.divide(1, 20);
    int i24 = calcolatrice0.divide((int)(short)1, (int)'#');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 48);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test175() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test175"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide(33, (-26));
    int i27 = calcolatrice0.divide(0, 7);
    int i30 = calcolatrice0.divide((-50), 7);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-7));

  }

  @Test
  public void test176() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test176"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide(100, (int)' ');
    int i15 = calcolatrice0.divide(35, 1);
    int i18 = calcolatrice0.divide(16, 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 3);

  }

  @Test
  public void test177() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test177"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide(100, (int)' ');
    int i15 = calcolatrice0.divide(25, 26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test178() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test178"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(48, (-5));
    int i21 = calcolatrice0.divide(5, (-14));
    // The following exception was thrown during execution in test generation
    try {
    int i24 = calcolatrice0.divide((int)(short)100, 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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
    org.junit.Assert.assertTrue(i18 == (-9));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test179() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test179"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(12, 24);
    int i21 = calcolatrice0.divide(19, 32);
    
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

  }

  @Test
  public void test180() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test180"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide(1, (-35));
    int i9 = calcolatrice0.divide((int)'#', (-100));
    int i12 = calcolatrice0.divide((int)(short)10, (int)(byte)10);
    int i15 = calcolatrice0.divide((int)(short)100, 2);
    int i18 = calcolatrice0.divide((int)(byte)0, 2);
    int i21 = calcolatrice0.divide((-33), (-12));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 2);

  }

  @Test
  public void test181() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test181"); }


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
    int i33 = calcolatrice0.divide((int)(byte)100, (-1));
    // The following exception was thrown during execution in test generation
    try {
    int i36 = calcolatrice0.divide((int)(short)1, 0);
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
    org.junit.Assert.assertTrue(i33 == (-100));

  }

  @Test
  public void test182() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test182"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)'4', (int)'4');
    int i12 = calcolatrice0.divide((int)'a', (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (-1));
    int i18 = calcolatrice0.divide(1, (-14));
    int i21 = calcolatrice0.divide(100, (-100));
    int i24 = calcolatrice0.divide((-4), (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-97));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-97));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 1);

  }

  @Test
  public void test183() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test183"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(byte)-1, 10);
    int i18 = calcolatrice0.divide((int)(byte)-1, 100);
    int i21 = calcolatrice0.divide(2, (int)(short)-1);
    int i24 = calcolatrice0.divide((int)(byte)100, (-26));
    int i27 = calcolatrice0.divide((-14), 7);
    int i30 = calcolatrice0.divide((-25), (int)(short)-1);
    int i33 = calcolatrice0.divide(33, (int)(short)10);
    int i36 = calcolatrice0.divide((-4), (-2));
    int i39 = calcolatrice0.divide((int)' ', (-24));
    
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
    org.junit.Assert.assertTrue(i21 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-1));

  }

  @Test
  public void test184() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test184"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((-50), 33);
    int i24 = calcolatrice0.divide((-33), (int)'4');
    int i27 = calcolatrice0.divide(0, (-26));
    int i30 = calcolatrice0.divide(25, (int)'4');
    // The following exception was thrown during execution in test generation
    try {
    int i33 = calcolatrice0.divide(20, (int)(byte)0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test185() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test185"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(32, 5);
    int i12 = calcolatrice0.divide((-11), (-97));
    int i15 = calcolatrice0.divide(17, 16);
    int i18 = calcolatrice0.divide((-2), 25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test186() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test186"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide(0, 52);
    int i12 = calcolatrice0.divide((-7), (-16));
    int i15 = calcolatrice0.divide(3, (-20));
    int i18 = calcolatrice0.divide((-4), 20);
    int i21 = calcolatrice0.divide(11, 35);
    
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

  }

  @Test
  public void test187() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test187"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide(16, (-35));
    int i27 = calcolatrice0.divide(0, 6);
    int i30 = calcolatrice0.divide((-3), (int)(short)-1);
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 3);

  }

  @Test
  public void test188() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test188"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide(0, (int)'#');
    int i9 = calcolatrice0.divide(4, (int)' ');
    int i12 = calcolatrice0.divide((-35), (int)(short)-1);
    int i15 = calcolatrice0.divide(20, 100);
    int i18 = calcolatrice0.divide((-2), (-50));
    int i21 = calcolatrice0.divide(3, 17);
    int i24 = calcolatrice0.divide((-14), (int)(byte)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));

  }

  @Test
  public void test189() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test189"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide(100, (int)(byte)-1);
    int i18 = calcolatrice0.divide((-50), (-3));
    int i21 = calcolatrice0.divide(3, (-17));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test190() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test190"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(byte)0, (-26));
    int i21 = calcolatrice0.divide(97, (-20));
    int i24 = calcolatrice0.divide((-6), 5);
    int i27 = calcolatrice0.divide(14, 50);
    int i30 = calcolatrice0.divide(26, 11);
    
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
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 2);

  }

  @Test
  public void test191() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test191"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide(0, (-50));
    int i24 = calcolatrice0.divide(52, 9);
    int i27 = calcolatrice0.divide((int)(short)100, 2);
    int i30 = calcolatrice0.divide(0, 32);
    int i33 = calcolatrice0.divide((-13), 1);
    int i36 = calcolatrice0.divide((-13), (-32));
    int i39 = calcolatrice0.divide((-5), 13);
    int i42 = calcolatrice0.divide(12, 4);
    
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
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-13));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 3);

  }

  @Test
  public void test192() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test192"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-35), 6);
    int i21 = calcolatrice0.divide(6, (int)'#');
    int i24 = calcolatrice0.divide((-14), (-4));
    int i27 = calcolatrice0.divide(4, (-20));
    
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
    org.junit.Assert.assertTrue(i24 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test193() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test193"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide(0, (int)'a');
    int i18 = calcolatrice0.divide((-2), (-3));
    int i21 = calcolatrice0.divide(32, (int)'#');
    int i24 = calcolatrice0.divide((int)'a', 100);
    int i27 = calcolatrice0.divide(35, (-6));
    int i30 = calcolatrice0.divide(0, (-13));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-5));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test194() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test194"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)'#', (int)(byte)-1);
    int i12 = calcolatrice0.divide((int)(short)-1, (-100));
    int i15 = calcolatrice0.divide(100, 100);
    int i18 = calcolatrice0.divide(0, (-3));
    int i21 = calcolatrice0.divide(0, (int)'a');
    int i24 = calcolatrice0.divide(11, 10);
    int i27 = calcolatrice0.divide((int)(byte)-1, 97);
    
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
  public void test195() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test195"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(3, (int)(short)100);
    int i15 = calcolatrice0.divide((-52), (int)(byte)100);
    int i18 = calcolatrice0.divide((-10), (-33));
    int i21 = calcolatrice0.divide((-3), (-52));
    int i24 = calcolatrice0.divide(16, (-4));
    int i27 = calcolatrice0.divide((-10), 9);
    int i30 = calcolatrice0.divide(11, (-17));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test196() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test196"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-33), (int)'a');
    int i24 = calcolatrice0.divide(0, 97);
    int i27 = calcolatrice0.divide((-10), (-3));
    int i30 = calcolatrice0.divide(17, (int)(byte)10);
    int i33 = calcolatrice0.divide((-2), (-48));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test197() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test197"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)-1, (int)' ');
    int i18 = calcolatrice0.divide(100, (int)(short)1);
    
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
    org.junit.Assert.assertTrue(i18 == 100);

  }

  @Test
  public void test198() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test198"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide((-2), (-5));
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test199() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test199"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)'4', (int)'#');
    int i21 = calcolatrice0.divide((-26), 2);
    int i24 = calcolatrice0.divide((-35), 2);
    int i27 = calcolatrice0.divide((-5), 6);
    int i30 = calcolatrice0.divide((-24), (int)(byte)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-13));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-17));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-2));

  }

  @Test
  public void test200() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test200"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide(0, 52);
    int i12 = calcolatrice0.divide((-7), (-16));
    int i15 = calcolatrice0.divide(0, (int)(short)10);
    int i18 = calcolatrice0.divide(19, 7);
    
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
    org.junit.Assert.assertTrue(i18 == 2);

  }

  @Test
  public void test201() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test201"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(1, (-10));
    int i24 = calcolatrice0.divide(4, (-9));
    int i27 = calcolatrice0.divide((int)' ', 10);
    int i30 = calcolatrice0.divide((int)(byte)-1, (-97));
    // The following exception was thrown during execution in test generation
    try {
    int i33 = calcolatrice0.divide((-24), (int)(short)0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test202() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test202"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide((int)(short)10, (-10));
    int i12 = calcolatrice0.divide((int)(byte)10, (-33));
    int i15 = calcolatrice0.divide((int)(byte)-1, (-97));
    int i18 = calcolatrice0.divide((int)(short)1, (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test203() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test203"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide((int)(byte)100, (int)(short)-1);
    int i18 = calcolatrice0.divide((-19), 2);
    int i21 = calcolatrice0.divide((-33), 32);
    int i24 = calcolatrice0.divide((-20), (-97));
    int i27 = calcolatrice0.divide(10, 6);
    int i30 = calcolatrice0.divide(6, (int)(short)10);
    int i33 = calcolatrice0.divide((-4), (int)(byte)-1);
    
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
    org.junit.Assert.assertTrue(i27 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 4);

  }

  @Test
  public void test204() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test204"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide((-100), 10);
    int i24 = calcolatrice0.divide(12, 10);
    int i27 = calcolatrice0.divide((-11), (-1));
    int i30 = calcolatrice0.divide((-50), 20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-2));

  }

  @Test
  public void test205() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test205"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)'4', (int)(byte)1);
    int i15 = calcolatrice0.divide(0, (-97));
    int i18 = calcolatrice0.divide((int)'#', (-32));
    int i21 = calcolatrice0.divide((int)(byte)100, 20);
    int i24 = calcolatrice0.divide(33, (-9));
    int i27 = calcolatrice0.divide((int)'a', 9);
    int i30 = calcolatrice0.divide((-100), 35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 52);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-2));

  }

  @Test
  public void test206() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test206"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)-1, (int)' ');
    int i18 = calcolatrice0.divide((int)(byte)1, (-97));
    int i21 = calcolatrice0.divide((-3), 16);
    int i24 = calcolatrice0.divide(25, 97);
    int i27 = calcolatrice0.divide(0, (int)' ');
    
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

  }

  @Test
  public void test207() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test207"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(3, (-7));
    int i12 = calcolatrice0.divide(35, (-5));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-7));

  }

  @Test
  public void test208() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test208"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(4, (-11));
    int i15 = calcolatrice0.divide(6, (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test209() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test209"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)'#', (int)(byte)-1);
    int i12 = calcolatrice0.divide((-97), (-19));
    int i15 = calcolatrice0.divide((-97), (-14));
    int i18 = calcolatrice0.divide(10, 52);
    int i21 = calcolatrice0.divide((int)(byte)10, 25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test210() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test210"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide((int)'#', (int)'a');
    int i27 = calcolatrice0.divide(0, 5);
    int i30 = calcolatrice0.divide((-9), (-25));
    int i33 = calcolatrice0.divide((int)(byte)10, 17);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
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

  }

  @Test
  public void test211() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test211"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide(0, (int)'a');
    int i24 = calcolatrice0.divide(20, 52);
    int i27 = calcolatrice0.divide(7, 100);
    int i30 = calcolatrice0.divide(13, 10);
    int i33 = calcolatrice0.divide(26, (-25));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-1));

  }

  @Test
  public void test212() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test212"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide(0, (-50));
    int i24 = calcolatrice0.divide(52, 9);
    int i27 = calcolatrice0.divide((int)(short)100, 2);
    int i30 = calcolatrice0.divide(0, (-33));
    int i33 = calcolatrice0.divide((int)(short)100, 14);
    int i36 = calcolatrice0.divide((-11), 97);
    int i39 = calcolatrice0.divide((-24), 4);
    int i42 = calcolatrice0.divide((int)(byte)1, 26);
    int i45 = calcolatrice0.divide((-10), (-25));
    
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
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-6));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i45 == 0);

  }

  @Test
  public void test213() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test213"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide(1, (-35));
    int i9 = calcolatrice0.divide(100, (-1));
    int i12 = calcolatrice0.divide(17, 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);

  }

  @Test
  public void test214() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test214"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(byte)100, (-2));
    int i24 = calcolatrice0.divide((-3), (-52));
    int i27 = calcolatrice0.divide((-4), 97);
    int i30 = calcolatrice0.divide((-3), (int)(short)100);
    int i33 = calcolatrice0.divide((-13), (-17));
    int i36 = calcolatrice0.divide(0, 2);
    int i39 = calcolatrice0.divide(6, 10);
    int i42 = calcolatrice0.divide((-24), 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == (-2));

  }

  @Test
  public void test215() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test215"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)1, (-1));
    int i24 = calcolatrice0.divide((int)(short)-1, (-17));
    int i27 = calcolatrice0.divide((-32), (-10));
    int i30 = calcolatrice0.divide((int)'#', (int)(short)1);
    int i33 = calcolatrice0.divide(48, (int)(byte)100);
    int i36 = calcolatrice0.divide((-3), 97);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test216() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test216"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(1, (-10));
    int i24 = calcolatrice0.divide(4, (-9));
    int i27 = calcolatrice0.divide((int)' ', 10);
    int i30 = calcolatrice0.divide((-32), (-13));
    
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
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 2);

  }

  @Test
  public void test217() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test217"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(3, (int)(short)100);
    int i15 = calcolatrice0.divide((-52), (int)(byte)100);
    int i18 = calcolatrice0.divide((-10), (-33));
    int i21 = calcolatrice0.divide((int)(short)1, (-5));
    int i24 = calcolatrice0.divide((int)'#', (int)'4');
    int i27 = calcolatrice0.divide((-2), 1);
    int i30 = calcolatrice0.divide(20, (-19));
    int i33 = calcolatrice0.divide((-10), (-9));
    int i36 = calcolatrice0.divide((int)' ', 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
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
    org.junit.Assert.assertTrue(i27 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 3);

  }

  @Test
  public void test218() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test218"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(byte)100, (-2));
    int i24 = calcolatrice0.divide((int)(byte)0, (-1));
    int i27 = calcolatrice0.divide(14, (-50));
    int i30 = calcolatrice0.divide((int)' ', (-16));
    int i33 = calcolatrice0.divide(97, (int)(byte)100);
    int i36 = calcolatrice0.divide((-6), (int)(byte)10);
    int i39 = calcolatrice0.divide(32, 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 3);

  }

  @Test
  public void test219() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test219"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i12 = calcolatrice0.divide(50, 32);
    int i15 = calcolatrice0.divide(3, (int)(short)10);
    int i18 = calcolatrice0.divide((-50), (int)(short)100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test220() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test220"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-33), (int)'a');
    int i24 = calcolatrice0.divide(0, 97);
    int i27 = calcolatrice0.divide((-10), (-3));
    int i30 = calcolatrice0.divide(17, (int)(byte)10);
    int i33 = calcolatrice0.divide(32, (int)'#');
    int i36 = calcolatrice0.divide(52, (-12));
    int i39 = calcolatrice0.divide(13, (-6));
    int i42 = calcolatrice0.divide((-7), (-7));
    int i45 = calcolatrice0.divide((-12), 35);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i45 == 0);

  }

  @Test
  public void test221() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test221"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide(0, 52);
    int i12 = calcolatrice0.divide((-4), (int)(byte)10);
    int i15 = calcolatrice0.divide((int)(byte)-1, (-1));
    int i18 = calcolatrice0.divide((-8), 16);
    int i21 = calcolatrice0.divide((int)(byte)1, (int)'4');
    
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
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test222() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test222"); }


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
    int i30 = calcolatrice0.divide((-14), (-50));
    int i33 = calcolatrice0.divide(10, 10);
    int i36 = calcolatrice0.divide(100, 20);
    
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
    org.junit.Assert.assertTrue(i33 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 5);

  }

  @Test
  public void test223() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test223"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide(0, (int)'a');
    int i18 = calcolatrice0.divide(1, 1);
    int i21 = calcolatrice0.divide(0, (-5));
    int i24 = calcolatrice0.divide((-8), (-25));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test224() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test224"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(short)0, (-33));
    // The following exception was thrown during execution in test generation
    try {
    int i12 = calcolatrice0.divide((-13), 0);
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
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);

  }

  @Test
  public void test225() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test225"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-33), (int)'a');
    int i24 = calcolatrice0.divide(0, 97);
    int i27 = calcolatrice0.divide((-10), (-3));
    int i30 = calcolatrice0.divide(17, (int)(byte)10);
    int i33 = calcolatrice0.divide(32, (int)'#');
    int i36 = calcolatrice0.divide(52, (-12));
    int i39 = calcolatrice0.divide((-25), (-33));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);

  }

  @Test
  public void test226() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test226"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide((int)(short)0, (-10));
    int i15 = calcolatrice0.divide((-17), 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-2));

  }

  @Test
  public void test227() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test227"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide(3, 32);
    int i18 = calcolatrice0.divide(9, (-16));
    int i21 = calcolatrice0.divide(97, (int)(byte)1);
    int i24 = calcolatrice0.divide((-1), (int)'#');
    // The following exception was thrown during execution in test generation
    try {
    int i27 = calcolatrice0.divide(12, (int)(short)0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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
    org.junit.Assert.assertTrue(i21 == 97);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test228() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test228"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide((int)(short)-1, (-1));
    int i21 = calcolatrice0.divide((-2), (-35));
    int i24 = calcolatrice0.divide(35, (int)(short)-1);
    int i27 = calcolatrice0.divide((-11), (-100));
    int i30 = calcolatrice0.divide((int)(short)1, (-52));
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test229() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test229"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((int)(short)-1, (-33));
    int i24 = calcolatrice0.divide((-14), (int)(short)100);
    
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

  }

  @Test
  public void test230() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test230"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide(100, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)'#', 52);
    int i21 = calcolatrice0.divide((-2), 9);
    // The following exception was thrown during execution in test generation
    try {
    int i24 = calcolatrice0.divide((-50), 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test231() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test231"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide(4, (-50));
    int i24 = calcolatrice0.divide(5, (int)(byte)1);
    int i27 = calcolatrice0.divide((int)(short)100, (-7));
    int i30 = calcolatrice0.divide((-97), (-16));
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-14));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 6);

  }

  @Test
  public void test232() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test232"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((int)(short)100, (int)(short)100);
    int i24 = calcolatrice0.divide((int)'a', (-100));
    int i27 = calcolatrice0.divide(6, (-52));
    int i30 = calcolatrice0.divide(9, (-48));
    
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
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test233() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test233"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide((-8), (int)(byte)100);
    int i27 = calcolatrice0.divide(25, (int)'#');
    int i30 = calcolatrice0.divide(6, (-10));
    // The following exception was thrown during execution in test generation
    try {
    int i33 = calcolatrice0.divide(33, (int)(short)0);
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
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-3));
    
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
  public void test234() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test234"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-10), (int)(byte)1);
    int i6 = calcolatrice0.divide((-5), (-35));
    int i9 = calcolatrice0.divide((int)(short)100, (-5));
    int i12 = calcolatrice0.divide((-4), (int)(byte)100);
    int i15 = calcolatrice0.divide((-8), (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test235() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test235"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-52), 32);
    int i6 = calcolatrice0.divide(11, (-1));
    int i9 = calcolatrice0.divide((-2), 14);
    int i12 = calcolatrice0.divide((int)'#', (int)(byte)1);
    int i15 = calcolatrice0.divide(19, 14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 1);

  }

  @Test
  public void test236() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test236"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(3, (int)(short)100);
    int i15 = calcolatrice0.divide((-52), (int)(byte)100);
    int i18 = calcolatrice0.divide((-10), (-33));
    int i21 = calcolatrice0.divide((int)'a', (-20));
    int i24 = calcolatrice0.divide(10, (-48));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test237() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test237"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide(10, 1);
    int i12 = calcolatrice0.divide((int)(byte)10, (-2));
    int i15 = calcolatrice0.divide((int)' ', 52);
    int i18 = calcolatrice0.divide(50, (-16));
    int i21 = calcolatrice0.divide((int)(byte)1, (int)(byte)10);
    int i24 = calcolatrice0.divide(11, 5);
    int i27 = calcolatrice0.divide((-97), (-7));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-5));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 13);

  }

  @Test
  public void test238() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test238"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide((-33), (int)(byte)10);
    int i27 = calcolatrice0.divide((int)(short)0, (int)(byte)1);
    int i30 = calcolatrice0.divide((int)'#', (int)'a');
    int i33 = calcolatrice0.divide(12, (-19));
    int i36 = calcolatrice0.divide(50, 97);
    int i39 = calcolatrice0.divide((-100), (-9));
    int i42 = calcolatrice0.divide((-48), (-97));
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);

  }

  @Test
  public void test239() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test239"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-3), (-100));
    int i24 = calcolatrice0.divide((int)' ', (-100));
    int i27 = calcolatrice0.divide(14, (int)(byte)1);
    int i30 = calcolatrice0.divide(6, (-13));
    int i33 = calcolatrice0.divide(26, (-35));
    int i36 = calcolatrice0.divide((-2), 14);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test240() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test240"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide(0, (int)'a');
    int i18 = calcolatrice0.divide(1, 1);
    int i21 = calcolatrice0.divide(26, (int)(byte)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-26));

  }

  @Test
  public void test241() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test241"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((-4), (int)(byte)1);
    int i21 = calcolatrice0.divide(5, 2);
    int i24 = calcolatrice0.divide((int)(short)0, 100);
    int i27 = calcolatrice0.divide(14, (-52));
    int i30 = calcolatrice0.divide((-9), (-52));
    int i33 = calcolatrice0.divide(3, (int)(short)-1);
    int i36 = calcolatrice0.divide(97, (-24));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-4));

  }

  @Test
  public void test242() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test242"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide((-33), (int)(byte)10);
    int i27 = calcolatrice0.divide((-5), 2);
    int i30 = calcolatrice0.divide((int)(byte)-1, (-1));
    int i33 = calcolatrice0.divide((-17), (int)(byte)100);
    int i36 = calcolatrice0.divide(32, (-1));
    // The following exception was thrown during execution in test generation
    try {
    int i39 = calcolatrice0.divide(50, (int)(short)0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-32));

  }

  @Test
  public void test243() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test243"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide((-3), (int)'#');
    int i27 = calcolatrice0.divide((-16), (-97));
    int i30 = calcolatrice0.divide((-17), (-48));
    int i33 = calcolatrice0.divide(0, (int)' ');
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
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

  }

  @Test
  public void test244() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test244"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-52), 32);
    int i6 = calcolatrice0.divide((-35), (-16));
    int i9 = calcolatrice0.divide(16, (-5));
    int i12 = calcolatrice0.divide(9, (-10));
    int i15 = calcolatrice0.divide((int)(byte)0, (-19));
    int i18 = calcolatrice0.divide(3, 26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test245() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test245"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)-1, (int)' ');
    int i18 = calcolatrice0.divide((int)(byte)1, (-97));
    int i21 = calcolatrice0.divide(2, (-2));
    int i24 = calcolatrice0.divide(35, (-17));
    int i27 = calcolatrice0.divide(16, (-2));
    int i30 = calcolatrice0.divide((int)(short)0, 6);
    int i33 = calcolatrice0.divide((int)'a', (int)(byte)10);
    int i36 = calcolatrice0.divide((int)(short)100, 97);
    
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
    org.junit.Assert.assertTrue(i24 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 1);

  }

  @Test
  public void test246() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test246"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(byte)0, (-26));
    int i21 = calcolatrice0.divide((-8), (-32));
    int i24 = calcolatrice0.divide(2, 16);
    
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
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test247() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test247"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide(4, (-35));
    int i12 = calcolatrice0.divide(6, (int)'a');
    int i15 = calcolatrice0.divide((-11), (int)(short)1);
    int i18 = calcolatrice0.divide(0, (-4));
    int i21 = calcolatrice0.divide(26, (-25));
    int i24 = calcolatrice0.divide(8, (int)(short)10);
    int i27 = calcolatrice0.divide((-25), 50);
    int i30 = calcolatrice0.divide(19, (int)' ');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test248() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test248"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide((-8), (int)(byte)100);
    int i27 = calcolatrice0.divide((-14), (int)' ');
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test249() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test249"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((-1), (int)(short)100);
    int i18 = calcolatrice0.divide(32, (-3));
    int i21 = calcolatrice0.divide((int)' ', 1);
    int i24 = calcolatrice0.divide((int)'4', 25);
    int i27 = calcolatrice0.divide((-97), 25);
    int i30 = calcolatrice0.divide((int)(byte)10, (int)(byte)1);
    int i33 = calcolatrice0.divide(100, (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-2));

  }

  @Test
  public void test250() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test250"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)' ', (int)(byte)1);
    int i18 = calcolatrice0.divide(5, (int)(byte)100);
    int i21 = calcolatrice0.divide((int)(byte)100, 6);
    int i24 = calcolatrice0.divide(0, (-14));
    int i27 = calcolatrice0.divide(4, (-11));
    int i30 = calcolatrice0.divide((-11), (-11));
    
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
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);

  }

  @Test
  public void test251() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test251"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(byte)-1, (-35));
    int i18 = calcolatrice0.divide((-26), (-16));
    int i21 = calcolatrice0.divide(12, (-12));
    int i24 = calcolatrice0.divide(0, (-9));
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test252() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test252"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide((-33), (int)(byte)10);
    int i27 = calcolatrice0.divide(50, 17);
    int i30 = calcolatrice0.divide(33, (int)'4');
    int i33 = calcolatrice0.divide((-10), 5);
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-2));

  }

  @Test
  public void test253() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test253"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide(52, 10);
    int i12 = calcolatrice0.divide((-19), (-10));
    int i15 = calcolatrice0.divide((-33), (-97));
    int i18 = calcolatrice0.divide((int)(byte)-1, (int)(short)100);
    int i21 = calcolatrice0.divide(52, 25);
    int i24 = calcolatrice0.divide(48, (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-48));

  }

  @Test
  public void test254() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test254"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide(0, 52);
    int i12 = calcolatrice0.divide((-7), (-16));
    int i15 = calcolatrice0.divide(3, (-20));
    int i18 = calcolatrice0.divide((-4), 20);
    int i21 = calcolatrice0.divide((-35), (-20));
    
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
    org.junit.Assert.assertTrue(i21 == 1);

  }

  @Test
  public void test255() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test255"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide((int)'a', 4);
    
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
    org.junit.Assert.assertTrue(i18 == 24);

  }

  @Test
  public void test256() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test256"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(byte)100, (-2));
    int i24 = calcolatrice0.divide((-3), (-52));
    int i27 = calcolatrice0.divide((-4), 97);
    int i30 = calcolatrice0.divide((-8), 100);
    int i33 = calcolatrice0.divide(52, 17);
    int i36 = calcolatrice0.divide((-4), 1);
    int i39 = calcolatrice0.divide((int)(short)10, (int)'a');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);

  }

  @Test
  public void test257() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test257"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(byte)0, (-6));
    int i12 = calcolatrice0.divide(2, (int)(byte)100);
    int i15 = calcolatrice0.divide(12, 33);
    
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

  }

  @Test
  public void test258() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test258"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide(100, (int)(byte)-1);
    int i18 = calcolatrice0.divide((-50), (-3));
    int i21 = calcolatrice0.divide((int)'a', (-16));
    int i24 = calcolatrice0.divide((-33), (-97));
    int i27 = calcolatrice0.divide((-13), (-52));
    int i30 = calcolatrice0.divide(0, (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-6));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test259() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test259"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)100, (int)'#');
    int i24 = calcolatrice0.divide(26, (-5));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-5));

  }

  @Test
  public void test260() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test260"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide(0, (int)'a');
    int i12 = calcolatrice0.divide((-97), (int)(short)-1);
    int i15 = calcolatrice0.divide(50, (-14));
    int i18 = calcolatrice0.divide(13, (-97));
    int i21 = calcolatrice0.divide(1, (int)'#');
    // The following exception was thrown during execution in test generation
    try {
    int i24 = calcolatrice0.divide(17, (int)(short)0);
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
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 97);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test261() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test261"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide((-33), (int)(byte)10);
    int i27 = calcolatrice0.divide((-5), 2);
    int i30 = calcolatrice0.divide((int)(byte)-1, (-1));
    int i33 = calcolatrice0.divide((int)(byte)0, (-13));
    int i36 = calcolatrice0.divide(16, (-4));
    int i39 = calcolatrice0.divide(16, (-97));
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);

  }

  @Test
  public void test262() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test262"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide(0, (int)'#');
    int i9 = calcolatrice0.divide((-7), 25);
    int i12 = calcolatrice0.divide((int)'4', (-3));
    int i15 = calcolatrice0.divide(0, (int)' ');
    int i18 = calcolatrice0.divide(97, (-26));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-17));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-3));

  }

  @Test
  public void test263() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test263"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide((-33), (-11));
    int i12 = calcolatrice0.divide((-48), (-13));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 3);

  }

  @Test
  public void test264() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test264"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(short)0, (int)(byte)10);
    int i18 = calcolatrice0.divide(0, (int)(byte)10);
    int i21 = calcolatrice0.divide((int)(byte)-1, (-97));
    int i24 = calcolatrice0.divide((-50), (-11));
    int i27 = calcolatrice0.divide(32, (int)(short)-1);
    int i30 = calcolatrice0.divide((-24), (-25));
    
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
    org.junit.Assert.assertTrue(i24 == 4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-32));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test265() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test265"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)-1, (int)' ');
    int i18 = calcolatrice0.divide((int)(byte)1, (-97));
    int i21 = calcolatrice0.divide(2, (-2));
    int i24 = calcolatrice0.divide(33, (-97));
    int i27 = calcolatrice0.divide(6, 5);
    int i30 = calcolatrice0.divide((int)(byte)0, (-10));
    
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
    org.junit.Assert.assertTrue(i27 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test266() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test266"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide(100, 5);
    int i24 = calcolatrice0.divide(10, (int)(short)10);
    int i27 = calcolatrice0.divide(3, 6);
    int i30 = calcolatrice0.divide(0, 100);
    int i33 = calcolatrice0.divide((int)(byte)0, (-13));
    int i36 = calcolatrice0.divide((-26), (-9));
    
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
    org.junit.Assert.assertTrue(i21 == 20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 2);

  }

  @Test
  public void test267() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test267"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((-33), (int)(byte)-1);
    int i18 = calcolatrice0.divide((-14), 16);
    int i21 = calcolatrice0.divide((-5), (-3));
    int i24 = calcolatrice0.divide(0, (-11));
    int i27 = calcolatrice0.divide(17, 1);
    int i30 = calcolatrice0.divide((-8), (-25));
    int i33 = calcolatrice0.divide((int)(short)10, (-26));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test268() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test268"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide((int)(short)10, (-10));
    int i12 = calcolatrice0.divide(52, (int)' ');
    int i15 = calcolatrice0.divide((-32), (int)'#');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test269() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test269"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(short)0, (int)(byte)10);
    int i18 = calcolatrice0.divide((int)(byte)1, (-3));
    int i21 = calcolatrice0.divide((int)(short)1, (int)(byte)10);
    int i24 = calcolatrice0.divide((-33), (-35));
    int i27 = calcolatrice0.divide((-3), 1);
    int i30 = calcolatrice0.divide(0, (int)'4');
    int i33 = calcolatrice0.divide((-4), 33);
    int i36 = calcolatrice0.divide((int)'a', (-10));
    
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
    org.junit.Assert.assertTrue(i27 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-9));

  }

  @Test
  public void test270() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test270"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(32, 5);
    int i12 = calcolatrice0.divide((-3), (int)(short)100);
    int i15 = calcolatrice0.divide(0, (int)(short)-1);
    int i18 = calcolatrice0.divide((-3), 14);
    int i21 = calcolatrice0.divide((-6), 48);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test271() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test271"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(3, (int)(short)100);
    int i15 = calcolatrice0.divide((-48), (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 4);

  }

  @Test
  public void test272() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test272"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((-26), (int)'a');
    int i21 = calcolatrice0.divide((-8), (-33));
    int i24 = calcolatrice0.divide((-25), 5);
    
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
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-5));

  }

  @Test
  public void test273() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test273"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    // The following exception was thrown during execution in test generation
    try {
    int i18 = calcolatrice0.divide(6, 0);
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
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));

  }

  @Test
  public void test274() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test274"); }


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
    int i33 = calcolatrice0.divide(9, (-20));
    
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
  public void test275() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test275"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(32, 5);
    int i12 = calcolatrice0.divide(0, 32);
    int i15 = calcolatrice0.divide(50, (-16));
    int i18 = calcolatrice0.divide(52, (-35));
    int i21 = calcolatrice0.divide(9, 14);
    int i24 = calcolatrice0.divide(16, (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-5));

  }

  @Test
  public void test276() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test276"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide(100, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)'#', 52);
    int i21 = calcolatrice0.divide((int)(short)100, (-14));
    int i24 = calcolatrice0.divide((-26), (-9));
    int i27 = calcolatrice0.divide(7, (-9));
    int i30 = calcolatrice0.divide(0, (int)'a');
    int i33 = calcolatrice0.divide(11, (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-7));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-3));

  }

  @Test
  public void test277() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test277"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(short)0, (int)(byte)10);
    int i18 = calcolatrice0.divide((int)(byte)1, (-3));
    int i21 = calcolatrice0.divide((int)(short)1, (int)(byte)10);
    int i24 = calcolatrice0.divide((-33), (-35));
    int i27 = calcolatrice0.divide((-3), 1);
    int i30 = calcolatrice0.divide(0, (int)'4');
    int i33 = calcolatrice0.divide((-4), 33);
    int i36 = calcolatrice0.divide(33, 35);
    
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
    org.junit.Assert.assertTrue(i27 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test278() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test278"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide((-32), (int)'a');
    int i12 = calcolatrice0.divide((int)(short)100, 100);
    int i15 = calcolatrice0.divide(16, 16);
    int i18 = calcolatrice0.divide((-48), (-19));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 2);

  }

  @Test
  public void test279() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test279"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((-33), (-10));
    int i18 = calcolatrice0.divide(1, (int)(byte)10);
    int i21 = calcolatrice0.divide(100, (-4));
    int i24 = calcolatrice0.divide((int)(byte)1, 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-25));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test280() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test280"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide(97, (int)(short)1);
    int i12 = calcolatrice0.divide((-4), 33);
    int i15 = calcolatrice0.divide(14, (-17));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 97);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test281() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test281"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)' ', (int)(byte)1);
    int i18 = calcolatrice0.divide(6, (int)(byte)1);
    int i21 = calcolatrice0.divide((-9), (-32));
    int i24 = calcolatrice0.divide(50, 97);
    int i27 = calcolatrice0.divide(2, (-35));
    
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
    org.junit.Assert.assertTrue(i18 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test282() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test282"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((int)(short)-1, (-33));
    int i24 = calcolatrice0.divide((-3), (-5));
    int i27 = calcolatrice0.divide((int)(short)10, 10);
    int i30 = calcolatrice0.divide((-32), (-1));
    int i33 = calcolatrice0.divide((int)(byte)100, 3);
    int i36 = calcolatrice0.divide((-33), 52);
    
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
    org.junit.Assert.assertTrue(i27 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test283() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test283"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(short)10, (int)'#');
    int i12 = calcolatrice0.divide((int)(short)100, 52);
    int i15 = calcolatrice0.divide(17, 20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test284() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test284"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(byte)100, (-2));
    int i24 = calcolatrice0.divide(3, 48);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test285() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test285"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(10, 1);
    int i15 = calcolatrice0.divide(100, (-5));
    int i18 = calcolatrice0.divide((int)(byte)-1, (-100));
    int i21 = calcolatrice0.divide((-50), (-50));
    int i24 = calcolatrice0.divide(48, (-100));
    int i27 = calcolatrice0.divide(12, (-26));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test286() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test286"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide(0, (-50));
    int i24 = calcolatrice0.divide(52, 9);
    int i27 = calcolatrice0.divide((int)(short)100, 2);
    int i30 = calcolatrice0.divide(0, (-33));
    int i33 = calcolatrice0.divide(50, (-8));
    int i36 = calcolatrice0.divide(4, 9);
    int i39 = calcolatrice0.divide((-16), (-1));
    
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
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-6));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 16);

  }

  @Test
  public void test287() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test287"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((-1), (int)' ');
    int i12 = calcolatrice0.divide(0, (int)(byte)1);
    int i15 = calcolatrice0.divide((int)(byte)-1, (-8));
    int i18 = calcolatrice0.divide(0, 100);
    int i21 = calcolatrice0.divide((-5), (int)(short)100);
    
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

  }

  @Test
  public void test288() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test288"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide((-32), (int)'a');
    int i12 = calcolatrice0.divide((-10), (-1));
    int i15 = calcolatrice0.divide(7, 12);
    int i18 = calcolatrice0.divide(52, 25);
    int i21 = calcolatrice0.divide(1, (int)'4');
    int i24 = calcolatrice0.divide((-20), (-6));
    int i27 = calcolatrice0.divide((-50), (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 2);

  }

  @Test
  public void test289() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test289"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide((-33), (int)(byte)10);
    int i27 = calcolatrice0.divide((-5), 2);
    int i30 = calcolatrice0.divide(97, 32);
    int i33 = calcolatrice0.divide((int)'4', 52);
    int i36 = calcolatrice0.divide((int)'#', (int)(short)100);
    int i39 = calcolatrice0.divide((int)(short)10, (int)(byte)-1);
    int i42 = calcolatrice0.divide((-9), (int)'#');
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);

  }

  @Test
  public void test290() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test290"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)(byte)-1, (-5));
    int i18 = calcolatrice0.divide((-35), (int)'4');
    int i21 = calcolatrice0.divide(14, (int)(byte)-1);
    int i24 = calcolatrice0.divide((-3), 10);
    
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
    org.junit.Assert.assertTrue(i21 == (-14));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test291() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test291"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide(0, (int)'a');
    int i18 = calcolatrice0.divide((-2), (-3));
    int i21 = calcolatrice0.divide(5, (int)(byte)100);
    int i24 = calcolatrice0.divide(5, (-8));
    int i27 = calcolatrice0.divide((-50), 100);
    int i30 = calcolatrice0.divide((-9), 52);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-3));
    
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

  }

  @Test
  public void test292() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test292"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide(100, 5);
    int i24 = calcolatrice0.divide(20, 2);
    int i27 = calcolatrice0.divide(11, 97);
    int i30 = calcolatrice0.divide(97, 33);
    
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
    org.junit.Assert.assertTrue(i21 == 20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 2);

  }

  @Test
  public void test293() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test293"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide((-32), (int)'a');
    int i12 = calcolatrice0.divide((int)(short)100, 100);
    int i15 = calcolatrice0.divide(9, 4);
    int i18 = calcolatrice0.divide((int)'#', (int)' ');
    int i21 = calcolatrice0.divide(97, 17);
    int i24 = calcolatrice0.divide((-10), (int)(short)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-10));

  }

  @Test
  public void test294() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test294"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(byte)-1, 10);
    int i18 = calcolatrice0.divide((-26), 35);
    int i21 = calcolatrice0.divide(0, (-20));
    int i24 = calcolatrice0.divide(52, (-32));
    
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
    org.junit.Assert.assertTrue(i24 == (-1));

  }

  @Test
  public void test295() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test295"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide(0, (int)'#');
    int i9 = calcolatrice0.divide(4, (int)' ');
    int i12 = calcolatrice0.divide((-35), (int)(short)-1);
    int i15 = calcolatrice0.divide(20, 100);
    int i18 = calcolatrice0.divide((-2), (-50));
    int i21 = calcolatrice0.divide(3, 17);
    int i24 = calcolatrice0.divide((-14), (-13));
    int i27 = calcolatrice0.divide((-13), (-52));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
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
  public void test296() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test296"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((int)'a', (-3));
    int i12 = calcolatrice0.divide(32, (-2));
    int i15 = calcolatrice0.divide(7, (-48));
    int i18 = calcolatrice0.divide((-12), (int)(byte)1);
    int i21 = calcolatrice0.divide(13, 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-32));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-16));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-12));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);

  }

  @Test
  public void test297() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test297"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(1, (-10));
    int i24 = calcolatrice0.divide((-33), (-97));
    int i27 = calcolatrice0.divide((-52), (-13));
    int i30 = calcolatrice0.divide(20, (-9));
    int i33 = calcolatrice0.divide((-11), 2);
    int i36 = calcolatrice0.divide((-3), 25);
    
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
    org.junit.Assert.assertTrue(i30 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-5));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test298() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test298"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide((int)(short)10, (-10));
    int i12 = calcolatrice0.divide((int)(byte)10, (-33));
    int i15 = calcolatrice0.divide((int)(short)1, (int)(byte)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));

  }

  @Test
  public void test299() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test299"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(32, 5);
    int i12 = calcolatrice0.divide((int)(short)100, (int)(short)100);
    int i15 = calcolatrice0.divide((-26), (-32));
    int i18 = calcolatrice0.divide((-33), 97);
    int i21 = calcolatrice0.divide((-14), (int)' ');
    int i24 = calcolatrice0.divide(6, (int)(byte)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-6));

  }

  @Test
  public void test300() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test300"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(10, 1);
    int i15 = calcolatrice0.divide(100, (-5));
    int i18 = calcolatrice0.divide(0, 50);
    int i21 = calcolatrice0.divide(8, 13);
    int i24 = calcolatrice0.divide(0, 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test301() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test301"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide(0, (int)'a');
    int i12 = calcolatrice0.divide((int)(short)10, (-6));
    int i15 = calcolatrice0.divide(32, 25);
    int i18 = calcolatrice0.divide(8, (-24));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test302() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test302"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide(1, (-35));
    int i9 = calcolatrice0.divide((int)'#', (-100));
    int i12 = calcolatrice0.divide(33, (int)(short)1);
    int i15 = calcolatrice0.divide((int)'#', 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 2);

  }

  @Test
  public void test303() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test303"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)'4', (int)(byte)1);
    int i15 = calcolatrice0.divide(0, (-97));
    int i18 = calcolatrice0.divide((int)'a', 8);
    int i21 = calcolatrice0.divide((int)(byte)10, (-9));
    int i24 = calcolatrice0.divide((int)'#', 10);
    int i27 = calcolatrice0.divide(48, (-33));
    int i30 = calcolatrice0.divide(24, (-19));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 52);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-1));

  }

  @Test
  public void test304() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test304"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((int)(short)-1, (-33));
    int i24 = calcolatrice0.divide((int)(byte)1, 100);
    int i27 = calcolatrice0.divide((-13), 100);
    int i30 = calcolatrice0.divide(97, 11);
    int i33 = calcolatrice0.divide(12, 4);
    int i36 = calcolatrice0.divide((int)'#', (int)(short)100);
    int i39 = calcolatrice0.divide((int)(short)100, (int)(byte)100);
    int i42 = calcolatrice0.divide((-5), 100);
    
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
    org.junit.Assert.assertTrue(i30 == 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);

  }

  @Test
  public void test305() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test305"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(10, 17);
    int i24 = calcolatrice0.divide(0, (int)'a');
    int i27 = calcolatrice0.divide((int)(byte)10, (-12));
    int i30 = calcolatrice0.divide(11, (-20));
    
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
  public void test306() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test306"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide(0, (int)'#');
    int i9 = calcolatrice0.divide((-7), 25);
    int i12 = calcolatrice0.divide((int)(byte)10, (int)(short)100);
    int i15 = calcolatrice0.divide(10, (int)' ');
    int i18 = calcolatrice0.divide((-100), (int)'a');
    int i21 = calcolatrice0.divide(11, 13);
    int i24 = calcolatrice0.divide((-10), (int)' ');
    int i27 = calcolatrice0.divide(0, (int)(short)-1);
    
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
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test307() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test307"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(32, 5);
    int i12 = calcolatrice0.divide(0, 32);
    int i15 = calcolatrice0.divide(50, (-16));
    int i18 = calcolatrice0.divide(52, (-35));
    int i21 = calcolatrice0.divide((-35), (int)'#');
    int i24 = calcolatrice0.divide(24, 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 2);

  }

  @Test
  public void test308() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test308"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(byte)-1, 10);
    int i18 = calcolatrice0.divide((int)'a', (-20));
    int i21 = calcolatrice0.divide(19, 32);
    int i24 = calcolatrice0.divide((-25), 12);
    
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
    org.junit.Assert.assertTrue(i18 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-2));

  }

  @Test
  public void test309() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test309"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide((-3), (int)'#');
    int i27 = calcolatrice0.divide((-33), (int)(byte)-1);
    int i30 = calcolatrice0.divide((-13), (int)(byte)1);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-13));

  }

  @Test
  public void test310() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test310"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(short)10, (int)'#');
    int i12 = calcolatrice0.divide(52, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(byte)1, 25);
    int i18 = calcolatrice0.divide((-24), 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-8));

  }

  @Test
  public void test311() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test311"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide(0, (-2));
    int i12 = calcolatrice0.divide((-7), 33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);

  }

  @Test
  public void test312() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test312"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((int)(short)-1, (-33));
    int i24 = calcolatrice0.divide((-3), (-5));
    int i27 = calcolatrice0.divide(3, 25);
    int i30 = calcolatrice0.divide((-35), 5);
    int i33 = calcolatrice0.divide((-25), (-32));
    int i36 = calcolatrice0.divide(0, 2);
    
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
    org.junit.Assert.assertTrue(i30 == (-7));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test313() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test313"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide((-33), (int)(byte)10);
    int i27 = calcolatrice0.divide((-5), 2);
    int i30 = calcolatrice0.divide((int)(byte)-1, (-1));
    int i33 = calcolatrice0.divide((-32), 1);
    int i36 = calcolatrice0.divide(14, (int)(short)-1);
    int i39 = calcolatrice0.divide(0, (int)(short)-1);
    int i42 = calcolatrice0.divide((int)(short)-1, (int)(short)10);
    int i45 = calcolatrice0.divide(5, (-35));
    int i48 = calcolatrice0.divide((-14), (int)(byte)100);
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-32));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-14));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i45 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i48 == 0);

  }

  @Test
  public void test314() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test314"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(10, 1);
    int i15 = calcolatrice0.divide(100, (-5));
    int i18 = calcolatrice0.divide((int)(byte)-1, (-100));
    int i21 = calcolatrice0.divide((-32), (int)(byte)-1);
    int i24 = calcolatrice0.divide((int)(byte)100, 1);
    int i27 = calcolatrice0.divide((-12), (-13));
    int i30 = calcolatrice0.divide(100, 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 50);

  }

  @Test
  public void test315() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test315"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((int)'a', (-3));
    int i12 = calcolatrice0.divide(6, (-1));
    int i15 = calcolatrice0.divide(4, (-4));
    int i18 = calcolatrice0.divide(0, (-6));
    int i21 = calcolatrice0.divide((-50), 4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-32));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-6));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-12));

  }

  @Test
  public void test316() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test316"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide((-19), 100);
    int i21 = calcolatrice0.divide(19, (-19));
    
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

  }

  @Test
  public void test317() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test317"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-97), 1);
    int i6 = calcolatrice0.divide((int)(byte)-1, (-20));
    int i9 = calcolatrice0.divide(20, 11);
    // The following exception was thrown during execution in test generation
    try {
    int i12 = calcolatrice0.divide((-2), 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-97));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 1);

  }

  @Test
  public void test318() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test318"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide((int)(short)-1, (-1));
    int i21 = calcolatrice0.divide(0, 10);
    int i24 = calcolatrice0.divide((int)(short)1, (-11));
    int i27 = calcolatrice0.divide((-7), (-12));
    int i30 = calcolatrice0.divide((-3), (-19));
    // The following exception was thrown during execution in test generation
    try {
    int i33 = calcolatrice0.divide((-17), 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
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
  public void test319() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test319"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-52), 32);
    int i6 = calcolatrice0.divide(14, 52);
    int i9 = calcolatrice0.divide((-12), 50);
    int i12 = calcolatrice0.divide(16, (-3));
    int i15 = calcolatrice0.divide(9, (int)(byte)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-5));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 9);

  }

  @Test
  public void test320() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test320"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(1, (-10));
    int i24 = calcolatrice0.divide((-33), (-97));
    int i27 = calcolatrice0.divide((-52), (-13));
    int i30 = calcolatrice0.divide((-12), (-52));
    int i33 = calcolatrice0.divide(48, (int)' ');
    int i36 = calcolatrice0.divide((-20), (-32));
    int i39 = calcolatrice0.divide(26, 5);
    
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
    org.junit.Assert.assertTrue(i33 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 5);

  }

  @Test
  public void test321() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test321"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide(0, (int)'a');
    int i18 = calcolatrice0.divide((-2), (-3));
    int i21 = calcolatrice0.divide(5, (int)(byte)100);
    int i24 = calcolatrice0.divide(5, (-8));
    int i27 = calcolatrice0.divide((-50), 100);
    int i30 = calcolatrice0.divide((-19), (int)(short)10);
    int i33 = calcolatrice0.divide((-20), 100);
    int i36 = calcolatrice0.divide((-33), (int)(byte)10);
    int i39 = calcolatrice0.divide((-25), (int)(short)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-3));
    
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
    org.junit.Assert.assertTrue(i30 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 25);

  }

  @Test
  public void test322() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test322"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide(3, 32);
    int i18 = calcolatrice0.divide(9, (-16));
    int i21 = calcolatrice0.divide((int)(short)-1, (-48));
    int i24 = calcolatrice0.divide((-1), 17);
    
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

  }

  @Test
  public void test323() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test323"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((-50), 33);
    int i24 = calcolatrice0.divide((-33), (int)'4');
    int i27 = calcolatrice0.divide(5, (int)(short)10);
    int i30 = calcolatrice0.divide(19, (-2));
    int i33 = calcolatrice0.divide(17, (-97));
    
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
    org.junit.Assert.assertTrue(i30 == (-9));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test324() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test324"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(32, 5);
    int i12 = calcolatrice0.divide(3, (-20));
    int i15 = calcolatrice0.divide(20, (int)(byte)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 20);

  }

  @Test
  public void test325() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test325"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide(1, 10);
    int i18 = calcolatrice0.divide((-5), (int)' ');
    int i21 = calcolatrice0.divide(0, (int)(short)1);
    int i24 = calcolatrice0.divide(5, (int)(short)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 5);

  }

  @Test
  public void test326() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test326"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(byte)100, (-2));
    int i24 = calcolatrice0.divide((int)(byte)0, (-1));
    int i27 = calcolatrice0.divide(14, (-50));
    int i30 = calcolatrice0.divide((int)' ', (-16));
    int i33 = calcolatrice0.divide(50, (-50));
    int i36 = calcolatrice0.divide((int)(short)10, 12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test327() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test327"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-52), 32);
    int i6 = calcolatrice0.divide(11, (-1));
    int i9 = calcolatrice0.divide((-52), (int)(byte)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 52);

  }

  @Test
  public void test328() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test328"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((int)'a', (-3));
    int i12 = calcolatrice0.divide(6, (-1));
    int i15 = calcolatrice0.divide((-6), (int)(short)10);
    int i18 = calcolatrice0.divide((-26), 8);
    int i21 = calcolatrice0.divide(33, (int)' ');
    int i24 = calcolatrice0.divide((-52), (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-32));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-6));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 17);

  }

  @Test
  public void test329() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test329"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((int)(short)-1, (-33));
    int i24 = calcolatrice0.divide((-3), (-5));
    int i27 = calcolatrice0.divide(3, 25);
    int i30 = calcolatrice0.divide((int)(byte)100, (-9));
    int i33 = calcolatrice0.divide(50, 12);
    int i36 = calcolatrice0.divide((int)(byte)100, 20);
    int i39 = calcolatrice0.divide((-8), (int)(byte)100);
    int i42 = calcolatrice0.divide(6, (-50));
    
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
    org.junit.Assert.assertTrue(i30 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);

  }

  @Test
  public void test330() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test330"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(byte)-1, 10);
    int i18 = calcolatrice0.divide((int)(byte)-1, 100);
    int i21 = calcolatrice0.divide((int)'4', (-13));
    int i24 = calcolatrice0.divide((-16), 26);
    int i27 = calcolatrice0.divide(35, (-19));
    int i30 = calcolatrice0.divide((-6), (-2));
    
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
    org.junit.Assert.assertTrue(i21 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 3);

  }

  @Test
  public void test331() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test331"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide(100, (-3));
    int i21 = calcolatrice0.divide(1, 12);
    int i24 = calcolatrice0.divide(10, 10);
    int i27 = calcolatrice0.divide(32, (-26));
    
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
    org.junit.Assert.assertTrue(i18 == (-33));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-1));

  }

  @Test
  public void test332() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test332"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide(0, 11);
    int i21 = calcolatrice0.divide((int)(short)0, (-17));
    
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
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test333() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test333"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide((-26), 50);
    int i24 = calcolatrice0.divide((-1), (-32));
    int i27 = calcolatrice0.divide((-19), (-5));
    int i30 = calcolatrice0.divide((-5), (int)' ');
    
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
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test334() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test334"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((-5), 4);
    int i21 = calcolatrice0.divide(20, (-14));
    int i24 = calcolatrice0.divide((-32), 10);
    int i27 = calcolatrice0.divide(19, (int)(short)-1);
    
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
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-19));

  }

  @Test
  public void test335() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test335"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide((int)(byte)1, (-3));
    int i24 = calcolatrice0.divide(25, 1);
    int i27 = calcolatrice0.divide((int)(short)1, 48);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test336() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test336"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-3), (-100));
    int i24 = calcolatrice0.divide(35, 1);
    int i27 = calcolatrice0.divide(35, (-3));
    int i30 = calcolatrice0.divide(6, 5);
    int i33 = calcolatrice0.divide(26, 3);
    int i36 = calcolatrice0.divide((int)(byte)-1, 32);
    int i39 = calcolatrice0.divide(14, (-97));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);

  }

  @Test
  public void test337() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test337"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(1, (-10));
    int i24 = calcolatrice0.divide((-33), (-97));
    int i27 = calcolatrice0.divide(0, 16);
    int i30 = calcolatrice0.divide(0, 5);
    int i33 = calcolatrice0.divide(50, 10);
    int i36 = calcolatrice0.divide((int)(byte)0, 52);
    
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
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test338() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test338"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(10, 17);
    int i24 = calcolatrice0.divide(0, (int)'a');
    int i27 = calcolatrice0.divide((int)(byte)10, (-12));
    int i30 = calcolatrice0.divide((-6), 1);
    int i33 = calcolatrice0.divide((int)(byte)0, (-10));
    
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
    org.junit.Assert.assertTrue(i30 == (-6));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test339() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test339"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide(0, (int)'a');
    int i12 = calcolatrice0.divide((-32), (-25));
    int i15 = calcolatrice0.divide(11, (-26));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test340() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test340"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((-16), (-5));
    int i18 = calcolatrice0.divide((-32), 3);
    int i21 = calcolatrice0.divide((-16), (-10));
    int i24 = calcolatrice0.divide((-13), (-7));
    int i27 = calcolatrice0.divide((int)'4', 16);
    int i30 = calcolatrice0.divide(13, 13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);

  }

  @Test
  public void test341() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test341"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide(1, (int)'#');
    int i24 = calcolatrice0.divide(0, (-26));
    
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

  }

  @Test
  public void test342() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test342"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide(8, 97);
    int i27 = calcolatrice0.divide((-6), 10);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test343() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test343"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(0, (int)'a');
    int i21 = calcolatrice0.divide(25, 17);
    int i24 = calcolatrice0.divide(8, 14);
    int i27 = calcolatrice0.divide((-52), 52);
    int i30 = calcolatrice0.divide((int)'#', (-32));
    
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
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-1));

  }

  @Test
  public void test344() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test344"); }


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
    int i36 = calcolatrice0.divide(1, (-7));
    int i39 = calcolatrice0.divide((-5), (-5));
    // The following exception was thrown during execution in test generation
    try {
    int i42 = calcolatrice0.divide((-52), 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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
    org.junit.Assert.assertTrue(i39 == 1);

  }

  @Test
  public void test345() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test345"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide(10, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(short)-1, (-52));
    int i21 = calcolatrice0.divide((-1), (-32));
    int i24 = calcolatrice0.divide((int)'a', (int)(short)1);
    int i27 = calcolatrice0.divide((int)'4', (-12));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 97);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-4));

  }

  @Test
  public void test346() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test346"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide((-100), 10);
    int i24 = calcolatrice0.divide((-16), (-2));
    int i27 = calcolatrice0.divide(1, 50);
    int i30 = calcolatrice0.divide((-20), (-12));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);

  }

  @Test
  public void test347() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test347"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide((-3), (int)(short)100);
    int i15 = calcolatrice0.divide((-6), (int)(short)10);
    int i18 = calcolatrice0.divide(97, (-20));
    int i21 = calcolatrice0.divide((int)(byte)1, (int)(short)10);
    int i24 = calcolatrice0.divide((-19), 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-19));

  }

  @Test
  public void test348() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test348"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(byte)100, (-2));
    int i24 = calcolatrice0.divide((int)(byte)0, (-1));
    int i27 = calcolatrice0.divide(14, (-50));
    int i30 = calcolatrice0.divide((int)' ', (-16));
    int i33 = calcolatrice0.divide(97, (int)(byte)100);
    int i36 = calcolatrice0.divide(5, (-5));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-1));

  }

  @Test
  public void test349() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test349"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide(10, (-10));
    int i18 = calcolatrice0.divide(16, 50);
    int i21 = calcolatrice0.divide(9, (-2));
    int i24 = calcolatrice0.divide((int)(byte)100, (-25));
    int i27 = calcolatrice0.divide((int)'4', (int)'4');
    int i30 = calcolatrice0.divide(13, (-5));
    int i33 = calcolatrice0.divide((-13), (-100));
    int i36 = calcolatrice0.divide(33, 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 3);

  }

  @Test
  public void test350() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test350"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)0, (-4));
    int i18 = calcolatrice0.divide((-5), (-8));
    int i21 = calcolatrice0.divide((-26), (-5));
    int i24 = calcolatrice0.divide((-26), (-26));
    
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
    org.junit.Assert.assertTrue(i21 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 1);

  }

  @Test
  public void test351() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test351"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(32, 5);
    int i12 = calcolatrice0.divide(3, (-20));
    int i15 = calcolatrice0.divide((-7), 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test352() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test352"); }


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
    int i33 = calcolatrice0.divide(14, 11);
    int i36 = calcolatrice0.divide(0, (int)(byte)-1);
    int i39 = calcolatrice0.divide(19, (-6));
    
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
    org.junit.Assert.assertTrue(i33 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-3));

  }

  @Test
  public void test353() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test353"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)'4', (int)'#');
    int i21 = calcolatrice0.divide((-50), (int)(short)-1);
    int i24 = calcolatrice0.divide(6, (int)(byte)10);
    int i27 = calcolatrice0.divide((int)(short)-1, (-32));
    int i30 = calcolatrice0.divide(1, 16);
    int i33 = calcolatrice0.divide((-20), 2);
    int i36 = calcolatrice0.divide(13, (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test354() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test354"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide((-19), 100);
    // The following exception was thrown during execution in test generation
    try {
    int i21 = calcolatrice0.divide((int)(short)100, 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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

  }

  @Test
  public void test355() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test355"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(32, 5);
    int i12 = calcolatrice0.divide(0, 32);
    int i15 = calcolatrice0.divide(50, (-16));
    int i18 = calcolatrice0.divide(52, (-35));
    int i21 = calcolatrice0.divide(97, (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-12));

  }

  @Test
  public void test356() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test356"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)'#', (int)(byte)-1);
    int i12 = calcolatrice0.divide((-97), (-19));
    int i15 = calcolatrice0.divide((int)(short)1, (-25));
    int i18 = calcolatrice0.divide((int)(byte)10, (int)(short)100);
    int i21 = calcolatrice0.divide(12, (int)(byte)1);
    int i24 = calcolatrice0.divide((-26), (-13));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 2);

  }

  @Test
  public void test357() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test357"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)'4', (int)(byte)1);
    int i15 = calcolatrice0.divide(0, (-97));
    int i18 = calcolatrice0.divide((int)'a', 8);
    int i21 = calcolatrice0.divide((int)(byte)10, (-9));
    int i24 = calcolatrice0.divide((int)'#', 10);
    int i27 = calcolatrice0.divide(0, 26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 52);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test358() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test358"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide((int)(byte)100, (int)(short)-1);
    int i18 = calcolatrice0.divide((-19), 2);
    int i21 = calcolatrice0.divide((-33), 32);
    int i24 = calcolatrice0.divide((-35), (int)(short)1);
    int i27 = calcolatrice0.divide(50, (-52));
    int i30 = calcolatrice0.divide(3, 3);
    int i33 = calcolatrice0.divide((int)(byte)-1, (int)(byte)1);
    int i36 = calcolatrice0.divide(6, (-20));
    int i39 = calcolatrice0.divide((int)(short)10, (-14));
    
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
    org.junit.Assert.assertTrue(i24 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);

  }

  @Test
  public void test359() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test359"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide(50, (-33));
    int i21 = calcolatrice0.divide(0, 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test360() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test360"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(3, (int)(short)100);
    int i15 = calcolatrice0.divide((-52), (int)(byte)100);
    int i18 = calcolatrice0.divide((-10), (-33));
    int i21 = calcolatrice0.divide((int)(short)1, (-5));
    int i24 = calcolatrice0.divide((int)'#', (int)'4');
    int i27 = calcolatrice0.divide((-2), 1);
    int i30 = calcolatrice0.divide((-6), 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
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
    org.junit.Assert.assertTrue(i27 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test361() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test361"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((-33), (int)(byte)-1);
    int i18 = calcolatrice0.divide((-14), 16);
    int i21 = calcolatrice0.divide((-5), (-3));
    int i24 = calcolatrice0.divide((-97), (-26));
    int i27 = calcolatrice0.divide(0, (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test362() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test362"); }


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
    int i36 = calcolatrice0.divide((-32), (-11));
    int i39 = calcolatrice0.divide((-16), (-25));
    int i42 = calcolatrice0.divide(19, (int)(short)10);
    int i45 = calcolatrice0.divide((-32), 12);
    
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
    org.junit.Assert.assertTrue(i36 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i45 == (-2));

  }

  @Test
  public void test363() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test363"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide(1, (int)'#');
    int i24 = calcolatrice0.divide((-26), 10);
    int i27 = calcolatrice0.divide((int)'#', 16);
    int i30 = calcolatrice0.divide(16, 52);
    int i33 = calcolatrice0.divide((-19), 97);
    int i36 = calcolatrice0.divide(7, (-6));
    
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
    org.junit.Assert.assertTrue(i24 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-1));

  }

  @Test
  public void test364() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test364"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide((int)(byte)100, (int)(short)-1);
    int i18 = calcolatrice0.divide((-19), 2);
    int i21 = calcolatrice0.divide((-33), 32);
    int i24 = calcolatrice0.divide(17, (-33));
    int i27 = calcolatrice0.divide(52, 1);
    int i30 = calcolatrice0.divide((-20), (int)(byte)1);
    int i33 = calcolatrice0.divide((-9), (-2));
    
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
    org.junit.Assert.assertTrue(i27 == 52);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 4);

  }

  @Test
  public void test365() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test365"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((int)(byte)10, (int)(short)10);
    int i21 = calcolatrice0.divide((int)'#', 32);
    int i24 = calcolatrice0.divide((int)(byte)0, (-9));
    int i27 = calcolatrice0.divide((-2), (int)(byte)1);
    int i30 = calcolatrice0.divide((int)' ', (int)' ');
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);

  }

  @Test
  public void test366() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test366"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(0, (int)'a');
    int i21 = calcolatrice0.divide(0, 6);
    int i24 = calcolatrice0.divide(26, (-20));
    
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
    org.junit.Assert.assertTrue(i24 == (-1));

  }

  @Test
  public void test367() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test367"); }


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
    int i30 = calcolatrice0.divide((-26), (int)(short)10);
    int i33 = calcolatrice0.divide(5, (-50));
    
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
    org.junit.Assert.assertTrue(i30 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test368() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test368"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide(4, (-35));
    int i12 = calcolatrice0.divide((-25), 16);
    int i15 = calcolatrice0.divide((int)(short)1, 10);
    int i18 = calcolatrice0.divide((-52), (-48));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);

  }

  @Test
  public void test369() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test369"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(byte)0, (-26));
    int i21 = calcolatrice0.divide((int)(short)1, 3);
    int i24 = calcolatrice0.divide((-7), (-35));
    int i27 = calcolatrice0.divide((int)(byte)-1, (-8));
    
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
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test370() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test370"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide((-100), 10);
    int i24 = calcolatrice0.divide(12, 10);
    int i27 = calcolatrice0.divide((-97), 100);
    int i30 = calcolatrice0.divide((int)(short)1, (int)(byte)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test371() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test371"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((-1), (int)(short)100);
    int i18 = calcolatrice0.divide(1, (-32));
    int i21 = calcolatrice0.divide((int)' ', (-33));
    int i24 = calcolatrice0.divide((int)(byte)0, (-33));
    int i27 = calcolatrice0.divide(33, 3);
    int i30 = calcolatrice0.divide(12, (-32));
    int i33 = calcolatrice0.divide(1, 5);
    int i36 = calcolatrice0.divide((int)'4', 24);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 2);

  }

  @Test
  public void test372() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test372"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((int)(byte)10, (int)(short)10);
    int i21 = calcolatrice0.divide((-1), (int)(short)1);
    int i24 = calcolatrice0.divide(20, (-26));
    int i27 = calcolatrice0.divide((-52), (int)' ');
    int i30 = calcolatrice0.divide(10, (-32));
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test373() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test373"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide(100, 5);
    int i24 = calcolatrice0.divide(10, (int)(short)10);
    int i27 = calcolatrice0.divide(3, 6);
    int i30 = calcolatrice0.divide(0, 100);
    int i33 = calcolatrice0.divide((int)(byte)0, (-13));
    int i36 = calcolatrice0.divide(13, 16);
    
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
    org.junit.Assert.assertTrue(i21 == 20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test374() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test374"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)(byte)-1, (-5));
    int i18 = calcolatrice0.divide(0, (-19));
    int i21 = calcolatrice0.divide((-52), 100);
    int i24 = calcolatrice0.divide(5, 50);
    
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

  }

  @Test
  public void test375() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test375"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide((-100), 10);
    int i24 = calcolatrice0.divide((-16), (-2));
    int i27 = calcolatrice0.divide(1, 50);
    int i30 = calcolatrice0.divide(11, 17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test376() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test376"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide((int)(short)10, (-10));
    int i12 = calcolatrice0.divide((int)'a', (-32));
    int i15 = calcolatrice0.divide(16, (-10));
    int i18 = calcolatrice0.divide((-13), (-97));
    int i21 = calcolatrice0.divide(14, 19);
    
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
  public void test377() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test377"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-3), (-100));
    int i24 = calcolatrice0.divide(35, 1);
    int i27 = calcolatrice0.divide(3, (-17));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test378() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test378"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)10);
    int i15 = calcolatrice0.divide((-50), (int)(short)-1);
    int i18 = calcolatrice0.divide((-13), 8);
    int i21 = calcolatrice0.divide((int)(short)10, (int)'a');
    int i24 = calcolatrice0.divide(3, (-4));
    int i27 = calcolatrice0.divide((-35), (int)(short)10);
    int i30 = calcolatrice0.divide((-6), (-32));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test379() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test379"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide(0, (int)'a');
    int i12 = calcolatrice0.divide((-32), (-25));
    int i15 = calcolatrice0.divide((int)'a', (-48));
    int i18 = calcolatrice0.divide((-4), (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test380() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test380"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide(50, (int)'a');
    int i18 = calcolatrice0.divide((int)(short)10, (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test381() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test381"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(10, 1);
    int i15 = calcolatrice0.divide(100, (-5));
    int i18 = calcolatrice0.divide((int)(byte)-1, (-100));
    int i21 = calcolatrice0.divide((-50), (-50));
    int i24 = calcolatrice0.divide((-8), 14);
    int i27 = calcolatrice0.divide(8, (-1));
    int i30 = calcolatrice0.divide((-7), 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-7));

  }

  @Test
  public void test382() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test382"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)'4', (int)(byte)1);
    int i15 = calcolatrice0.divide(0, (-97));
    int i18 = calcolatrice0.divide((int)'#', (-32));
    int i21 = calcolatrice0.divide((int)(byte)100, 19);
    int i24 = calcolatrice0.divide(25, (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 52);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-25));

  }

  @Test
  public void test383() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test383"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide(16, (-35));
    int i27 = calcolatrice0.divide((int)(short)10, (-5));
    int i30 = calcolatrice0.divide(1, 50);
    int i33 = calcolatrice0.divide((-25), (int)' ');
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test384() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test384"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide(8, 97);
    int i27 = calcolatrice0.divide(2, (-19));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test385() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test385"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide((-8), (int)(byte)100);
    int i27 = calcolatrice0.divide(25, (int)'#');
    int i30 = calcolatrice0.divide(6, (-10));
    int i33 = calcolatrice0.divide((int)(short)10, (-26));
    int i36 = calcolatrice0.divide((-50), (int)'4');
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
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
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test386() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test386"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((-32), 25);
    int i15 = calcolatrice0.divide(9, (int)(byte)100);
    int i18 = calcolatrice0.divide(5, 16);
    int i21 = calcolatrice0.divide((-25), 100);
    int i24 = calcolatrice0.divide(33, (int)(short)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 33);

  }

  @Test
  public void test387() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test387"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(10, 1);
    int i15 = calcolatrice0.divide(100, (-5));
    int i18 = calcolatrice0.divide((int)(byte)-1, (-100));
    int i21 = calcolatrice0.divide((-50), (-50));
    int i24 = calcolatrice0.divide(0, (-9));
    int i27 = calcolatrice0.divide((int)(short)100, (int)(short)1);
    int i30 = calcolatrice0.divide((-17), (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);

  }

  @Test
  public void test388() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test388"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide(10, (-10));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((int)'4', 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 6);

  }

  @Test
  public void test389() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test389"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(short)10, (int)'#');
    int i12 = calcolatrice0.divide((int)(byte)-1, 52);
    int i15 = calcolatrice0.divide(2, 100);
    int i18 = calcolatrice0.divide(17, 2);
    int i21 = calcolatrice0.divide(26, (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test390() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test390"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(32, 5);
    int i12 = calcolatrice0.divide(0, 32);
    int i15 = calcolatrice0.divide(50, (-16));
    int i18 = calcolatrice0.divide(52, (-35));
    int i21 = calcolatrice0.divide((int)'#', 26);
    int i24 = calcolatrice0.divide((int)(short)1, 13);
    int i27 = calcolatrice0.divide(11, (int)(short)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-11));

  }

  @Test
  public void test391() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test391"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((-1), (int)(short)100);
    int i18 = calcolatrice0.divide(1, (-32));
    int i21 = calcolatrice0.divide((int)' ', (-33));
    int i24 = calcolatrice0.divide((int)(byte)0, (-33));
    int i27 = calcolatrice0.divide(33, 3);
    int i30 = calcolatrice0.divide((-1), (-12));
    int i33 = calcolatrice0.divide(0, 13);
    int i36 = calcolatrice0.divide((-97), (-6));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 16);

  }

  @Test
  public void test392() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test392"); }


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
    int i33 = calcolatrice0.divide((int)(byte)100, (-1));
    int i36 = calcolatrice0.divide((int)(byte)10, 11);
    int i39 = calcolatrice0.divide((-2), (int)(byte)1);
    
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
    org.junit.Assert.assertTrue(i33 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-2));

  }

  @Test
  public void test393() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test393"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((int)(short)10, (-1));
    int i21 = calcolatrice0.divide((int)(byte)100, (-2));
    int i24 = calcolatrice0.divide((-3), (-52));
    int i27 = calcolatrice0.divide((-4), 97);
    int i30 = calcolatrice0.divide((-3), (int)(short)100);
    int i33 = calcolatrice0.divide((int)'a', 3);
    int i36 = calcolatrice0.divide((int)(short)1, 12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test394() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test394"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(0, (-4));
    int i21 = calcolatrice0.divide((-12), (-5));
    int i24 = calcolatrice0.divide(13, 8);
    
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
    org.junit.Assert.assertTrue(i21 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 1);

  }

  @Test
  public void test395() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test395"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)10, 52);
    int i18 = calcolatrice0.divide(5, (int)'#');
    int i21 = calcolatrice0.divide(52, (-2));
    int i24 = calcolatrice0.divide((-10), (int)(byte)10);
    int i27 = calcolatrice0.divide((-26), (-8));
    int i30 = calcolatrice0.divide(0, 24);
    
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
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test396() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test396"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(short)10, (int)'#');
    int i12 = calcolatrice0.divide(52, (int)(byte)100);
    int i15 = calcolatrice0.divide(6, (-9));
    int i18 = calcolatrice0.divide(0, (-16));
    // The following exception was thrown during execution in test generation
    try {
    int i21 = calcolatrice0.divide(33, 0);
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
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test397() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test397"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide(10, (int)(byte)-1);
    int i18 = calcolatrice0.divide(100, (int)(short)-1);
    int i21 = calcolatrice0.divide((-32), (-100));
    int i24 = calcolatrice0.divide((-25), (-33));
    // The following exception was thrown during execution in test generation
    try {
    int i27 = calcolatrice0.divide(13, (int)(byte)0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test398() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test398"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-97), 1);
    int i6 = calcolatrice0.divide((int)(byte)-1, (-20));
    int i9 = calcolatrice0.divide((-9), (-1));
    int i12 = calcolatrice0.divide((-7), (-16));
    int i15 = calcolatrice0.divide((-16), (-33));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-97));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test399() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test399"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide(4, (-35));
    int i12 = calcolatrice0.divide(6, (int)'a');
    int i15 = calcolatrice0.divide(20, 26);
    
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

  }

  @Test
  public void test400() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test400"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)(short)1, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(short)10, (int)'#');
    int i12 = calcolatrice0.divide(25, (-2));
    int i15 = calcolatrice0.divide(9, 10);
    int i18 = calcolatrice0.divide(48, (-50));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-12));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test401() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test401"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(0, (-4));
    int i21 = calcolatrice0.divide((-12), (-5));
    int i24 = calcolatrice0.divide((-8), (-20));
    int i27 = calcolatrice0.divide(100, (int)(short)1);
    int i30 = calcolatrice0.divide(3, 8);
    
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
    org.junit.Assert.assertTrue(i21 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test402() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test402"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide((-33), (int)(byte)10);
    int i27 = calcolatrice0.divide((-5), 2);
    int i30 = calcolatrice0.divide(25, 17);
    int i33 = calcolatrice0.divide((-13), 20);
    int i36 = calcolatrice0.divide((-4), 100);
    int i39 = calcolatrice0.divide((-4), (int)(short)1);
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-2));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-4));

  }

  @Test
  public void test403() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test403"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide(0, 52);
    int i12 = calcolatrice0.divide((-7), (-16));
    int i15 = calcolatrice0.divide(3, (-20));
    int i18 = calcolatrice0.divide((-4), 20);
    int i21 = calcolatrice0.divide((-10), (-4));
    
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
    org.junit.Assert.assertTrue(i21 == 2);

  }

  @Test
  public void test404() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test404"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide((int)(short)0, (-10));
    int i15 = calcolatrice0.divide(0, (-16));
    int i18 = calcolatrice0.divide((int)(short)1, 8);
    int i21 = calcolatrice0.divide(8, (int)(short)10);
    int i24 = calcolatrice0.divide(0, (-24));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
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

  }

  @Test
  public void test405() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test405"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(3, (int)(short)100);
    int i15 = calcolatrice0.divide((-52), (int)(byte)100);
    int i18 = calcolatrice0.divide(32, 16);
    int i21 = calcolatrice0.divide((int)'4', 32);
    int i24 = calcolatrice0.divide((int)' ', 50);
    int i27 = calcolatrice0.divide((-26), (-14));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 1);

  }

  @Test
  public void test406() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test406"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide(16, (int)(short)1);
    int i15 = calcolatrice0.divide((int)(byte)-1, 25);
    int i18 = calcolatrice0.divide((-9), 35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test407() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test407"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-97), 1);
    int i6 = calcolatrice0.divide((int)(byte)-1, (-20));
    int i9 = calcolatrice0.divide((-9), (-1));
    int i12 = calcolatrice0.divide(1, (int)(short)100);
    int i15 = calcolatrice0.divide((int)(short)0, 33);
    int i18 = calcolatrice0.divide((-33), (-48));
    int i21 = calcolatrice0.divide((int)(byte)1, 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-97));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test408() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test408"); }


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
    int i36 = calcolatrice0.divide((-26), (int)(byte)-1);
    int i39 = calcolatrice0.divide(13, (-25));
    
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
    org.junit.Assert.assertTrue(i36 == 26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);

  }

  @Test
  public void test409() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test409"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)'4', (int)(byte)-1);
    int i12 = calcolatrice0.divide(1, (-26));
    int i15 = calcolatrice0.divide(97, (int)(short)-1);
    int i18 = calcolatrice0.divide((int)(byte)100, (-1));
    int i21 = calcolatrice0.divide((int)(byte)1, (int)'a');
    int i24 = calcolatrice0.divide((-12), (int)(byte)100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-52));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-97));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test410() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test410"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((-1), (int)(short)100);
    int i18 = calcolatrice0.divide(1, (-32));
    int i21 = calcolatrice0.divide((int)' ', (-33));
    int i24 = calcolatrice0.divide((-33), (int)'#');
    int i27 = calcolatrice0.divide((int)(short)1, (int)' ');
    int i30 = calcolatrice0.divide((-9), (int)' ');
    int i33 = calcolatrice0.divide((-16), 4);
    int i36 = calcolatrice0.divide(33, 14);
    int i39 = calcolatrice0.divide((-52), 12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
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
    org.junit.Assert.assertTrue(i33 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == (-4));

  }

  @Test
  public void test411() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test411"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide((int)(short)0, (-10));
    int i15 = calcolatrice0.divide(33, (-26));
    int i18 = calcolatrice0.divide(100, (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-9));

  }

  @Test
  public void test412() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test412"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide(3, (-1));
    int i18 = calcolatrice0.divide(0, (-25));
    int i21 = calcolatrice0.divide((-4), (int)(short)1);
    int i24 = calcolatrice0.divide(17, (-97));
    int i27 = calcolatrice0.divide(100, (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-10));

  }

  @Test
  public void test413() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test413"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-35), (int)(byte)10);
    int i21 = calcolatrice0.divide((int)(byte)1, (int)'a');
    int i24 = calcolatrice0.divide(17, (-97));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test414() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test414"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((-16), 25);
    int i24 = calcolatrice0.divide((-4), 33);
    
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

  }

  @Test
  public void test415() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test415"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)'#', (int)(byte)-1);
    int i12 = calcolatrice0.divide((int)(short)-1, (-100));
    int i15 = calcolatrice0.divide(100, 100);
    int i18 = calcolatrice0.divide(0, (-3));
    int i21 = calcolatrice0.divide(0, (int)'a');
    int i24 = calcolatrice0.divide(11, 10);
    int i27 = calcolatrice0.divide((int)'a', (-8));
    
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
    org.junit.Assert.assertTrue(i27 == (-12));

  }

  @Test
  public void test416() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test416"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide((-26), 50);
    int i24 = calcolatrice0.divide((int)(byte)1, 52);
    int i27 = calcolatrice0.divide((int)'a', (-12));
    int i30 = calcolatrice0.divide((int)(byte)0, 7);
    int i33 = calcolatrice0.divide(97, 12);
    int i36 = calcolatrice0.divide(0, (-9));
    
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
    org.junit.Assert.assertTrue(i27 == (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test417() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test417"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide((int)(byte)0, (-10));
    int i12 = calcolatrice0.divide(6, (-9));
    int i15 = calcolatrice0.divide((-1), 1);
    int i18 = calcolatrice0.divide(6, (-19));
    int i21 = calcolatrice0.divide(0, (-48));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test418() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test418"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide(1, 10);
    int i18 = calcolatrice0.divide(5, (-32));
    int i21 = calcolatrice0.divide((-14), (-14));
    int i24 = calcolatrice0.divide((-14), (int)(byte)100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test419() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test419"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(short)0, (int)(byte)10);
    int i18 = calcolatrice0.divide(20, (int)(byte)1);
    int i21 = calcolatrice0.divide(14, (-35));
    // The following exception was thrown during execution in test generation
    try {
    int i24 = calcolatrice0.divide((int)'4', 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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
    org.junit.Assert.assertTrue(i18 == 20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test420() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test420"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-10), (int)(byte)1);
    int i6 = calcolatrice0.divide((-5), (-35));
    int i9 = calcolatrice0.divide((-1), 26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);

  }

  @Test
  public void test421() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test421"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(short)0, (int)(byte)10);
    int i18 = calcolatrice0.divide((int)(byte)1, (-3));
    int i21 = calcolatrice0.divide((int)(short)1, (int)(byte)10);
    int i24 = calcolatrice0.divide((-33), (-35));
    int i27 = calcolatrice0.divide((-3), 1);
    int i30 = calcolatrice0.divide(0, (int)'4');
    int i33 = calcolatrice0.divide((int)(short)0, (int)'#');
    int i36 = calcolatrice0.divide((-8), 5);
    int i39 = calcolatrice0.divide((int)(byte)10, (-25));
    int i42 = calcolatrice0.divide(10, 14);
    
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
    org.junit.Assert.assertTrue(i27 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);

  }

  @Test
  public void test422() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test422"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((int)(short)100, (int)(short)100);
    int i24 = calcolatrice0.divide((int)'a', (-100));
    int i27 = calcolatrice0.divide(6, (-52));
    int i30 = calcolatrice0.divide((int)(short)0, (-20));
    int i33 = calcolatrice0.divide((-52), (int)(short)100);
    
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
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test423() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test423"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(1, (-10));
    int i24 = calcolatrice0.divide((int)(short)-1, (int)'#');
    int i27 = calcolatrice0.divide((-35), (-19));
    int i30 = calcolatrice0.divide((-14), (-19));
    int i33 = calcolatrice0.divide(0, 50);
    int i36 = calcolatrice0.divide(17, 7);
    
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
    org.junit.Assert.assertTrue(i27 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 2);

  }

  @Test
  public void test424() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test424"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((-1), (int)' ');
    int i12 = calcolatrice0.divide(0, (int)(byte)1);
    int i15 = calcolatrice0.divide((-20), (-11));
    int i18 = calcolatrice0.divide(48, (-12));
    int i21 = calcolatrice0.divide((-26), 16);
    
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
    org.junit.Assert.assertTrue(i18 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));

  }

  @Test
  public void test425() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test425"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(byte)100, (int)'#');
    int i9 = calcolatrice0.divide(0, (-9));
    int i12 = calcolatrice0.divide((-50), (-3));
    int i15 = calcolatrice0.divide(17, (-16));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));

  }

  @Test
  public void test426() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test426"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide((-1), (int)' ');
    int i27 = calcolatrice0.divide((int)(short)10, (int)'a');
    // The following exception was thrown during execution in test generation
    try {
    int i30 = calcolatrice0.divide(11, 0);
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
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test427() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test427"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide(1, (-35));
    int i9 = calcolatrice0.divide((int)'#', (-100));
    int i12 = calcolatrice0.divide(5, (-52));
    int i15 = calcolatrice0.divide(6, (-14));
    
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

  }

  @Test
  public void test428() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test428"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((-1), (int)(short)100);
    int i18 = calcolatrice0.divide(32, (-3));
    int i21 = calcolatrice0.divide((int)' ', 1);
    int i24 = calcolatrice0.divide((int)'4', 25);
    int i27 = calcolatrice0.divide((-97), 25);
    int i30 = calcolatrice0.divide((int)(byte)10, (int)(byte)1);
    int i33 = calcolatrice0.divide(25, (int)'#');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test429() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test429"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(3, (int)(short)100);
    int i15 = calcolatrice0.divide((-52), (int)(byte)100);
    int i18 = calcolatrice0.divide((-10), (-33));
    int i21 = calcolatrice0.divide((int)'a', (-20));
    int i24 = calcolatrice0.divide(20, (-19));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-4));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));

  }

  @Test
  public void test430() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test430"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide(0, (int)'#');
    int i9 = calcolatrice0.divide((-7), 25);
    int i12 = calcolatrice0.divide((int)'4', (-3));
    int i15 = calcolatrice0.divide(97, 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-17));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 9);

  }

  @Test
  public void test431() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test431"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide(0, (int)'a');
    int i24 = calcolatrice0.divide(0, (-24));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test432() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test432"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(0, (int)'a');
    int i21 = calcolatrice0.divide(25, 17);
    int i24 = calcolatrice0.divide(8, 14);
    int i27 = calcolatrice0.divide((-52), 52);
    int i30 = calcolatrice0.divide(2, (int)(short)100);
    int i33 = calcolatrice0.divide((-52), (-19));
    
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
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 2);

  }

  @Test
  public void test433() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test433"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-33), (int)'a');
    int i24 = calcolatrice0.divide((int)(byte)1, (int)(byte)-1);
    int i27 = calcolatrice0.divide(32, 13);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 2);

  }

  @Test
  public void test434() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test434"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide((-32), (int)'a');
    int i12 = calcolatrice0.divide((int)(short)100, 100);
    int i15 = calcolatrice0.divide((int)'a', (-11));
    int i18 = calcolatrice0.divide((int)(byte)-1, 17);
    int i21 = calcolatrice0.divide(8, 11);
    int i24 = calcolatrice0.divide((-3), (-7));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test435() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test435"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-33), (int)'a');
    int i24 = calcolatrice0.divide((int)(short)1, (-35));
    int i27 = calcolatrice0.divide(17, 32);
    int i30 = calcolatrice0.divide(4, (int)(short)1);
    int i33 = calcolatrice0.divide((int)(byte)0, (-33));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test436() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test436"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide((-33), (int)(byte)10);
    int i27 = calcolatrice0.divide((int)(short)-1, (int)(byte)-1);
    int i30 = calcolatrice0.divide(97, (-3));
    int i33 = calcolatrice0.divide(5, (int)(short)10);
    int i36 = calcolatrice0.divide((int)(short)1, 4);
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-32));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test437() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test437"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((-26), (int)'a');
    int i21 = calcolatrice0.divide((-50), (int)(short)-1);
    int i24 = calcolatrice0.divide(0, 33);
    // The following exception was thrown during execution in test generation
    try {
    int i27 = calcolatrice0.divide((int)(byte)0, 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test438() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test438"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(byte)-1, 50);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test439() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test439"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-33), (int)'a');
    int i24 = calcolatrice0.divide((int)(byte)1, (int)(byte)-1);
    int i27 = calcolatrice0.divide((-24), (-3));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 8);

  }

  @Test
  public void test440() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test440"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-10), (int)(byte)1);
    int i6 = calcolatrice0.divide(100, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)'a', (-97));
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);

  }

  @Test
  public void test441() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test441"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)'4', (int)'4');
    int i12 = calcolatrice0.divide((int)'a', (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (-1));
    int i18 = calcolatrice0.divide((-97), (-9));
    int i21 = calcolatrice0.divide(0, (-11));
    int i24 = calcolatrice0.divide((-33), (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-97));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-97));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 4);

  }

  @Test
  public void test442() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test442"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((int)'a', (int)'4');
    int i21 = calcolatrice0.divide((int)(short)0, (-97));
    int i24 = calcolatrice0.divide(97, 48);
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 2);

  }

  @Test
  public void test443() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test443"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide(0, (int)'a');
    int i18 = calcolatrice0.divide((-2), (-3));
    int i21 = calcolatrice0.divide(32, (int)'#');
    int i24 = calcolatrice0.divide((int)'a', 100);
    int i27 = calcolatrice0.divide((-7), 24);
    int i30 = calcolatrice0.divide(11, (-13));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-3));
    
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

  }

  @Test
  public void test444() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test444"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-97), 1);
    int i6 = calcolatrice0.divide((int)(byte)-1, (-20));
    int i9 = calcolatrice0.divide((-9), (-1));
    int i12 = calcolatrice0.divide(1, (int)(short)100);
    int i15 = calcolatrice0.divide((-8), (-26));
    int i18 = calcolatrice0.divide((int)' ', (-17));
    int i21 = calcolatrice0.divide(3, (int)' ');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-97));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test445() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test445"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide(0, 52);
    int i12 = calcolatrice0.divide((-4), (int)(byte)10);
    int i15 = calcolatrice0.divide((int)(byte)-1, (-1));
    int i18 = calcolatrice0.divide((-8), 16);
    // The following exception was thrown during execution in test generation
    try {
    int i21 = calcolatrice0.divide(10, 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test446() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test446"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-33), (int)'a');
    int i24 = calcolatrice0.divide(0, 97);
    int i27 = calcolatrice0.divide((-10), (-3));
    int i30 = calcolatrice0.divide((-19), (int)(byte)10);
    int i33 = calcolatrice0.divide(4, 16);
    int i36 = calcolatrice0.divide((int)(short)0, (-33));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test447() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test447"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-35), (int)(byte)10);
    int i21 = calcolatrice0.divide((int)(byte)1, (int)'a');
    int i24 = calcolatrice0.divide(0, 33);
    int i27 = calcolatrice0.divide((-32), (-2));
    int i30 = calcolatrice0.divide(33, (-4));
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-8));

  }

  @Test
  public void test448() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test448"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)0, (-97));
    int i18 = calcolatrice0.divide((-32), 3);
    int i21 = calcolatrice0.divide((-100), (-100));
    int i24 = calcolatrice0.divide((-25), (-9));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 2);

  }

  @Test
  public void test449() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test449"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide((-3), (int)'#');
    int i27 = calcolatrice0.divide(0, (-17));
    int i30 = calcolatrice0.divide((int)(short)10, 13);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
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
  public void test450() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test450"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(32, 5);
    int i12 = calcolatrice0.divide((-11), (-97));
    int i15 = calcolatrice0.divide(17, 16);
    int i18 = calcolatrice0.divide(35, (int)'#');
    int i21 = calcolatrice0.divide(52, 16);
    int i24 = calcolatrice0.divide((int)'4', (int)(short)100);
    int i27 = calcolatrice0.divide((int)(short)1, (-32));
    int i30 = calcolatrice0.divide((-50), (int)(byte)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 50);

  }

  @Test
  public void test451() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test451"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)-1, (int)' ');
    int i18 = calcolatrice0.divide((int)(byte)1, (-97));
    int i21 = calcolatrice0.divide((-33), 6);
    int i24 = calcolatrice0.divide((int)(short)100, (int)(byte)-1);
    int i27 = calcolatrice0.divide((int)(byte)-1, (-48));
    
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
    org.junit.Assert.assertTrue(i21 == (-5));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test452() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test452"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(3, (int)(short)100);
    int i15 = calcolatrice0.divide((-52), (int)(byte)100);
    int i18 = calcolatrice0.divide((int)(byte)10, (-3));
    int i21 = calcolatrice0.divide((-14), (-50));
    int i24 = calcolatrice0.divide((-14), (-33));
    int i27 = calcolatrice0.divide(26, 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 13);

  }

  @Test
  public void test453() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test453"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide((-97), (-8));
    int i21 = calcolatrice0.divide((-12), (-14));
    int i24 = calcolatrice0.divide((-26), (-52));
    
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
    org.junit.Assert.assertTrue(i18 == 12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test454() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test454"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)-1, (int)' ');
    int i18 = calcolatrice0.divide((int)(byte)1, (-97));
    int i21 = calcolatrice0.divide((-33), 6);
    int i24 = calcolatrice0.divide((-14), (int)'a');
    int i27 = calcolatrice0.divide((int)(short)100, 7);
    int i30 = calcolatrice0.divide((int)(byte)10, 1);
    int i33 = calcolatrice0.divide(10, 9);
    
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
    org.junit.Assert.assertTrue(i21 == (-5));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 1);

  }

  @Test
  public void test455() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test455"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide(0, 52);
    int i12 = calcolatrice0.divide((-7), (-16));
    int i15 = calcolatrice0.divide(50, (-19));
    // The following exception was thrown during execution in test generation
    try {
    int i18 = calcolatrice0.divide((-3), 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-2));

  }

  @Test
  public void test456() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test456"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide(52, 10);
    int i12 = calcolatrice0.divide((-19), (-10));
    int i15 = calcolatrice0.divide(20, (-50));
    int i18 = calcolatrice0.divide((-7), 16);
    int i21 = calcolatrice0.divide(11, 48);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test457() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test457"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide((int)(short)-1, (-33));
    int i24 = calcolatrice0.divide((-3), (-5));
    int i27 = calcolatrice0.divide(3, 25);
    int i30 = calcolatrice0.divide((int)(byte)100, (-9));
    int i33 = calcolatrice0.divide(50, 12);
    int i36 = calcolatrice0.divide((-25), 4);
    int i39 = calcolatrice0.divide((-26), (-16));
    int i42 = calcolatrice0.divide(25, 2);
    
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
    org.junit.Assert.assertTrue(i30 == (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-6));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 12);

  }

  @Test
  public void test458() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test458"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-100), (-32));
    int i12 = calcolatrice0.divide((int)(short)100, 6);
    int i15 = calcolatrice0.divide((-35), 35);
    int i18 = calcolatrice0.divide((-26), (-1));
    int i21 = calcolatrice0.divide(6, (-33));
    int i24 = calcolatrice0.divide((int)(byte)1, 8);
    int i27 = calcolatrice0.divide((int)'a', 24);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 4);

  }

  @Test
  public void test459() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test459"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide(0, 52);
    int i12 = calcolatrice0.divide(33, (int)(short)1);
    int i15 = calcolatrice0.divide((-32), 2);
    int i18 = calcolatrice0.divide((-26), (int)(short)100);
    int i21 = calcolatrice0.divide((-97), (int)(byte)1);
    int i24 = calcolatrice0.divide((-9), 100);
    int i27 = calcolatrice0.divide(97, 4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-16));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-97));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 24);

  }

  @Test
  public void test460() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test460"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide(3, (int)' ');
    int i18 = calcolatrice0.divide((int)(byte)-1, 10);
    int i21 = calcolatrice0.divide((int)(short)-1, (-100));
    int i24 = calcolatrice0.divide(0, (-20));
    
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

  }

  @Test
  public void test461() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test461"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide((-3), (int)'#');
    int i27 = calcolatrice0.divide(0, (-17));
    // The following exception was thrown during execution in test generation
    try {
    int i30 = calcolatrice0.divide((int)(byte)0, 0);
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
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test462() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test462"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)'#', (int)(byte)-1);
    int i12 = calcolatrice0.divide((int)(short)-1, (-100));
    int i15 = calcolatrice0.divide((-97), 52);
    int i18 = calcolatrice0.divide((-33), (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 3);

  }

  @Test
  public void test463() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test463"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide(1, (-35));
    int i21 = calcolatrice0.divide(100, 5);
    int i24 = calcolatrice0.divide(20, 2);
    int i27 = calcolatrice0.divide(11, 97);
    int i30 = calcolatrice0.divide((-13), (-4));
    
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
    org.junit.Assert.assertTrue(i21 == 20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 3);

  }

  @Test
  public void test464() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test464"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(byte)1, 7);
    int i12 = calcolatrice0.divide((-17), (-6));
    int i15 = calcolatrice0.divide((int)(short)100, 14);
    int i18 = calcolatrice0.divide((-33), (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 3);

  }

  @Test
  public void test465() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test465"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(byte)0, (int)' ');
    int i9 = calcolatrice0.divide((-1), 10);
    int i12 = calcolatrice0.divide(10, (-97));
    int i15 = calcolatrice0.divide((int)(byte)-1, (int)' ');
    int i18 = calcolatrice0.divide((int)(byte)1, (-97));
    int i21 = calcolatrice0.divide((-3), 16);
    int i24 = calcolatrice0.divide(25, 97);
    int i27 = calcolatrice0.divide((int)(short)10, 25);
    
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

  }

  @Test
  public void test466() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test466"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)0, (int)(short)-1);
    int i9 = calcolatrice0.divide((int)(byte)10, (int)(short)-1);
    int i12 = calcolatrice0.divide((int)(short)100, (-33));
    int i15 = calcolatrice0.divide((int)(byte)100, (int)(short)-1);
    int i18 = calcolatrice0.divide((-19), 2);
    int i21 = calcolatrice0.divide((-33), 32);
    int i24 = calcolatrice0.divide((-35), (int)(short)1);
    int i27 = calcolatrice0.divide(50, (-52));
    int i30 = calcolatrice0.divide(0, (int)(byte)-1);
    int i33 = calcolatrice0.divide((-7), 1);
    int i36 = calcolatrice0.divide((-97), (-3));
    
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
    org.junit.Assert.assertTrue(i24 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-7));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 32);

  }

  @Test
  public void test467() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test467"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide((-32), (int)'a');
    int i12 = calcolatrice0.divide((int)(short)100, 100);
    int i15 = calcolatrice0.divide(9, 4);
    int i18 = calcolatrice0.divide((int)'#', (int)' ');
    int i21 = calcolatrice0.divide((-6), 16);
    int i24 = calcolatrice0.divide((-52), (-6));
    int i27 = calcolatrice0.divide((-33), (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 33);

  }

  @Test
  public void test468() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test468"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)'4', (int)'#');
    int i21 = calcolatrice0.divide((-50), (int)(short)-1);
    int i24 = calcolatrice0.divide(6, (int)(byte)10);
    int i27 = calcolatrice0.divide((int)(short)-1, (-32));
    int i30 = calcolatrice0.divide(0, (int)'#');
    int i33 = calcolatrice0.divide(11, 17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test469() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test469"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide(17, 8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 2);

  }

  @Test
  public void test470() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test470"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((-1), (-1));
    int i18 = calcolatrice0.divide((-19), 3);
    int i21 = calcolatrice0.divide(0, (-26));
    int i24 = calcolatrice0.divide(20, 50);
    
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
    org.junit.Assert.assertTrue(i18 == (-6));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);

  }

  @Test
  public void test471() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test471"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide(0, (-50));
    int i24 = calcolatrice0.divide(52, 9);
    int i27 = calcolatrice0.divide((int)(short)100, 2);
    int i30 = calcolatrice0.divide(0, (-33));
    int i33 = calcolatrice0.divide((int)(short)100, 14);
    int i36 = calcolatrice0.divide(50, (-3));
    
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
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-16));

  }

  @Test
  public void test472() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test472"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)'4', (int)(byte)-1);
    int i12 = calcolatrice0.divide(1, (-26));
    int i15 = calcolatrice0.divide(97, (int)(short)-1);
    int i18 = calcolatrice0.divide((-12), (-48));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-52));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-97));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test473() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test473"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide(100, (int)(byte)-1);
    int i18 = calcolatrice0.divide(52, (-35));
    int i21 = calcolatrice0.divide((int)'a', (-5));
    int i24 = calcolatrice0.divide((int)(short)1, (-32));
    int i27 = calcolatrice0.divide(5, 17);
    int i30 = calcolatrice0.divide(26, (-52));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-19));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test474() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test474"); }


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
    int i33 = calcolatrice0.divide((-97), (int)(byte)100);
    int i36 = calcolatrice0.divide((-13), (int)(short)100);
    int i39 = calcolatrice0.divide(6, 12);
    
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
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);

  }

  @Test
  public void test475() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test475"); }


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
    int i30 = calcolatrice0.divide(35, (int)(short)-1);
    int i33 = calcolatrice0.divide(7, (-33));
    int i36 = calcolatrice0.divide((-48), (-52));
    
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
    org.junit.Assert.assertTrue(i30 == (-35));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 0);

  }

  @Test
  public void test476() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test476"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)' ', (int)(byte)1);
    int i18 = calcolatrice0.divide(5, (int)(byte)100);
    int i21 = calcolatrice0.divide((int)(byte)100, 6);
    int i24 = calcolatrice0.divide(0, (-14));
    int i27 = calcolatrice0.divide((-3), (int)(byte)1);
    
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
    org.junit.Assert.assertTrue(i27 == (-3));

  }

  @Test
  public void test477() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test477"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(3, (int)(short)100);
    int i15 = calcolatrice0.divide(0, (int)(short)100);
    int i18 = calcolatrice0.divide((-4), (-16));
    // The following exception was thrown during execution in test generation
    try {
    int i21 = calcolatrice0.divide(0, 0);
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
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

  @Test
  public void test478() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test478"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide((-19), 100);
    int i21 = calcolatrice0.divide(10, 4);
    int i24 = calcolatrice0.divide(13, (-13));
    int i27 = calcolatrice0.divide((-48), 100);
    int i30 = calcolatrice0.divide((-97), (-20));
    
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
    org.junit.Assert.assertTrue(i21 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 4);

  }

  @Test
  public void test479() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test479"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide(1, (-35));
    int i9 = calcolatrice0.divide(100, (-1));
    int i12 = calcolatrice0.divide(7, 10);
    int i15 = calcolatrice0.divide((int)(short)0, (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);

  }

  @Test
  public void test480() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test480"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((-33), (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)' ', (-4));
    int i21 = calcolatrice0.divide((-14), (-11));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);

  }

  @Test
  public void test481() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test481"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide(8, (-16));
    int i18 = calcolatrice0.divide((int)' ', 14);
    
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
    org.junit.Assert.assertTrue(i18 == 2);

  }

  @Test
  public void test482() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test482"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide(100, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)'#', 52);
    int i21 = calcolatrice0.divide(97, 97);
    int i24 = calcolatrice0.divide(5, 33);
    int i27 = calcolatrice0.divide((-25), 20);
    int i30 = calcolatrice0.divide((-26), 20);
    int i33 = calcolatrice0.divide((-11), (int)'a');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test483() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test483"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(3, (int)(short)100);
    int i15 = calcolatrice0.divide((-52), (int)(byte)100);
    int i18 = calcolatrice0.divide((-10), (-33));
    int i21 = calcolatrice0.divide((int)(short)1, (-5));
    int i24 = calcolatrice0.divide((-25), (int)(byte)1);
    int i27 = calcolatrice0.divide((int)(short)1, 11);
    // The following exception was thrown during execution in test generation
    try {
    int i30 = calcolatrice0.divide(52, (int)(byte)0);
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
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-25));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);

  }

  @Test
  public void test484() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test484"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide(0, (int)(short)1);
    int i9 = calcolatrice0.divide((-100), (-6));
    int i12 = calcolatrice0.divide((int)(short)100, 33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 3);

  }

  @Test
  public void test485() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test485"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(1, (-10));
    int i24 = calcolatrice0.divide((-33), (-97));
    int i27 = calcolatrice0.divide((-52), (-13));
    int i30 = calcolatrice0.divide((-12), (-52));
    int i33 = calcolatrice0.divide((-16), (-11));
    int i36 = calcolatrice0.divide(50, (-14));
    int i39 = calcolatrice0.divide((int)(byte)0, (int)(short)100);
    
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
    org.junit.Assert.assertTrue(i33 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);

  }

  @Test
  public void test486() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test486"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide(1, (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)(short)100, (-97));
    int i21 = calcolatrice0.divide(0, (-50));
    int i24 = calcolatrice0.divide(52, 9);
    int i27 = calcolatrice0.divide((int)(short)100, 2);
    int i30 = calcolatrice0.divide(0, 32);
    int i33 = calcolatrice0.divide((-13), 1);
    int i36 = calcolatrice0.divide(26, 7);
    int i39 = calcolatrice0.divide(0, 8);
    int i42 = calcolatrice0.divide((-16), 19);
    int i45 = calcolatrice0.divide((-50), 19);
    
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
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == (-13));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i36 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i39 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i45 == (-2));

  }

  @Test
  public void test487() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test487"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)-1);
    int i15 = calcolatrice0.divide((int)'a', (int)'4');
    int i18 = calcolatrice0.divide(2, (int)(short)1);
    int i21 = calcolatrice0.divide(1, (-10));
    int i24 = calcolatrice0.divide(4, (-9));
    int i27 = calcolatrice0.divide((int)' ', 10);
    int i30 = calcolatrice0.divide(14, (-24));
    
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
    org.junit.Assert.assertTrue(i27 == 3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);

  }

  @Test
  public void test488() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test488"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)(short)1, (-1));
    int i12 = calcolatrice0.divide(3, (int)(short)100);
    int i15 = calcolatrice0.divide((-52), (int)(byte)100);
    int i18 = calcolatrice0.divide((int)(byte)0, (-97));
    int i21 = calcolatrice0.divide((-12), (int)(byte)100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test489() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test489"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)'4', (int)'#');
    int i21 = calcolatrice0.divide((-50), (int)(short)-1);
    int i24 = calcolatrice0.divide(6, (int)(byte)10);
    int i27 = calcolatrice0.divide((int)(short)-1, (-32));
    int i30 = calcolatrice0.divide(0, (int)'#');
    int i33 = calcolatrice0.divide((-25), (-33));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test490() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test490"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-52), 32);
    int i6 = calcolatrice0.divide(14, 52);
    int i9 = calcolatrice0.divide((-12), 50);
    int i12 = calcolatrice0.divide(16, (-3));
    int i15 = calcolatrice0.divide((-11), (int)(byte)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-5));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-11));

  }

  @Test
  public void test491() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test491"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((int)'#', (-35));
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((int)(short)0, (-1));
    int i24 = calcolatrice0.divide((-3), (int)'#');
    int i27 = calcolatrice0.divide((-33), (int)(byte)-1);
    int i30 = calcolatrice0.divide((int)(byte)100, 6);
    
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
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 16);

  }

  @Test
  public void test492() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test492"); }


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
    int i36 = calcolatrice0.divide((-14), (-25));
    int i39 = calcolatrice0.divide(0, (int)'#');
    int i42 = calcolatrice0.divide(5, 97);
    
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
    org.junit.Assert.assertTrue(i39 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i42 == 0);

  }

  @Test
  public void test493() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test493"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((int)'4', (int)'#');
    int i21 = calcolatrice0.divide((-50), (int)(short)-1);
    int i24 = calcolatrice0.divide(35, (-26));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 50);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-1));

  }

  @Test
  public void test494() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test494"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)0, (int)(byte)100);
    int i15 = calcolatrice0.divide((int)(short)1, (int)'a');
    int i18 = calcolatrice0.divide((int)(short)-1, (-1));
    int i21 = calcolatrice0.divide((-2), (-35));
    int i24 = calcolatrice0.divide(35, (int)(short)-1);
    // The following exception was thrown during execution in test generation
    try {
    int i27 = calcolatrice0.divide((int)(byte)-1, (int)(short)0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
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
    org.junit.Assert.assertTrue(i18 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i24 == (-35));

  }

  @Test
  public void test495() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test495"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide(0, 1);
    int i12 = calcolatrice0.divide((-10), (-35));
    int i15 = calcolatrice0.divide((-33), (int)(byte)-1);
    int i18 = calcolatrice0.divide((int)' ', (-4));
    int i21 = calcolatrice0.divide((-19), 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-8));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == (-1));

  }

  @Test
  public void test496() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test496"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide(0, (int)'a');
    int i15 = calcolatrice0.divide((int)(byte)-1, 10);
    int i18 = calcolatrice0.divide(20, (int)(byte)10);
    int i21 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    
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
    org.junit.Assert.assertTrue(i18 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test497() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test497"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((int)(short)10, 1);
    int i6 = calcolatrice0.divide((int)' ', (int)'4');
    int i9 = calcolatrice0.divide((int)'#', (int)(byte)-1);
    int i12 = calcolatrice0.divide((int)(short)-1, (-100));
    int i15 = calcolatrice0.divide(100, 100);
    int i18 = calcolatrice0.divide((-32), (-97));
    int i21 = calcolatrice0.divide(1, (-9));
    int i24 = calcolatrice0.divide((-97), (-17));
    int i27 = calcolatrice0.divide((-50), (-3));
    int i30 = calcolatrice0.divide((-6), (-48));
    int i33 = calcolatrice0.divide(33, 97);
    
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
    org.junit.Assert.assertTrue(i24 == 5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i27 == 16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i30 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i33 == 0);

  }

  @Test
  public void test498() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test498"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide((int)(short)10, (-10));
    int i12 = calcolatrice0.divide(20, (-1));
    int i15 = calcolatrice0.divide((-33), (int)(byte)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == (-3));

  }

  @Test
  public void test499() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test499"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide(0, (int)(byte)100);
    int i6 = calcolatrice0.divide((int)(short)0, 100);
    int i9 = calcolatrice0.divide((int)(short)1, (int)(byte)100);
    int i12 = calcolatrice0.divide((int)(short)10, (-1));
    int i15 = calcolatrice0.divide((int)(short)100, (int)(byte)1);
    int i18 = calcolatrice0.divide((-32), 10);
    int i21 = calcolatrice0.divide((-8), (-12));
    // The following exception was thrown during execution in test generation
    try {
    int i24 = calcolatrice0.divide(20, 0);
      org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException");
    } catch (java.lang.ArithmeticException e) {
      // Expected exception.
      if (! e.getClass().getCanonicalName().equals("java.lang.ArithmeticException")) {
        org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException, got " + e.getClass().getCanonicalName());
      }
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == (-10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == (-3));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i21 == 0);

  }

  @Test
  public void test500() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest3.test500"); }


    Calcolatrice calcolatrice0 = new Calcolatrice();
    int i3 = calcolatrice0.divide((-1), 100);
    int i6 = calcolatrice0.divide((int)(short)100, (int)(byte)10);
    int i9 = calcolatrice0.divide((int)(short)10, (-10));
    int i12 = calcolatrice0.divide((int)(byte)10, (-33));
    int i15 = calcolatrice0.divide((int)'#', 14);
    int i18 = calcolatrice0.divide((-26), 35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i15 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i18 == 0);

  }

}
