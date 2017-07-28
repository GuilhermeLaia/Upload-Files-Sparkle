package br.com.sparkle.api.exception;

/**
 * @author guilhermemedeiros
 * Class Exception StorageFileNotFoundException 
 */
public class StorageFileNotFoundException extends StorageFileException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3398020091951227145L;

	public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}