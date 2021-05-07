package airports;

import java.util.HashSet;
import java.util.Set;

import logicalcollections.LogicalSet;

/**
 * Each instance of this class represents an airport in an airport graph with is-connected-to edges.
 * 
 * @invar | getConnectedAirports() != null
 * @invar | getConnectedAirports().stream().allMatch(airport -> airport != null && airport.getConnectedAirports().contains(this))
 */
public class Airport {
	
	/**
	 * @invar | connectedAirports != null
	 * @invar | connectedAirports.stream().allMatch(airport -> airport != null && airport.connectedAirports.contains(this))
	 * @representationObject
	 * @peerObjects
	 */
	private Set<Airport> connectedAirports = new HashSet<>();
	
	/**
	 * @basic
	 * @creates | result
	 * @peerObjects
	 */
	public Set<Airport> getConnectedAirports() { return Set.copyOf(connectedAirports); }

	/**
	 * @post | getConnectedAirports().isEmpty()
	 */
	public Airport() {}
	
	/**
	 * @pre | other != null
	 * 
	 * @mutates_properties | this.getConnectedAirports(), other.getConnectedAirports()
	 * 
	 * @post | this.getConnectedAirports().equals(LogicalSet.plus(old(this.getConnectedAirports()), other))
	 * @post | other.getConnectedAirports().equals(LogicalSet.plus(old(other.getConnectedAirports()), this))
	 */
	public void connectTo(Airport other) {
		connectedAirports.add(other);
		other.connectedAirports.add(this);
	}

	/**
	 * @pre | getConnectedAirports().contains(other)
	 * 
	 * @mutates_properties | this.getConnectedAirports(), other.getConnectedAirports()
	 * 
	 * @post | this.getConnectedAirports().equals(LogicalSet.minus(old(this.getConnectedAirports()), other))
	 * @post | other.getConnectedAirports().equals(LogicalSet.minus(old(other.getConnectedAirports()), this))
	 */
	public void disconnectFrom(Airport other) {
		connectedAirports.remove(other);
		other.connectedAirports.remove(this);
	}
}
