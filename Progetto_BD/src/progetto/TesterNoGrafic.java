package progetto;

public class TesterNoGrafic {

	private static final String DB_URL ="jdbc:mysql://localhost/TVJournal";
	private static final String USER = "root";
	private static final String PASS = "Myl0vefromanotherstar*";

	public static void main(String[] args) {
		
		QueryManager q=new QueryManager(DB_URL,USER,PASS);
	
	
		
		String[][] table = q.getTable("select * from Titolo;");
		
		for(int i = 0; i<= q.getRowCount(); i++) {
			for(int j = 0; j < q.getColumnCount(); j++)
				System.out.print(table[i][j]+ " ");
			
			System.out.println(" ");
		}
	
		String[] qu = q.makeQuery("select * from Titolo;");
		for(int i = 0; i<qu.length; i++) {
			System.out.println(qu[i]);
		}
		
	}

}
