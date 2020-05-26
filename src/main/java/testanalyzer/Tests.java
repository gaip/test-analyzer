package testanalyzer;

import java.io.Serializable;

import testanalyzer.parsing.TestResolver;
import testanalyzer.parsing.exceptions.NoTestsFound;

public class Tests implements Serializable{

	private TestResolver resolver;

	public Tests(TestResolver resolver) {
		this.resolver = resolver;
	}

	public int getCount() throws Exception {
		return resolver.getNumberOfTests();
	}

	public TestQuality qualityDataFor(int i) throws Exception {
		TestClassQuality qualityList = resolver.getTestQualityData();
		if (qualityList.isEmpty())
			throw new NoTestsFound();
		return qualityList.get(i);
	}

	public String getClassName() throws Exception {
		return resolver.getTestClassName();
	}

	public TestClassQuality getAll() throws Exception {
		return resolver.getTestQualityData();
	}

}
