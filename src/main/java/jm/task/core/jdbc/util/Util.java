package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // JDBC параметры
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/my_db?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root"; // замените на свой пароль

    // Hibernate SessionFactory
    private static final SessionFactory sessionFactory = buildSessionFactory();

    // JDBC соединение
    public static Connection getJDBCConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к базе данных", e);
        }
    }

    // Создание SessionFactory для Hibernate
    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            // Настройки Hibernate
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            configuration.setProperty("hibernate.connection.url", JDBC_URL);
            configuration.setProperty("hibernate.connection.username", JDBC_USER);
            configuration.setProperty("hibernate.connection.password", JDBC_PASSWORD);

            // Диалект для MySQL
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

            // Отображение SQL запросов
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.format_sql", "true");

            // Стратегия создания таблиц
            configuration.setProperty("hibernate.hbm2ddl.auto", "validate");

            // Добавляем класс User
            configuration.addAnnotatedClass(User.class);

            return configuration.buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка инициализации SessionFactory", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}