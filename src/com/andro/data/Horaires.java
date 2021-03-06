package com.andro.data;

import java.util.LinkedList;

public class Horaires{
	private LinkedList<Destination> destinations;
	
	public Horaires(){
		destinations = new LinkedList<Destination>();
	}
	
	public void add(String destination, String time ){
		
		if( !destinations.isEmpty() ){
			Destination last = destinations.getLast();
			if( last.getDestination().equals( destination ) ){
				last.addTime( time );
				return;
			}
		}
		this.destinations.add(  new Destination( destination, time ) );
		
	}
	
	public String toString(){
		return( destinations.size() == 1 ?
				tabbedToString() : compressedToString() );
	}
	
	private String compressedToString(){
		StringBuilder sb = new StringBuilder();
		
		for( Destination destination : destinations ){
			sb.append( destination.getDestination()).append(" - ");
			for(String time : destination.getTimes() )
				sb.append(time).append(" ");
			sbClean( sb );
			sb.append("\n");
		}
		sbClean( sb );
		return sb.toString();
	}
	
	private String tabbedToString(){
		StringBuilder sb = new StringBuilder();
		Destination destination = destinations.getFirst();
		
		sb.append( destination.getDestination()).append("\n\t");
		for(String time : destination.getTimes() )
			sb.append(time).append("  ");
		sbClean( sb );
		return sb.toString();
	}
	
	
	private void sbClean( StringBuilder sb ){
		if( sb.length() > 0 )
			sb.setLength( sb.length() - 1 );
	}
}
