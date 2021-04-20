package board_Proj.util;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

public class JdbcUtilTest {

	@Test
	public void test() {
	Connection con = JdbcUtil.getConnection();
	Assert.assertNotNull(con);
	
	System.out.println("con >> "+con);
	}

}
