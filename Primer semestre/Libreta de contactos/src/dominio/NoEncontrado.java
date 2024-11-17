package dominio;

public class NoEncontrado extends Exception {
    public static class DuplicadoException extends Exception {
        public DuplicadoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class cNoEncontradoException extends Exception {
        public cNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }
}

