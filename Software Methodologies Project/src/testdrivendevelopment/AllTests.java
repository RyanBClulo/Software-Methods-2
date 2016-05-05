package testdrivendevelopment;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EnemyTester.class, KeyboardTester.class, MouseTester.class, PlayerShipTester.class,
		ProjectileTester.class,ScoreTester.class })
public class AllTests {
}