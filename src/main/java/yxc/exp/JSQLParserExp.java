package yxc.exp;

import java.io.StringReader;

import org.junit.Test;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.insert.Insert;

public class JSQLParserExp {

	@Test
	public void parseInsert() throws JSQLParserException {
		String select = "insert into usertable(field1,field2,field3) values(?,?,?)";
		Statement statement = CCJSqlParserUtil.parse(new StringReader(select));
		if(Insert.class.isInstance(statement)) {
			System.out.println(Insert.class.cast(statement).getColumns());
		}
	}
}
