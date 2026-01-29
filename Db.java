import java.sql.*;

class Db {
    private String dbUrl = "jdbc:mysql://localhost:3306/myGame?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private String user = "root";
    private String password = "leronnt"; // Проверь пароль еще раз!
    private Connection con = null;

    public Db() {
        try {
            // Пробуем загрузить драйвер
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(dbUrl, user, password);
            System.out.println("--- Соединение с БД установлено успешно! ---");
        } catch (ClassNotFoundException e) {
            System.out.println("КРИТИЧЕСКАЯ ОШИБКА: Драйвер MySQL не найден! Проверьте Referenced Libraries.");
        } catch (SQLException e) {
            System.out.println("ОШИБКА ПОДКЛЮЧЕНИЯ: Проверьте пароль или запущен ли MySQL сервер. " + e.getMessage());
        }
    }

    public boolean authenticate(String username, String pass) {
        // Защита от NullPointerException
        if (this.con == null) {
            System.out.println("Ошибка: Нет связи с базой данных. Вход невозможен.");
            return false;
        }

        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 1;
            }
        } catch (SQLException e) {
            System.out.println("Ошибка запроса к базе: " + e.getMessage());
        }
        return false;
    }

    public void close() {
        try { if (con != null) con.close(); } catch (SQLException e) {}
    }
}