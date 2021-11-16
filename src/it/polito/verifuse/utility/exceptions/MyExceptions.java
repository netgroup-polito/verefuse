package it.polito.verifuse.utility.exceptions;


@SuppressWarnings("serial")
public class MyExceptions extends Exception {
	
	public MyExceptions(String message) {
		super(message);
	}
	
	public static class GeneralException extends Exception	{
		
		public GeneralException(String message) {
			super(message);
		}
	}
	
	public static class IllegalArgumentException extends Exception	{
		
		public IllegalArgumentException(String message) {
			super(message);
		}
	}
	
	public static class NotFoundException extends Exception	{
		
		public NotFoundException(String message) {
			super(message);
		}
	}
	
	public static class NullArgumentException extends Exception	{
		
		public NullArgumentException(String message) {
			super(message);
		}
	}
	public static class ValidationFileException extends Exception	{
		
		public ValidationFileException (String message) {
			super(message);
		}
	}
	public static class UnmarshalFileXMLException extends Exception	{
		
		public UnmarshalFileXMLException (String message) {
			super(message);
		}
	}
	public static class NotFoundMappingFunctionalityException extends Exception	{
		
		public NotFoundMappingFunctionalityException (String message) {
			super(message);
		}
	}
	public static class SolverGurobiException extends Exception	{
		
		public SolverGurobiException (String message) {
			super(message);
		}
	}
	public static class FindChainFunctionalityException extends Exception	{
		
		public FindChainFunctionalityException (String message) {
			super(message);
		}
	}



}
