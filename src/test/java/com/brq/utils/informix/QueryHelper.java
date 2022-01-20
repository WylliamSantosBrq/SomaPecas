package com.brq.utils.informix;

public abstract class QueryHelper {

	abstract void executeLambda(String query, CarregamentoDeDados lambda);
	abstract String getQuery(String...args);
	
}
