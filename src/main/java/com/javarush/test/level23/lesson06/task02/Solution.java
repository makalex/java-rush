package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.SERVER_NOT_ACCESSIBLE);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.SERVER_NOT_ACCESSIBLE, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.UNAUTHORIZED_USER);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.UNAUTHORIZED_USER, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.BANNED_USER);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.BANNED_USER, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.RESTRICTION);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.RESTRICTION, cause);
        }
    }

    public static final class Constants {
        public static final String SERVER_NOT_ACCESSIBLE = "Server is not accessible for now.";
        public static final String UNAUTHORIZED_USER = "User is not authorized.";
        public static final String BANNED_USER = "User is banned.";
        public static final String RESTRICTION = "Access is denied.";
    }
}
