

import com.allendowney.thinkdast.ListClientExample;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author downey
 */
public class ListClientExampleTest {

  /**
   * Test method for {@link ListClientExample}.
   */
  @Test
  public void testListClientExample() {
    ListClientExample lce = new ListClientExample();
    @SuppressWarnings("rawtypes")
    List list = lce.getList();
    Assert.assertThat(list, CoreMatchers.instanceOf(ArrayList.class));
  }

}
