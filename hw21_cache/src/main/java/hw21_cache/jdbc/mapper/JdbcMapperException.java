package hw21_cache.jdbc.mapper;

public class JdbcMapperException extends RuntimeException {

        public JdbcMapperException (String msg) {
            super(msg);
        }

        public JdbcMapperException (Exception ex) {
            super(ex);
        }
    }

