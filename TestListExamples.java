import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

class TestChecker implements StringChecker{
    public boolean checkString(String s){
        return (s.length() == 5);
    }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeLeftEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("d", "e");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "c", "d", "e");
    assertEquals(expected, merged);
  }

  @Test
  public void testFilter1(){
    List<String> testList = new ArrayList<>();
    testList.add("1");
    testList.add("12345");
    testList.add("34");
    List<String> result = ListExamples.filter(testList, new TestChecker());
    assertEquals(1, result.size());
    assertEquals("12345", result.get(0));
  }

  @Test
  public void testFilter2(){
    List<String> testList = new ArrayList<>();
    testList.add("1");
    testList.add("12345");
    testList.add("34");
    testList.add("56789");
    List<String> result = ListExamples.filter(testList, new TestChecker());
    assertEquals(2, result.size());
    assertEquals("12345", result.get(0));
    assertEquals("56789", result.get(1));
  }
}
