package it.polito.verifuse.neo4j.client;

@SuppressWarnings("serial")
public class Neo4jClientExceptions extends Exception {
	
	public Neo4jClientExceptions(String message) {
		super(message);
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
	
	public static class GeneralException extends Exception	{
		
		public GeneralException(String message) {
			super(message);
		}
	}
}
