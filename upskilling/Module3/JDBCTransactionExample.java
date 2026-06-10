import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JDBCTransactionExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:bank.db";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
             
            stmt.execute("CREATE TABLE IF NOT EXISTS accounts (id INTEGER PRIMARY KEY, balance REAL)");
            stmt.execute("INSERT OR IGNORE INTO accounts (id, balance) VALUES (1, 1000.0)");
            stmt.execute("INSERT OR IGNORE INTO accounts (id, balance) VALUES (2, 500.0)");
            
            // Start transaction
            conn.setAutoCommit(false);
            
            try (PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
                 PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?")) {
                 
                 double transferAmount = 200.0;
                 
                 // Debit Account 1
                 debit.setDouble(1, transferAmount);
                 debit.setInt(2, 1);
                 debit.executeUpdate();
                 
                 // Credit Account 2
                 credit.setDouble(1, transferAmount);
                 credit.setInt(2, 2);
                 credit.executeUpdate();
                 
                 conn.commit();
                 System.out.println("Transfer successful. Transaction committed.");
            } catch (Exception e) {
                conn.rollback();
                System.out.println("Transfer failed. Transaction rolled back.");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
