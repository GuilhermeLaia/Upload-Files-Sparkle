package br.com.sparkle.api.exception;

/**
 * @author guilhermemedeiros
 * Class Exception StorageFileException 
 */
public class StorageFileException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3899535086363600501L;

	public StorageFileException(String message) {
        super(message);
    }

    public StorageFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
