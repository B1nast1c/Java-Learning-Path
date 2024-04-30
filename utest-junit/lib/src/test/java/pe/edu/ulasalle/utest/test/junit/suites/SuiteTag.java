package pe.edu.ulasalle.utest.test.junit.suites;

import org.junit.platform.suite.api.IncludeTags; 
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"pe.edu.ulasalle.utest.test.junit.suites.packb"})
@IncludeTags({"nonfun"})
public class SuiteTag {

	
}
